import scala.collection.mutable._
import scala.collection.immutable.List

val fruit_to_color: Map[String, String] = Map(
  "banana" -> "yellow",
  "blueberry" -> "blue",
  "cherry" -> "red",
  "lemon" -> "yellow",
  "kiwi" -> "green")

def reverse(map: Map[String, String]): Map[B,List[A]]  = {
  var result = Map[String, List[String]]()
  map.foreach{case (key:String, value:String) =>
    result.put(value, result.getOrElse(value, List()).::(key))
  }
  result
}

def reverse2(map: Map[String, String]): Map[B,List[A]]  = {
    map.foldLeft[Map[String, List[String]]](Map()) { case (result, (key, value)) =>
      val list: List[String] = result.getOrElse[List[String]](value, List[String]()).::(key)
      result.put(value, list)
      result
    }
}

reverse(fruit_to_color)
