package org.dcistudent.geolocationstatisticsapi.mapper.manager;

import org.dcistudent.geolocationstatisticsapi.entity.Asn;
import org.dcistudent.geolocationstatisticsapi.model.data.AsnDataModel;
import org.dcistudent.geolocationstatisticsapi.model.data.AsnIpBlocksDataModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AsnDataModelMapper {

  AsnDataModel mapToDataModel(Asn asn);

  @Mapping(source = "ipStart", target = "ipStart")
  @Mapping(source = "ipEnd", target = "ipEnd")
  AsnIpBlocksDataModel mapToAsnIpBlocksDataModel(Asn asn); // New method

  default AsnDataModel mapToDataModelWithIpBlocks(Asn asn) {
    AsnDataModel model = this.mapToDataModel(asn);
    model.getIpBlocks().add(this.mapToAsnIpBlocksDataModel(asn)); // Use the new method
    return model;
  }
}