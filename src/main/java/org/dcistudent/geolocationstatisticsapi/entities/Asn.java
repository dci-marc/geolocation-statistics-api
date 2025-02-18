package org.dcistudent.geolocationstatisticsapi.entities;

import jakarta.persistence.*;

@Entity
public class Asn {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "ip_start")
  private String ipStart;
  @Column(name = "ip_end")
  private String ipEnd;
  @Column(name = "as_number")
  private Long asNumber;
  @Column(name = "as_org")
  private String asOrg;

  public Asn() {}

  public Asn(String ipStart, String ipEnd, Long asNumber, String asOrg) {
    this.ipStart = ipStart;
    this.ipEnd = ipEnd;
    this.asNumber = asNumber;
    this.asOrg = asOrg;
  }

  public Long getId() {
    return this.id;
  }

  public Asn setId(Long id) {
    this.id = id;
    return this;
  }

  public String getIpStart() {
    return this.ipStart;
  }

  public Asn setIpStart(String ipStart) {
    this.ipStart = ipStart;
    return this;
  }

  public String getIpEnd() {
    return this.ipEnd;
  }

  public Asn setIpEnd(String ipEnd) {
    this.ipEnd = ipEnd;
    return this;
  }

  public Long getAsNumber() {
    return this.asNumber;
  }

  public Asn setAsNumber(Long asNumber) {
    this.asNumber = asNumber;
    return this;
  }

  public String getAsOrg() {
    return this.asOrg;
  }

  public Asn setAsOrg(String asOrg) {
    this.asOrg = asOrg;
    return this;
  }
}
