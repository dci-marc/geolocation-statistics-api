package org.dcistudent.geolocationstatisticsapi.controller;

import org.dcistudent.geolocationstatisticsapi.dto.AsByAsNumberDto;
import org.dcistudent.geolocationstatisticsapi.dto.IpBlocksPerCountryDto;
import org.dcistudent.geolocationstatisticsapi.service.StatisticService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StatisticController {

  final StatisticService statisticService;

  public StatisticController(StatisticService statisticService) {
    this.statisticService = statisticService;
  }

  @GetMapping("/ip-blocks-per-country")
  public List<IpBlocksPerCountryDto> getIpBlocksPerCountry() {
    return this.statisticService.getIpBlocksPerCountry();
  }

  @GetMapping("/as/{asNumber}")
  public List<AsByAsNumberDto> getAsByAsNumber(@PathVariable Long asNumber) {
    return this.statisticService.getAsByAsNumber(asNumber);
  }
}
