package wei.bigdata.conf

import scala.beans.BeanProperty

/**
 * @description: col pattern properties
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 10:06
 */
class ColPattern(_name: String) {
  /**
   *
   */
  @BeanProperty
  val name: String = _name

  @BeanProperty
  var pattern: String = _
  /**
   * final type pattern
   */
  @BeanProperty
  var typePattern: String = _
  /**
   * enable null
   */
  @BeanProperty
  var nullAble: Boolean = false

}
