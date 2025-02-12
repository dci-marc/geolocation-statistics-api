package org.dcistudent.geolocationstatisticsapi.service;

import org.dcistudent.geolocationstatisticsapi.dto.AsByAsNumberDto;
import org.dcistudent.geolocationstatisticsapi.dto.IpBlocksPerCountryDto;
import org.dcistudent.geolocationstatisticsapi.repository.AsnRepository;
import org.dcistudent.geolocationstatisticsapi.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;
import java.util.List;

@Service
public class StatisticService {

  private final CityRepository cityRepository;
  private final AsnRepository asnRepository;

  public StatisticService(CityRepository cityRepository, AsnRepository asnRepository) {
    this.cityRepository = cityRepository;
    this.asnRepository = asnRepository;
  }

  public List<IpBlocksPerCountryDto> getIpBlocksPerCountry() {
    return cityRepository.findIpBlocksPerCountry();
  }

  public List<AsByAsNumberDto> getAsByAsNumber(Long asNumber) {
    return asnRepository.findAsByAsNumber(asNumber);
  }
}
