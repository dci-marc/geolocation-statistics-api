package org.dcistudent.geolocationstatisticsapi.repository;

import org.dcistudent.geolocationstatisticsapi.entity.Asn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AsnRepository extends JpaRepository<Asn, Long> {
  @Query("SELECT a " +
         "FROM Asn AS a " +
         "WHERE a.asNumber = :asNumber")
  List<Asn> findAsByNumber(@Param("asNumber") Long asNumber);

  @Query("SELECT a " +
      "FROM Asn AS a " +
      "WHERE a.id = :id")
  List<Asn> findAsById(@Param("id") Long id);

  @Query("SELECT a " +
      "FROM Asn AS a " +
      "WHERE a.asOrg LIKE CONCAT('%', :name, '%')")
  List<Asn> findAsByName(@Param("name") String name);
}
