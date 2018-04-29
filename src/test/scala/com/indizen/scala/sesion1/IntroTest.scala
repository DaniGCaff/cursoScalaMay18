package com.indizen.scala.sesion1

/**
  * Created by scouto.
  */

import MyApp._
import org.scalatest._

class IntroTest extends FlatSpec with Matchers {



  "sum" should "work with both natural numbers" in {
    sum(2,3) should be (5)
  }

  "factorial" should "be 1 for any integer below 0" in {
    factorial(-5) should be (1)
    factorial(-1) should be (1)
  }

  "operate" should "add properly" in {
    operate[Int,Int](1,2, (x, y) => x +y) should be (3)
    operate[Double,Double](1,2, (x, y) => x +y) should be (3.0)
  }

  it should "multiply properly" in {
    operate[Int,Int](10,2, (x, y) => x *y) should be (20)
    operate[Int,String](10,2, (x, y) => (x *y).toString) should be ("20")
  }

  it should "work for any type" in {
    operate[Int,String](10, 2, (x, y) => (x *y).toString) should be ("20")
    operate[String,String]("company","love", (x, y) => (s"I ${y} this ${x}" )) should be ("I love this company")
  }

  "max" should "return Int.MinValue if empty list" in {
    max(Nil) should be (Int.MinValue)
  }

  it should "return the max value otherwise" in {
    max(List(0,1,6, 3)) should be (6)
    max(List(-1,-66, -45)) should be (-1)
  }

  "second" should "return the second element if present, 0 oterhwise" in {
    second(Nil) should be (0)
    second(List(1)) should be (0)
    second(List(1,5)) should be (5)
    second(List(1,5,56,567,324)) should be (5)
  }

  "nth" should "return  0 if nth element is not present" in {
    nth(Nil, 5) should be (0)
    nth(List(1,2,3), 5) should be (0)
  }

  it should "return 0 if the n element is not valid" in {
    nth(List(1,2,3), -2) should be (0)
  }

  it should "return the element for valid index" in {
    nth(List(1,2,3), 0) should be (1)
    nth(List(1,2,3), 2) should be (3)
  }

}
