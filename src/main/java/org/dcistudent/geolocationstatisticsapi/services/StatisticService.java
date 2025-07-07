package org.dcistudent.geolocationstatisticsapi.services;

import org.dcistudent.geolocationstatisticsapi.managers.AsnManager;
import org.dcistudent.geolocationstatisticsapi.managers.LogManager;
import org.dcistudent.geolocationstatisticsapi.models.data.AsnDataModel;
import org.dcistudent.geolocationstatisticsapi.models.data.LogDataModel;
import org.dcistudent.geolocationstatisticsapi.models.response.CountryIpBlocksResponse;
import org.dcistudent.geolocationstatisticsapi.repositories.CityRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StatisticService {

  private final @NotNull CityRepository cityRepository;
  private final @NotNull AsnManager asnManager;
  private final @NotNull LogManager logManager;

  public StatisticService(@NotNull CityRepository cityRepository, @NotNull AsnManager asnManager, @NotNull LogManager logManager) {
    this.cityRepository = cityRepository;
    this.asnManager = asnManager;
    this.logManager = logManager;
  }

  public @NotNull List<CountryIpBlocksResponse> getIpBlocksPerCountry() {
    return this.cityRepository.findIpBlocksPerCountry();
  }

  public @NotNull Map<Long, AsnDataModel> getAsByNumber(@NotNull Long number) {
    return this.asnManager.findAsByNumber(number);
  }

  public @NotNull Map<Long, AsnDataModel> getAsById(@NotNull Long id) {
    return this.asnManager.findAsById(id);
  }

  public @NotNull Map<Long, AsnDataModel> getAsByName(@NotNull String name) {
    return this.asnManager.findAsByName(name);
  }

  public @NotNull List<LogDataModel> getLogsWithLimit(@NotNull Integer limit) {
    return this.logManager.findLogsByLimit(limit);
  }
}
