var factor = 2
val multiplier = (i: Int) => i * factor

println(
    (1 to 10)
    .filter(n => n % 2 == 0)
    .map(multiplier)
    .reduce((x,y) => x * y)  
)

factor = 3


println(
    (1 to 10)
    .filter(n => n % 2 == 0)
    .map(multiplier)
    .reduce((x,y) => x * y)  
)