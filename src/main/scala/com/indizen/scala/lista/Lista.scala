package com.indizen.scala.lista



/**
  * Created by scouto.
  */
sealed trait Lista[+A]{
  def ::[B >: A] (x: B): Lista[B] =
    new ::(x, this)
}

case object Nil extends Lista[Nothing]

case class ::[+A](head: A, tail: Lista[A]) extends Lista[A]

object Lista {


  def apply[A](as: A*): Lista[A] =
    if (as.isEmpty) Nil
    else as.head::apply(as.tail: _*)


  def sum(ints: Lista[Int]): Int = ???

  def product(ints: Lista[Double]): Double = ???

  def tail[A](list: Lista[A]): Lista[A] = ???

  def setHead[A](list: Lista[A], newHead: A): Lista[A] = ???

  def drop[A](list: Lista[A], n: Int): Lista[A] = ???

  def dropWhileOld[A](list: Lista[A], f: A => Boolean): Lista[A] = ???

  def dropWhile[A](list: Lista[A])(f: A => Boolean): Lista[A] = ???



  def foldRight[A, B](as: Lista[A], z: B)(f: (A, B) => B): B = ???

  def sumFold(ints: Lista[Int]): Int = ???

  def productFold(ints: Lista[Double]): Double = ???

  def length[A](as: Lista[A]): Int = ???

//  @tailrec
  def foldLeft[A, B](as: Lista[A], z: B)(f: (B, A) => B): B = ???

  def sumFoldLeft(ints: Lista[Int]): Int = ???

  def productFoldLeft(ints: Lista[Double]): Double = ???

  def lengthFoldLeft[A](as: Lista[A]): Int = ???

  def reverse[A](as: Lista[A]): Lista[A] = ???

  def foldRightbyLeft[A, B](as: Lista[A], z: B)(f: (A, B) => B): B = ???

  def foldLeftbyRight[A, B](as: Lista[A], z: B)(f: (B, A) => B): B = ???

  def sumFoldRightLeft(ints: Lista[Int]): Int = ???

  def sumFoldLeftRight(ints: Lista[Int]): Int = ???

  def productFoldRightLeft(ints: Lista[Double]): Double = ???

  def productFoldLeftRight(ints: Lista[Double]): Double = ???

  def lengthLeftRight[A](as: Lista[A]): Int = ???

  def lengthRightLeft[A](as: Lista[A]): Int = ???

  def map[A, B](l: Lista[A])(f: A => B): Lista[B] = ???

  def filter[A](l: Lista[A])(f: A => Boolean): Lista[A] = ???



}



