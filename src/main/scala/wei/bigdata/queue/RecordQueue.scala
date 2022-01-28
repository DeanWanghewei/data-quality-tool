package wei.bigdata.queue

import wei.bigdata.conf.Record

import java.util.concurrent.LinkedBlockingQueue

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 14:09
 */
class RecordQueue {

}

object RecordQueue {
  val queue: LinkedBlockingQueue[Record] = new LinkedBlockingQueue[Record]()
}
