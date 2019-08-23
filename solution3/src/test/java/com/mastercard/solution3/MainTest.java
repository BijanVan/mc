package com.mastercard.solution3;

import static com.mastercard.solution3.Main.retryConnectToServer;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainTest {

  @DisplayName("retryConnectToServer should not get a valid fd because of throttling (4 seconds)")
  @Test
  void retryConnectToServerTestThrottling() throws InterruptedException {
    Server server = new Server(5);
    Optional<Integer> fd = retryConnectToServer(server, 100, 100, 2, 3000, 6);
    assertTrue(fd.isEmpty());
  }

  @DisplayName(
      "retryConnectToServer should get a valid fd because an interval > throttling (2 seconds)")
  @Test
  void retryConnectToServerSuccess() throws InterruptedException {
    Server server = new Server(2);
    Optional<Integer> fd = retryConnectToServer(server, 100, 100, 2, 3000, 6);
    assertTrue(fd.isPresent());
  }

  @DisplayName(
      "retryConnectToServer should not get a valid fd because a server error (retries < 2)")
  @Test
  void retryConnectToServerError() throws InterruptedException {
    Server server = new Server(4);
    Optional<Integer> fd = retryConnectToServer(server, 100, 100, 2, 3000, 1);
    assertTrue(fd.isEmpty());
  }
}
