# get your feet wet with *Twirl* (2 min) [![Build Status](https://travis-ci.org/wetfeet-tutorials/wetfeet.twirl.png?branch=master)](https://travis-ci.org/wetfeet-tutorials/wetfeet.twirl)

a lightweight templating engine for scala

### prerequisites

* sbt 0.13.8+
* scala 2.11.8+

### dependencies

* add `addSbtPlugin("com.typesafe.sbt" % "sbt-twirl" % "1.2.0")` to your `project/plugins.sbt` file
* enable the plugin in `build.sbt`: `enablePlugins(SbtTwirl)`


### run it

run the sbt `run` task from the console

    sbt run


---

### where to go from here

* check out the [documentation](https://www.playframework.com/documentation/2.5.x/ScalaTemplates) to find out how to
 * use alternatives, escape the special *@* character, ...
 * *include* another template in your template
 * generate `txt` or `xml` documents
 * use custom formats
 * ...

### resources

* https://www.playframework.com/documentation/2.5.x/ScalaTemplates
* https://github.com/spray/twirl
* https://github.com/playframework/twirl


* all the [wetfeet tutorials](http://wetfeet.mike-wendler.de/tutorials.html)

  Have Fun!
