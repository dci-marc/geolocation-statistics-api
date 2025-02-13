package org.dcistudent.geolocationstatisticsapi.service;

import org.dcistudent.geolocationstatisticsapi.manager.AsnManager;
import org.dcistudent.geolocationstatisticsapi.model.data.AsnDataModel;
import org.dcistudent.geolocationstatisticsapi.model.response.AsResponse;
import org.dcistudent.geolocationstatisticsapi.model.response.CountryIpBlocksResponse;
import org.dcistudent.geolocationstatisticsapi.repository.CityRepository;
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
