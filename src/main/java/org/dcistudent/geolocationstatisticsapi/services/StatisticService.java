package org.dcistudent.geolocationstatisticsapi.services;

import org.dcistudent.geolocationstatisticsapi.managers.AsnManager;
import org.dcistudent.geolocationstatisticsapi.models.data.AsnDataModel;
import org.dcistudent.geolocationstatisticsapi.models.response.CountryIpBlocksResponse;
import org.dcistudent.geolocationstatisticsapi.repositories.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StatisticService {

  private final CityRepository cityRepository;
  private final AsnManager asnManager;

  public StatisticService(CityRepository cityRepository, AsnManager asnManager) {
    this.cityRepository = cityRepository;
    this.asnManager = asnManager;
  }

  public List<CountryIpBlocksResponse> getIpBlocksPerCountry() {
    return this.cityRepository.findIpBlocksPerCountry();
  }

  public Map<Long, AsnDataModel> getAsByNumber(Long number) {
    return this.asnManager.findAsByNumber(number);
  }

  public Map<Long, AsnDataModel> getAsById(Long id) {
    return this.asnManager.findAsById(id);
  }

  public Map<Long, AsnDataModel> getAsByName(String name) {
    return this.asnManager.findAsByName(name);
  }
}
