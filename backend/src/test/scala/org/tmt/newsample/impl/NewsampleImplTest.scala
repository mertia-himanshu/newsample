package org.tmt.newsample.impl

import org.scalatest.concurrent.ScalaFutures.convertScalaFuture
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.tmt.newsample.core.models.{AdminGreetResponse, GreetResponse, UserInfo}

class NewsampleImplTest extends AnyWordSpec with Matchers {

  "NewsampleImpl" must {
    "greeting should return greeting response of 'Hello user'" in {
      val newsampleImpl = new NewsampleImpl()
      newsampleImpl.greeting(UserInfo("John", "Smith")).futureValue should ===(GreetResponse("Hello user: John Smith!!!"))
    }

    "adminGreeting should return greeting response of 'Hello admin user'" in {
      val newsampleImpl = new NewsampleImpl()
      newsampleImpl.adminGreeting(UserInfo("John", "Smith")).futureValue should ===(AdminGreetResponse("Hello admin user: John Smith!!!"))
    }
  }
}
