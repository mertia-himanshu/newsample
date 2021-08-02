package org.tmt.newsample

import caseapp.{CommandName, ExtraName, HelpMessage}

sealed trait NewsampleAppCommand

object NewsampleAppCommand {

  @CommandName("start")
  final case class StartCommand(
     @HelpMessage("port of the app")
     @ExtraName("p")
     port: Option[Int]
   ) extends NewsampleAppCommand

}
