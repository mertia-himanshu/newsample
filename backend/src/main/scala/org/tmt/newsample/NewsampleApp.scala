package org.tmt.newsample

import caseapp.core.RemainingArgs
import csw.location.api.models.Metadata
import csw.network.utils.SocketUtils
import esw.http.template.wiring.ServerApp
import NewsampleAppCommand.StartCommand

object NewsampleApp extends ServerApp[NewsampleAppCommand] {
  override def appName: String    = getClass.getSimpleName.dropRight(1)

  override def run(command: NewsampleAppCommand, remainingArgs: RemainingArgs): Unit =
    command match {
      case StartCommand(port) =>
        val wiring = new NewsampleWiring(Some(port.getOrElse(SocketUtils.getFreePort)))
        start(wiring, Metadata.empty)
    }
}
