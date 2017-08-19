package wetfeet.akka

import java.util.Locale

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Demonstrates the use of Akka.
  * A main actor asks a child actor to get some data and passes this to
  * another child actor to write it to the console.
  */
object AkkaDemo {

  def main (args: Array[String]): Unit = {
    println ("******************************* wetfeet.akka STARTED ... ***************************\n")

    println ("1. start the actor system ... ")
    val system = ActorSystem ("AkkaDemo")

    println ("2. get the actor communication going by starting the main actor")
    system.actorOf (Props[Main], "languagesActor")
  }

}


/** The main actor. Creates 2 child actors to do the actual work. */
class Main extends Actor {

  // create this child actor when the main actor is being created
  def dataProvider = context.actorOf (Props[DataProvider], "languagesActor")

  println ("3. tell the data provider actor to provide some data")
  dataProvider ! GET

  /** deal with messages this actor understands */
  override def receive: Receive = {
    case GOT(locales: Array[Locale]) =>
      println ("5. received data back from the provider ... pass it on to the writer actor ...")
      val childActor = context.actorOf(Props[DataWriter], "writeLanguagesActor")
      childActor ! PRINT(locales)
    case PRINTED =>
      println ("8. done ... terminate the actor system ... ")
      context.system.terminate
      println ("\n\n**************************** wetfeet.akka DONE ... ***************************")
  }

}


/** the messages of the DataProvider actor (should go into a companion object) */
case object GET
case class GOT(locales: Array[Locale])

/** The data providing actor. */
class DataProvider extends Actor {

  /** deal with messages this actor understands */
  override def receive = {
    case GET =>
      val locales: Array[Locale] = Locale.getAvailableLocales
      println ("4. got some data ... and send it back to the sender ...")
      sender ! GOT (locales)
  }

}


/** the messages of the DataWriter actor (should go into a companion object) */
case class PRINT(locales: Array[Locale])
case object PRINTED

/** An actor for printing the data to the console. */
class DataWriter extends Actor {

  /** deal with messages this actor understands */
  override def receive = {
    case PRINT(locales: Array[Locale]) =>
      println ("6. received some data to write: ")
      locales.take (5).foreach { lang => println (s"${lang.toString}")}
      println
      println ("7. tell the sender that data was printed")
      sender ! PRINTED
  }

}
