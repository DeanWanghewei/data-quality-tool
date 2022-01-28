package wei.bigdata.analysis.`type`

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 11:43
 */
class ChinaTelephoneNumberPattern extends Patterns {
  /**
   * Verify that the given value complies with the rules
   *
   * @param value
   * @return
   */
  override def detection(value: String): Boolean = {
    true
  }
}
