package wei.bigdata

import org.apache.commons.cli.{DefaultParser, Options}
import wei.bigdata.work.DataQuality


/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 9:36
 */
class Application

object Application extends App {
  val options = new Options
  options.addOption("job", true, "Job config json file")

  private val parser = new DefaultParser
  val cl = parser.parse(options, args)
  DataQuality.entry(cl.getOptionValue("job"))
}
