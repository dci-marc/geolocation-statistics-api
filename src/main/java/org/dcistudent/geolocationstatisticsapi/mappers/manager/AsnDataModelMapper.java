package org.dcistudent.geolocationstatisticsapi.mappers.manager;

import org.dcistudent.geolocationstatisticsapi.entities.Asn;
import org.dcistudent.geolocationstatisticsapi.models.data.AsnDataModel;
import org.dcistudent.geolocationstatisticsapi.models.data.IpBlockDataModel;
import org.jetbrains.annotations.NotNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AsnDataModelMapper {

  @NotNull AsnDataModel mapToDataModel(Asn asn);

  @Mapping(source = "ipStart", target = "ipStart")
  @Mapping(source = "ipEnd", target = "ipEnd")
  IpBlockDataModel mapToAsnIpBlocksDataModel(@NotNull Asn asn);

  default @NotNull AsnDataModel mapToDataModelWithIpBlocks(@NotNull Asn asn) {
    AsnDataModel model = this.mapToDataModel(asn);
    model.getIpBlocks().add(this.mapToAsnIpBlocksDataModel(asn));
    return model;
  }
}