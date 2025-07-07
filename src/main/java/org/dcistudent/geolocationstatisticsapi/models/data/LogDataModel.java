package org.dcistudent.geolocationstatisticsapi.models.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jetbrains.annotations.NotNull;

import java.time.ZonedDateTime;

public class LogDataModel {

  @JsonIgnore
  private @NotNull String id;
  private @NotNull Integer level;
  private @NotNull ZonedDateTime datetime;
  private @NotNull String message;

  public LogDataModel() {}

  public LogDataModel(
      @NotNull String id,
      @NotNull Integer level,
      @NotNull ZonedDateTime datetime,
      @NotNull String message
  ) {
    this
        .setId(id)
        .setLevel(level)
        .setDatetime(datetime)
        .setMessage(message);
  }

  public @NotNull String getId() {
    return this.id;
  }

  public @NotNull LogDataModel setId(@NotNull String id) {
    this.id = id;
    return this;
  }

  public @NotNull Integer getLevel() {
    return this.level;
  }

  public @NotNull LogDataModel setLevel(@NotNull Integer level) {
    this.level = level;
    return this;
  }

  public @NotNull ZonedDateTime getDatetime() {
    return this.datetime;
  }

  public @NotNull LogDataModel setDatetime(@NotNull ZonedDateTime datetime) {
    this.datetime = datetime;
    return this;
  }

  public @NotNull String getMessage() {
    return this.message;
  }

  public @NotNull LogDataModel setMessage(@NotNull String message) {
    this.message = message;
    return this;
  }
}
