package org.dcistudent.geolocationstatisticsapi.mappers.manager;

import org.dcistudent.geolocationstatisticsapi.entities.Asn;
import org.dcistudent.geolocationstatisticsapi.models.data.AsnDataModel;
import org.dcistudent.geolocationstatisticsapi.models.data.IpBlockDataModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AsnDataModelMapper {

  AsnDataModel mapToDataModel(Asn asn);

  @Mapping(source = "ipStart", target = "ipStart")
  @Mapping(source = "ipEnd", target = "ipEnd")
  IpBlockDataModel mapToAsnIpBlocksDataModel(Asn asn);

  default AsnDataModel mapToDataModelWithIpBlocks(Asn asn) {
    AsnDataModel model = this.mapToDataModel(asn);
    model.getIpBlocks().add(this.mapToAsnIpBlocksDataModel(asn));
    return model;
  }
}