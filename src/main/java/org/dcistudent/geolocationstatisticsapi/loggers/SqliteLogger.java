package org.dcistudent.geolocationstatisticsapi.loggers;

import org.dcistudent.geolocationstatisticsapi.services.LogService;
import org.springframework.stereotype.Component;

@Component
public class SqliteLogger {

  private final LogService logService;

  public SqliteLogger(LogService logService) {
    this.logService = logService;
  }

  public void logDebug(String message) {
    this.logService.log(Level.DEBUG.get(), message);
  }

  public void logInfo(String message) {
    this.logService.log(Level.INFO.get(), message);
  }

  public void logWarn(String message) {
    this.logService.log(Level.WARN.get(), message);
  }

  public void logError(String message) {
    this.logService.log(Level.ERROR.get(), message);
  }


  public void logFatal(String message) {
    this.logService.log(Level.FATAL.get(), message);
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
