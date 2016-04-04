package algorithms.multiplication

/**
  * Fast multiplication algorithm
  */
class KaratsubaAlgorithm {

  /**
    * Multiplies two given numbers
    * Numbers can have length more than standard `Int.MaxValue`
    * That's why they have String type
    * @param x first multiplier
    * @param y second multiplier
    * @return result of multiplication
    */
  def multiply(x: String, y: String): String = {
    if (isInt(x).isEmpty) {
      devide(x)
    }
    ""
  }

  /**
    * Divides given number on two parts.
    * The first one tens
    * The second one units
    * @param x number to divide
    */
  private def devide(x: String): Unit = {

  }

  private def isInt(x: String): Option[Int] = {
    val length = x.length
    val isLonger = length > Int.MaxValue.toString.length
    if (isLonger) {
      None
    } else {
      try {
        Some(x.toInt)
      } catch {
        case NumberFormatException => None
      }
    }
  }
}
