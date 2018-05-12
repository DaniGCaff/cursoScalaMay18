package com.indizen.scala.lista

import scala.annotation.tailrec



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
      case Nil => 1.0
      case h::t => h * product(t)
    }
  }

  def tail[A](list: Lista[A]): Lista[A] = {
    list match {
      case Nil => Nil
      case _::t => t
    }
  }

  def setHead[A](list: Lista[A], newHead: A): Lista[A] = {
    list match {
      case Nil => Lista(newHead)
      case h::t => newHead::t
    }

  }

  def drop[A](list: Lista[A], n: Int): Lista[A] = {

    @tailrec
    def go(rest: Lista[A], x: Int): Lista[A] = {
      (rest, x) match {
        case (Nil, _) => Nil
        case (_, current) if current <= 0 => rest
        case (_::t, current) if current > 0 => go(t, x - 1)
      }
    }

    go(list, n)

  }

  def dropWhileOld[A](list: Lista[A], f: A => Boolean): Lista[A] = {

    @tailrec
    def go(rest: Lista[A]): Lista[A] = {
      rest match {
        case Nil => Nil
        case h::t if f(h) => go(t)
        case h::_ if !f(h) => rest
      }
    }

    go(list)
  }

  def dropWhile[A](list: Lista[A])(f: A => Boolean): Lista[A] = {

    @tailrec
    def go(rest: Lista[A]): Lista[A] = {
      rest match {
        case Nil => Nil
        case h::t if f(h) => go(t)
        case h::_ if !f(h) => rest
      }
    }

    go(list)
  }



  def foldRight[A, B](as: Lista[A], z: B)(f: (A, B) => B): B = {

    as match {
      case Nil => z
      case h::t => f(h, foldRight(t, z)(f))
    }
  }

  def sumFold(ints: Lista[Int]): Int = {
    foldRight(ints, 0)(_ + _)
  }

  def productFold(ints: Lista[Double]): Double = {
    foldRight(ints, 1.0)(_ * _)

  }

  def length[A](as: Lista[A]): Int = {
    foldRight(as, 0)((_, acc) => acc + 1)
  }

  @tailrec
  def foldLeft[A, B](as: Lista[A], z: B)(f: (B, A) => B): B = {
    as match {
      case Nil => z
      case h::t => foldLeft(t, f(z, h))(f)
    }
  }

  def sumFoldLeft(ints: Lista[Int]): Int = {
    foldLeft(ints, 0)(_ + _)
  }

  def productFoldLeft(ints: Lista[Double]): Double = {
    foldLeft(ints, 1.0)(_ * _)
  }

  def lengthFoldLeft[A](as: Lista[A]): Int = {
    foldLeft(as, 0)((acc, _) => acc + 1)
  }

  def reverse[A](as: Lista[A]): Lista[A] = {
    foldLeft(as, Lista[A]())((acc, elem) => elem::acc)
  }

  def foldRightbyLeft[A, B](as: Lista[A], z: B)(f: (A, B) => B): B = {
    foldLeft(as, z)((acc, elem) => f(elem, acc))
  }

  def foldLeftbyRight[A, B](as: Lista[A], z: B)(f: (B, A) => B): B = {
    foldRight(as, z)((elem, acc) => f(acc, elem))
  }

  def sumFoldRightLeft(ints: Lista[Int]): Int = {
    foldRightbyLeft(ints, 0)(_ + _)
  }

  def sumFoldLeftRight(ints: Lista[Int]): Int = {
    foldLeftbyRight(ints, 0)(_ + _)
  }

  def productFoldRightLeft(ints: Lista[Double]): Double = {
    foldRightbyLeft(ints, 1.0)(_ * _)
  }

  def productFoldLeftRight(ints: Lista[Double]): Double = {
    foldLeftbyRight(ints, 1.0)(_ * _)
  }

  def lengthLeftRight[A](as: Lista[A]): Int = {
    foldLeftbyRight(as, 0)((acc, _) => acc + 1)
  }

  def lengthRightLeft[A](as: Lista[A]): Int = {
    foldRightbyLeft(as, 0)((_, acc) => acc + 1)
  }

  def map[A, B](l: Lista[A])(f: A => B): Lista[B] = {
    foldRight(l, Nil: Lista[B])((elem, acc) => f(elem)::acc)
  }

  def filter[A](l: Lista[A])(f: A => Boolean): Lista[A] = {
    foldRight(l, Nil: Lista[A])((elem, acc) => if (f(elem)) elem::acc else acc)
  }



}



