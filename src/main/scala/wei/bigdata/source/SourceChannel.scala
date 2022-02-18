package wei.bigdata.source

import wei.bigdata.conf.Config
import wei.bigdata.core.ConstantCore
import wei.bigdata.queue.RecordQueue

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-2-16 15:58
 */
abstract class SourceChannel extends Runnable {


  private var config: Config = _
  private var queue: RecordQueue = _

  def setSourceChannelConfig(_config: Config): Unit = config = _config

  def getConfig(): Config = {
    this.config.getConfig(ConstantCore.PARAMETER)
  }

  def setQueue(_queue: RecordQueue): Unit = {
    this.queue = _queue
  }

  def init(): Unit

  def read(queue: RecordQueue): Unit

  def destroy(): Unit

  /**
   * channel 名称
   *
   * @return
   */
  def getName(): String


  override def run(): Unit = {
    init()
    read(queue)
  }
}

object SourceChannel {
  def getSourceChannel(rootConfig: Config): SourceChannel = {
    val sourceRootConfig = rootConfig.getConfig(ConstantCore.SOURCE)
    val sourceName = sourceRootConfig.getConfig(ConstantCore.NAME)

    val channel = new MysqlSourceChannel
    channel.setSourceChannelConfig(sourceRootConfig)
    channel
  }
}
