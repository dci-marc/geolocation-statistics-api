package org.dcistudent.geolocationstatisticsapi.models.response;

public class IpBlockResponse {
  private String ipStart;
  private String ipEnd;

  public IpBlockResponse() {}

  public IpBlockResponse(String ipStart, String ipEnd) {
    this.setIpStart(ipStart);
    this.setIpEnd(ipEnd);
  }

  public String getIpStart() {
    return this.ipStart;
  }

  public void setIpStart(String ipStart) {
    this.ipStart = ipStart;
  }

  public String getIpEnd() {
    return this.ipEnd;
  }

  public void setIpEnd(String ipEnd) {
    this.ipEnd = ipEnd;
  }
}
