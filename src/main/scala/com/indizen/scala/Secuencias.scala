package com.indizen.scala

/**
  * Created by scouto.
  */
object Secuencias extends App{


  //Ejercicios
  def addAtTheEnd(list: List[Int], elem: Int): List[Int] = list :+ elem

  def addAtTheEndIfNotExists(list: List[Int], elem: Int): List[Int] = {
    if (list.contains(elem)) list :+ elem
    else list

//    if (list.exists( _ == elem)) list :+ elem
//    else list
  }

  def isPalindrome(list: List[Int]) : Boolean = list == list.reverse

  def doubleIfEven(list: List[Int]): List[Int] = {
    list.filter(x => x %2 ==0).map(x=> x*2)
  }

  //Mapas
  val romanos = Map(1 -> "I", 2->"II", 3->"III", 4->"IV", 5->"V", 6->"VI", 7->"VII", 8->"VIII", 9->"IX", 10→"X")

  def printMap(myMap: Map[Int, String]) = ???

  def printSortedMap(myMap: Map[Int, String]) = ???


  //Ejercicios


  def penultimate(list: List[Int]): Option[Int] = {
  list.reverse match {
    case h::Nil  => None
    case h::t => Some(t.head)
    case _ => None
  }
}
  def duplicate(list: List[Int], k: Int): List[Int] = ???

  def rotate(list: List[Int], x: Int): List[Int] = ???

  def isPalindrome(word: String): Boolean = {
    word.toUpperCase == word.reverse.toUpperCase
  }


  def second(list: List[Int]): Option[Int] = {
    list match {
      case h :: h2 :: t => Some(h2)
      case _ => None
    }
  }

  def nth(list: List[Int], n: Int): Option[Int] = {
    list match {
      case h :: t if n == 0 => Some(h)
      case h :: t if n > 0 => nth(t, n - 1)
      case _ => None
    }
  }

  def removeFirstElement[A](list: List[A], f: A => Boolean): List[A] = ???


}
