package wei.bigdata.analysis

import org.slf4j.LoggerFactory
import wei.bigdata.analysis.pattern.Patterns
import wei.bigdata.conf.Config
import wei.bigdata.core.record.Record
import wei.bigdata.queue.RecordQueue
import wei.bigdata.util.ReflectUtil

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 13:56
 */
class Analysis(recordQueue: RecordQueue) extends Runnable {
  def setConfig(config: Config): Unit = {
    val patternClass = ReflectUtil.getSubClass(classOf[Patterns])
    val patterns = config.getAsArray()
  }

  val logger = LoggerFactory.getLogger(this.getClass)

  var recordAnalysis: RecordAnalysis = _

  override def run(): Unit = {
    var record: Record = null
    while ((record = recordQueue.get()) != null) {
      val errorRecordOption = recordAnalysis.qualityRecord(record)
      if (errorRecordOption.isDefined) {

      }
    }
  }
}