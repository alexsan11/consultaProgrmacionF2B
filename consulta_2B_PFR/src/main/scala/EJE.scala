import akka.actor.ActorSystem
import akka.stream.scaladsl.Source
import akka.stream.{ActorMaterializer, Materializer}

object Main extends App {
  implicit val system: ActorSystem = ActorSystem("MySystem")
  implicit val materializer: Materializer = ActorMaterializer()

  val numbers: Source[Int, _] = Source(1 to 10)

  numbers
    .map(_ * 2) // Operador map para multiplicar cada número por 2
    .filter(_ % 3 == 0) // Operador filter para filtrar solo los números divisibles por 3
    .reduce(_ + _) // Operador reduce para sumar todos los números resultantes

  numbers.runForeach(println) // Función subscribe para imprimir cada número resultante

  system.terminate()
}