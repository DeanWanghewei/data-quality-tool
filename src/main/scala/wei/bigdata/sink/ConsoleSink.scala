package wei.bigdata.sink

import com.google.gson.Gson
import org.slf4j.LoggerFactory
import wei.bigdata.conf.TableResultMetric

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 15:48
 */
class ConsoleSink extends Sink {
  val logger = LoggerFactory.getLogger(this.getClass)

  override def collect(resultMetric: TableResultMetric): Unit = {
    while (resultMetric.running) {
      logger.info(s"result [${new Gson().toJson(resultMetric.collectIndicators())}]")
      Thread.sleep(2000)
    }
  }
}
