val seq1 = Seq("Programming", "Scala")

//For Seq , the “cons” operator is '+:' instead of '::'

val seq2 = "People" +: "shoud" +: "read" +: seq1

val seq3 = seq1 ++ seq2