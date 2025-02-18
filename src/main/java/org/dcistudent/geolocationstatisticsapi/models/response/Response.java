package org.dcistudent.geolocationstatisticsapi.models.response;

public class Response<T> {
  int status = 0;
  String message = "";
  T data;

  public Response() {}

  public Response(Integer status, String message) {
    this.status = status;
    this.message = message;
  }

  public Response(int status, String message, T data) {
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

  public T getData() {
    return this.data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public enum Status {
    OK(200),
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
