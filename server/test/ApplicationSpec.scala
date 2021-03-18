import org.junit.runner._
import org.specs2.runner._
import org.scalatestplus.play._
import play.api.test._
import models._
import controllers._

import scala.concurrent.Future

import org.scalatestplus.play._

import play.api.mvc._
import play.api.test._
import play.api.test.Helpers._

import play.api.mvc._
import play.api.test._
import org.scalatestplus.play.guice.GuiceOneServerPerSuite

/*
import play.api.test.Helpers._
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class ApplicationSpec() extends PlaySpecification {

  "Application" should {

    "send 404 on a bad request" in new WithApplication {
      route(app, FakeRequest(GET, "/boum")) must beSome.which (status(_) == NOT_FOUND)
    }

    "render the index page" in new WithApplication {
      val home = route(app, FakeRequest(GET, "/")).get

      status(home) must equalTo(OK)
      contentType(home) must beSome.which(_ == "text/html")
      contentAsString(home) must contain ("shouts out")
    }
  }
}

class TestingSpec extends PlaySpec {
  "Usersmodel" must {
     "reject an invalid username" in {
        val badUsername = "asdfasdfasdfasdf"
        userModel.isValidUser(badUsername) mustBe false
      }
      "accept a valid username" in {
        val goodUsername = "cweisenb"
        userModel.isValidUser(goodUsername) mustBe true
      }
      "return the correct friends" in {
        val goodUsername = "cweisenb"
        val friends = userModel.getFriendsByName(goodUsername)
        println(friends.mkString(", "))
        (userModel.getFriendsByName(goodUsername).mkString(",")  == "jbaker6,mbarton,dclaesse,thall,khardee,espradli,swhitney") mustBe true
      }
  }
  "Application Controller" must {
    "give back login" in {
      val controller = new Application(Helpers.stubControllerComponents())
      val result = controller.postForm().apply(FakeRequest())
      val bodyText = contentAsString(result)
      bodyText must include ("form")
    }
  }
}


import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneServerPerSuite
import org.scalatestplus.play.OneBrowserPerSuite

class seleniumspec extends PlaySpec with GuiceOneServerPerSuite with OneBrowserPerSuite with HtmlUnitFactory {
  "login" must {
    "login access" in {
      go to s"http://localhost:$port/postForm"
      click on "username"
      textField("username").value="cweisenb"
      click on "loginBtn"
      textField("loginBtn").value="pass"
    }
  }
}
