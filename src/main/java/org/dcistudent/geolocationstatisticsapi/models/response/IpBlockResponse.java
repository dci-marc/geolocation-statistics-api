package org.dcistudent.geolocationstatisticsapi.models.response;

import org.jetbrains.annotations.NotNull;

public class IpBlockResponse {
  private @NotNull String ipStart;
  private @NotNull String ipEnd;

  public IpBlockResponse() {}

  public IpBlockResponse(@NotNull String ipStart, @NotNull String ipEnd) {
    this
        .setIpStart(ipStart)
        .setIpEnd(ipEnd);
  }

  public @NotNull String getIpStart() {
    return this.ipStart;
  }

  public @NotNull IpBlockResponse setIpStart(@NotNull String ipStart) {
    this.ipStart = ipStart;
    return this;
  }

  public @NotNull String getIpEnd() {
    return this.ipEnd;
  }

  public @NotNull IpBlockResponse setIpEnd(@NotNull String ipEnd) {
    this.ipEnd = ipEnd;
    return this;
  }
}
