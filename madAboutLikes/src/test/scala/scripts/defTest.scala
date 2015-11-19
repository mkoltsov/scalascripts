package scripts


import com.typesafe.config.ConfigFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.scalatest.{FreeSpec, FunSuite, Matchers, FlatSpec}
import org.scalatest.selenium.{Firefox, HtmlUnit, WebBrowser}


class defTest extends FreeSpec with Matchers with WebBrowser {
  implicit val webDriver: WebDriver = new FirefoxDriver()
  val conf = ConfigFactory.load()
  val host = conf.getString("test.baseUrl")

  "title should be correct" in {
    go to (host)
    textField("os_username").value = conf.getString("test.login")
    pwdField("os_password").value = conf.getString("test.password")
    click on className("panelButton")
    while (true) {
      Thread.sleep(10000)
      findAll(linkText("Like")).foreach(elem => click on elem)
      Thread.sleep(10000)
      click on className("go_next")
    }
    pageTitle should be("LUXproject -  LuxTown Home - LuxTown - Confluence")
  }

  "Gracious shutdown" in {
    quit()
  }
}

