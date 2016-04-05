package algorithms.multiplication

import scala.collection.mutable
import scala.math.BigInt

/**
  * Fast multiplication algorithm
  */
object KaratsubaAlgorithm {
  var counter1 = 0
  var counter2 = 0
  var counter3 = 0
  /**
    * Multiplies two given numbers
    * Numbers can have length more than standard `Int.MaxValue`
    * That's why they have String type
    *
    * @param x first multiplier
    * @param y second multiplier
    * @return result of multiplication
    */
  def multiply(x: String, y: String): String = {
    var oneTwo = ("", "")
    if (x.length > y.length) {
      oneTwo = align(x, y)
    } else {
      oneTwo = align(y, x)
    }
    val first = oneTwo._1
    val second = oneTwo._2
    val n = first.length

    val ab = divide(first)
    val cd = divide(second)

    // 10^n(ac) + 10^n/2((a+b)(c+d)-ac-bd) + bd
    val ac = (ab._1, cd._1)
    val acResult = getOrCall(ac._1, ac._2)
    val bd = (ab._2, cd._2)
    val bdResult = getOrCall(bd._1, bd._2)
    val apb: BigInt = BigInt(ac._1) + BigInt(bd._1)
    val cpd: BigInt = BigInt(ac._2) + BigInt(bd._2)
    val apbcpdResult = getOrCall(apb.toString, cpd.toString)
    val numb = BigInt(apbcpdResult) - BigInt(acResult) - BigInt(bdResult)

    if (numb == 105) {
      counter1 += 1
    } else if (numb == 72) {
      counter2 += 1
    } else if (numb == 12) {
      counter3 += 1
    }
    (BigInt(10).pow(n) * BigInt(acResult) +
      BigInt(10).pow(n / 2) * numb +
      BigInt(bdResult)).toString
  }

  private def align(one: String, two: String): (String, String) = {
    val o = alignOne(one)
    val diff = o.length - two.length
    var a = diff
    var t = two
    while(a > 0) {
      t = "0" + t
      a -= 1
    }
    (o, t)
  }

  private def alignOne(number: String): String = {
    if (number.length % 2 != 0) {
      "0" + number
    } else {
      number
    }
  }

  private def getOrCall(multipliers: (String, String)): String = {
    val a = BigInt(multipliers._1).toString()
    val b = BigInt(multipliers._2).toString()
    if (a.length > 1 || b.length > 1) {
      multiply(a, b)
    } else {
      (multipliers._1.toInt * multipliers._2.toInt).toString
    }
  }

  private def divide(x: String): (String, String) = {
    val idx = x.length / 2
    val a = x.substring(0, idx)
    val b = x.substring(idx, x.length)

    (a, b)
  }
}
