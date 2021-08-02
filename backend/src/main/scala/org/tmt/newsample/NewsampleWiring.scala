package org.tmt.newsample

import akka.http.scaladsl.server.Route
import esw.http.template.wiring.ServerWiring
import org.tmt.newsample.impl.{JNewsampleImpl, NewsampleImpl}
import org.tmt.newsample.http.{JNewsampleImplWrapper, NewsampleRoute}

class NewsampleWiring(val port: Option[Int]) extends ServerWiring {
  override val actorSystemName: String = "newsample-actor-system"

  lazy val jNewsampleImpl: JNewsampleImpl = new JNewsampleImpl(jCswServices)
  lazy val newsampleImpl               = new NewsampleImpl()
  lazy val newsampleImplWrapper        = new JNewsampleImplWrapper(jNewsampleImpl)

  import actorRuntime.ec
  override lazy val routes: Route = new NewsampleRoute(newsampleImpl, newsampleImplWrapper, securityDirectives).route
}
