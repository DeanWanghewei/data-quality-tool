package wei.bigdata.util

import org.reflections.Reflections

import scala.collection.JavaConverters._

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-2-18 14:35
 */
object ReflectUtil {
  def getSubClass[T](traitClass: Class[T]): Seq[T] = {
    val reflections = new Reflections()
    reflections.getSubTypesOf(traitClass).asScala.map(_.asInstanceOf[T]).toSeq
  }

}
