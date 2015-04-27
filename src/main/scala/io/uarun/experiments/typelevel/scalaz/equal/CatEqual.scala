package io.uarun.experiments.typelevel.scalaz.equal

import io.uarun.experiments.typelevel.typeclass.Cat

import scalaz.Equal
import scalaz.syntax.equal._

object CatEqual {

  object CatEqualImplicits {
    import scalaz.std.anyVal._
    import scalaz.std.string._

    implicit val catEqualImplicits: Equal[Cat] = Equal.equal[Cat] { (c1, c2) ⇒
      c1.name  === c2.name &&
      c1.age   === c2.age  &&
      c1.color === c2.color
    }
  }

  import CatEqualImplicits._
  def main(args: Array[String]): Unit = {
    val c1 = Cat("Keller", 40, "orange and black")
    val c2 = Cat("Dave",   42, "orange and black")

    println(c1 === c2)

    import scalaz.std.option._
    val optCat1: Option[Cat] = Some(c1)
    val optCat2: Option[Cat] = None

    println(optCat1 === optCat2)
    println(optCat1 =/= optCat2)
  }
}
