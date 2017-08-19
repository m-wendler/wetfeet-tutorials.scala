package wetfeet.twirl

import java.util.Locale

import play.twirl.api.HtmlFormat.Appendable

object TwirlDemo {

  def main (args: Array[String]) = {
    println ("******************************* wetfeet.twirl STARTED ... *************************\n")

    println ("1. define the value to pass to the template")
    val locales: Array[Locale] = Locale.getAvailableLocales
    val caption: String        = "Java Locales"

    println ("2. instantiate the template - passing in the defined values (just the first 5 values)")
    val template: Appendable   = wetfeet.twirl.html.demo(locales.take (5), caption)

    println ("3. do something with the generated text")
    println (template)

    println ("\n**************************** wetfeet.twirl DONE ... ***************************")
  }

}

