package wei.bigdata.core.record

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-2-16 14:54
 */
trait Record {

  def set(key: String, value: AnyRef): Unit

  def getValue(key: String): Option[AnyRef]
}
