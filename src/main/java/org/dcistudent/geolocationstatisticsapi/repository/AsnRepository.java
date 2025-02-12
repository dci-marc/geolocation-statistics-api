package org.dcistudent.geolocationstatisticsapi.repository;

import org.dcistudent.geolocationstatisticsapi.dto.AsDto;
import org.dcistudent.geolocationstatisticsapi.entity.Asn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AsnRepository extends JpaRepository<Asn, Long> {
  @Query("SELECT NEW " +
         "org.dcistudent.geolocationstatisticsapi.dto.AsDto( " +
         "a.id, a.asNumber, a.asOrg, a.ipStart, a.ipEnd " +
         ") " +
         "FROM Asn AS a " +
         "WHERE a.asNumber = :asNumber")
  List<AsDto> findAsByNumber(@Param("asNumber") Long asNumber);

  @Query("SELECT NEW " +
      "org.dcistudent.geolocationstatisticsapi.dto.AsDto( " +
      "a.id, a.asNumber, a.asOrg, a.ipStart, a.ipEnd " +
      ") " +
      "FROM Asn AS a " +
      "WHERE a.id = :id")
  List<AsDto> findAsById(@Param("id") Long id);

  @Query("SELECT NEW " +
      "org.dcistudent.geolocationstatisticsapi.dto.AsDto( " +
      "a.id, a.asNumber, a.asOrg, a.ipStart, a.ipEnd " +
      ") " +
      "FROM Asn AS a " +
      "WHERE a.asOrg LIKE CONCAT('%', :name, '%')")
  List<AsDto> findAsByName(@Param("name") String name);
}
