package io.uarun.experiments.typelevel.typeclass

trait Printable[A] {
  def format(value: A): String
}

object PrintDefaults {
  implicit val stringPrintable = new Printable[String] {
    override def format(value: String): String = value
  }

  implicit val intPrintable = new Printable[Int] {
    override def format(value: Int): String = value.toString
  }
}

object Print {
  def format[A](value: A)(implicit printer: Printable[A]): String = {
    printer.format(value)
  }

  def show[A](value: A)(implicit printer: Printable[A]): Unit = {
    println(printer.format(value))
  }
}

object PrintSyntax {
  implicit class PrintOps[A](value: A) {
    def format(implicit printer: Printable[A]): String = {
      printer.format(value)
    }

    def print(implicit printer: Printable[A]): Unit = {
      println(printer.format(value))
    }
  }
}
