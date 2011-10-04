package db
import scala.actors.Actor._
import org.neodatis.odb.ODBFactory
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery
import org.neodatis.odb.Objects
import org.neodatis.odb.OdbConfiguration
import org.neodatis.odb.core.query.criteria.Where
import org.neodatis.odb.ODB

object odb{
	var db:ODB = null;
    OdbConfiguration.setDatabaseCharacterEncoding("UTF-8")
    OdbConfiguration.useMultiThread(true, 3)
	object transaction {
		def apply[T1](fun: => T1):Option[T1]={
			var reslt:Option[T1] = None
		    this.synchronized{
		        try{
			        db = ODBFactory.open(System.getProperty("user.dir"))
					println("open")
					reslt = Some(fun)
					println("close:")
					db.commit
		        }catch{
		            case ex:Exception => ex.printStackTrace
		        } finally {
		            db.close
		        }
		        reslt
		    }
		}
	}
}