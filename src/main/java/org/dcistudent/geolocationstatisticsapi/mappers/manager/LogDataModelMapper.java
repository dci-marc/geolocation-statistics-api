package org.dcistudent.geolocationstatisticsapi.mappers.manager;

import org.dcistudent.geolocationstatisticsapi.models.data.LogDataModel;
import org.jetbrains.annotations.NotNull;
import org.mapstruct.Mapper;

import java.time.ZonedDateTime;

@Mapper(componentModel = "spring")
public interface LogDataModelMapper {

  default @NotNull LogDataModel mapToDataModel(
      @NotNull String id,
      @NotNull Integer level,
      @NotNull String datetime,
      @NotNull String message
  ) {
    return new LogDataModel(id, level, ZonedDateTime.parse(datetime), message);
  }
}
