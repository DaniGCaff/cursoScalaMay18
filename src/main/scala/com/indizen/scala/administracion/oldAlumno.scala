package com.indizen.scala.administracion

/**
  * Created by scouto.
  */
class oldAlumno(val nombre: String, val apellidos: String)

object oldAlumno {
  def apply(nombre: String, apellidos: String ) = new oldAlumno (nombre, apellidos)

  def unapply(arg: oldAlumno) = Some((arg.nombre, arg.apellidos))
}
