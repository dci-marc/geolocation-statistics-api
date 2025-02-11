package org.dcistudent.geolocationstatisticsapi.entity;

import jakarta.persistence.*;

@Entity
public class Asn {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Byte ipStart;
  private Byte ipEnd;
  private String asNumber;
  private String asOrg;

  public Asn() {}

  public Asn(Byte ipStart, Byte ipEnd, String asNumber, String asOrg) {
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

  public Byte ipStart() {
    return ipStart;
  }

  public Asn setIpStart(Byte ipStart) {
    this.ipStart = ipStart;
    return this;
  }

  public Byte ipEnd() {
    return ipEnd;
  }

  public Asn setIpEnd(Byte ipEnd) {
    this.ipEnd = ipEnd;
    return this;
  }

  public String asNumber() {
    return asNumber;
  }

  public Asn setAsNumber(String asNumber) {
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
