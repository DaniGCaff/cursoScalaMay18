package com.indizen.scala.lista

import com.indizen.scala.lista.Lista._
import org.scalatest.prop.PropertyChecks
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by scouto.
  */
class ListaTest extends FlatSpec with Matchers with PropertyChecks{



  "sum" should "return 0 for empty listas" in {
    sum(Lista()) should be (0)
    sum(Nil) should be (0)
  }

  it should "return the addition" in {

    sum(Lista(1,2)) should be (3)
    sum(Lista(-1,2)) should be (1)
    sum(Lista(16)) should be (16)
    sum(Lista(16, -20)) should be (-4)
  }

  "product" should "return 1.0 for empty listas" in {
    product(Lista()) should be (1.0)
    product(Nil) should be (1.0)
  }

  it should "return the proper value" in {
    product(Lista(1,2)) should be (2)
    product(Lista()) should be (1)
    product(Lista(-1,2)) should be (-2)
    product(Lista(16)) should be (16)
    product(Lista(5, 5)) should be (25)
  }

  "tail" should "be empty for empty lists" in {
    val l = Lista()
    assert(tail(l) == Nil)
  }

  it should "be empty for one-element lists" in {
    val l = Lista(1)
    assert(tail(l) == Nil)
  }

  it should "be the tail itself for bigger lists" in {

    val lInt = Lista(1, 2, 5, 7)
    assert(tail(lInt) == Lista(2, 5, 7))

    val lString = Lista("myName", "mySurname")
    assert(tail(lString) == Lista("mySurname"))

    val lBool = Lista(true, true, false)
    assert(tail(lBool) == Lista(true, false))

  }

  "setHead" should "be one element list for empty lists" in {
    val l = Lista()
    setHead(l, 5) should be (Lista(5))
  }


  "setHead" should "be one element list for one-element lists" in {
    val l = Lista(7)
    setHead(l, 5) should be (Lista(5))
  }

  "setHead" should "be the same list with a new head" in {
    val l = Lista(7, 9, 10, 12)
    setHead(l, 5) should be (Lista(5, 9, 10, 12))
  }


  "drop" should "be empty for empty lists" in {
    val l = Lista()
    assert(drop(l, 5) == Nil)
    assert(drop(l, 0) == Nil)
    assert(drop(l, -5) == Nil)
  }

  it should "be empty for one-element lists" in {
    val l = Lista(1)
    assert(drop(l, 5) == Nil)
  }

  it should "be the same list for 0 drops regardless the list itself" in {
    val l = Lista(1)
    val ls = Lista("myName", "mySurname")
    assert(drop(l, 0) == l)
    assert(drop(Nil, 0) == Nil)
    assert(drop(ls, 0) == ls)
  }

  it should "be the list without the x elements at the beginning for bigger lists" in {

    val lInt = Lista(1, 2, 5, 7)
    assert(drop(lInt, 3) === Lista(7))
    assert(drop(lInt, 4) == Nil)
    assert(drop(lInt, 1) == tail(lInt))
    assert(drop(lInt, 15) == Nil)

  }

  "dropWhileOld" should "be empty for empty lists" in {
    val l: Lista[Int] = Lista()
    assert(dropWhileOld(l, (x: Int) => x > 5) == Nil)
    assert(dropWhileOld(l, (x: Int) => x > 5) == Nil)
    assert(dropWhileOld(l, (x: Int) => x > 5) == Nil)
  }

  it should "remove elements as longer as the predicates satisfies" in {

    val lInt = Lista(1, 2, 5, 7)
    assert(dropWhileOld(lInt, (x: Int) => x < 5) == Lista(5, 7))
    assert(dropWhileOld(lInt, (x: Int) => x < 5) == Lista(5, 7))
    assert(dropWhileOld(lInt, (x: Int) => x < 10) == Nil)
    assert(dropWhileOld(lInt, (x: Int) => true) == Nil)
    assert(dropWhileOld(lInt, (x: Int) => false) == Lista(1, 2, 5, 7))

  }

  "dropWhile" should "be empty for empty lists" in {
    val l: Lista[Int] = Lista()
    assert(dropWhile(l)(x => x > 5) == Nil)
    assert(dropWhile(l)(_ > 5) == Nil)
    assert(dropWhile(l)(_ > 5) == Nil)
  }

  it should "remove elements as longer as the predicates satisfies" in {

    val lInt = Lista(1, 2, 5, 7)
    assert(dropWhile(lInt)(_ < 5) == Lista(5, 7))
    assert(dropWhileOld(lInt, (x: Int) => x < 5) == Lista(5, 7))
    assert(dropWhile(lInt)(_ < 10) == Nil)
    assert(dropWhile(lInt)(x => true) == Nil)
    assert(dropWhile(lInt)(x => false) == Lista(1, 2, 5, 7))

  }

  "sumFold" should "work the same as sum" in {
    sumFold(Lista()) should be (sum(Lista()))
    sumFold(Nil) should be (sum(Nil))
    sumFold(Lista(1,2)) should be (sum(Lista(1,2)))
    sumFold(Lista(-1,2)) should be (sum(Lista(-1,2)))
    sumFold(Lista(16)) should be ( sum(Lista(16)))
    sumFold(Lista(16, -20)) should be ( sum(Lista(16, -20)))
  }


