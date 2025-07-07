package org.dcistudent.geolocationstatisticsapi.models.data;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class IpBlockDataModel implements Serializable {
  private @NotNull String ipStart;
  private @NotNull String ipEnd;

  public IpBlockDataModel(@NotNull String ipStart, @NotNull String ipEnd) {
    this
        .setIpStart(ipStart)
        .setIpEnd(ipEnd);
  }

  public @NotNull String getIpStart() {
    return this.ipStart;
  }

  public @NotNull IpBlockDataModel setIpStart(@NotNull String ipStart) {
    this.ipStart = ipStart;
    return this;
  }

  public @NotNull String getIpEnd() {
    return this.ipEnd;
  }

  public @NotNull IpBlockDataModel setIpEnd(@NotNull String ipEnd) {
    this.ipEnd = ipEnd;
    return this;
  }
}
