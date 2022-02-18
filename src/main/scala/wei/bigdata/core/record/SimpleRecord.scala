package wei.bigdata.core.record

import scala.beans.BeanProperty
import scala.collection.mutable

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 10:41
 */
class SimpleRecord extends Record {
  @BeanProperty
  var cols: mutable.Buffer[Col] = new mutable.ArrayBuffer[Col]

  override def set(key: String, value: AnyRef): Unit = {
    cols += new Col(key, value)
  }

  override def getValue(key: String): Option[AnyRef] = {
    val collect = cols.filter(_.name.equals(key))
    if (collect.size < 0) {
      return None
    }
    Some(collect.head.value)
  }

}
