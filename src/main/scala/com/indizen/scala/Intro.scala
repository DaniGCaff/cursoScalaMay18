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


  //Ejercicios fin de sesión
//  def operate[A, B] = ???

  def max(list: List[Int]): Int = ???

  def second(list: List[Int]): Int = ???

  def nth(list: List[Int], n: Int): Int = ???

}










