package org.dcistudent.geolocationstatisticsapi.entities;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Entity
public class Asn {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "ip_start")
  @NotNull
  private String ipStart;

  @Column(name = "ip_end")
  @NotNull
  private String ipEnd;

  @Column(name = "as_number")
  @NotNull
  private Long asNumber;

  @Column(name = "as_org")
  @NotNull
  private String asOrg;

  public Asn() {}

  public Asn(@NotNull String ipStart, @NotNull String ipEnd, @NotNull Long asNumber, @NotNull String asOrg) {
    this
        .setIpStart(ipStart)
        .setIpEnd(ipEnd)
        .setAsNumber(asNumber)
        .setAsOrg(asOrg);
  }

  public @NotNull Long getId() {
    return this.id;
  }

  public Asn setId(@NotNull Long id) {
    this.id = id;
    return this;
  }

  public @NotNull String getIpStart() {
    return this.ipStart;
  }

  public Asn setIpStart(@NotNull String ipStart) {
    this.ipStart = ipStart;
    return this;
  }

  public @NotNull String getIpEnd() {
    return this.ipEnd;
  }

  public Asn setIpEnd(@NotNull String ipEnd) {
    this.ipEnd = ipEnd;
    return this;
  }

  public @NotNull Long getAsNumber() {
    return this.asNumber;
  }

  public Asn setAsNumber(@NotNull Long asNumber) {
    this.asNumber = asNumber;
    return this;
  }

  public @NotNull String getAsOrg() {
    return this.asOrg;
  }

  public Asn setAsOrg(@NotNull String asOrg) {
    this.asOrg = asOrg;
    return this;
  }
}
