package wei.bigdata.analysis.pattern

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-2-18 14:32
 */
class NullValuePattern extends Patterns {
  /**
   * Verify that the given value complies with the rules
   *
   * @param value null value
   * @return
   */
  override def detection(value: AnyRef): Boolean = {
    value == null
  }
}
