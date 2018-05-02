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
  def aplicaInteres(cant: Double, tipo: Option[Double]): Double = {
    cant * tipo.getOrElse(1.5)
  }

  def aplicaInteres2(cant: Option[Double], tipo: Option[Double]): Option[Double] = {
    (cant, tipo) match {
      case (Some(c), Some(t)) => Some(c*t)
      case _ => None
    }
  }

  def aplicaInteresEither(cant: Option[Double], tipo: Option[Double]): Either[String, Double] =  {
    (cant, tipo) match {
      case (Some(c), Some(t)) => Right(c * t)
      case (None, _) => Left("cantidad vacia")
      case (_, None) => Left("tipo vacio")
    }
  }


  def aplicaInteresEither(cant: Either[String, Double], tipo: Either[String, Double]): Either[String, Double] =  {
    (cant, tipo) match {
      case (Left(e1), Left(e2)) => Left(s"errores encontrados: [${e1}, ${e2}]")
      case (Left(e), _) => Left(e)
      case (_, Left(e)) => Left(e)
      case (Right(c), Right(t)) => Right(c * t)
    }
  }



}
