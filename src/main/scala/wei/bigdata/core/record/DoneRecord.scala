package wei.bigdata.core.record

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-2-16 14:50
 */

class DoneRecord extends Record {
  override def set(key: String, value: AnyRef): Unit = {}

  override def getValue(key: String): Option[AnyRef] = {
    None
  }
}

object DoneRecord {
  private val SINGLE = new DoneRecord

  def get(): DoneRecord = SINGLE
}

