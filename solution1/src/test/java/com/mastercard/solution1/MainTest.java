package com.mastercard.solution1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainTest {

  @DisplayName("findDuplicates(T[] in) should throw NullPointerException if input is null")
  @Test
  void assertThrowsExceptionArray() {
    Integer[] data = null;
    Main main = new Main();

    Throwable exception =
        assertThrows(
            NullPointerException.class,
            () -> {
              main.findDuplicates(data);
            });
  }

  @DisplayName("findDuplicates(T[] in) should return empty list if the input length is less than 2")
  @Test
  void findDuplicatesArrayLength1() {
    Integer[] data = new Integer[] {1};
    Main main = new Main();
    List<Integer> dups = main.findDuplicates(data);

    assertEquals(dups.size(), 0);
  }

  @DisplayName(
      "findDuplicates(T[] in) should return an empty list if the input does not have duplicates")
  @Test
  void findDuplicatesArrayWithoutDuplicates() {
    Integer[] data = new Integer[] {2, 8, 6, 3};
    List<Integer> expected = new ArrayList<>();
    Main main = new Main();
    List<Integer> dups = main.findDuplicates(data);

    assertEquals(expected, dups);
  }

  @DisplayName("findDuplicates(T[] in) should return expected list if the input has duplicates")
  @Test
  void findDuplicatesArrayWithDuplicates() {
    Integer[] data = new Integer[] {2, 1, 2, 5, 1, 2, 8, 2, 1};
    List<Integer> expected = List.of(1, 2);
    Main main = new Main();
    List<Integer> dups = main.findDuplicates(data);

    assertEquals(expected, dups);
  }

  @DisplayName("findDuplicates(Map<K, V> in) should throw NullPointerException if input is null")
  @Test
  void assertThrowsExceptionMap() {
    Map<Integer, Integer> data = null;
    Main main = new Main();

    Throwable exception =
        assertThrows(
            NullPointerException.class,
            () -> {
              main.findDuplicates(data);
            });
  }

  @DisplayName(
      "findDuplicates(Map<K, V> in) should return empty list if the input length is less than 2")
  @Test
  void findDuplicatesMapLength1() {
    Map<Integer, Integer> data = Map.of(1, 10);
    Main main = new Main();
    List<Integer> dups = main.findDuplicates(data);

    assertEquals(dups.size(), 0);
  }

  @DisplayName(
      "findDuplicates(Map<K, V> in) should return an empty list if the input does not have duplicates")
  @Test
  void findDuplicatesMapWithoutDuplicates() {
    Map<Integer, Integer> data = Map.of(1, 10, 6, 40, 8, 60);
    List<Integer> expected = new ArrayList<>();
    Main main = new Main();
    List<Integer> dups = main.findDuplicates(data);

    assertEquals(expected, dups);
  }

  @DisplayName(
      "findDuplicates(Map<K, V> in) should return expected list if the input has duplicates")
  @Test
  void findDuplicatesMapWithDuplicates() {
    Map<Integer, Integer> data = Map.of(1, 2, 2, 1, 3, 2, 4, 5, 5, 1, 6, 2, 7, 8, 8, 2, 9, 1);
    List<Integer> expected = List.of(1, 2);
    Main main = new Main();
    List<Integer> dups = main.findDuplicates(data);
    assertEquals(expected, dups);
  }
}
