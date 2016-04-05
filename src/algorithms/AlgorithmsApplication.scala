package algorithms

import algorithms.multiplication.KaratsubaAlgorithm

object AlgorithmsApplication {
  def main(args: Array[String]) {
    val res = KaratsubaAlgorithm.multiply("1685287499328328297814655639278583667919355849391453456921116729", "7114192848577754587969744626558571536728983167954552999895348492")
    println(res)
    println(res == "11989460275519080564894036768322865785999566885539505969749975204962718118914971586072960191064507745920086993438529097266122668")
    println(KaratsubaAlgorithm.counter1)
    println(KaratsubaAlgorithm.counter2)
    println(KaratsubaAlgorithm.counter3)
  }
}
