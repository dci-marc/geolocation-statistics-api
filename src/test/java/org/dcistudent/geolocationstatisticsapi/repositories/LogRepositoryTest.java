package org.dcistudent.geolocationstatisticsapi.repositories;

import org.dcistudent.geolocationstatisticsapi.entities.Log;
import org.dcistudent.geolocationstatisticsapi.loggers.SqliteLogger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class LogRepositoryTest {

  @MockitoBean
  private LogRepository logRepository;

  @Test
  void testFindWithLimit() {
    Log log = new Log();
    log.setId(UUID.randomUUID().toString());
    log.setLevel(SqliteLogger.Level.INFO.get());
    log.setDatetime(ZonedDateTime.now().toString());
    log.setMessage("Example message");

    when(logRepository.findWithLimit(1)).thenReturn(List.of(log));

    List<Log> result = logRepository.findWithLimit(1);

    assertThat(result).hasSize(1);
    assertThat(result.get(0).getMessage()).isEqualTo("Example message");
    verify(logRepository, times(1)).findWithLimit(1);
  }
}
