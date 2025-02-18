package org.dcistudent.geolocationstatisticsapi.controllers;

import org.dcistudent.geolocationstatisticsapi.factories.model.SerializerResponseFactory;
import org.dcistudent.geolocationstatisticsapi.loggers.SqliteLogger;
import org.dcistudent.geolocationstatisticsapi.models.response.AsnResponse;
import org.dcistudent.geolocationstatisticsapi.models.response.CountryIpBlocksResponse;
import org.dcistudent.geolocationstatisticsapi.models.response.Response;
import org.dcistudent.geolocationstatisticsapi.services.StatisticService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StatisticController {

  final StatisticService statisticService;
  final SqliteLogger sqliteLogger;

  public StatisticController(StatisticService statisticService, SqliteLogger sqliteLogger) {
    this.statisticService = statisticService;
    this.sqliteLogger = sqliteLogger;
  }

  @GetMapping("/ip-blocks-per-country")
  public List<CountryIpBlocksResponse> getIpBlocksPerCountry() {
    return this.statisticService.getIpBlocksPerCountry();
  }

  @GetMapping("/as/by-number/{number}")
  public Response<Map<Long, AsnResponse>> getAsByNumber(@PathVariable Long number) {
    try {
      Map<Long, AsnResponse> response = SerializerResponseFactory
          .serializeAsnResponse(this.statisticService.getAsByNumber(number));
      this.sqliteLogger.logInfo(
          String.format(
              "%s getAsByNumber: %d, Count: %d",
              StatisticController.class.getName(),
              number,
              response.size()
          )
      );

      return new Response<>(Response.Status.OK.get(), Response.Message.OK.get(), response
      );
    } catch (Exception e) {
      this.sqliteLogger.logFatal(Arrays.toString(e.getStackTrace()));
      return new Response<>(Response.Status.INTERNAL_SERVER_ERROR.get(), Response.Message.INTERNAL_SERVER_ERROR.get());
    }
  }

  @GetMapping("/as/by-id/{id}")
  public Response<Map<Long, AsnResponse>> getAsById(@PathVariable Long id) {
    try {
      Map<Long, AsnResponse> response = SerializerResponseFactory
          .serializeAsnResponse(this.statisticService.getAsById(id));
      this.sqliteLogger.logInfo(
          String.format(
              "%s getAsById: %d, Count: %d",
              StatisticController.class.getName(),
              id,
              response.size()
          )
      );

      return new Response<>(Response.Status.OK.get(), Response.Message.OK.get(), response);
    } catch (Exception e) {
      this.sqliteLogger.logFatal(Arrays.toString(e.getStackTrace()));
      return new Response<>(Response.Status.INTERNAL_SERVER_ERROR.get(), Response.Message.INTERNAL_SERVER_ERROR.get());
    }
  }

  @GetMapping("/as/by-name/{name}")
  public Response<Map<Long, AsnResponse>> getAsByName(@PathVariable String name) {
    try {
      Map<Long, AsnResponse> response = SerializerResponseFactory
          .serializeAsnResponse(this.statisticService.getAsByName(name));
      this.sqliteLogger.logInfo(
          String.format(
              "%s getAsByName: %s, Count: %d",
              StatisticController.class.getName(),
              name,
              response.size()
          )
      );

      return new Response<>(Response.Status.OK.get(), Response.Message.OK.get(), response);
    } catch (Exception e) {
      this.sqliteLogger.logFatal(Arrays.toString(e.getStackTrace()));
      return new Response<>(Response.Status.INTERNAL_SERVER_ERROR.get(), Response.Message.INTERNAL_SERVER_ERROR.get());
    }
  }
}
