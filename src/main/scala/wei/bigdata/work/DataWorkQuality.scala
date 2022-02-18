package wei.bigdata.work

import wei.bigdata.conf.Config
import wei.bigdata.core.ConstantCore
import wei.bigdata.core.quality.CollectMetric
import wei.bigdata.util.ConfigParser

import java.util.concurrent.{ExecutorService, Executors, Future}
import scala.collection.mutable.ArrayBuffer

/**
 * @description: 一个Reader 对应一个analysis解析器。最后使用一个sink collect merge触发最终结果。
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-2-16 15:52
 */
class DataWorkQuality {

  def startDataWork(config: Config): Unit = {
    val parallelism = config.getIntOrElse(ConstantCore.CORE_PARALLELISM, 1)
    val threadPool: ExecutorService = Executors.newFixedThreadPool(parallelism)
    val futures = new ArrayBuffer[Future[CollectMetric]]()
    for (_ <- 0 to parallelism) {
      val work = new DataWork()
      work.setConfig(config)
      val future = threadPool.submit(work)
      futures += future
    }

    val collectMetric = futures.map(_.get()).reduce((leftIndex, rightIndex) => {
      val metric = new CollectMetric()
      metric.total = leftIndex.total + rightIndex.total
      metric.collectItem = leftIndex.collectItem ++ rightIndex.collectItem
      metric
    })
    // print Sink
    println(collectMetric)
  }

  def entry(configPath: String): Unit = {
    val config = Config.fromConfigString(ConfigParser.loadLocalPath(configPath))
    startDataWork(config)
  }


}
