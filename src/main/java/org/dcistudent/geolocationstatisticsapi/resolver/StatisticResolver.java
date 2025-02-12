package org.dcistudent.geolocationstatisticsapi.resolver;

import org.dcistudent.geolocationstatisticsapi.dto.AsDto;
import org.dcistudent.geolocationstatisticsapi.dto.IpBlocksPerCountryDto;
import org.dcistudent.geolocationstatisticsapi.service.StatisticService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StatisticResolver {

  final StatisticService statisticService;

  public StatisticResolver(StatisticService statisticService) {
    this.statisticService = statisticService;
  }

  @QueryMapping
  public List<IpBlocksPerCountryDto> getIpBlocksPerCountry() {
    return this.statisticService.getIpBlocksPerCountry();
  }

  @QueryMapping
  public List<AsDto> getAsByNumber(@Argument Long number) {
    return this.statisticService.getAsByNumber(number);
  }

  @QueryMapping
  public List<AsDto> getAsById(@Argument Long id) {
    return this.statisticService.getAsById(id);
  }

  @QueryMapping
  public List<AsDto> getAsByName(@Argument String name) {
    return this.statisticService.getAsByName(name);
  }
}
