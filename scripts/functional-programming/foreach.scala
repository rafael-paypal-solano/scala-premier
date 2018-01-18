List(1, 2, 3, 4, 5) foreach {i => println(s"Int: $i")}

val capitals = Map(
    "Alabama" -> "Montgomery",
    "Alaska" -> "Juneau",
    "Wyoming" -> "Cheyenne"
)

capitals.foreach {case (k, v) => println(s"($k, $v)")}