val capitals = Map(
    "Alabama" -> "Montgomery",
    "Alaska" -> "Juneau",
    "Wyoming" -> "Cheyenne"    
)

val lengths = capitals.map(
    entry => (entry._1, entry._2.length)
)

val upperCapitals = capitals.map {
    case (k, v) => (k, v.toUpperCase)
}

val morecapitals = capitals + ("Virginia" -> "Richmond")
println(lengths)
println(upperCapitals)
println(morecapitals)