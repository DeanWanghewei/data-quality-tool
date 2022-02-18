package wei.bigdata.conf

import java.util.concurrent.atomic.LongAdder
import scala.beans.BeanProperty

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-27 17:30
 */

class MetricItem(_name: String, _cnt: LongAdder) {
  @BeanProperty
  val name: String = _name
  @BeanProperty
  val cnt: LongAdder = _cnt
}