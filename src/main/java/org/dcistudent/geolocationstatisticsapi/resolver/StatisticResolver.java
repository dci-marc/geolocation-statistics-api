package org.dcistudent.geolocationstatisticsapi.resolver;

import org.dcistudent.geolocationstatisticsapi.model.response.CountryIpBlocksResponse;
import org.dcistudent.geolocationstatisticsapi.model.response.Response;
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
  public List<CountryIpBlocksResponse> getIpBlocksPerCountry() {
    return this.statisticService.getIpBlocksPerCountry();
  }

  @QueryMapping
  public Response getAsByNumber(@Argument Long number) {
    try {
      return new Response(Response.Status.OK.get(), Response.Message.OK.get(), this.statisticService.getAsByNumber(number));
    } catch (Exception e) {
      return new Response(Response.Status.INTERNAL_SERVER_ERROR.get(), Response.Message.INTERNAL_SERVER_ERROR.get());
    }
  }

  @QueryMapping
  public Response getAsById(@Argument Long id) {
    try {
      return new Response(Response.Status.OK.get(), Response.Message.OK.get(), this.statisticService.getAsById(id));
    } catch (Exception e) {
      return new Response(Response.Status.INTERNAL_SERVER_ERROR.get(), Response.Message.INTERNAL_SERVER_ERROR.get());
    }
  }

  @QueryMapping
  public Response getAsByName(@Argument String name) {
    try {
      return new Response(Response.Status.OK.get(), Response.Message.OK.get(), this.statisticService.getAsByName(name));
    } catch (Exception e) {
      return new Response(Response.Status.INTERNAL_SERVER_ERROR.get(), Response.Message.INTERNAL_SERVER_ERROR.get());
    }
  }
}
