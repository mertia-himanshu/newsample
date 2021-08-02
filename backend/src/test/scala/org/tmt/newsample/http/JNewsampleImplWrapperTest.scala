package org.tmt.newsample.http

import java.util.concurrent.CompletableFuture

import org.mockito.MockitoSugar.{mock, verify, when}
import org.scalatest.concurrent.ScalaFutures.convertScalaFuture
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.tmt.newsample.impl.JNewsampleImpl
import org.tmt.newsample.core.models.GreetResponse

class JNewsampleImplWrapperTest extends AnyWordSpec with Matchers {

  "NewsampleImplWrapper" must {
    "delegate sayBye to JNewsampleImpl.sayBye" in {
      val jNewsampleImpl       = mock[JNewsampleImpl]
      val newsampleImplWrapper = new JNewsampleImplWrapper(jNewsampleImpl)

      val newsampleResponse = mock[GreetResponse]
      when(jNewsampleImpl.sayBye()).thenReturn(CompletableFuture.completedFuture(newsampleResponse))

      newsampleImplWrapper.sayBye().futureValue should ===(newsampleResponse)
      verify(jNewsampleImpl).sayBye()
    }
  }
}
