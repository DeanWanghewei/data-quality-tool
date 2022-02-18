package wei.bigdata.analysis.pattern

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
  def detection(value: AnyRef): Boolean

  /**
   * give this pattern a own name,this name is A primary key
   *
   * @return this pattern name
   */
  def typePatternName(): String = {
    this.getClass.getName
  }

}
