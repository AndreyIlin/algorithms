package scala.algorithms.sorting

/**
  * Insertion sort algorithm
  * Complexity is O(sqr(n))
  * Can be useful on small amounts of data
  * Doesn't use additional memory, except one field to store key value
  * Modifies given array
  * The left part of array divided by index of the first loop is always sorted before each iteration
  */
object InsertionSort {

  /**
    * Sorts a give array of numbers in ascending order
    *
    * @param array of numbers to sort
    * @return sorted array
    */
  def sort(array: Array[Int]): Array[Int] = {
    for (i <- 1 until array.length) {
      val key = array(i)
      var j = i - 1

      while (j >= 0 && array(j) > key) {
        array(j + 1) = array(j)
        j = j - 1
      }

      array(j + 1) = key
    }
    array
  }
}
