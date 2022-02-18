package wei.bigdata.work

import org.slf4j.LoggerFactory
import wei.bigdata.analysis.Analysis
import wei.bigdata.conf.Config
import wei.bigdata.core.ConstantCore
import wei.bigdata.core.quality.CollectMetric
import wei.bigdata.queue.DefaultRecordQueue
import wei.bigdata.source.SourceChannel

import java.util.concurrent.Callable



/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-2-16 20:01
 */
class DataWork() extends Callable[CollectMetric] {
  val logger = LoggerFactory.getLogger(this.getClass)
  var config: Config = _

  def setConfig(_config: Config): Unit = {
    this.config = _config
  }


  override def call(): CollectMetric = {
    val queue = new DefaultRecordQueue
    val channel = SourceChannel.getSourceChannel(config)
    channel.setSourceChannelConfig(config.getConfig(ConstantCore.SOURCE))
    channel.setQueue(queue)

    try new Thread(channel).start() catch {
      case exception: Exception => {
        logger.error("stop source .", exception)
      }
    } finally {
      channel.destroy()
    }
    val metric = new CollectMetric

    val analysis = new Analysis(queue)
    analysis.setConfig(config.getConfig(ConstantCore.COL_PATTERNS))

    metric
  }
}
