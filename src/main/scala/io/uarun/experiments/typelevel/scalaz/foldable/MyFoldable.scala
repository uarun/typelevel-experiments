package io.uarun.experiments.typelevel.scalaz.foldable

import scalaz.Monoid
import scalaz.std.anyVal._
import scalaz.syntax.monoid._

object ListFoldableSyntax {
  implicit class ListOps[A](value: List[A]) {
    def foldMap(implicit monoid: Monoid[A]): A = value.foldLeft(mzero[A])(_ |+| _)
  }
}

object MyFoldable {

  import ListFoldableSyntax._
  def main(args: Array[String]): Unit = {
    val x = List(1, 2, 3).foldMap
    println(x)
  }
}
