package wei.bigdata.core

import wei.bigdata.conf.Configuration

/**
 * @description: 作为一个插件来使用
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-28 9:36
 */
trait Slot extends Runnable {
  protected var config: Configuration = _

  /**
   * the slot generate name,
   * this name must be unique
   *
   * @Return slotName
   */
  def getSlotName: String

  /**
   * init this slot
   */
  def init(): Unit

  /**
   * The slot will call out
   */
  def destroy(): Unit

  /**
   * init slot config
   *
   * @param slotConfig configProperties
   */
  def setSlotConf(slotConfig: Configuration): Unit = {
    this.config = slotConfig
  }

  def getSlotConfig: Configuration = this.config

}