  "productFold" should "work the same as product" in {
    productFold(Lista()) should be (product(Lista()))
    productFold(Nil) should be (product(Nil))
    productFold(Lista(1.5,2)) should be (product(Lista(1.5,2)))
    productFold(Lista(-1,2)) should be (product(Lista(-1,2)))
    productFold(Lista(16)) should be (product(Lista(16)))
    productFold(Lista(16, -20)) should be ( product(Lista(16, -20)))
  }

  "length" should "be 0 for empty lists" in {
    val l = Lista()
    assert(Lista.length(l) == 0)
  }

  it should "be the actual length for bigger lists" in {
    assert(Lista.length(Lista(1, 2, 5, 1)) == 4)
    assert(Lista.length(Lista(6)) == 1)
  }

  "sumFoldLeft" should "work the same as sum" in {
    sumFoldLeft(Lista()) should be (sum(Lista()))
    sumFoldLeft(Nil) should be (sum(Nil))
    sumFoldLeft(Lista(1,2)) should be (sum(Lista(1,2)))
    sumFoldLeft(Lista(-1,2)) should be (sum(Lista(-1,2)))
    sumFoldLeft(Lista(16)) should be ( sum(Lista(16)))
    sumFoldLeft(Lista(16, -20)) should be ( sum(Lista(16, -20)))
  }


  "productFoldLeft" should "work the same as product" in {

    productFoldLeft(Lista()) should be (product(Lista()))
    productFoldLeft(Nil) should be (product(Nil))
    productFoldLeft(Lista(1.5,2)) should be (product(Lista(1.5,2)))
    productFoldLeft(Lista(-1,2)) should be (product(Lista(-1,2)))
    productFoldLeft(Lista(16)) should be (product(Lista(16)))
    productFoldLeft(Lista(16, -20)) should be ( product(Lista(16, -20)))
  }


  "lengthFoldLeft" should "be the same as length" in {
    val l = Lista()
    assert(lengthFoldLeft(l) == Lista.length(l))
    assert(lengthFoldLeft(Lista(1, 2, 5, 1)) == Lista.length(Lista(1, 2, 5, 1)))
    assert(lengthFoldLeft(Lista(6)) == Lista.length(Lista(6)))
  }

  "reverse" should "be the list itself for empty lists or one-element lists" in {
    val l = Lista()
    val l1 = Lista(5)
    assert(reverse(l) == l)
    assert(reverse(l1) == l1)
  }

  it should "be the reversed list for bigger lists" in {
    val l = Lista(1,2,3,4,5)
    assert(reverse(l) == Lista(5,4,3,2,1))
  }

  "productFoldRightLeft" should "work the same as product" in {

    productFoldRightLeft(Lista()) should be (product(Lista()))
    productFoldRightLeft(Nil) should be (product(Nil))
    productFoldRightLeft(Lista(1.5,2)) should be (product(Lista(1.5,2)))
    productFoldRightLeft(Lista(-1,2)) should be (product(Lista(-1,2)))
    productFoldRightLeft(Lista(16)) should be (product(Lista(16)))
    productFoldRightLeft(Lista(16, -20)) should be ( product(Lista(16, -20)))
  }


  "productFoldLeftRight" should "work the same as product" in {

    productFoldLeftRight(Lista()) should be (product(Lista()))
    productFoldLeftRight(Nil) should be (product(Nil))
    productFoldLeftRight(Lista(1.5,2)) should be (product(Lista(1.5,2)))
    productFoldLeftRight(Lista(-1,2)) should be (product(Lista(-1,2)))
    productFoldLeftRight(Lista(16)) should be (product(Lista(16)))
    productFoldLeftRight(Lista(16, -20)) should be ( product(Lista(16, -20)))
  }

  "sumFoldRightLeft" should "work the same as sum" in {

    sumFoldRightLeft(Lista()) should be (sum(Lista()))
    sumFoldRightLeft(Nil) should be (sum(Nil))
    sumFoldRightLeft(Lista(1,2)) should be (sum(Lista(1,2)))
    sumFoldRightLeft(Lista(-1,2)) should be (sum(Lista(-1,2)))
    sumFoldRightLeft(Lista(16)) should be (sum(Lista(16)))
    sumFoldRightLeft(Lista(16, -20)) should be ( sum(Lista(16, -20)))
  }


  "sumFoldLeftRight" should "work the same as sum" in {

    sumFoldLeftRight(Lista()) should be (sum(Lista()))
    sumFoldLeftRight(Nil) should be (sum(Nil))
    sumFoldLeftRight(Lista(1,2)) should be (sum(Lista(1,2)))
    sumFoldLeftRight(Lista(-1,2)) should be (sum(Lista(-1,2)))
    sumFoldLeftRight(Lista(16)) should be (sum(Lista(16)))
    sumFoldLeftRight(Lista(16, -20)) should be ( sum(Lista(16, -20)))
  }


  "lengthLeftRight" should "be the same as length" in {
    val l = Lista()
    assert(lengthLeftRight(l) == Lista.length(l))
    assert(lengthLeftRight(Lista(1, 2, 5, 1)) == Lista.length(Lista(1, 2, 5, 1)))
    assert(lengthLeftRight(Lista(6)) == Lista.length(Lista(6)))
  }


  "lengthRightLeft" should "be the same as length" in {
    val l = Lista()
    assert(lengthRightLeft(l) == Lista.length(l))
    assert(lengthRightLeft(Lista(1, 2, 5, 1)) == Lista.length(Lista(1, 2, 5, 1)))
    assert(lengthRightLeft(Lista(6)) == Lista.length(Lista(6)))
  }




}


