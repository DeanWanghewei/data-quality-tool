package wei.bigdata.analysis

import wei.bigdata.conf.TableSchema
import wei.bigdata.core.quality.{ColError, RecordError}
import wei.bigdata.core.record.Record

import java.util.regex.Pattern
import scala.collection.mutable

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 10:11
 */
class RecordAnalysis(_tableSchema: TableSchema) {
  private val tableSchema: TableSchema = _tableSchema

  def qualityRecord(record: Record): Option[RecordError] = {
    val patternArray = tableSchema.colPatternArray
    val errorColBuffer: mutable.ArrayBuffer[ColError] = new mutable.ArrayBuffer[ColError]

    if (patternArray == null) {
      return None
    }
    patternArray.foreach(item => {
      val valueOption = record.getValue(item.name)

    })

    if (errorColBuffer.isEmpty) {
      None
    } else {
      val errorRecord = new RecordError
      errorRecord.colArray = errorColBuffer
      Some(errorRecord)
    }
  }


}

object RecordAnalysis {
  val patternCacheMap: mutable.Map[String, Pattern] = mutable.Map()

  private def getPattern(patternStr: String): Pattern = {
    val itemPattern = patternCacheMap.getOrElse(patternStr, {
      Pattern.compile(patternStr)
    })
    if (!patternCacheMap.contains(patternStr)) {
      patternCacheMap += (patternStr -> itemPattern)
    }
    itemPattern
  }
}
