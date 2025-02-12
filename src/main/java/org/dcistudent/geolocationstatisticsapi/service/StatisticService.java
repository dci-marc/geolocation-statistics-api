package org.dcistudent.geolocationstatisticsapi.service;

import org.dcistudent.geolocationstatisticsapi.dto.AsDto;
import org.dcistudent.geolocationstatisticsapi.dto.IpBlocksPerCountryDto;
import org.dcistudent.geolocationstatisticsapi.repository.AsnRepository;
import org.dcistudent.geolocationstatisticsapi.repository.CityRepository;
import org.springframework.stereotype.Service;

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

  public List<AsDto> getAsByNumber(Long number) {
    return asnRepository.findAsByNumber(number);
  }

  public List<AsDto> getAsById(Long id) {
    return asnRepository.findAsById(id);
  }

  public List<AsDto> getAsByName(String name) {
    return asnRepository.findAsByName(name);
  }

}
