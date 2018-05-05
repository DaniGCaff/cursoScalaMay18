package com.indizen.scala.lista

import scala.annotation.tailrec

/**
  * Created by scouto.
  */
sealed trait Lista[+A]

case object Vacio extends Lista[Nothing]

case class Cons[+A](head: A, tail: Lista[A]) extends Lista[A]

object Lista {


  def apply[A](as: A*): Lista[A] =
    if (as.isEmpty) Vacio
    else Cons(as.head, apply(as.tail: _*))


  def sum(ints: Lista[Int]): Int = {
    ints match {
      case Vacio => 0
      case Cons(h, t) => h + sum(t)
    }
  }

  def product(ints: Lista[Double]): Double = {
    ints match {
      case Vacio => 1.0
      case Cons(h, t) => h * product(t)
    }
  }

  def tail[A](list: Lista[A]): Lista[A] = {
    list match {
      case Vacio => Vacio
      case Cons(_, t) => t
    }
  }

  def setHead[A](list: Lista[A], newHead: A): Lista[A] = {
    list match {
      case Vacio => Lista(newHead)
      case Cons(h, t) => Cons(newHead, t)
    }

  }

  def drop[A](list: Lista[A], n: Int): Lista[A] = {

    @tailrec
    def go(rest: Lista[A], x: Int): Lista[A] = {
      (rest, x) match {
        case (Vacio, _) => Vacio
        case (_, current) if current <= 0 => rest
        case (Cons(_, t), current) if current > 0 => go(t, x - 1)
      }
    }

    go(list, n)

  }

  def dropWhileOld[A](list: Lista[A], f: A => Boolean): Lista[A] = {

    @tailrec
    def go(rest: Lista[A]): Lista[A] = {
      rest match {
        case Vacio => Vacio
        case Cons(h, t) if f(h) => go(t)
        case Cons(h, _) if !f(h) => rest
      }
    }

    go(list)
  }

  def dropWhile[A](list: Lista[A])(f: A => Boolean): Lista[A] = {

    @tailrec
    def go(rest: Lista[A]): Lista[A] = {
      rest match {
        case Vacio => Vacio
        case Cons(h, t) if f(h) => go(t)
        case Cons(h, _) if !f(h) => rest
      }
    }

    go(list)
  }



  def foldRight[A, B](as: Lista[A], z: B)(f: (A, B) => B): B = {

    as match {
      case Vacio => z
      case Cons(h, t) => f(h, foldRight(t, z)(f))
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
      case Vacio => z
      case Cons(h, t) => foldLeft(t, f(z, h))(f)
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
    foldLeft(as, Lista[A]())((acc, elem) => Cons(elem, acc))
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
    foldRight(l, Vacio: Lista[B])((elem, acc) => Cons(f(elem), acc))
  }

  def filter[A](l: Lista[A])(f: A => Boolean): Lista[A] = {
    foldRight(l, Vacio: Lista[A])((elem, acc) => if (f(elem)) Cons(elem, acc) else acc)
  }



}



