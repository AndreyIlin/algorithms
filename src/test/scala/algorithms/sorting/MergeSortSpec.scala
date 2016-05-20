package scala.algorithms.sorting

import org.scalatest.{Matchers, WordSpec}

class MergeSortSpec extends WordSpec with Matchers {

  "MergeSortSpec" should {

    "merge two sorted arrays" in {
      val left = Array(1, 3, 5, 7)
      val right = Array(2, 4, 6, 8, 9, 10)

      MergeSort.merge(left, right) should equal(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    }

    "sort given array of integer numbers" in {
      val input = Array(11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1)

      MergeSort.sort(input) should equal(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11))
    }

  }
}
