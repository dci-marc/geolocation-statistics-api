package org.dcistudent.geolocationstatisticsapi.entities;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Entity
public class City {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "ip_start")
  @NotNull
  private Byte ipStart;

  @Column(name = "ip_end")
  @NotNull
  private Byte ipEnd;

  @Column(name = "continent")
  @NotNull
  private String continent;

  @Column(name = "country")
  @NotNull
  private String country;

  @Column(name = "state_province")
  @NotNull
  private String stateProvince;

  @Column(name = "name")
  @NotNull
  private String name;

  @Column(name = "latitude")
  @NotNull
  private Float latitude;

  @Column(name = "longitude")
  @NotNull
  private Float longitude;

  public City() {}

  public City(
      @NotNull Byte ipStart,
      @NotNull Byte ipEnd,
      @NotNull String continent,
      @NotNull String country,
      @NotNull String stateProvince,
      @NotNull String name,
      @NotNull Float latitude,
      @NotNull Float longitude
  ) {
    this
        .setIpStart(ipStart)
        .setIpEnd(ipEnd)
        .setContinent(continent)
        .setCountry(country)
        .setStateProvince(stateProvince)
        .setName(name)
        .setLatitude(latitude)
        .setLongitude(longitude);
  }

  public @NotNull Long id() {
    return this.id;
  }

  public City setId(@NotNull Long id) {
    this.id = id;
    return this;
  }

  public @NotNull Byte getIpStart() {
    return ipStart;
  }

  public City setIpStart(@NotNull Byte ipStart) {
    this.ipStart = ipStart;
    return this;
  }

  public @NotNull Byte getIpEnd() {
    return this.ipEnd;
  }

  public City setIpEnd(@NotNull Byte ipEnd) {
    this.ipEnd = ipEnd;
    return this;
  }

  public @NotNull String getContinent() {
    return this.continent;
  }

  public City setContinent(String continent) {
    this.continent = continent;
    return this;
  }

  public @NotNull String getCountry() {
    return country;
  }

  public City setCountry(@NotNull String country) {
    this.country = country;
    return this;
  }

  public @NotNull String getStateProvince() {
    return this.stateProvince;
  }

  public City setStateProvince(@NotNull String stateProvince) {
    this.stateProvince = stateProvince;
    return this;
  }

  public @NotNull String getName() {
    return this.name;
  }

  public City setName(@NotNull String name) {
    this.name = name;
    return this;
  }

  public @NotNull Float getLatitude() {
    return this.latitude;
  }

  public City setLatitude(@NotNull Float latitude) {
    this.latitude = latitude;
    return this;
  }

  public @NotNull Float getLongitude() {
    return this.longitude;
  }

  public City setLongitude(@NotNull Float longitude) {
    this.longitude = longitude;
    return this;
  }

  @Override
  public @NotNull String toString() {
    return "City{" +
        "id=" + this.id +
        ", ipStart=" + this.ipStart +
        ", ipEnd=" + this.ipEnd +
        ", continent=" + this.continent +
        ", country=" + this.country +
        ", stateProvince=" + this.stateProvince +
        ", name=" + this.name +
        ", latitude=" + this.latitude +
        ", longitude=" + this.longitude +
        '}';
  }
}
