package io.uarun.experiments.typelevel.scalaz.foldable

import scalaz.Monoid

import scalaz.std.anyVal._
import scalaz.syntax.monoid._
import scalaz.syntax.show._

object ListFoldMapSyntax {
  implicit class ListOps[A](value: List[A]) {
    def foldMap[B : Monoid](f: A ⇒ B = (a: A) ⇒ a): B =
      value.foldLeft(mzero[B])(_ |+| f(_))
  }
}

object MyFoldableV2 {

  import ListFoldMapSyntax._
  def main(args: Array[String]): Unit = {
    List("1", "2", "3").foldMap(_.toInt).println
    List(1, 2, 3).foldMap().println
  }
}
