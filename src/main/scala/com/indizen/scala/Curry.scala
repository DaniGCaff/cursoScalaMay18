package com.indizen.scala

/**
  * Created by scouto.
  */
object Curry extends App{

  def uncurry(f: Int => Int => Int): (Int, Int) => Int = ???

  def curry(f: (Int, Int) => Int): Int => Int => Int = ???

  def genericuncurry[A,B,C](f: A => B => C): (A, B) => C = ???

  def genericcurry[A,B,C](f: (A, B) => C): A => B => C = ???

}
