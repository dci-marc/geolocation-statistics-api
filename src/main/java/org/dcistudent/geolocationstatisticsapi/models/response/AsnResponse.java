package org.dcistudent.geolocationstatisticsapi.models.response;

import java.util.ArrayList;
import java.util.List;

public class AsnResponse {

  private Long asNumber;
  private String asOrg;
  private List<IpBlockResponse> ipBlocks = new ArrayList<>();

  public AsnResponse() {}

  public AsnResponse(Long asNumber, String asOrg, List<IpBlockResponse> ipBlocks) {
    this.setAsNumber(asNumber);
    this.setAsOrg(asOrg);
    this.setIpBlocks(ipBlocks);
  }

  public Long getAsNumber() {
    return this.asNumber;
  }

  public void setAsNumber(Long asNumber) {
    this.asNumber = asNumber;
  }

  public String getAsOrg() {
    return this.asOrg;
  }

  public void setAsOrg(String asOrg) {
    this.asOrg = asOrg;
  }

  public List<IpBlockResponse> getIpBlocks() {
    return this.ipBlocks;
  }

  public void setIpBlocks(List<IpBlockResponse> ipBlocks) {
    this.ipBlocks = ipBlocks;
  }
}
