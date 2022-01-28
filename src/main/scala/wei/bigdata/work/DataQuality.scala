package wei.bigdata.work

import wei.bigdata.analysis.Analysis
import wei.bigdata.conf.{Configuration, TableResultMetric}
import wei.bigdata.sink.Sink
import wei.bigdata.source.Source
import wei.bigdata.util.ConfigParser

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 14:37
 */
class DataQuality(_configuration: Configuration) {
  private val configuration: Configuration = _configuration

  def startSink(metric: TableResultMetric): Unit = new Thread(Sink.apply(configuration.getTypeSink()).setMetric(metric)).start()

  def startAnalysis(metric: TableResultMetric): Unit =
    Analysis.apply(configuration.getCoreThread(), configuration.getTableSchema()).start(metric)

  def startSource(): Unit =
    Source.apply(configuration.getTypeSource(), configuration.getSourceConnectJson()).read()
}

object DataQuality {
  def entry(configPath: String): Unit = {
    val metric = new TableResultMetric
    val quality = new DataQuality(ConfigParser.parseConfig(configPath))
    quality.startSink(metric)
    quality.startAnalysis(metric)
    quality.startSource()
  }
}
