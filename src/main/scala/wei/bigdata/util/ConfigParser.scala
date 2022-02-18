package wei.bigdata.util


import org.apache.commons.io.FileUtils
import org.apache.commons.lang3.StringUtils

import java.io.File

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 15:02
 */
class ConfigParser {


}

object ConfigParser {
  /**
   * load local file context
   *
   * @return file text
   */
  def loadLocalPath(path: String): String = {
    if (StringUtils.isBlank(path)) {
      throw new RuntimeException("must config in start args:  -job <var>")
    }
    FileUtils.readFileToString(new File(path),"utf-8")
  }
}
