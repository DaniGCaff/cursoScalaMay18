package com.indizen.scala

/**
  * Created by scouto.
  */
object Secuencias extends App{


  //Ejercicios
  def addToList(list: List[Int], elem: Int): List[Int] = list :+ elem

  def addToListIfNotExists(list: List[Int], elem: Int): List[Int] = {
    if (list.contains(elem)) list :+ elem
    else list
  }

  def isPalindrome(list: List[Int]) : Boolean = list == list.reverse


  //Mapas
  val romanos = Map(1 -> "I", 2->"II", 3->"III", 4->"IV", 5->"V", 6->"VI", 7->"VII", 8->"VIII", 9->"IX", 10→"X")


}
