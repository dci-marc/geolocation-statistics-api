package org.dcistudent.geolocationstatisticsapi.models.response;

import org.jetbrains.annotations.NotNull;

public class Response {
  int status = 0;
  @NotNull String message = "";
  @NotNull Object data = new Object();

  public Response() {}

  public Response(@NotNull Integer status, @NotNull String message) {
    this.status = status;
    this.message = message;
  }

  public Response(int status, @NotNull String message, @NotNull Object data) {
    this
        .setStatus(status)
        .setMessage(message)
        .setData(data);
  }

  public int getStatus() {
    return this.status;
  }

  public @NotNull Response setStatus(int status) {
    this.status = status;
    return this;
  }

  public @NotNull String getMessage() {
    return this.message;
  }

  public @NotNull Response setMessage(@NotNull String message) {
    this.message = message;
    return this;
  }

  public @NotNull Object getData() {
    return this.data;
  }

  public @NotNull Response setData(@NotNull Object data) {
    this.data = data;
    return this;
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
