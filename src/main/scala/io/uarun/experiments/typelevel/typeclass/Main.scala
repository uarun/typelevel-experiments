package io.uarun.experiments.typelevel.typeclass

case class Cat(name: String, age: Int, color: String)

object Cat {
  import PrintDefaults._

  implicit val catPrinter = new Printable[Cat] {
    override def format(cat: Cat): String = {
      val name  = Print.format(cat.name)
      val age   = Print.format(cat.age)
      val color = Print.format(cat.color)
      s"$name is a $age year-old $color cat."
    }
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    import PrintSyntax._
    val cat = Cat("Cutie", 2, "Brown")
    cat.print
  }
}
