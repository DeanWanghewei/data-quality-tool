package wei.bigdata.source

import com.alibaba.druid.pool.{DruidDataSource, DruidPooledConnection}
import org.slf4j.LoggerFactory
import wei.bigdata.conf.{QueryResultCol, Record}
import wei.bigdata.queue.RecordQueue

import scala.collection.mutable.ListBuffer

/**
 * @description: some desc
 * @author: weiyixiao
 * @email: wanghewei@kemai.cn
 * @date: 2022-1-26 15:48
 */
class MysqlSource extends Source {
  val logger = LoggerFactory.getLogger(this.getClass)
  private var druidConnection: DruidPooledConnection = _

  override def read(): Unit = {
    logger.info("start to read mysql ")
    val statement = druidConnection.getConnection.prepareStatement("select * from t_data_job_result where 1=1")
    val resultSet = statement.executeQuery()
    val metaData = resultSet.getMetaData
    val metaColList = ListBuffer[QueryResultCol]()

    for (i <- 1 to metaData.getColumnCount) {
      val col = new QueryResultCol(metaData.getColumnName(i), metaData.getColumnTypeName(i))
      metaColList += col
    }


    while (resultSet.next()) {
      val record = new Record()
      for (elem <- metaColList) {
        record.set(elem.getColumnName, resultSet.getObject(elem.getColumnName))
      }
      logger.info("add new record ...")
      RecordQueue.queue.put(record)
    }
    statement.close()
  }

  override def init(userProperties: String): Unit = {
    val source = new DruidDataSource()
    //    val map = new Gson().fromJson(userProperties, classOf[Map[String, AnyRef]])
    source.setDriverClassName("com.mysql.cj.jdbc.Driver")
    //    val properties = new Properties
    //    map.foreach(item => properties.setProperty(item._1, item._2.toString))
    //    source.setConnectProperties(properties)
    source.setUrl("jdbc:mysql://192.168.239.235:3306/gaia_ops_platform?useUnicode=true&characterEncoding=utf8&useOldAliasMetadataBehavior=true&serverTimezone=Asia/Shanghai")
    source.setUsername("root")
    source.setPassword("Km@666888")
    druidConnection = source.getConnection
  }
}
