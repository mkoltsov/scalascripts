package scripts

import com.typesafe.config.ConfigFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.{FirefoxProfile, FirefoxDriver}
import org.scalatest.selenium.WebBrowser
import org.scalatest.{FreeSpec, Matchers}

import scala.util.{Failure, Success, Try}


class defTestParallel extends FreeSpec with Matchers with WebBrowser {
  implicit val webDriver: WebDriver = new FirefoxDriver()
  val conf = ConfigFactory.load()
  val host = conf.getString("test.baseUrl")

  "title should be correct" in {
    go to (host)
    textField("os_username").value = conf.getString("test.login")
    pwdField("os_password").value = conf.getString("test.password")
    click on className("panelButton")
    Thread.sleep(1000)
//    click on className("news_feed_text")
//    findAll(className("input-wrap-holder")).foreach(elem => click on elem)
//    click on id("personal_ok_button")
//    Thread.sleep(10000)
    //    click on className("go_next")
    while (true) {
      Thread.sleep(10000)
      findAll(linkText("Like")).foreach(elem => click on elem)
      Thread.sleep(1000)
      click on className("go_next")
    }
    //      //      val cnt = 0
    //      (0 to findAll(partialLinkText("comments")).length - 1).foreach {
    //        i =>
    //          Thread.sleep(10000)
    //          val elem = Try(findAll(partialLinkText("comments")).toSeq(i))
    //          Thread.sleep(10000)
    //          elem match {
    //            case Success(v) =>
    //              click on elem.get
    //              Thread.sleep(10000)
    //              findAll(linkText("Like")).foreach(elem => click on elem)
    //              goBack()
    //            case Failure(v) =>
    //              println(s"Couldn't find the ${i} element")
    //          }

    //      }
    //      click on partialLinkText("comments")
    //      findAll(linkText("Like")).foreach(elem => click on elem)
    //      goBack()
    //       findAll(cssSelector("span[class='indent comment-counter']")).foreach{ elem =>
    ////         val elem = findAll(className("blogHeading")).toList(i)
    ////         elem.fin
    //         click on elem
    //         Thread.sleep(10000)
    //         goBack()
    //         Thread.sleep(10000)
    //       }
    //      findAll(className("comment-counter").productArity).foreach { elem =>
    //        click on partialLinkText("comment")
    //        Thread.sleep(1000)
    //        findAll(linkText("Like")).foreach(elem => click on elem)
    //        Thread.sleep(1000)
    //        goBack()
    //        Thread.sleep(10000)
    //      }
    //      Thread.sleep(10000)
    //      click on className("go_next")
    //    }
    pageTitle should be("LUXproject -  LuxTown Home - LuxTown - Confluence")
  }

  "Gracious shutdown" in {
    quit()
  }
}

