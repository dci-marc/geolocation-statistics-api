package org.dcistudent.geolocationstatisticsapi.repository;

import org.dcistudent.geolocationstatisticsapi.dto.AsByAsNumberDto;
import org.dcistudent.geolocationstatisticsapi.entity.Asn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AsnRepository extends JpaRepository<Asn, Long> {
  @Query("SELECT NEW " +
         "org.dcistudent.geolocationstatisticsapi.dto.AsByAsNumberDto( " +
         "a.asNumber, a.asOrg, a.ipStart, a.ipEnd " +
         ") " +
         "FROM Asn AS a " +
         "WHERE a.asNumber = :asNumber")
  List<AsByAsNumberDto> findAsByAsNumber(@Param("asNumber") Long asNumber);
}
