package io.uarun.experiments.typelevel.scalaz.monoid

import scalaz.{Show, Monoid}
import scalaz.std.anyVal._
import scalaz.std.option._

import scalaz.syntax.monoid._
import scalaz.syntax.show._

case class Order(totalCost: Double, quantity: Double)
object Order {
  implicit val orderMonoid: Monoid[Order] =  new Monoid[Order] {
    override def zero: Order = Order(0, 0)
    override def append(o1: Order, o2: => Order): Order =
      Order(o1.totalCost + o2.totalCost,
            o1.quantity  + o2.quantity)
  }

  implicit val orderShow: Show[Order] = Show.shows { order ⇒
    s"${order.getClass.getSimpleName}(cost: ${order.totalCost}, qty: ${order.quantity})"
  }
}

object SuperAdderV2 {
  def add[T : Monoid](items: List[T]): T = {
    items.foldLeft(mzero[T])(_ |+| _)
  }

  def main(args: Array[String]): Unit = {
    val x = (1 to 10).toList
    add(x).println

    val y = List(Option(1), Option(14))
    add(y).println

    val o1 = Order(100, 10)
    val o2 = Order(200, 20)
    val os = List(o1, o2)
    add(os).println

    val oos = List(Option(o1), Option(o2))
    add(oos).println
  }
}
