 val results: Seq[Option[Int]] = Vector(Some(10), None, Some(20))

 val results2 = for {
     Some(i) <- results
 } yield(2 * i)

 println(results2)