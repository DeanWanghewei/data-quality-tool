package wei.bigdata.conf

import scala.beans.BeanProperty

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 10:32
 */
class ErrorCol(_colPattern: ColPattern, _value: AnyRef, _name: String) {
  @BeanProperty
  val name: String = _name
  @BeanProperty
  var colPattern: ColPattern = _colPattern
  @BeanProperty
  val value: AnyRef = _value
  @BeanProperty
  var msg: String = _
}
