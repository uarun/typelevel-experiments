package io.uarun.experiments.typelevel.scalaz.monads

import scala.language.higherKinds

object MonadSandbox {

  def main(args: Array[String]): Unit = {
  }

  //... Implement map in terms of flatMap and point
  object MapInTermsOfFlatMapAndPoint {
    def flatMap[F[_], A, B](value: F[A])(func: A ⇒ F[B]): F[B] = ???
    def point[F[_], A](value: A): F[A] = ???

    def map[F[_], A, B](fa: F[A])(func: A ⇒ B): F[B] = {
      flatMap(fa)(a ⇒ point(func(a)))
    }
  }
}
