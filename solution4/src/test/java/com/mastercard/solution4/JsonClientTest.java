package com.mastercard.solution4;

import static org.junit.jupiter.api.Assertions.*;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JsonClientTest {

  @DisplayName(
      "createBookFromJson() should return a valid book & the json representation of that should be equal to the original JSON string")
  @Test
  void createBookFromJson() {
    Injector injector = Guice.createInjector(new JsonModule());
    JsonClient jsonClient = injector.getInstance(JsonClient.class);

    String jsonExpected =
        "{\n"
            + "\"title\":\"Title #1\",\n"
            + "\"isbn\":\"08976678555\",\n"
            + "\"authors\":[\n"
            + "\"author #1\",\n"
            + "\"author #2\"\n"
            + "]\n"
            + "}";

    Book book = jsonClient.createBookFromJson(jsonExpected);
    String jsonActual = jsonClient.createJsonFromBook(book);

    assertEquals(jsonExpected.replaceAll("\n", ""), jsonActual);
  }
}
