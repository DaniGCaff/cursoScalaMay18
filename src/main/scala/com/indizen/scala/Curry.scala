package com.indizen.scala

/**
  * Created by scouto.
  */
object Curry extends App{

  def uncurry(f: Int => Int => Int): (Int, Int) => Int = {
    (a, b) => f(a)(b)
  }

  def curry(f: (Int, Int) => Int): Int => Int => Int = {
    a => b =>f(a,b)
  }

  def genericuncurry[A,B,C](f: A => B => C): (A, B) => C = {
    (a, b) => f(a)(b)
  }

  def genericcurry[A,B,C](f: (A, B) => C): A => B => C = {
    a => b =>f(a,b)
  }

}
