package org.dcistudent.geolocationstatisticsapi.managers;

import org.dcistudent.geolocationstatisticsapi.entities.Log;
import org.dcistudent.geolocationstatisticsapi.mappers.manager.LogDataModelMapper;
import org.dcistudent.geolocationstatisticsapi.models.data.LogDataModel;
import org.dcistudent.geolocationstatisticsapi.repositories.LogRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class LogManager {

  @NotNull LogRepository logRepository;
  @NotNull LogDataModelMapper logDataModelMapper;

  public LogManager(@NotNull LogRepository logRepository, @NotNull LogDataModelMapper logDataModelMapper) {
    this.logRepository = logRepository;
    this.logDataModelMapper = logDataModelMapper;
  }

  public @NotNull List<LogDataModel> findLogsByLimit(@NotNull Integer limit) {
    return this.convertToDataModel(this.logRepository.findWithLimit(limit));
  }

  @Transactional
  public void log(int level, @NotNull String message) {
    logRepository.insert(
        UUID.randomUUID().toString(),
        level,
        ZonedDateTime.now().toString(),
        message
    );
  }

  private @NotNull List<LogDataModel> convertToDataModel(@NotNull List<Log> list) {
    return list.stream().map(log -> logDataModelMapper.mapToDataModel(
        log.getId(),
        log.getLevel(),
        log.getDatetime(),
        log.getMessage()
    )).toList();
  }
}
