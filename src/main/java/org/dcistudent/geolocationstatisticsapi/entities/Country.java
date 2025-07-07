package org.dcistudent.geolocationstatisticsapi.entities;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Entity
public class Country {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "ip_start")
  @NotNull
  private Byte ipStart;

  @Column(name = "ip_end")
  @NotNull
  private Byte ipEnd;

  @Column(name = "name")
  @NotNull
  private Character name;

  public Country() {}

  public Country(@NotNull Byte ipStart, @NotNull Byte ipEnd, @NotNull Character name) {
    this
        .setIpStart(ipStart)
        .setIpEnd(ipEnd)
        .setName(name);
  }

  public @NotNull Long getId() {
    return this.id;
  }

  public Country setId(@NotNull Long id) {
    this.id = id;
    return this;
  }

  public @NotNull Byte getIpStart() {
    return this.ipStart;
  }

  public Country setIpStart(@NotNull Byte ipStart) {
    this.ipStart = ipStart;
    return this;
  }

  public @NotNull Byte getIpEnd() {
    return this.ipEnd;
  }

  public Country setIpEnd(@NotNull Byte ipEnd) {
    this.ipEnd = ipEnd;
    return this;
  }

  public @NotNull Character getCountry() {
    return this.name;
  }

  public Country setName(@NotNull Character country) {
    this.name = country;
    return this;
  }

  @Override
  public @NotNull String toString() {
    return "Country{" +
        "id=" + this.id +
        ", ipStart=" + this.ipStart +
        ", ipEnd=" + this.ipEnd +
        ", country=" + this.name +
        '}';
  }
}
