import java.io.FileNotFoundException

import scala.io.Source
import scala.util.Try

object FileOperation extends App{

  val filename = "/home/niranjan/test.txt"
  try {

    val fileLines = Source.fromFile(filename).getLines.mkString("")
    print(fileLines)
  } catch {
    case  e :FileNotFoundException => println(s"Couldn't find file : $filename" )
  }

  def readFile(filename:String):Try[List[String]]={
    import Control._
    Try{
      val lines = using(io.Source.fromFile(filename)) {
        source => (for (line <- source.getLines()) yield line).toList
    }
     lines
    }

  }

}

object Control {
  def using [A <: {def close(): Unit} ,B](resource :A)(f:A=>B): B ={

    try {
      f(resource)
    } finally {
      resource.close()
    }
  }
}