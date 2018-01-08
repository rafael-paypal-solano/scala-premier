
package typelessdomore
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Futures {
    def sleep(millis: Long) = {
        Thread.sleep(millis)        
    }

    def doWork(index: Int):Int = {
        sleep((math.random * 1000).toLong)
        index
    }

    def main(args: Array[String]): Unit = {
        
        (1 to 5).foreach { index =>
            val future = Future {
                doWork(index)
            }

            future onSuccess {
                case answer: Int => println(s"Success ! returned: !answer")
            }

            future onFailure {
                case th: Throwable => println(s"failure returned: $th")
            }
        }
        
        println("started!")
        sleep(1000)
    }
}