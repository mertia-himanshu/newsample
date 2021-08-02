package org.tmt.newsample.http

import org.tmt.newsample.impl.JNewsampleImpl
import org.tmt.newsample.core.models.GreetResponse

import scala.compat.java8.FutureConverters.CompletionStageOps
import scala.concurrent.Future

class JNewsampleImplWrapper(jNewsampleImpl: JNewsampleImpl) {
  def sayBye(): Future[GreetResponse] = jNewsampleImpl.sayBye().toScala
}
