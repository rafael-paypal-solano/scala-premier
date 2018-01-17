val list1 = List("Programming", "Scala")

//the '::' method is called called “cons” (for “construct”), creates new lists by prepending new elements to an existing list
val list2 = "People" :: "should" :: "read" :: list1

// :: method to construct a list by prepending elements to the Nil empty list
val list3 = "Programming" :: "Scala" :: Nil