object Multiplier {
    var factor = 2
    def multiplier(i: Int) = i * factor
}

println((1 to 10) filter (_ % 2 == 0) map Multiplier.multiplier reduce (_ * _))

Multiplier.factor = 3
println((1 to 10) filter (_ % 2 == 0) map Multiplier.multiplier reduce (_ * _))