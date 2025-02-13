package org.dcistudent.geolocationstatisticsapi.model.data;

public class AsnIpBlocksDataModel {
  private String ipStart;
  private String ipEnd;

  public AsnIpBlocksDataModel(String ipStart, String ipEnd) {
    this.ipStart = ipStart;
    this.ipEnd = ipEnd;
  }

  public String ipStart() {
    return this.ipStart;
  }

  public AsnIpBlocksDataModel setIpStart(String ipStart) {
    this.ipStart = ipStart;
    return this;
  }

  public String ipEnd() {
    return this.ipEnd;
  }

  public AsnIpBlocksDataModel setIpEnd(String ipEnd) {
    this.ipEnd = ipEnd;
    return this;
  }
}
