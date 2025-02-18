package org.dcistudent.geolocationstatisticsapi.models.response;

public class LogResponse {

  private Integer level;
  private String datetime;
  private String message;

  public LogResponse() {}

  public LogResponse(Integer level, String datetime, String message) {
    this.setLevel(level);
    this.setDatetime(datetime);
    this.setMessage(message);
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
