val states = Set("Alabama", "Alaska", "Wyoming")
val lengths = states.map(state=> state.length)

val states2 = states + "Virginia"
val states3 = states2 + ("New York", "Illinois")