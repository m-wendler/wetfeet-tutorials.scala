package wetfeet.twirl

import org.scalatest.{Matchers, WordSpec}

class TwirlSpec extends WordSpec with Matchers {

  "twirl" should {

    "instantiate a txt template with a passed in string" in {
      val template = wetfeet.twirl.txt.demo ("mate")
      template.toString should endWith ("hello mate!")
    }

  }

}
