import akka.actor.ActorSystem
import akka.stream.scaladsl.{Source, Sink}
import akka.stream.{ActorMaterializer, Materializer}
import scala.concurrent.duration._

object ReactiveProgrammingExample extends App {
  // Configuración del sistema de actores y el materializador
  implicit val system: ActorSystem = ActorSystem("ReactiveExample")
  implicit val materializer: Materializer = ActorMaterializer()

  // Definir una fuente de datos (Observable)
  val numbersSource = Source(1 to 4)

  // Aplicar operadores de transformación y filtrado
  val resultFuture = numbersSource
    .map(_ * 2)            // Operador map: Multiplicar cada elemento por 2
    .filter(_ % 3 == 0)    // Operador filter: Filtrar los elementos que son divisibles por 3
    .reduce(_ + _)         // Operador reduce: Sumar todos los elementos restantes
    .runWith(Sink.head)


  println(resultFuture)


}