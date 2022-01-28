package wei.bigdata.source

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 15:48
 */
trait Source {
  def init(properties: String): Unit

  def read(): Unit
}

object Source {
  def apply(typeSource: String = "mysql", properties: String): Source = {
    val source = new MysqlSource
    source.init(properties)
    source
  }
}
