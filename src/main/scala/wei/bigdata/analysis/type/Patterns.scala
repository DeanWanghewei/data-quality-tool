package wei.bigdata.analysis.`type`

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 10:59
 */
trait Patterns {
  /**
   * Verify that the given value complies with the rules
   *
   * @param value
   * @return
   */
  def detection(value: String): Boolean

  /**
   * give this pattern a own name
   *
   * @return this pattern name
   */
  def typePatternName(): String = {
    this.getClass.getName
  }

}
