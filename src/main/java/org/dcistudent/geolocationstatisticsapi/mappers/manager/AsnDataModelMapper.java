package org.dcistudent.geolocationstatisticsapi.mappers.manager;

import org.dcistudent.geolocationstatisticsapi.entities.Asn;
import org.dcistudent.geolocationstatisticsapi.models.data.asn.DataModel;
import org.dcistudent.geolocationstatisticsapi.models.data.asn.IpBlockDataModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AsnDataModelMapper {

  DataModel mapToDataModel(Asn asn);

  @Mapping(source = "ipStart", target = "ipStart")
  @Mapping(source = "ipEnd", target = "ipEnd")
  IpBlockDataModel mapToAsnIpBlocksDataModel(Asn asn);

  default DataModel mapToDataModelWithIpBlocks(Asn asn) {
    DataModel model = this.mapToDataModel(asn);
    model.getIpBlocks().add(this.mapToAsnIpBlocksDataModel(asn));
    return model;
  }
}