package io.uarun.experiments.typelevel.scalaz.functors

import scalaz.Functor
import scalaz.syntax.functor._

sealed trait Result[+A]
final case class Success[A](value: A) extends Result[A]
final case class Warning[A](value: A, message: String) extends Result[A]
final case class Failure[A](message: String) extends Result[Nothing]

object ResultImplicits {
  implicit val resultFunctor = new Functor[Result] {
    override def map[A, B](fa: Result[A])(f: (A) => B): Result[B] = fa match {
      case Success(a)      ⇒ Success(f(a))
      case Warning(a, msg) ⇒ Warning(f(a), msg)
      case Failure(msg)    ⇒ Failure(msg)
    }
  }

  //... We need these convenient constructors to deal with invariance issue (when resolving the implicit)
  def success[A](value: A): Result[A] = Success(value)
  def warning[A](value: A, msg: String): Result[A] = Warning(value, msg)
  def failure[A](msg: String): Result[A] = Failure(msg)
}

object Main {
  def main(args: Array[String]): Unit = {
    import ResultImplicits._
    val r1 = success(10)
    val r2 = warning(1, "Very small number")

    println(success(10) map (_ * 10))
    println(r2 map (_ * 10))
    println(failure[Int]("Error!") map (_ * 10))
  }
}
