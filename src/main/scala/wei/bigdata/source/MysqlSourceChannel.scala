package wei.bigdata.source

import wei.bigdata.queue.RecordQueue

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-2-16 20:19
 */
class MysqlSourceChannel extends SourceChannel {
  override def init(): Unit = {
  }


  override def destroy(): Unit = {

  }

  /**
   * channel 名称
   *
   * @return
   */
  override def getName(): String = "mysql"

  override def read(queue: RecordQueue): Unit = {
  }
}
