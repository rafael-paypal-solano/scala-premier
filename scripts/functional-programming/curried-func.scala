def cat1(s1: String)(s2: String) = s1 + s2
val greetings = cat1("Greetings ") _
val saludos = cat1("Saludos ") _

println(greetings("to my folks."))
println(saludos("a mi gente."))