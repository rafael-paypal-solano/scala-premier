import java.text.SimpleDateFormat
import java.util.{Date, Properties}

val formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
def escaper(string: String) = "\""+string.replaceAll("\"", "\\\"")+"\""

class BillItem(
    val desc: String,
    val amount: Double,
    val count: Int    
) {
    override def toString = s"{desc:${escaper(desc)}, amount:$amount, count:$count}."
}

class Bill (
    val creationDate: Date,
    val items: Seq[BillItem]
)


val bills = Seq[Bill] (
    new Bill(
        formatter.parse("2001-09-11 11:00:01"),
        Seq[BillItem] (
            new BillItem("8oz Bottled Water \"Dazany\"", 24.0, 8),
            new BillItem("Omelette", 6.0, 2),
            new BillItem("Hot Dog", 1.0, 1)            
        ) 
    ),
    new Bill(
        formatter.parse("2009-09-21 14:00:01"),
        Seq[BillItem] (
            new BillItem("8oz Bottled Water \"Dazany\"", 36.0, 8),
            new BillItem("Omelette", 6.0, 1),
            new BillItem("Hot Dog", 2.0, 1),
            new BillItem("Diapers", 3.0, 3)
        ) 
    )        
)
/*
Map(Omelette -> List((Omelette,3.0), (Omelette,6.0)), Hot Dog -> List((Hot Dog,1.0), (Hot Dog,2.0)), Diapers -> List((Diapers,1.0)), 8oz Bottled Water "Dazany" -> List((8oz BottledWater "Dazany",3.0), (8oz Bottled Water "Dazany",4.5)))
*/

//Creates a single list containing items from all bills.
val allItems = bills.flatMap(bill => bill.items) 

 //Calculate per-bill item prices
val allPrices = allItems.map(item => item.desc -> item.amount / item.count)

//Group per-bill item prices by item description
val allPricesByItem = allPrices.groupBy(tuple => tuple._1).map ({case (desc:String, prices:List[(String, Double)])=> desc -> prices.map(_._2)})

//Calculates average item price
val averagePrices = allPricesByItem.map({case (k:String, v:List[Double])=> k->  v.fold(0.0)((a, b) => a + b) / v.size})

println(allPricesByItem)
println(averagePrices)
//Estimates average price per bill by converting Seq to a Map using Sea.map and _.toMap
//val prices = allItems.map( item => item.desc -> item.amount / item.count ).toMap
//println(prices)

