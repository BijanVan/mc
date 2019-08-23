package com.mastercard.solution3;

import java.util.Optional;
import java.util.Random;

public class Main {

  /**
   * Connects to a server with a retry logic.
   *
   * @param server Server to connect to.
   * @param retryInterval Interval between retries in milliseconds
   * @param jitter Jitter (0 to jitter) added to the {@code retryInterval} in milliseconds
   * @param backoffFactor Backoff factor
   * @param maxInterval Maximum interval so that retry interval < {@maxInterval}
   * @param maxRetry Maximum number of tries
   * @return An optional file descriptor
   */
  public static Optional<Integer> retryConnectToServer(
      Server server,
      int retryInterval,
      int jitter,
      int backoffFactor,
      int maxInterval,
      int maxRetry)
      throws InterruptedException {
    int countTries = 0;
    Random rnd = new Random(System.currentTimeMillis());

    while (server.connect().isEmpty() && countTries++ < maxRetry) {
      int delay = retryInterval + rnd.nextInt(jitter);
      if (delay > maxInterval) delay = maxInterval;
      Thread.sleep(delay);
      retryInterval *= backoffFactor;
    }

    return server.getFd();
  }
}
