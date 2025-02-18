package org.dcistudent.geolocationstatisticsapi.models.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.ZonedDateTime;

public class LogDataModel {

  @JsonIgnore
  private String id;
  private Integer level;
  private ZonedDateTime datetime;
  private String message;

  public LogDataModel() {}

  public LogDataModel(String id, Integer level, ZonedDateTime datetime, String message) {
    this.setId(id);
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

  public ZonedDateTime getDatetime() {
    return this.datetime;
  }

  public void setDatetime(ZonedDateTime datetime) {
    this.datetime = datetime;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
