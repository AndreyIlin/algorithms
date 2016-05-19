package algorithms.suggestion

import scala.io.Source

case class User(id: Int, rates: Array[Int])

object UserDB {
  var users = List[User]()

  def get(id: Int): User = {
    users.find(user => user.id == id).get
  }

  def readFromFile(path: String) {
    val source = Source.fromFile(path)
    val fileIterator = source.getLines()

    // Need to skip the first line
    fileIterator.next()

    // Writing to DB
    users = fileIterator.map(processInput(_)).toList
  }

  private def processInput(formattedData: String): User = {
    val source = formattedData.split(" ")
    var array = Array[Int]()
    for (i <- 1 until source.length) {
      array = array :+ source(i).toInt
    }
    User(source(0).toInt, array)
  }
}

object SuggestionAlgorithm {
  def computeUsersInversions(first: User, second: User): Int = {
    var inversionsCount = 0
    var inversionArray = Array[Int]()
    for (i <- 1 to first.rates.length) {
      inversionArray = inversionArray :+ second.rates(first.rates.indexOf(i))
    }

    var i = 0
    var j = 0
    while (i < inversionArray.length) {
      while (j < inversionArray.length) {
        if (i < j && inversionArray(i) > inversionArray(j)) {
          inversionsCount += 1
        }
        j += 1
      }
      j = 0
      i += 1
    }
    inversionsCount
  }
}
