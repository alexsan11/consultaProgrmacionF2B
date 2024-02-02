import akka.actor.ActorSystem
import akka.stream.scaladsl.{Source, Sink}
import akka.stream.{ActorMaterializer, Materializer}
import scala.concurrent.duration._


val resultFuture = Source(1 to 10)
  .map(_ * 2) // Operador map: Multiplicar cada elemento por 2
  .filter(_ % 3 == 0) // Operador filter: Filtrar los elementos que son divisibles por 3
  .reduce(_ + _) // Operador reduce: Sumar todos los elementos restantes
  