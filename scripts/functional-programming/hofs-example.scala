/*
A requirement of the function passed to reduce is that the
operation performed must be associative, like multiplication or addition, because we
are not guaranteed that the collection elements will be processed in a particular order!
*/
println((1 to 10).filter(n => n % 2 == 0).map(n=> n * 2).reduce((x, y) => x * y))