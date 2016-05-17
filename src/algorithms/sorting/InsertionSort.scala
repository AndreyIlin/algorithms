package algorithms.sorting

/**
  * Insertion sort algorithm
  * Complexity is O(sqr(n))
  * Can be useful on small amounts of data
  * Doesn't use additional memory, except one field to store key value
  * Modifies given array
  * The left part of array divided by index of the first loop is always sorted before each iteration
  */
object InsertionSort {
  def sort(toSort: Array[Int]): Array[Int] = {
    for (i <- 1 until toSort.length) {
      val key = toSort(i)
      var j = i - 1

      while (j >= 0 && toSort(j) > key) {
        toSort(j + 1) = toSort(j)
        j = j - 1
      }

      toSort(j + 1) = key
    }
    toSort
  }
}
