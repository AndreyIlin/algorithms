package scala.algorithms.multiplication

import org.scalatest.{Matchers, WordSpec}

class KaratsubaAlgorithmSpec extends WordSpec with Matchers{

  "KaratsubaAlgorithmSpec" should {

    "multiply" in {
      val a = "1685287499328328297814655639278583667919355849391453456921116729"
      val b = "7114192848577754587969744626558571536728983167954552999895348492"

      KaratsubaAlgorithm.multiply(a, b) should equal (
        "11989460275519080564894036768322865785999566885539505969749975204962718118914971586072960191064507745920086993438529097266122668")
    }

  }
}
