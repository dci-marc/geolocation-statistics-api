package org.dcistudent.geolocationstatisticsapi.factories.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dcistudent.geolocationstatisticsapi.models.data.AsnDataModel;
import org.dcistudent.geolocationstatisticsapi.models.response.AsnResponse;

import java.util.HashMap;
import java.util.Map;

public final class SerializerResponseFactory {

  private static final ObjectMapper objectMapper = new ObjectMapper();
  private SerializerResponseFactory() {}

  public static AsnResponse serializeAsnResponse(AsnDataModel model) {
    return SerializerResponseFactory.objectMapper.convertValue(model, AsnResponse.class);
  }

  public static Map<Long, AsnResponse> serializeAsnResponse(Map<Long, AsnDataModel> mapData) {
    Map<Long, AsnResponse> mapResponse = new HashMap<>();

    mapData.forEach(
        (key, value) -> mapResponse.put(key, SerializerResponseFactory.serializeAsnResponse(value))
    );

    return mapResponse;
  }
}
