package org.dcistudent.geolocationstatisticsapi.loggers;

import org.dcistudent.geolocationstatisticsapi.repositories.LogRepository;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public final class SqliteLogger {

  private final LogRepository logRepository;

  public SqliteLogger(LogRepository logRepository) {
    this.logRepository = logRepository;
  }

  public void logDebug(String message) {
    this.log(Level.DEBUG.get(), message);
  }

  public void logInfo(String message) {
    this.log(Level.INFO.get(), message);
  }

  public void logWarn(String message) {
    this.log(Level.WARN.get(), message);
  }

  public void logError(String message) {
    this.log(Level.ERROR.get(), message);
  }


  public void logFatal(String message) {
    this.log(Level.FATAL.get(), message);
  }

  private void log(Integer level, String message) {
    this.logRepository.insert(
        level,
        ZonedDateTime.now().toString(),
        message
    );

  }

  public enum Level {
    DEBUG(0),
    INFO(1),
    WARN(2),
    ERROR(3),
    FATAL(4);

    private final int value;

    Level(int value) {
      this.value = value;
    }

    public int get() {
      return this.value;
    }
  }
}
