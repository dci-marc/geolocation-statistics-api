package org.dcistudent.geolocationstatisticsapi.entity;

import jakarta.persistence.*;

@Entity
public class City {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "ip_start")
  private Byte ipStart;
  @Column(name = "ip_end")
  private Byte ipEnd;
  @Column(name = "continent")
  private String continent;
  @Column(name = "country")
  private String country;
  @Column(name = "state_province")
  private String stateProvince;
  @Column(name = "name")
  private String name;
  @Column(name = "latitude")
  private Float latitude;
  @Column(name = "longitude")
  private Float longitude;

  public City() {}

  public City(
      Byte ipStart,
      Byte ipEnd,
      String continent,
      String country,
      String stateProvince,
      String name,
      Float latitude,
      Float longitude
  ) {
    this.ipStart = ipStart;
    this.ipEnd = ipEnd;
    this.continent = continent;
    this.country = country;
    this.stateProvince = stateProvince;
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public Long id() {
    return id;
  }

  public City setId(Long id) {
    this.id = id;
    return this;
  }

  public Byte ipStart() {
    return ipStart;
  }

  public City setIpStart(Byte ipStart) {
    this.ipStart = ipStart;
    return this;
  }

  public Byte ipEnd() {
    return ipEnd;
  }

  public City setIpEnd(Byte ipEnd) {
    this.ipEnd = ipEnd;
    return this;
  }

  public String continent() {
    return continent;
  }

  public City setContinent(String continent) {
    this.continent = continent;
    return this;
  }

  public String country() {
    return country;
  }

  public City setCountry(String country) {
    this.country = country;
    return this;
  }

  public String stateProvince() {
    return stateProvince;
  }

  public City setStateProvince(String stateProvince) {
    this.stateProvince = stateProvince;
    return this;
  }

  public String name() {
    return name;
  }

  public City setName(String name) {
    this.name = name;
    return this;
  }

  public Float latitude() {
    return latitude;
  }

  public City setLatitude(Float latitude) {
    this.latitude = latitude;
    return this;
  }

  public Float longitude() {
    return longitude;
  }

  public City setLongitude(Float longitude) {
    this.longitude = longitude;
    return this;
  }

  @Override
  public String toString() {
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
