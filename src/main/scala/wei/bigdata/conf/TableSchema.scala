package wei.bigdata.conf

import scala.beans.BeanProperty

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 10:13
 */
class TableSchema {
  @BeanProperty
  var colPatternArray: Array[ColPattern] = _
}
