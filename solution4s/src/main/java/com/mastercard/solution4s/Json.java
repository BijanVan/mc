package com.mastercard.solution4s;

public interface Json {
  /**
   * Conversion to class
   *
   * @param json The string from which the object is to be deserialized
   * @param classOfT The class of T
   * @param <T> The type of the desired object
   * @return An object of type T from the string. Returns null if json is null.
   * @throws {@code JsonSyntaxException} - if json is not a valid representation for an object of
   *     type classOfT
   */
  <T> T fromJson(String json, Class<T> classOfT);

  /**
   * Conversion to JSON string
   *
   * @param src The object for which JSON representation is to be created
   * @return JsonImpl representation of src
   */
  String toJson(Object src);
}
