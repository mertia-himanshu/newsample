package org.tmt.newsample.impl;

import esw.http.template.wiring.JCswServices;
import org.tmt.newsample.core.models.GreetResponse;

import java.util.concurrent.CompletableFuture;

public class JNewsampleImpl {
  JCswServices jCswServices;

  public JNewsampleImpl(JCswServices jCswServices) {
    this.jCswServices = jCswServices;
  }

  public CompletableFuture<GreetResponse> sayBye() {
    return CompletableFuture.completedFuture(new GreetResponse("Bye!!!"));
  }

}
