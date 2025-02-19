package org.dcistudent.geolocationstatisticsapi.factories.model;

import org.dcistudent.geolocationstatisticsapi.loggers.SqliteLogger;
import org.dcistudent.geolocationstatisticsapi.models.data.AsnDataModel;
import org.dcistudent.geolocationstatisticsapi.models.data.IpBlockDataModel;
import org.dcistudent.geolocationstatisticsapi.models.data.LogDataModel;
import org.dcistudent.geolocationstatisticsapi.models.response.AsnResponse;
import org.dcistudent.geolocationstatisticsapi.models.response.LogResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SerializerResponseFactoryTest {

  private static AsnResponse createAsnResponseTestData() {
    AsnResponse response = new AsnResponse();
    response.setAsNumber(1L);
    response.setAsOrg("Test ASN");
    return response;
  }

  private static AsnDataModel createAsnDataModelTestData() {
    AsnDataModel model = new AsnDataModel(1L, "Test ASN");
    model.setIpBlocks(List.of(new IpBlockDataModel("1.1.1.0", "1.1.1.255")));
    return model;
  }

  private static LogResponse createLogResponseTestData(ZonedDateTime dateTime) {
    LogResponse response = new LogResponse();
    response.setLevel(SqliteLogger.Level.INFO.get());
    response.setDatetime(dateTime.toString());
    response.setMessage("Test message");
    return response;
  }

  private static LogDataModel createLogDataModelTestData(ZonedDateTime dateTime) {
    LogDataModel model = new LogDataModel();
    model.setId("1");
    model.setLevel(SqliteLogger.Level.INFO.get());
    model.setDatetime(dateTime);
    model.setMessage("Test message");
    return model;
  }

  @Test
  void testSerializeAsnResponse() {
    AsnDataModel model = SerializerResponseFactoryTest.createAsnDataModelTestData();
    AsnResponse response = SerializerResponseFactoryTest.createAsnResponseTestData();

    AsnResponse result = SerializerResponseFactory.serializeAsnResponse(model);

    assertThat(result).isNotNull();
    assertThat(result.getAsNumber()).isEqualTo(response.getAsNumber());
    assertThat(result.getAsOrg()).isEqualTo(response.getAsOrg());
    assertThat(result.getIpBlocks()).hasSize(1);
    assertThat(result.getIpBlocks().get(0).getIpStart()).isEqualTo(response.getIpBlocks().get(0).getIpStart());
    assertThat(result.getIpBlocks().get(0).getIpEnd()).isEqualTo(response.getIpBlocks().get(0).getIpEnd());
  }

  @Test
  void testSerializeAsnResponseMap() {
    Map<Long, AsnDataModel> map = Map.of(1L, SerializerResponseFactoryTest.createAsnDataModelTestData());
    AsnResponse response = SerializerResponseFactoryTest.createAsnResponseTestData();

    Map<Long, AsnResponse> result = SerializerResponseFactory.serializeAsnResponse(map);

    assertThat(result).isNotNull().hasSize(1);
    assertThat(result.get(1L).getAsNumber()).isEqualTo(response.getAsNumber());
    assertThat(result.get(1L).getAsOrg()).isEqualTo(response.getAsOrg());
    assertThat(result.get(1L).getIpBlocks()).hasSize(1);
    assertThat(result.get(1L).getIpBlocks().get(0).getIpStart()).isEqualTo(response.getIpBlocks().get(0).getIpStart());
    assertThat(result.get(1L).getIpBlocks().get(0).getIpEnd()).isEqualTo(response.getIpBlocks().get(0).getIpEnd());
  }

  @Test
  void testSerializeLogResponse() {
    ZonedDateTime dateTime = ZonedDateTime.now();
    LogDataModel model = SerializerResponseFactoryTest.createLogDataModelTestData(dateTime);
    LogResponse response = SerializerResponseFactoryTest.createLogResponseTestData(dateTime);

    LogResponse result = SerializerResponseFactory.serializeLogResponse(model);

    assertThat(result).isNotNull();
    assertThat(result.getLevel()).isEqualTo(response.getLevel());
    assertThat(result.getDatetime()).isEqualTo(response.getDatetime());
    assertThat(result.getMessage()).isEqualTo(response.getMessage());
  }

  @Test
  void testSerializeLogResponseList() {
    ZonedDateTime dateTime = ZonedDateTime.now();
    List<LogDataModel> list = List.of(SerializerResponseFactoryTest.createLogDataModelTestData(dateTime));
    LogResponse response = SerializerResponseFactoryTest.createLogResponseTestData(dateTime);

    List<LogResponse> result = SerializerResponseFactory.serializeLogResponse(list);

    assertThat(result).isNotNull().hasSize(1);
    assertThat(result.get(0).getLevel()).isEqualTo(response.getLevel());
    assertThat(result.get(0).getDatetime()).isEqualTo(response.getDatetime());
    assertThat(result.get(0).getMessage()).isEqualTo(response.getMessage());
  }
}