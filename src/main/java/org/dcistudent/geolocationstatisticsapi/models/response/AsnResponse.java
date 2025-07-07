package org.dcistudent.geolocationstatisticsapi.models.response;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AsnResponse {

  private @NotNull Long asNumber;
  private @NotNull String asOrg;
  private @NotNull List<IpBlockResponse> ipBlocks = new ArrayList<>();

  public AsnResponse() {}

  public AsnResponse(@NotNull Long asNumber, @NotNull String asOrg, @NotNull List<IpBlockResponse> ipBlocks) {
    this
        .setAsNumber(asNumber)
        .setAsOrg(asOrg)
        .setIpBlocks(ipBlocks);
  }

  public @NotNull Long getAsNumber() {
    return this.asNumber;
  }

  public @NotNull AsnResponse setAsNumber(@NotNull Long asNumber) {
    this.asNumber = asNumber;
    return this;
  }

  public @NotNull String getAsOrg() {
    return this.asOrg;
  }

  public @NotNull AsnResponse setAsOrg(@NotNull String asOrg) {
    this.asOrg = asOrg;
    return this;
  }

  public @NotNull List<IpBlockResponse> getIpBlocks() {
    return this.ipBlocks;
  }

  public @NotNull AsnResponse setIpBlocks(@NotNull List<IpBlockResponse> ipBlocks) {
    this.ipBlocks = ipBlocks;
    return this;
  }
}
