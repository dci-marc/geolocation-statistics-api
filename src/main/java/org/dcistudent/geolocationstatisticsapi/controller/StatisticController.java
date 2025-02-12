package org.dcistudent.geolocationstatisticsapi.controller;

import org.dcistudent.geolocationstatisticsapi.dto.AsDto;
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

  @GetMapping("/as/by-number/{number}")
  public List<AsDto> getAsByNumber(@PathVariable Long number) {
    return this.statisticService.getAsByNumber(number);
  }

  @GetMapping("/as/by-id/{id}")
  public List<AsDto> getAsById(@PathVariable Long id) {
    return this.statisticService.getAsById(id);
  }

  @GetMapping("/as/by-name/{name}")
  public List<AsDto> getAsByName(@PathVariable String name) {
    return this.statisticService.getAsByName(name);
  }
}
