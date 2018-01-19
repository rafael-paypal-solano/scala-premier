val stateCapitals = Map(
    "Alabama" -> "Montgomery",
    "Alaska" -> "Juneau",
    "Wyoming" -> "Cheyenne"
)

val map2 = stateCapitals.filter({ pair => pair._1.startsWith("A") })
println(map2)