package wei.bigdata.conf

import java.util.concurrent.atomic.LongAdder
import scala.beans.BeanProperty
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 10:26
 */
class TableResultMetric {
  @BeanProperty
  val errorRecordCollect: ListBuffer[ErrorRecord] = ListBuffer()
  @BeanProperty
  var recordTotal: LongAdder = new LongAdder
  @BeanProperty
  var running: Boolean = true

  def collectIndicators(): CollectMetric = {
    val metric = new CollectMetric
    metric.total = recordTotal.longValue()

    val colCntMap = mutable.Map[String, MetricItem]()
    errorRecordCollect.foreach(_.colArray.foreach(item => {
      if (colCntMap.contains(item.name)) {
        colCntMap(item.name).getCnt.increment()
      } else {
        val itemMetric = new MetricItem(item.name, new LongAdder())
        itemMetric.cnt.increment()
        colCntMap.put(item.name, itemMetric)
      }
    }))
    metric.collectItem = colCntMap.values.toList

    metric
  }
}
