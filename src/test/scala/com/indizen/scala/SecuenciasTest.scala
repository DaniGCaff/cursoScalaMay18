package com.indizen.scala

/**
  * Created by scouto.
  */

import com.indizen.scala.Secuencias._
import org.scalacheck.Gen
import org.scalatest._
import org.scalatest.prop.PropertyChecks


class SecuenciasTest extends FlatSpec with Matchers with PropertyChecks {

  val genInteger = for (n <- Gen.choose(-500, 500)) yield n
  val genIntList = Gen.containerOf[List, Int](genInteger)


  ignore should "create a single element list for empty lists" in {
    addAtTheEnd(Nil,3) should be (List(3))
  }

  ignore should "add an element to the given list" in {

    forAll(genIntList, genInteger) { (myList, myInt) =>
º
      val result = addAtTheEnd(myList, myInt)
      myList.length +1 shouldEqual result.length
      result.last shouldEqual myInt
    }
  }




}
