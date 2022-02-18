package wei.bigdata.core.pattern

import scala.beans.BeanProperty

/**
 * @description: 字段的验证方式
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-2-18 14:05
 */
class ColPattern {
  /**
   * 字段名
   */
  @BeanProperty
  var name: String = _

  /**
   * 字段index偏移量
   */
  @BeanProperty
  var index: Int = _

  /**
   * 使用的规则名称
   */
  @BeanProperty
  var pattern: String = _

}
