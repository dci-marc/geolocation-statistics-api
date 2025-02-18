package org.dcistudent.geolocationstatisticsapi.models.data.asn;

import java.io.Serializable;

public class IpBlockDataModel implements Serializable {
  private String ipStart;
  private String ipEnd;

  public IpBlockDataModel(String ipStart, String ipEnd) {
    this.ipStart = ipStart;
    this.ipEnd = ipEnd;
  }

  public String getIpStart() {
    return this.ipStart;
  }

  public IpBlockDataModel setIpStart(String ipStart) {
    this.ipStart = ipStart;
    return this;
  }

  public String getIpEnd() {
    return this.ipEnd;
  }

  public IpBlockDataModel setIpEnd(String ipEnd) {
    this.ipEnd = ipEnd;
    return this;
  }
}
