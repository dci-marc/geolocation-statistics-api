package org.dcistudent.geolocationstatisticsapi.models.data;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AsnDataModel implements Serializable {
  private @NotNull Long asNumber;
  private @NotNull String asOrg;
  private @NotNull List<IpBlockDataModel> ipBlocks = new ArrayList<>();

  public AsnDataModel(@NotNull Long asNumber, @NotNull String asOrg) {
    this
        .setAsNumber(asNumber)
        .setAsOrg(asOrg);
  }

  public @NotNull Long getAsNumber() {
    return this.asNumber;
  }

  public @NotNull AsnDataModel setAsNumber(@NotNull Long asNumber) {
    this.asNumber = asNumber;
    return this;
  }

  public @NotNull String getAsOrg() {
    return this.asOrg;
  }

  public @NotNull AsnDataModel setAsOrg(@NotNull String asOrg) {
    this.asOrg = asOrg;
    return this;
  }

  public @NotNull List<IpBlockDataModel> getIpBlocks() {
    return this.ipBlocks;
  }

  public @NotNull AsnDataModel setIpBlocks(@NotNull List<IpBlockDataModel> ipBlocks) {
    this.ipBlocks = ipBlocks;
    return this;
  }
}
