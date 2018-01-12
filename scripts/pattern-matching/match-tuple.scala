val languages = Seq(
    ("Scala", "Martin", "Odersky"),
    ("Clojure", "Rich", "Hickey"),
    ("Lisp", "John", "McCarthy")
)

for(tuple <- languages) {
    tuple match {
        case ("Scala", _, _) => println("Found Scala")
        case (language, firstName, lastName) => println(s"Found other language $language ($firstName, $lastName)")
    }
}