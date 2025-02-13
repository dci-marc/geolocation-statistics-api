package org.dcistudent.geolocationstatisticsapi.model.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AsnDataModel implements Serializable {
  private Long asNumber;
  private String asOrg;
  private List<AsnIpBlockDataModel> ipBlocks = new ArrayList<>();

  public AsnDataModel(Long asNumber, String asOrg) {
    this.setAsNumber(asNumber);
    this.setAsOrg(asOrg);
  }

  public Long getAsNumber() {
    return this.asNumber;
  }

  public AsnDataModel setAsNumber(Long asNumber) {
    this.asNumber = asNumber;
    return this;
  }

  public String getAsOrg() {
    return this.asOrg;
  }

  public AsnDataModel setAsOrg(String asOrg) {
    this.asOrg = asOrg;
    return this;
  }

  public List<AsnIpBlockDataModel> getIpBlocks() {
    return this.ipBlocks;
  }

  public AsnDataModel setIpBlocks(List<AsnIpBlockDataModel> ipBlocks) {
    this.ipBlocks = ipBlocks;
    return this;
  }
}
