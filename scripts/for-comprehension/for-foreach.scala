val states = List("Alabama", "Alaska", "Virginia", "Wyoming")

//1 Foreach
for {
    s <- states
} println(s)

states.foreach(println)

//2 Map
println(
    for {
        g <- states
    } yield g.toUpperCase
)
println(states.map(_.toUpperCase))

//3 Flatmap

println(for {
    s <- states
    c <- s.toList
} yield (s,c))

println(states.flatMap(state => state.toList.map((state,_))) )

//4 Flatmap + Filtering
println(for {
        s <- states
        c <- s.toList
        if c.isUpper
    } yield (s,c)
)

println(states.flatMap(state => state.toList.map((state,_))).filter(_._2.isUpper) )