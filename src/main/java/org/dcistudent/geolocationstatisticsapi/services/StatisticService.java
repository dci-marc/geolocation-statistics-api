package org.dcistudent.geolocationstatisticsapi.services;

import org.dcistudent.geolocationstatisticsapi.managers.AsnManager;
import org.dcistudent.geolocationstatisticsapi.managers.LogManager;
import org.dcistudent.geolocationstatisticsapi.models.data.AsnDataModel;
import org.dcistudent.geolocationstatisticsapi.models.data.LogDataModel;
import org.dcistudent.geolocationstatisticsapi.models.response.CountryIpBlocksResponse;
import org.dcistudent.geolocationstatisticsapi.repositories.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StatisticService {

  private final CityRepository cityRepository;
  private final AsnManager asnManager;
  private final LogManager logManager;

  public StatisticService(CityRepository cityRepository, AsnManager asnManager, LogManager logManager) {
    this.cityRepository = cityRepository;
    this.asnManager = asnManager;
    this.logManager = logManager;
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

  public List<LogDataModel> getLogsWithLimit(Integer limit) {
    return this.logManager.findLogsByLimit(limit);
  }
}
