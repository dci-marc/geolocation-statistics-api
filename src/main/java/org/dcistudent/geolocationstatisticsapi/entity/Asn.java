package org.dcistudent.geolocationstatisticsapi.entity;

import jakarta.persistence.*;

@Entity
public class Asn {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String ipStart;
  private String ipEnd;
  private Long asNumber;
  private String asOrg;

  public Asn() {}

  public Asn(String ipStart, String ipEnd, Long asNumber, String asOrg) {
    this.ipStart = ipStart;
    this.ipEnd = ipEnd;
    this.asNumber = asNumber;
    this.asOrg = asOrg;
  }

  public Long id() {
    return id;
  }

  public Asn setId(Long id) {
    this.id = id;
    return this;
  }

  public String ipStart() {
    return ipStart;
  }

  public Asn setIpStart(String ipStart) {
    this.ipStart = ipStart;
    return this;
  }

  public String ipEnd() {
    return ipEnd;
  }

  public Asn setIpEnd(String ipEnd) {
    this.ipEnd = ipEnd;
    return this;
  }

  public Long asNumber() {
    return asNumber;
  }

  public Asn setAsNumber(Long asNumber) {
    this.asNumber = asNumber;
    return this;
  }

  public String asOrg() {
    return asOrg;
  }

  public Asn setAsOrg(String asOrg) {
    this.asOrg = asOrg;
    return this;
  }

  @Override
  public String toString() {
    return "Asn{" +
      "id=" + this.id +
      ", ipStart=" + this.ipStart +
      ", ipEnd=" + this.ipEnd +
      ", asNumber='" + this.asNumber + '\'' +
      ", asOrg='" + this.asOrg + '\'' +
      '}';
  }
}
