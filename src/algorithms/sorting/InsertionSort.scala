package algorithms.sorting

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
