package com.indizen.scala.stream

import com.indizen.scala.stream.Stream._
/**
  * Created by couto.
  */
sealed trait Stream[+A] {

  def headOption: Option[A] = ???


  def toList: List[A] = ???

//  @tailrec
  final def drop(n: Int): Stream[A] = ???

  
//  @tailrec
  final def dropWhile(f: A => Boolean): Stream[A] = ???


  def take(n: Int): Stream[A] = ???

  def takeWhile(p: A => Boolean): Stream[A] = {
    this match {
      case Cons(h, t) if p(h()) => cons(h(), t().takeWhile(p))
      case _ => empty
    }
  }

  //true si algun elemento cumple
  def exists(f: A => Boolean): Boolean = ???

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


