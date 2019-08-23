package com.mastercard.solution2;

import static com.mastercard.solution2.Main.sort;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainTest {

  @DisplayName("sort(String fileName) should sort a file containing an integer on each line")
  @Test
  void sortTempFile() throws IOException {
    int countLines = 100;
    int[] actual = new int[countLines];
    File tempFile = File.createTempFile("mastercard", "test");
    try (RandomAccessFile file = new RandomAccessFile(tempFile, "rw")) {
      Random rnd = new Random();
      for (int i = 0; i < countLines; i++) {
        file.writeInt(rnd.nextInt(10 * countLines));
        file.writeByte('\n');
      }
      file.seek(0);
      sort(tempFile.getPath());
      for (int i = 0; i < countLines; i++) {
        actual[i] = file.readInt();
        file.readByte();
      }
    }

    for (int i = 0; i < countLines - 1; i++) {
      assertTrue(actual[i + 1] >= actual[i]);
    }
  }
}
