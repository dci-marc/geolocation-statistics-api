package org.dcistudent.geolocationstatisticsapi.mappers.manager;

import org.dcistudent.geolocationstatisticsapi.models.data.LogDataModel;
import org.mapstruct.Mapper;

import java.time.ZonedDateTime;

@Mapper(componentModel = "spring")
public interface LogDataModelMapper {

  default LogDataModel mapToDataModel(String id, Integer level, String datetime, String message) {
    return new LogDataModel(id, level, ZonedDateTime.parse(datetime), message);
  }
}
