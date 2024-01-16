import monix.execution.Scheduler.Implicits.global
import monix.reactive._
import concurrent.duration._

object Main extends App {

  val source = Observable.interval(1.second)
  val evenNumbers = source.filter(_ % 2 == 0)
  val doubledNumbers = evenNumbers.flatMap(x => Observable(x, x))
  val limitedStream = doubledNumbers.take(10)
  val cancelable = limitedStream.dump("O").subscribe()
}
