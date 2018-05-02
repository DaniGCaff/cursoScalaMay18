package com.indizen.scala

import scala.util.{Failure, Success, Try}

/**
  * Created by scouto.
  */
object Errores extends App{


  def divisionWithException (x: Int, y: Int) : Int = {
    try {
      x/y
    }catch {
      case e: Exception => println("division entre 0"); x
    }
  }

  def divisionwithTryPM (x: Int, y: Int) : Int = {

    Try(x/y) match {
      case Success(resultado) =>resultado
      case Failure(error) => println(error); x
    }
  }

  def divisionwithTry (x: Int, y: Int) : Try[Int] = {
    Try(x/y)
  }


  def divisionwithOption (x: Int, y: Int) : Option[Int] = {

    Try(x/y) match {
      case Success(resultado) => Some(resultado)
      case _ => None
    }
  }

  //Ejerciciso
  def aplicaInteres(cant: Double, tipo: Option[Double]): Double = ???

  def aplicaInteres2(cant: Option[Double], tipo: Option[Double]): Option[Double] = ???

  def aplicaInteresEither(cant: Option[Double], tipo: Option[Double]): Either[String, Double] =  ???


  def aplicaInteresEither(cant: Either[String, Double], tipo: Either[String, Double]): Either[String, Double] =  ???



}
