package com.indizen.scala

object Estrictas extends App{


  def myIf[A](cond: Boolean, onTrue: => A, onFalse: => A): A = {
    if (cond) onTrue
    else onFalse
  }

  def duplicateStrict(x: Double): Double = {
    println(x*2)
    x*2
  }

  def duplicateNonStrict(x: => Double): Double = {
    println(x*2)
    x*2
  }


  def duplicateNonStrictLazy(x: => Double): Double = {
    lazy val j = x
    println(j+j)
    j+j
  }

  duplicateStrict({println("duplicateStrict"); 10+11})
  duplicateNonStrict({println("duplicateNonStrict"); 10+11})
  duplicateNonStrictLazy({println("duplicateNonStrictLazy"); 10+11})


}
