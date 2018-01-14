def calcTax(amount: Float)(implicit rate: Float): Float = amount * rate;

object SimpleStateSalexTax {
    implicit val rate: Float = 0.05F
}

{
    import SimpleStateSalexTax.rate
    val amount = 100F
    println(s"Tax on $amount = ${calcTax(amount)}")
}

case class ComplicatedSalesTaxData (
    baseRate: Float,
    isTaxHoliday: Boolean,
    storeId: Int
)

object ComplicatedSalesTax {
    private def extraTaxRateForStore(id: Int): Float = {
        // From id, determine location, then extra taxes...
        0.0F
    }

    implicit def rate(implicit cstd: ComplicatedSalesTaxData): Float = 
        if(cstd.isTaxHoliday) 0.0F
        else cstd.baseRate + extraTaxRateForStore(cstd.storeId)
}

{
    import ComplicatedSalesTax.rate
    implicit val myStore = ComplicatedSalesTaxData(0.06F, false, 1010)
    val amount = 100F

    println(s"Tax on $amount = ${calcTax(amount)}")
}