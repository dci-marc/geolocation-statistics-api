package org.dcistudent.geolocationstatisticsapi.model.data;

import java.util.List;

public class AsnDataModel {
  private Long asNumber;
  private String asOrg;
  private List<AsnIpBlocksDataModel> ipBlocks;

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

  public List<AsnIpBlocksDataModel> getIpBlocks() {
    return this.ipBlocks;
  }

  public AsnDataModel setIpBlocks(List<AsnIpBlocksDataModel> ipBlocks) {
    this.ipBlocks = ipBlocks;
    return this;
  }
}
