package org.dcistudent.geolocationstatisticsapi.mappers.manager;

import org.dcistudent.geolocationstatisticsapi.models.data.LogDataModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LogDataModelMapperTest {

  @Autowired
  private LogDataModelMapper logDataModelMapper;

  public LogDataModelMapperTest() {
    this.logDataModelMapper = new LogDataModelMapperImpl();
  }

  @Test
  void testMapToDataModel() {
    String id = UUID.randomUUID().toString();
    ZonedDateTime datetime = ZonedDateTime.now();

    LogDataModel dataModel = this.logDataModelMapper.mapToDataModel(
        id, 1, datetime.toString(), "Test message"
    );

    assertThat(dataModel).isNotNull();
    assertThat(dataModel.getId()).isEqualTo(id);
    assertThat(dataModel.getLevel()).isEqualTo(1);
    assertThat(dataModel.getDatetime()).isEqualTo(datetime);
    assertThat(dataModel.getMessage()).isEqualTo("Test message");
  }
}
