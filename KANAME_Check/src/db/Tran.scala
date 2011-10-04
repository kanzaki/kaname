package db

object Tran {
    private var odbImpl:ODB = null
    def odb = odbImpl
    def apply[T](fun: =>T):T = {
    	def exec:T = synchronized{
    	    if(odb == null) {
    	        odbImpl = new ODB
		        odb.open
    	        var rtn:T = fun
		        odb.close
		        odbImpl = null
		        rtn
    	    }else{
		        fun
    	    }
    	}
        exec
    }
    class ODB{
        def open = println("open")
        def close = println("close")
        def go = println("go go go")
    }
}