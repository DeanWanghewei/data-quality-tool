package wei.bigdata.core.quality

import scala.beans.BeanProperty
import scala.collection.mutable

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 10:38
 */
class RecordError {
  @BeanProperty
  var colArray: mutable.ArrayBuffer[ColError] = new mutable.ArrayBuffer[ColError]
}
