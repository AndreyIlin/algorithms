package scala.algorithms.sorting

import scala.annotation.tailrec

/**
  * Merge sort algorithm
  * Uses recursive principe "divide and conquer"
  * On every step divides task to parts and call sort function recursively
  * each of them until parts have size < 2
  * Described with recurrence relation T(n) = 2T(n / 2) + O(n)
  * According to "Master theorem" has complexity O(n * log(n))
  */
object MergeSort {

  /**
    * Sorts given array with merge sort algorithm
    *
    * @param array to sort
    * @return array sorted ascending
    */
  def sort(array: Array[Int]): Array[Int] = {
    if (array.length > 1) {
      val dividerIndex = array.length / 2

      // create part arrays
      val left = new Array[Int](dividerIndex)
      val right = new Array[Int](array.length - dividerIndex)

      // copy elements from source to part arrays
      Array.copy(array, 0, left, 0, dividerIndex)
      Array.copy(array, dividerIndex, right, 0, array.length - dividerIndex)

      // divide and sort parts recursively
      merge(sort(left), sort(right))
    } else {
      array
    }
  }

  /**
    * Merges two sorted arrays to one
    *
    * @param left  sorted array
    * @param right sorted array
    * @return result of merge of two sorted arrays into one
    */
  def merge(left: Array[Int], right: Array[Int]): Array[Int] = {
    // take elements from both arrays
    // compare them
    // add to result array
    @tailrec
    def merge(l: Int, r: Int, left: Array[Int], right: Array[Int], acc: Array[Int]): Array[Int] = {
      if (l < left.length && r < right.length) {
        if (left(l) > right(r)) {
          merge(l, r + 1, left, right, acc :+ right(r))
        } else {
          merge(l + 1, r, left, right, acc :+ left(r))
        }
      } else {
        if (r == right.length && l != left.length) {
          acc ++ left.slice(l, left.length)
        } else  {
          acc ++ right.slice(r, right.length)
        }
      }
    }
    merge(0, 0, left, right, Array())
  }

}
