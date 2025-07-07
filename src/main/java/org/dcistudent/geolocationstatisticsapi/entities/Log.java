package org.dcistudent.geolocationstatisticsapi.entities;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Entity
public class Log {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(name = "level")
  @NotNull
  private Integer level;

  @Column(name = "datetime")
  @NotNull
  private String datetime;

  @Column(name = "message")
  @NotNull
  private String message;

  public Log() {}

  public Log(@NotNull Integer level, @NotNull String datetime, @NotNull String message) {
    this
        .setLevel(level)
        .setDatetime(datetime)
        .setMessage(message);
  }

  public @NotNull String getId() {
    return this.id;
  }

  public Log setId(@NotNull String id) {
    this.id = id;
    return this;
  }

  public @NotNull Integer getLevel() {
    return this.level;
  }

  public Log setLevel(@NotNull Integer level) {
    this.level = level;
    return this;
  }

  public @NotNull String getDatetime() {
    return this.datetime;
  }

  public Log setDatetime(@NotNull String datetime) {
    this.datetime = datetime;
    return this;
  }

  public @NotNull String getMessage() {
    return this.message;
  }

  public Log setMessage(@NotNull String message) {
    this.message = message;
    return this;
  }
}
