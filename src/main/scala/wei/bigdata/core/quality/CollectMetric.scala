package wei.bigdata.core.quality

import wei.bigdata.conf.MetricItem

import scala.beans.BeanProperty

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 16:57
 */
class CollectMetric {
  /**
   * total data size
   */
  @BeanProperty
  var total: Long = _

  @BeanProperty
  var collectItem: List[MetricItem] = _
}

