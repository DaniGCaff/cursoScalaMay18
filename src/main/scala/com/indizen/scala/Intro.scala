package com.indizen.scala

/**
  * Created by scouto.
  */
object MyApp extends App {
  println("Hello World ")


  //Ejemplos funciones
  def sum(x: Int, y: Int): Int = {
    x + y
  }




  //Ejemplos orden superior
  def createSum(x: Int): Int => Int = (y: Int) => x + y




  //Ejemplos recusividad
  def wrongFactorial(n: Int) = {
    if (n <= 0) 1
    else n * factorial(n - 1)
  }


  def factorial(n: Int) = {

    @annotation.tailrec
    def rec(acc: Int, current: Int): Int = {
      if (current <= 0) acc
      else rec(acc * current, current - 1)

    }

    rec(1, n)
  }

  //Ejemplos funciones Parciales
  def divide: PartialFunction[Int, Int] = {
    case d: Int if d != 0 => 42 / d
  }

  val divide2: PartialFunction[Int, Int] = {
    case d: Int if d != 0 => 42 / d
  }

  def divide3(x: Int): PartialFunction[Int, Int] = {
    case d: Int if d != 0 => x / d
  }


  //Ejercicios

  def createOp(x: Int, f: Int => Int): Int => Int = (y: Int) => f(x,y)


  def operate[A, B](x: A, y: A, f: (A, A) => B) = f(x, y)

  def max(list: List[Int]): Int = {

    @annotation.tailrec
    def go(current: Int, rest: List[Int]): Int = {
      rest match {
        case Nil => current
        case h :: t => if (h > current) go(h, t) else go(current, t)
      }
    }

    go(Int.MinValue, list)
  }

  def second(list: List[Int]): Int = {
    list match {
      case h :: h2 :: t => h2
      case _ => 0
    }
  }

  def nth(list: List[Int], n: Int): Int = {
    list match {
      case h :: t if n == 0 => h
      case h :: t if n > 0 => nth(t, n - 1)
      case _ => 0
    }
  }

}










