package com.mastercard.solution4s;

import com.google.gson.Gson;

public class JsonImpl implements Json {

  public <T> T fromJson(String json, Class<T> classOfT) {
    Gson gson = new Gson();
    return gson.fromJson(json, classOfT);
  }

  public String toJson(Object src) {
    Gson gson = new Gson();
    return gson.toJson(src);
  }
}
