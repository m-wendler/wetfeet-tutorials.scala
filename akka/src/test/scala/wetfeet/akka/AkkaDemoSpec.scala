package wetfeet.akka

import java.util.Locale

import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit, TestProbe}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}
import scala.concurrent.duration._

class AkkaDemoSpec extends TestKit(ActorSystem("akka-demo-spec"))
  with WordSpecLike
  with Matchers
  with BeforeAndAfterAll
  with ImplicitSender
{

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  "DataProvider" should {

    "provide locales" in {
      val actor = system.actorOf(Props[DataProvider], "dataProvider")
      actor ! GET
      expectMsgType[GOT](10 seconds)
    }

  }

  "Main" should {

    "start the whole process and get some data" in {
      val dataProviderTestProbe = TestProbe()
      val mainActor = system.actorOf (Props(new Main () {
        override def dataProvider = dataProviderTestProbe.ref
      }))

      dataProviderTestProbe.expectMsg (5.seconds, GET)
      dataProviderTestProbe.reply (GOT (Locale.getAvailableLocales))
    }

  }

}
