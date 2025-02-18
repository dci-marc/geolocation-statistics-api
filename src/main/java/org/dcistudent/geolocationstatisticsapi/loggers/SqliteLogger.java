package org.dcistudent.geolocationstatisticsapi.loggers;

import org.dcistudent.geolocationstatisticsapi.managers.LogManager;
import org.springframework.stereotype.Component;

@Component
public class SqliteLogger {

  private final LogManager logManager;

  public SqliteLogger(LogManager logManager) {
    this.logManager = logManager;
  }

  public void logDebug(String message) {
    this.logManager.log(Level.DEBUG.get(), message);
  }

  public void logInfo(String message) {
    this.logManager.log(Level.INFO.get(), message);
  }

  public void logWarn(String message) {
    this.logManager.log(Level.WARN.get(), message);
  }

  public void logError(String message) {
    this.logManager.log(Level.ERROR.get(), message);
  }


  public void logFatal(String message) {
    this.logManager.log(Level.FATAL.get(), message);
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
