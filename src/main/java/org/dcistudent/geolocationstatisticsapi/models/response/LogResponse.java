package org.dcistudent.geolocationstatisticsapi.models.response;

import org.jetbrains.annotations.NotNull;

public class LogResponse {

  private Integer level;
  private String datetime;
  private String message;

  public LogResponse() {}

  public LogResponse(Integer level, String datetime, String message) {
    this
        .setLevel(level)
        .setDatetime(datetime)
        .setMessage(message);
  }

  public Integer getLevel() {
    return this.level;
  }

  public @NotNull LogResponse setLevel(@NotNull Integer level) {
    this.level = level;
    return this;
  }

  public @NotNull String getDatetime() {
    return this.datetime;
  }

  public @NotNull LogResponse setDatetime(@NotNull String datetime) {
    this.datetime = datetime;
    return this;
  }

  public @NotNull String getMessage() {
    return this.message;
  }

  public @NotNull LogResponse setMessage(@NotNull String message) {
    this.message = message;
    return this;
  }
}
