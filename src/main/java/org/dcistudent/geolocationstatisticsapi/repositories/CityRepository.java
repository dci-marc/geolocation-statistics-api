package org.dcistudent.geolocationstatisticsapi.repositories;

import org.dcistudent.geolocationstatisticsapi.entities.City;
import org.dcistudent.geolocationstatisticsapi.models.response.CountryIpBlocksResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
  @Query("SELECT NEW " +
      "org.dcistudent.geolocationstatisticsapi.models.response.CountryIpBlocksResponse(" +
      "c.country, COUNT(c) " +
      ") " +
      "FROM City AS c " +
      "GROUP BY c.country")
  List<CountryIpBlocksResponse> findIpBlocksPerCountry();
}
