package org.tmt.newsample.impl;

import esw.http.template.wiring.JCswServices;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.mockito.Mockito;
import org.scalatestplus.junit.JUnitSuite;
import org.tmt.newsample.core.models.GreetResponse;

import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;

public class JNewsampleImplTest extends JUnitSuite {

  @Test
  public void shouldCallBye() throws ExecutionException, InterruptedException {
    JCswServices mock = Mockito.mock(JCswServices.class);
    JNewsampleImpl jNewsample = new JNewsampleImpl(mock);
    GreetResponse greetResponse = new GreetResponse("Bye!!!");
    assertThat(jNewsample.sayBye().get(), CoreMatchers.is(greetResponse));
  }
}
