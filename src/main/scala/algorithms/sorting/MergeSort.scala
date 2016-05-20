package scala.algorithms.sorting

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
    * @param left sorted array
    * @param right sorted array
    * @return result of merge of two sorted arrays into one
    */
  def merge(left: Array[Int], right: Array[Int]): Array[Int] = {
    // take elements from both arrays
    // compare them
    // add to result array
    var merged = Array[Int]()

    var i = 0
    var j = 0
    while(i < left.length && j < right.length) {
      val l = left(i)
      val r = right(j)

      if (l > r) {
        merged = merged :+ r
        j += 1
      } else {
        merged = merged :+ l
        i += 1
      }
    }
    if (j == right.length) {
      merged = merged ++ left.slice(i, left.length)
    }
    if (i == left.length) {
      merged = merged ++ right.slice(j, right.length)
    }
    merged
  }

}
