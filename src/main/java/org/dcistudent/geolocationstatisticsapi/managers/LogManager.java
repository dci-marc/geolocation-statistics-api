package org.dcistudent.geolocationstatisticsapi.services;

import org.dcistudent.geolocationstatisticsapi.repositories.LogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
public class LogService {

  LogRepository logRepository;

  public LogService(LogRepository logRepository) {
    this.logRepository = logRepository;
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
}
