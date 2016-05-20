package main.scala.algorithms.multiplication

import scala.annotation.tailrec
import scala.math.BigInt

/**
  * Fast multiplication algorithm
  * Has complexity O(n pow log2(3)) that is better than long multiplication algorithm O(n*n)
  * This makes it effective for multiplying very long numbers
  */
object KaratsubaAlgorithm {
  /**
    * Multiplies two given long numbers
    *
    * @param a first multiplier
    * @param b second multiplier
    * @return result of multiplication
    */
  def multiply(a: String, b: String): String = {
    val tuple = align(a, b)

    val ab = divide(tuple._1)
    val cd = divide(tuple._2)
    val n = tuple._1.length

    // 10^n(ac) + 10^n/2((a+b)(c+d)-ac-bd) + bd
    val axc = BigInt(evaluate(ab._1, cd._1))
    val bxd = BigInt(evaluate(ab._2, cd._2))
    val apb = BigInt(ab._1) + BigInt(ab._2)
    val cpd = BigInt(cd._1) + BigInt(cd._2)
    (BigInt(10).pow(n) * axc + BigInt(10).pow(n / 2) * (BigInt(evaluate(apb.toString, cpd.toString)) - axc - bxd) + bxd).toString
  }

  private def align(a: String, b: String): (String, String) = {
    even(normalize(a, b))
  }

  private def even(t: (String, String)): (String, String) = {
    if (t._1.length % 2 == 0) {
      t
    } else {
      ("0" + t._1, "0" + t._2)
    }
  }

  private def normalize(a: String, b: String): (String, String) = {
    @tailrec
    def normalize(s: String, l: Int): String = {
      if (l > 0) {
        normalize("0" + s, l - 1)
      } else {
        s
      }
    }

    val diff = a.length - b.length
    if (diff > 0) {
      (a, normalize(b, diff))
    } else {
      (normalize(a, -diff), b)
    }
  }

  private def evaluate(multipliers: (String, String)): String = {
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
