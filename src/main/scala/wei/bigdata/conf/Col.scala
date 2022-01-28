package wei.bigdata.conf

import org.apache.commons.lang3.StringUtils

import scala.beans.BeanProperty

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 10:43
 */
class Col(_name: String, _value: AnyRef) {
  @BeanProperty
  val name: String = _name
  @BeanProperty
  val index: Int = -1
  @BeanProperty
  val value: AnyRef = _value

  override def hashCode(): Int = name.hashCode()


  override def equals(obj: Any): Boolean = {
    obj match {
      case col: Col =>
        StringUtils.equalsIgnoreCase(this.name, col.name)
      case _ =>
        false
    }
  }
}
