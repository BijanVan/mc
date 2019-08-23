package com.mastercard.solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Main {

  /**
   * find a duplicate value in an array.
   *
   * @param in input array
   * @param <T> Any type implements {@code Comparable}
   * @return List of the duplicates. If there is none, the list would be empty
   * @throws {@code NullPointerException} - if {@code in} is null
   */
  public <T extends Comparable<T>> List<T> findDuplicates(T[] in) {
    Objects.requireNonNull(in);
    List<T> result = new ArrayList<>();
    if (in.length < 2) return result;

    Arrays.sort(in);
    boolean found = false;
    for (int i = 1; i < in.length; i++) {
      if (in[i].equals(in[i - 1])) {
        if (!found) result.add(in[i]);
        found = true;
      } else {
        found = false;
      }
    }

    return result;
  }

  public <K, V extends Comparable<V>> List<V> findDuplicates(Map<K, V> in) {
    Objects.requireNonNull(in);
    Set<V> result = new HashSet<>();
    if (in.size() < 2) return new ArrayList<>(result);

    Set<V> uniques = new HashSet<>();
    for (V v : in.values()) {
      if (uniques.contains(v)) {
        result.add(v);
      } else {
        uniques.add(v);
      }
    }
    return new ArrayList<>(result);
  }
}
