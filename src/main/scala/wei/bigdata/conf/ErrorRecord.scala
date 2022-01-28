package wei.bigdata.conf

import scala.beans.BeanProperty
import scala.collection.mutable

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 10:38
 */
class ErrorRecord {
  @BeanProperty
  var colArray: mutable.ArrayBuffer[ErrorCol] = new mutable.ArrayBuffer[ErrorCol]
}
