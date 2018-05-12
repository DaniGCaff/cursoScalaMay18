package com.indizen.scala.administracion

/**
  * Created by scouto.
  */
class oldAsignatura (val nombre: String, val plazas: Int = 30, val descripcion : Option[String])

object oldAsignatura {
  def apply(nombre: String, plazas: Int, descripcion : Option[String] ) = new oldAsignatura (nombre, plazas, descripcion)

  def unapply(arg: oldAsignatura) = Some((arg.nombre, arg.plazas, arg.descripcion))
}

