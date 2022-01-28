package wei.bigdata.analysis

import org.apache.commons.lang3.StringUtils
import wei.bigdata.analysis.RecordAnalysis._
import wei.bigdata.conf.{ErrorCol, ErrorRecord, Record, TableSchema}

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

  def qualityRecord(record: Record): Option[ErrorRecord] = {
    val patternArray = tableSchema.colPatternArray
    val errorColBuffer: mutable.ArrayBuffer[ErrorCol] = new mutable.ArrayBuffer[ErrorCol]

    if (patternArray == null) {
      return None
    }
    patternArray.foreach(item => {
      val valueOption = record.getValue(item.name)
      valueOption match {
        case Some(null) => errorColBuffer += new ErrorCol(item, null, item.name)
        case Some(value) => {
          if (StringUtils.isNotBlank(item.typePattern)) {
            // typePattern
          } else {
            val pattern = getPattern(item.pattern)
            val find = pattern.matcher(value.toString).find()
            if (!find) {
              errorColBuffer += new ErrorCol(item, valueOption.get, item.name)
            }
          }
        }
        case None => if (!item.nullAble) errorColBuffer += new ErrorCol(item, null, item.name)
      }
    })

    if (errorColBuffer.isEmpty) {
      None
    } else {
      val errorRecord = new ErrorRecord
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
