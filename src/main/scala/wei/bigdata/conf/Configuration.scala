package wei.bigdata.conf

import scala.collection.mutable.ArrayBuffer

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 14:42
 */
class Configuration(_context: String) {
  def getTableSchema(): TableSchema = {
    val schema = new TableSchema()
    val buffer = new ArrayBuffer[ColPattern]()
    val idPattern = new ColPattern("id")
    idPattern.pattern = "\\d+"
    buffer += idPattern

    val resultJsonCol = new ColPattern("result_json")
    resultJsonCol.pattern = "\\d+"
    buffer += resultJsonCol

    schema.colPatternArray = buffer.toArray
    schema
    // TODO 完善获取方式
  }

  def getTypeSink(): String = {
    "console"
  }

  def getTypeSource(): String = {
    "mysql"
  }

  def getSourceConnectJson(): String = {
    ""
  }

  def getCoreThread(): Int = {
    // TODO 完善获取方式
    1
  }

}
