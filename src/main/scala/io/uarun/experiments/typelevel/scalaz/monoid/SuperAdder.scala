package io.uarun.experiments.typelevel.scalaz.monoid

import scalaz.Monoid
import scalaz.std.anyVal._
import scalaz.std.option._

import scalaz.syntax.monoid._
import scalaz.syntax.show._

object SuperAdder {

  def add[T : Monoid](items: List[T]): T = {  //... Using view bounds
    items.foldLeft(mzero[T])(_ |+| _)
  }

  def add_[T](items: List[T])(implicit monoid: Monoid[T]): T = {  //... Using implicit typeclass parameter
    items.foldLeft(mzero[T])(_ |+| _)
  }

  def main(args: Array[String]): Unit = {
    val x = (1 to 10).toList
    add(x).println

    val y = List(Option(1), Option(14))
    add(y).println
  }
}
