def doSeqMatch[T] (seq: Seq[T]): String = seq match {
    case Nil => "Nothing"
    case head +: _ => head match {
        case _ : Double => "Double"
        case _ : String => "String"
        case _ => "Unmatched seq Element"
    }
}

for {
    x <- Seq(List(5.5, 5.6, 5.7), List("a", "b"), Nil)
}{
    x match {
        case seq: Seq[_] =>  println(s"seq ${doSeqMatch(seq)}", seq)
        case _ => println("unknown", x)
 
    }
}