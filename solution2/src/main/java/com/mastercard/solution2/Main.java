package com.mastercard.solution2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
  private static final int LINE_LENGTH = 5;

  private static void shuffle(RandomAccessFile file) throws IOException {
    long currentPos = file.getFilePointer();
    long countLines = file.length() / LINE_LENGTH;

    file.seek(0);
    for (long i = 0; i < countLines; i++) {
      long index = ThreadLocalRandom.current().nextLong(0, countLines);
      swapLines(file, i, index);
    }

    file.seek(currentPos);
  }

  private static int readInteger(RandomAccessFile file, long index) throws IOException {
    long startIndex = index * LINE_LENGTH;
    file.seek(startIndex);
    return file.readInt();
  }

  private static void writeInteger(RandomAccessFile file, long index, int value)
      throws IOException {
    long startIndex = index * LINE_LENGTH;
    file.seek(startIndex);
    file.writeInt(value);
  }

  private static void swapLines(RandomAccessFile file, long index1, long index2)
      throws IOException {
    long startIndex1 = index1 * LINE_LENGTH;
    long startIndex2 = index2 * LINE_LENGTH;
    byte[] line1 = new byte[LINE_LENGTH];
    byte[] line2 = new byte[LINE_LENGTH];

    file.seek(startIndex1);
    file.readFully(line1);
    file.seek(startIndex2);
    file.readFully(line2);

    file.seek(startIndex1);
    file.write(line2);
    file.seek(startIndex2);
    file.write(line1);
  }

  private static void quickSort(RandomAccessFile file, long start, long end) throws IOException {
    if (end <= start) return;

    int pivot = readInteger(file, start);
    long pivotIndex = start;

    for (long i = start + 1; i < end; i++) {
      long currentValue = readInteger(file, i);
      if (currentValue < pivot) {
        swapLines(file, i, pivotIndex + 1);
        swapLines(file, pivotIndex, pivotIndex + 1);
        pivotIndex += 1;
      }
    }
    if (0 < pivotIndex) quickSort(file, start, pivotIndex);
    if (pivotIndex + 1 < end) quickSort(file, pivotIndex + 1, end);
  }

  public static void sort(String fileName) throws IOException {
    if (!Files.exists(Path.of(fileName))) throw new FileNotFoundException();

    try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
      long countLines = file.length() / LINE_LENGTH;
      shuffle(file);
      quickSort(file, 0, countLines);
    }
  }

  public static void main(String[] args) throws IOException {
    File tempFile = File.createTempFile("mastercard", "test");
    try (RandomAccessFile file = new RandomAccessFile(tempFile, "rw")) {
      Random rnd = new Random();
      for (int i = 0; i < 100; i++) {
        //        file.writeInt(rnd.nextInt(1000));
        file.writeInt(i);
        file.writeByte('\n');
      }
      file.seek(0);
      sort(tempFile.getPath());
      for (int i = 0; i < 100; i++) {
        System.out.println(file.readInt());
        file.readByte();
      }
    }
  }
}
