package com.indizen.scala.traits

/**
  * Created by scouto.
  */
//case class AdministracionTrait[As <: AsignaturaTrait, Al <: AlumnoTrait](relacionAlumnos: Map[As, List[Al]] = Map()) {
case class AdministracionTrait[As , Al ](relacionAlumnos: Map[As, List[Al]] = Map()) {


//  def removeFirstElement(list: List[Al], f: AlumnoTrait => Boolean): List[Al] = ???

  /**
    * Debe dar de alta un alumno si no supera el máximo y el alumno no está ya presente
    * @param alumno
    * @param asignatura
    * @return
    */
  def alta(alumno: Al, asignatura: As): Option[AdministracionTrait[As, Al]] = ???


  /**
    * Debe dar de baja un alumno o levantar un error si no es posible
    * @param alumno
    * @param asignatura
    * @return
    */
  def baja(alumno: Al, asignatura: As): Either[String, AdministracionTrait[As, Al]] = ???



