package org.dcistudent.geolocationstatisticsapi.repository;

import org.dcistudent.geolocationstatisticsapi.dto.IpBlocksPerCountryDto;
import org.dcistudent.geolocationstatisticsapi.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
  @Query("SELECT NEW " +
         "org.dcistudent.geolocationstatisticsapi.dto.IpBlocksPerCountryDto(" +
         "c.country, COUNT(c) " +
         ") " +
         "FROM City AS c " +
         "GROUP BY c.country")
  List<IpBlocksPerCountryDto> findIpBlocksPerCountry();
}
