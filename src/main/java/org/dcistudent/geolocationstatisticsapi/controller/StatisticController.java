package org.dcistudent.geolocationstatisticsapi.controller;

import org.dcistudent.geolocationstatisticsapi.model.data.AsnDataModel;
import org.dcistudent.geolocationstatisticsapi.model.response.CountryIpBlocksResponse;
import org.dcistudent.geolocationstatisticsapi.model.response.Response;
import org.dcistudent.geolocationstatisticsapi.service.StatisticService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StatisticController {

  final StatisticService statisticService;

  public StatisticController(StatisticService statisticService) {
    this.statisticService = statisticService;
  }

  @GetMapping("/ip-blocks-per-country")
  public List<CountryIpBlocksResponse> getIpBlocksPerCountry() {
    return this.statisticService.getIpBlocksPerCountry();
  }

  @GetMapping("/as/by-number/{number}")
  public Response<Map<Long, AsnDataModel>> getAsByNumber(@PathVariable Long number) {
    try {
      return new Response<>(Response.Status.OK.get(), Response.Message.OK.get(), this.statisticService.getAsByNumber(number));
    } catch (Exception e) {
      return new Response<>(Response.Status.INTERNAL_SERVER_ERROR.get(), Response.Message.INTERNAL_SERVER_ERROR.get());
    }
  }

  @GetMapping("/as/by-id/{id}")
  public Response<Map<Long, AsnDataModel>> getAsById(@PathVariable Long id) {
    try {
      return new Response<>(Response.Status.OK.get(), Response.Message.OK.get(), this.statisticService.getAsById(id));
    } catch (Exception e) {
      return new Response<>(Response.Status.INTERNAL_SERVER_ERROR.get(), Response.Message.INTERNAL_SERVER_ERROR.get());
    }
  }

  @GetMapping("/as/by-name/{name}")
  public Response<Map<Long, AsnDataModel>> getAsByName(@PathVariable String name) {
    try {
      return new Response<>(Response.Status.OK.get(), Response.Message.OK.get(), this.statisticService.getAsByName(name));
    } catch (Exception e) {
      return new Response<>(Response.Status.INTERNAL_SERVER_ERROR.get(), Response.Message.INTERNAL_SERVER_ERROR.get());
    }
  }
}
