package io.uarun.experiments.typelevel.scalaz.functors

import scalaz.std.function._
import scalaz.syntax.functor._

object FunctorSandbox {

  def main(args: Array[String]): Unit = {
    val func1 = (x: Int) ⇒ x.toDouble
    val func2 = (y: Double) ⇒ y * 2
    val func3 = func1 map func2

    println(func3(3))   //... 6.0


    import scalaz.{Functor, Show}
    import scalaz.std.anyVal._
    import scalaz.std.list._
    import scalaz.std.option._
    import scalaz.std.string._
    import scalaz.syntax.show._

    Functor[List].map(List(1, 2, 3))(_ * 2).println     //... [2, 4, 6]
    Functor[Option].map(Some(123))(_.toString).println  //... Some("123")

    //... Lift Int ⇒ Int to Option[Int] ⇒ Option[Int]
    val optDoubler = Functor[Option].lift((x: Int) ⇒ x * 2)
    optDoubler(Some(2)).println
  }
}
