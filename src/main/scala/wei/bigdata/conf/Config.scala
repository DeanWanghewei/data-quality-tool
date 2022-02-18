package wei.bigdata.conf

import com.google.gson.{JsonArray, JsonObject, JsonParser}

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-2-16 16:11
 */
class Config(_root: JsonObject) {
  private val root: JsonObject = _root

  def getIntOrElse(key: String, defaultValue: Int): Int = {
    val value = root.getAsJsonObject(key)
    if (value != null) {
      value.getAsInt
    } else {
      defaultValue
    }
  }

  private def getAsJsonObject(key: String): JsonObject = {
    if (!root.has(key)) throw new RuntimeException(s"配置[${key}]不存在，请重新检查配置后重试")
    root.getAsJsonObject(key)
  }

  def getAsArray(): JsonArray = {
    this.root.getAsJsonArray
  }

  def getConfig(key: String): Config = {
    new Config(getAsJsonObject(key))
  }
}

object Config {
  def fromConfigString(configStr: String): Config = {
    val jsonObject = JsonParser.parseString(configStr).getAsJsonObject
    new Config(jsonObject)
  }
}
