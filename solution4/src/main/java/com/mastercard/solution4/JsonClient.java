package com.mastercard.solution4;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.mastercard.solution4s.Json;
import com.mastercard.solution4s.JsonImpl;

public class JsonClient {
  private final Json json;

  @Inject
  public JsonClient(Json json) {
    this.json = json;
  }

  public Book createBookFromJson(String jsonString) {
    return this.json.fromJson(jsonString, Book.class);
  }

  public String createJsonFromBook(Book book) {
    return this.json.toJson(book);
  }
}
