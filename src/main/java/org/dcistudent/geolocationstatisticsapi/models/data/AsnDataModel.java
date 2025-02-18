package org.dcistudent.geolocationstatisticsapi.models.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AsnDataModel implements Serializable {
  private Long asNumber;
  private String asOrg;
  private List<IpBlockDataModel> ipBlocks = new ArrayList<>();

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

  public List<IpBlockDataModel> getIpBlocks() {
    return this.ipBlocks;
  }

  public AsnDataModel setIpBlocks(List<IpBlockDataModel> ipBlocks) {
    this.ipBlocks = ipBlocks;
    return this;
  }
}
