package com.indizen.scala.stream

import scala.annotation.tailrec
import com.github.scouto.sesion10.Stream._
/**
  * Created by couto.
  */
sealed trait Stream[+A] {

  def headOption: Option[A] = {
    this match {
      case Empty => None
      case Cons(h, _) => Some(h())
    }
  }


  def toList: List[A] = ???

//  @tailrec
  final def drop(n: Int): Stream[A] = ???

//  @tailrec
  final def dropWhile(f: A => Boolean): Stream[A] = ???

  def take(n: Int): Stream[A] = ???

  def takeWhile(p: A => Boolean): Stream[A] = ???

  //true si algun elemento cumple
  def exists(f: A => Boolean): Boolean = ???

  //Sesion 11
  def foldRight[B](z: => B)(f: (A, => B) => B): B = ???

//  @tailrec
  final def foldLeft[B](z: => B)(f: ( => B, A) => B): B = ???

  def existsFoldRight(f: A => Boolean): Boolean = ???

  def existsFoldLeft(f: A => Boolean): Boolean = ???

  def forAll(p: A => Boolean): Boolean = ???

  def headOptionFold: Option[A] = ???

  def takeWhileFold(p: A => Boolean): Stream[A] = ???

  def map[B](f: A => B): Stream[B] = ???

  def filter(p: A => Boolean): Stream[A] = ???

  def append[B >: A](other: => Stream[B]): Stream[B] = ???

  def flatMap[B](f: A => Stream[B]): Stream[B] = ???

  def find(p: A => Boolean): Option[A] = ???

  def mapUnfold[B](f: A => B): Stream[B] = ???

  def takeUnfold(n: Int): Stream[A] = ???

  def takeWhileUnfold(p: A => Boolean): Stream[A] = ???

  def zipWith[B, C](other: Stream[B])(f: (A, B) => C): Stream[C] = ???

  def zipWithAll[B, C](other: Stream[B])(f: (Option[A], Option[B]) => C) : Stream[C] = ???

  def tails: Stream[Stream[A]] = ???

  def zip[B](s2: Stream[B]): Stream[(A, B)] = ???

  def zipAll[B](s2: Stream[B]): Stream[(Option[A], Option[B])] = ???

  def empiezaPor[A](s: Stream[A]): Boolean = ???


  def tieneSubsecuencia[A](s: Stream[A]): Boolean = ???





}
case object Empty extends Stream[Nothing]
case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

object Stream {

  //constructor
  def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
    lazy val head = hd
    lazy val tail = tl

    Cons(() => head, () => tail)
  }

  //constructor de empty Stream con tipo
  def empty[A]: Stream[A] = Empty

  def apply[A](as: A*): Stream[A] = {
    if (as.isEmpty) empty
    else cons(as.head, apply(as.tail: _*))
  }


  val ones: Stream[Int] = ???

  def constant[A](a: A): Stream[A] = ???

  def from(n: Int): Stream[Int] = ???


  //0,1,1, 2,3,5,8,13....
  def fibs: Stream[Int] = ???

  def unfold[A,S](z: S)(f: S => Option[(A,S)]): Stream[A] = ???

  def onesUnfold: Stream[Int] = ???

  def constantUnfold[A](a: A): Stream[A] = ???

  def fromUnfold(n: Int): Stream[Int] = ???

  def fibsUnfold: Stream[Int] = ???

}


