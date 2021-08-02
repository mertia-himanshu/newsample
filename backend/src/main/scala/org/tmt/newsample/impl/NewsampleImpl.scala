package org.tmt.newsample.impl

import org.tmt.newsample.core.models.{AdminGreetResponse, GreetResponse, UserInfo}

import scala.concurrent.Future

class NewsampleImpl() {
  // #greeting
  def greeting(userInfo: UserInfo): Future[GreetResponse] = Future.successful(GreetResponse(userInfo))
  // #greeting

  def adminGreeting(userInfo: UserInfo): Future[AdminGreetResponse] =
    Future.successful(AdminGreetResponse(userInfo))
}
