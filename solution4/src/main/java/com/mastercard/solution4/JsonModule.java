package com.mastercard.solution4;

import com.google.inject.AbstractModule;
import com.mastercard.solution4s.Json;
import com.mastercard.solution4s.JsonImpl;

public class JsonModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(Json.class).to(JsonImpl.class);
  }

}
