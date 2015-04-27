package io.uarun.experiments.typelevel.scalaz.show

import io.uarun.experiments.typelevel.scalaz.show.CatShow.CatShowImplicits._
import io.uarun.experiments.typelevel.typeclass.Cat

import scalaz.Show
import scalaz.syntax.show._

object CatShow {

  //... Show implementation for Cat case class
  object CatShowImplicits {
    import scalaz.std.anyVal._
    import scalaz.std.string._

    implicit val catShowImplicit: Show[Cat] = Show.shows[Cat] { cat ⇒
      val name  = cat.name.shows
      val age   = cat.age.shows
      val color = cat.color.shows
      s"$name is a $age year-old $color cat"
    }
  }

  def main(args: Array[String]): Unit = {
    val c1 = Cat("Cutie", 3, "White")
    c1.println
    Cat("Brownie", 10, "Black & Brown").println
  }
}
