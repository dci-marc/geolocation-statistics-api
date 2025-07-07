package org.dcistudent.geolocationstatisticsapi.resolvers;

import org.dcistudent.geolocationstatisticsapi.models.response.CountryIpBlocksResponse;
import org.dcistudent.geolocationstatisticsapi.models.response.Response;
import org.dcistudent.geolocationstatisticsapi.services.StatisticService;
import org.jetbrains.annotations.NotNull;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StatisticResolver {

  final @NotNull StatisticService statisticService;

  public StatisticResolver(@NotNull StatisticService statisticService) {
    this.statisticService = statisticService;
  }

  @QueryMapping
  public @NotNull List<CountryIpBlocksResponse> getIpBlocksPerCountry() {
    return this.statisticService.getIpBlocksPerCountry();
  }

  @QueryMapping
  public @NotNull Response getAsByNumber(@NotNull @Argument Long number) {
    try {
      return new Response(Response.Status.OK.get(), Response.Message.OK.get(), this.statisticService.getAsByNumber(number));
    } catch (Exception e) {
      return new Response(Response.Status.INTERNAL_SERVER_ERROR.get(), Response.Message.INTERNAL_SERVER_ERROR.get());
    }
  }

  @QueryMapping
  public @NotNull Response getAsById(@NotNull @Argument Long id) {
    try {
      return new Response(Response.Status.OK.get(), Response.Message.OK.get(), this.statisticService.getAsById(id));
    } catch (Exception e) {
      return new Response(Response.Status.INTERNAL_SERVER_ERROR.get(), Response.Message.INTERNAL_SERVER_ERROR.get());
    }
  }

  @QueryMapping
  public @NotNull Response getAsByName(@NotNull @Argument String name) {
    try {
      return new Response(Response.Status.OK.get(), Response.Message.OK.get(), this.statisticService.getAsByName(name));
    } catch (Exception e) {
      return new Response(Response.Status.INTERNAL_SERVER_ERROR.get(), Response.Message.INTERNAL_SERVER_ERROR.get());
    }
  }
}
