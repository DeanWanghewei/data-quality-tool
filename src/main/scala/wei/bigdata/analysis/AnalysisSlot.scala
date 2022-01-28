package wei.bigdata.analysis

import wei.bigdata.core.Slot
import wei.bigdata.queue.RecordQueue

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-28 9:58
 */
abstract class AnalysisSlot extends Slot {

  def start(recordQueue: RecordQueue): Unit

  override def run(): Unit = {



  }
}
