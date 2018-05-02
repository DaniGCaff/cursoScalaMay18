package com.indizen.scala

/**
  * Created by scouto.
  */
object Secuencias extends App{


  //Ejercicios
  def addAtTheEnd(list: List[Int], elem: Int): List[Int] = ???

  def addAtTheEndIfNotExists(list: List[Int], elem: Int): List[Int] = ???

  def isPalindrome(list: List[Int]) : Boolean = list == list.reverse

  def doubleIfEven(list: List[Int]): List[Int] = ???

  //Mapas
  val romanos = Map(1 -> "I", 2->"II", 3->"III", 4->"IV", 5->"V", 6->"VI", 7->"VII", 8->"VIII", 9->"IX", 10→"X")

  def printMap(myMap: Map[Int, String]) = ???

  def printSortedMap(myMap: Map[Int, String]) = ???


  //Ejercicios


  def penultimate(list: List[Int]): Option[Int] = ???

  def duplicate(list: List[Int], k: Int): List[Int] = ???

  def rotate(list: List[Int], x: Int): List[Int] = ???





  def isPalindrome(word: String): Boolean = ???


  def second(list: List[Int]): Option[Int] = ???

  def nth(list: List[Int], n: Int): Option[Int] = ???

  def removeFirstElement[A](list: List[A], f: A => Boolean): List[A] = ???


}
