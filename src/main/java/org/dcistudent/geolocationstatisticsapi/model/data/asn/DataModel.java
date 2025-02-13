package org.dcistudent.geolocationstatisticsapi.model.data.asn;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataModel implements Serializable {
  private Long asNumber;
  private String asOrg;
  private List<IpBlockDataModel> ipBlocks = new ArrayList<>();

  public DataModel(Long asNumber, String asOrg) {
    this.setAsNumber(asNumber);
    this.setAsOrg(asOrg);
  }

  public Long getAsNumber() {
    return this.asNumber;
  }

  public DataModel setAsNumber(Long asNumber) {
    this.asNumber = asNumber;
    return this;
  }

  public String getAsOrg() {
    return this.asOrg;
  }

  public DataModel setAsOrg(String asOrg) {
    this.asOrg = asOrg;
    return this;
  }

  public List<IpBlockDataModel> getIpBlocks() {
    return this.ipBlocks;
  }

  public DataModel setIpBlocks(List<IpBlockDataModel> ipBlocks) {
    this.ipBlocks = ipBlocks;
    return this;
  }
}
