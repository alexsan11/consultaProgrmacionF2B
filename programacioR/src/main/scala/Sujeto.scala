import akka.actor._

case class SuscribirObservador(actor: ActorRef)
case class DesuscribirObservador(actor: ActorRef)
case class NotificarCambioEstado(estado: String)

class Sujeto extends Actor{
  var observadores: List[ActorRef] = List()

  def receive = {
    case SuscribirObservador(actor) =>
      observadores = actor :: observadores
    case DesuscribirObservador(actor) =>
      observadores = observadores.filter(_ != actor)
    case NotificarCambioEstado(estado) =>
      observadores.foreach(_ ! estado)
  }

}
class Observador extends Actor {
  def receive = {
    case mensaje: String =>
      // Manejar la notificación del sujeto
      println(s"Se ha recibido una notificación: $mensaje")
  }
}
val system = ActorSystem("SistemaObservador")
val sujeto = system.actorOf(Props[Sujeto], "sujeto")
val observador = system.actorOf(Props[Observador], "observador")

// Suscribir el observador al sujeto
sujeto ! SuscribirObservador(observador)

// Notificar un cambio de estado
sujeto ! NotificarCambioEstado("Nuevo estado")