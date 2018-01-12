def check(y: Int) = {
    for {
        x <- Seq (99, 100, 101)
    } {
        var str = x match {
            case `y` => "found y!"
            case i: Int => "int: " + i
        }
        println(str)
    }
    
}

check(100)