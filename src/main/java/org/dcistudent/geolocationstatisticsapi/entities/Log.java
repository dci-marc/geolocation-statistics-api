package org.dcistudent.geolocationstatisticsapi.entities;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
public class Log {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  @Column(name = "level")
  private Integer level;
  @Column(name = "datetime")
  private String datetime;
  @Column(name = "message")
  private String message;

  public Log() {}

  public Log(Integer level, String datetime, String message) {
    this.setLevel(level);
    this.setDatetime(datetime);
    this.setMessage(message);
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getLevel() {
    return this.level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public String getDatetime() {
    return this.datetime;
  }

  public void setDatetime(String datetime) {
    this.datetime = datetime;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
