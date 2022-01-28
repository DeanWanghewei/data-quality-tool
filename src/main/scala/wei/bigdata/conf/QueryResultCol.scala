package wei.bigdata.conf

import scala.beans.BeanProperty

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2021-7-30 15:43
 */
class QueryResultCol(private val _columnName: String, private val _columnType: String) {
  /**
   * 字段名
   */
  @BeanProperty
  var columnName: String = _columnName

  /**
   * 字段类型
   */
  @BeanProperty
  var columnType: String = _columnType

}
