package introscala.shapes
import akka.actor.{Props, Actor, ActorRef, ActorSystem}
import com.typesafe.config.ConfigFactory

private object Start 

object ShapesDrawingDriver {
    def main(args: Array[String]): Unit = {
      val system = ActorSystem("DrawingActorSystem", ConfigFactory.load())
      val drawer = system.actorOf(Props(new ShapesDrawingActor), "drawingActor")
      val driver = system.actorOf(Props(new ShapesDrawingDriver(drawer)), "drawingService")
      
      driver ! Start
    }
}

class ShapesDrawingDriver (drawerActor: ActorRef) extends Actor {
  import Messages._
  
  def receive = {
    case Start =>
      drawerActor ! Circle(Point(0.0,0.0), 1.0)
      drawerActor ! Rectangle(Point(0.0,0.0), 2, 5)
      drawerActor ! 3.14159
      drawerActor ! Triangle(Point(0.0,0.0), Point(2.0,0.0), Point(1.0,2.0))
      drawerActor ! Exit

    case response: Response =>
      println("ShapesDrawingDriver: Response = " + response)      

    case Finished =>
      println(s"ShapesDrawingDriver: cleaning up...")
      context.stop(self)

    case unexpected =>
      println("ShapesDrawingDriver: ERROR: Received an unexpected message = "+ unexpected)      
  }
}