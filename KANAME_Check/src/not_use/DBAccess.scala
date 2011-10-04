package db
import scala.actors.Actor._
import org.neodatis.odb.ODBFactory
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery
import org.neodatis.odb.Objects
import org.neodatis.odb.OdbConfiguration
import org.neodatis.odb.core.query.criteria.Where
import org.neodatis.odb.ODB

object ODBAccess{
    def DefaultPackageID = 1;
}
object DBAccess {
	val ex = actor{			
	  loop{
	    react{
	      case obj => {
//	        rslt = Some(fun())		//返値の設定
	      }
	    }
	  }
	}
	def exec[T1](fun:()=>T1):T1 = {
		var rslt:Option[T1] = None
		ex ! "go"
	    rslt.get
	}
	def abc():Int = {
	    exec{()=>{
	    	123
	    }}
	}
	def a = 123
	def b = "jjj"
}