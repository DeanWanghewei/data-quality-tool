package wei.bigdata.analysis

import org.slf4j.LoggerFactory
import wei.bigdata.conf.{TableResultMetric, TableSchema}
import wei.bigdata.queue.RecordQueue

import java.util.concurrent.Executors

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 13:56
 */
class Analysis(concurrency: Int = 1) {
  val logger = LoggerFactory.getLogger(this.getClass)
  val threadPool = Executors.newFixedThreadPool(concurrency)
  var running = true
  var recordAnalysis: RecordAnalysis = _

  /**
   * begin to analysis data
   */
  def start(metric: TableResultMetric): Unit = {
    for (_ <- 1 to concurrency) {
      logger.info("start new analysis thread")
      threadPool.submit(new Runnable {
        override def run(): Unit = {
          while (running) {
            if (RecordQueue.queue.isEmpty) {
              logger.info("waiting for source data...")
              Thread.sleep(500)
            } else {
              val record = RecordQueue.queue.poll()
              if (record != null) {
                val errorRecordOption = recordAnalysis.qualityRecord(record)
                if (errorRecordOption.isDefined) {
                  metric.errorRecordCollect += errorRecordOption.get
                }
                metric.recordTotal.increment()
              } else {
                logger.info("get an empty data ...")
              }
            }
          }
          logger.info("stop analysis ...")
        }
      })
    }
  }

  /**
   * stop
   */
  def stop(): Unit = {
    running = false
  }
}

object Analysis {

  def apply(threadNum: Int, tableSchema: TableSchema): Analysis = {
    val analysis = new Analysis(threadNum)
    analysis.recordAnalysis = new RecordAnalysis(tableSchema)
    analysis
  }

  def apply(tableSchema: TableSchema): Analysis = {
    this.apply(1, tableSchema)
  }
}