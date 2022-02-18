package wei.bigdata.queue

import wei.bigdata.core.record.Record

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-2-18 9:41
 */
trait RecordQueue {
  def put(record: Record): Unit

  def get(): Record
}
