package org.dcistudent.geolocationstatisticsapi.model.data;

import java.io.Serializable;

public class AsnIpBlockDataModel implements Serializable {
  private String ipStart;
  private String ipEnd;

  public AsnIpBlockDataModel(String ipStart, String ipEnd) {
    this.ipStart = ipStart;
    this.ipEnd = ipEnd;
  }

  public String getIpStart() {
    return this.ipStart;
  }

  public AsnIpBlockDataModel setIpStart(String ipStart) {
    this.ipStart = ipStart;
    return this;
  }

  public String getIpEnd() {
    return this.ipEnd;
  }

  public AsnIpBlockDataModel setIpEnd(String ipEnd) {
    this.ipEnd = ipEnd;
    return this;
  }
}
