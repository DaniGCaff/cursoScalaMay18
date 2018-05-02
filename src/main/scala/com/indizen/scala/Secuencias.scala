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

  def doubleIfEven(list: List[Int]): List[Int] = {
    list.filter(x => x %2 ==0).map(x=> x*2)
  }

  //Mapas
  val romanos = Map(1 -> "I", 2->"II", 3->"III", 4->"IV", 5->"V", 6->"VI", 7->"VII", 8->"VIII", 9->"IX", 10→"X")

  def printMap(myMap: Map[Int, String]) = {
    myMap.foreach{
      case (k, v) => println(s"${k} => ${v}")
    }
  }

  def printSortedMap(myMap: Map[Int, String]) = {
    myMap.toList.sortBy(_._1).foreach{
      case (k, v) => println(s"${k} => ${v}")
    }
  }


  //Ejercicios


  def penultimate(list: List[Int]): Option[Int] = {
    list.reverse match {
      case h::Nil  => None
      case h::t => Some(t.head)
      case _ => None
    }
  }

  def duplicates(list: List[Int], k: Int): List[Int] = {
//     for {
//        elem <- list
//      } yield List.fill(k)(elem)
//    }.flatten


    //    list.flatMap(e => List.fill(k)(e))


    list.flatMap(x => (1 to k).map(_ => x))

  }

  def rotate(list: List[Int], x: Int): List[Int] = {
    list match  {
      case Nil => list
      case h::Nil => list
      case h::t if x == 0 => list
      case h::t if x > 0 => rotate(t:+h, x-1)
      case h::t if x < 0 => rotate(t.reverse.head::h::t.reverse.tail.reverse, x+1)
    }


    //    list match {
    //      case Nil => Nil
    //      case l if (x > 0) => rotate(l.tail:::List(l.head), x-1)
    //      case l if (x < 0) => rotate(l.last::l.init, x+1)
    //      case l => l
    //    }


  }
  def isPalindrome(word: String): Boolean = {
    word.toUpperCase == word.reverse.toUpperCase
  }


  def removeFirstElement[A](list: List[A], f: A => Boolean): List[A] = {

    @annotation.tailrec
    def go(acc: List[A], rest: List[A]): List[A] = {

      rest match {
        case Nil => acc
        case h::t if f(h) => acc:::t
        case h::t if !f(h) => go(acc :+ h, t)
      }
    }

    go (List(), list)
  }

  //Ejercicios
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


}
