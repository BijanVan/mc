package com.mastercard.solution3;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalUnit;
import java.util.Optional;

public class Server {

  private Integer fd;
  private int countTries;
  private Instant lastTimeAttempt;
  private long minInterval; // in seconds

  public Optional<Integer> getFd() {
    return Optional.ofNullable(this.fd);
  }

  public int getCountTries() {
    return countTries;
  }

  public Instant getLastTimeAttempt() {
    return lastTimeAttempt;
  }

  public Server(int minInterval) {
    this.minInterval = minInterval;
    fd = null;
    countTries = 0;
    this.lastTimeAttempt = Instant.now();
  }

  /**
   * It simulate a faulty server
   *
   * @return An optional file descriptor when it connects to a server
   */
  Optional<Integer> connect() {
    long interval = Duration.between(this.lastTimeAttempt, Instant.now()).getSeconds();
    this.lastTimeAttempt = Instant.now();

    // Simulates error
    if (this.countTries++ < 2) return Optional.empty();

    // Simulates throttling
    if (interval < this.minInterval) return Optional.empty();
    this.fd = 1;
    return Optional.of(this.fd);
  }
}
