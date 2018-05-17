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


  def sum(ints: Lista[Int]): Int = {
    ints match {
      case Nil => 0
      case h::t => h + sum(t)
    }
  }

  def product(ints: Lista[Double]): Double = {
    ints match {
      case Nil => 1
      case h::t => h * product(t)
    }
  }

  def tail[A](list: Lista[A]): Lista[A] = {
    list match {
      case Nil => list //Nil
      case h::t=> t
    }
  }

  def setHead[A](list: Lista[A], newHead: A): Lista[A] = {
    list match {
      case Nil => Lista(newHead)
      case _::t => newHead::t
   }
  }

  def drop[A](list: Lista[A], n: Int): Lista[A] = {
    list match {
      case Nil => list
      case l if n <= 0 => l
      case h::t => drop(t, n-1)
    }


  }

  def dropWhileOld[A](list: Lista[A], f: A => Boolean): Lista[A] = {
    list match {
      case Nil => list
      case h::t if f(h) => dropWhileOld(t, f)
      case h::t if !f(h) => list
    }

  }

  def dropWhile[A](list: Lista[A])(f: A => Boolean): Lista[A] = {
    list match {
      case Nil => list
      case h::t if f(h) => dropWhile(t)(f)
      case _  => list
    }

  }



  def foldRight[A, B](as: Lista[A], z: B)(f: (A, B) => B): B = {
    as match {
      case Nil => z
      case h::t => f(h, foldRight(t, z)(f))
    }

  }

  def sumFold(ints: Lista[Int]): Int = {
    foldRight(ints, 0)( _ + _)
  }

  def productFold(ints: Lista[Double]): Double = {
    foldRight(ints, 1.0)(_ * _)
  }

  def length[A](as: Lista[A]): Int = {
    foldRight(as, 0)((_, acc) => acc +1)
  }

//  @tailrec
  def foldLeft[A, B](as: Lista[A], z: B)(f: (B, A) => B): B = {
    as match {
      case Nil => z
      case h::t => foldLeft(t, f(z, h))(f)
    }
  }

  def sumFoldLeft(ints: Lista[Int]): Int = {
    foldLeft(ints, 0)(_+_)
    foldLeft(ints, 0)((x, y) => x+y)
  }

  def productFoldLeft(ints: Lista[Double]): Double = {
    foldLeft(ints, 1.0)(_*_)
    foldLeft(ints, 1.0)((x, y) => x*y)

  }

  def lengthFoldLeft[A](as: Lista[A]): Int = {
    foldLeft(as, 0)((acc, _) => acc +1)
  }

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



