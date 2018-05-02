package com.indizen.scala

/**
  * Created by scouto.
  */
abstract class Printer[-A] {
  def print(value: A): Unit
}

//Sabe como imprimir todos los animales (incluidos gatos) => Printer[Animal] es subtipo de Priner[Gato]
class AnimalPrinter extends Printer[Animal] {
  def print(animal: Animal): Unit =
    println("The animal's name is: " + animal.nombre)
}

//Sabe como imprimir los gatos (pero no todos los animales => Printer[Gato] no es subtipo de Priter[Animal]
class CatPrinter extends Printer[Gato] {
  def print(gato: Gato): Unit =
    println("The cat's name is: " + gato.nombre)
}


object Contravarianza extends App {
  val gato: Gato = Gato("Felix")

  def printMyCat(printer: Printer[Gato]): Unit = {
    printer.print(gato)
  }

  val catPrinter: Printer[Gato] = new CatPrinter
  val animalPrinter: Printer[Animal] = new AnimalPrinter

  printMyCat(catPrinter)
  printMyCat(animalPrinter)
}
