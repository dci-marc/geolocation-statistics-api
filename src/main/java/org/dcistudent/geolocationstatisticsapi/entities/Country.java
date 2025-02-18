package org.dcistudent.geolocationstatisticsapi.entities;

import jakarta.persistence.*;

@Entity
public class Country {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "ip_start")
  private Byte ipStart;
  @Column(name = "ip_end")
  private Byte ipEnd;
  @Column(name = "name")
  private Character name;

  public Country() {}

  public Country(Byte ipStart, Byte ipEnd, Character name) {
    this.ipStart = ipStart;
    this.ipEnd = ipEnd;
    this.name = name;
  }

  public Long id() {
    return id;
  }

  public Country setId(Long id) {
    this.id = id;
    return this;
  }

  public Byte ipStart() {
    return ipStart;
  }

  public Country setIpStart(Byte ipStart) {
    this.ipStart = ipStart;
    return this;
  }

  public Byte ipEnd() {
    return ipEnd;
  }

  public Country setIpEnd(Byte ipEnd) {
    this.ipEnd = ipEnd;
    return this;
  }

  public Character country() {
    return name;
  }

  public Country setName(Character country) {
    this.name = country;
    return this;
  }

  @Override
  public String toString() {
    return "Country{" +
        "id=" + this.id +
        ", ipStart=" + this.ipStart +
        ", ipEnd=" + this.ipEnd +
        ", country=" + this.name +
        '}';
  }
}
