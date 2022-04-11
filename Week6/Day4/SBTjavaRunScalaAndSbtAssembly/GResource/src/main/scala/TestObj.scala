import scala.io.Source
object TestObj {
  def main(args: Array[String]): Unit = {
  println("hello")
    val fileStream = getClass.getResourceAsStream("help.txt")
    val lines = Source.fromInputStream(fileStream).getLines
    lines.foreach(line => println(line))

  }
}
