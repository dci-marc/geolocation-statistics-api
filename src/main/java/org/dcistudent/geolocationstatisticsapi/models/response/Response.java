package org.dcistudent.geolocationstatisticsapi.models.response;

public class Response {
  int status = 0;
  String message = "";
  Object data;

  public Response() {}

  public Response(Integer status, String message) {
    this.status = status;
    this.message = message;
  }

  public Response(int status, String message, Object data) {
    this.status = status;
    this.message = message;
    this.data = data;
  }

  public int getStatus() {
    return this.status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return this.data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public enum Status {
    OK(200),
    BAD_REQUEST(400),
    INTERNAL_SERVER_ERROR(500);

    private final int value;

    Status(int value) {
      this.value = value;
    }

    public int get() {
      return this.value;
    }
  }

  public enum Message {
    OK("OK"),
    BAD_REQUEST("Bad Request"),
    INTERNAL_SERVER_ERROR("Internal Server Error");

    private final String value;

    Message(String value) {
      this.value = value;
    }

    public String get() {
      return this.value;
    }
  }
}
