package org.tmt.newsample.http

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import csw.aas.http.AuthorizationPolicy.RealmRolePolicy
import csw.aas.http.SecurityDirectives
import org.tmt.newsample.impl.NewsampleImpl
import org.tmt.newsample.core.models.UserInfo

import scala.concurrent.ExecutionContext

class NewsampleRoute(service1: NewsampleImpl, service2: JNewsampleImplWrapper, securityDirectives: SecurityDirectives) (implicit  ec: ExecutionContext) extends HttpCodecs {

 val route: Route = post {
    path("greeting") {
      entity(as[UserInfo]) { userInfo =>
        complete(service1.greeting(userInfo))
      }
    } ~
    path("adminGreeting") {
      securityDirectives.sPost(RealmRolePolicy("Esw-user")) { token =>
        entity(as[UserInfo]) { userInfo => complete(service1.adminGreeting(userInfo)) }
      }
    }
  } ~
    path("sayBye") {
      complete(service2.sayBye())
    }
}

