package io.uarun.experiments.typelevel.scalaz.monoid

import scalaz.Monoid
import scalaz.std.anyVal._
import scalaz.std.string._

import scalaz.syntax.show._

object MonoidWorkbench {

  def main(args: Array[String]): Unit = {
    Monoid[String].append("Hello, ", "World").println
    Monoid.apply[String].append("Hello, ", "World").println

    import scalaz.syntax.monoid._
    val instance = Monoid[String]
    (instance.zero |+| "Test").println
    ("hello, " |+| "world").println

    val intMulMonoid = Monoid.instance[Int](_ * _, 1)
    val intModMonoid = Monoid.instance[Int](_ % _, 0)
    intMulMonoid.append(2, 3).println
    intModMonoid.append(6, 4).println
  }
}
