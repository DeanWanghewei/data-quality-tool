package wei.bigdata.queue

import wei.bigdata.core.record.{DoneRecord, Record}

import java.util.concurrent.LinkedBlockingDeque

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-2-18 9:36
 */
class DefaultRecordQueue extends RecordQueue {
  val queue: LinkedBlockingDeque[Record] = new LinkedBlockingDeque[Record]

  override def put(record: Record): Unit = {
    queue.put(record)
  }

  override def get(): Record = {
    val first = queue.getFirst
    if (first.isInstanceOf[DoneRecord]) return null
    first
  }

}

