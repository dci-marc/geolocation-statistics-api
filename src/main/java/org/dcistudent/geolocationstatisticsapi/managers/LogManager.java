package org.dcistudent.geolocationstatisticsapi.managers;

import org.dcistudent.geolocationstatisticsapi.entities.Log;
import org.dcistudent.geolocationstatisticsapi.mappers.manager.LogDataModelMapper;
import org.dcistudent.geolocationstatisticsapi.models.data.LogDataModel;
import org.dcistudent.geolocationstatisticsapi.repositories.LogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LogManager {

  LogRepository logRepository;
  LogDataModelMapper logDataModelMapper;

  public LogManager(LogRepository logRepository, LogDataModelMapper logDataModelMapper) {
    this.logRepository = logRepository;
    this.logDataModelMapper = logDataModelMapper;
  }

  public List<LogDataModel> findLogsByLimit(Integer limit) {
    return this.convertToDataModel(this.logRepository.findWithLimit(limit));
  }

  @Transactional
  public void log(int level, String message) { // No need for the enum here
    logRepository.insert(
        UUID.randomUUID().toString(),
        level,
        ZonedDateTime.now().toString(),
        message
    );
  }

  private List<LogDataModel> convertToDataModel(List<Log> list) {
    return list.stream().map(log -> logDataModelMapper.mapToDataModel(
        log.getId(),
        log.getLevel(),
        log.getDatetime(),
        log.getMessage()
    )).collect(Collectors.toList());
  }
}
