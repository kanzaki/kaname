import db.Tran

class Tester {
	def first(): Int = { 
		Tran{ 
			val a = 123
			val b = 22
	        println("first -----------------")
			Tran.odb.go
			nest()
			a + b
	    }
	}
	def nest():Int = {
	    Tran[Int]{
	        println("nest -----------------")
	    	Tran.odb.go
	        0
	    }
	}
}