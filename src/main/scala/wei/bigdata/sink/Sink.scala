package wei.bigdata.sink

import wei.bigdata.conf.TableResultMetric

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 15:48
 */
abstract class Sink extends Runnable {
  var resultMetric: TableResultMetric = _

  def collect(resultMetric: TableResultMetric): Unit

  def setMetric(resultMetric: TableResultMetric): Sink = {
    this.resultMetric = resultMetric
    this
  }

  override def run(): Unit = {
    this.collect(resultMetric)
  }
}

object Sink {
  def apply(sinkType: String = "console"): Sink = {
    new ConsoleSink
  }
}
