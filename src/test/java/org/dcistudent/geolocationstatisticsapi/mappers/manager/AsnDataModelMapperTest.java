package org.dcistudent.geolocationstatisticsapi.mappers.manager;

import org.dcistudent.geolocationstatisticsapi.entities.Asn;
import org.dcistudent.geolocationstatisticsapi.models.data.AsnDataModel;
import org.dcistudent.geolocationstatisticsapi.models.data.IpBlockDataModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AsnDataModelMapperTest {

  @Autowired
  private AsnDataModelMapper asnDataModelMapper;

  public AsnDataModelMapperTest() {
    this.asnDataModelMapper = new AsnDataModelMapperImpl();
  }

  @Test
  void testMapToDataModel() {
    Asn asn = new Asn();
    asn.setAsNumber(12345L);
    asn.setAsOrg("Example Org");

    AsnDataModel dataModel = this.asnDataModelMapper.mapToDataModel(asn);

    assertThat(dataModel).isNotNull();
    assertThat(dataModel.getAsNumber()).isEqualTo(12345L);
    assertThat(dataModel.getAsOrg()).isEqualTo("Example Org");
  }

  @Test
  void testMapToAsnIpBlocksDataModel() {
    Asn asn = new Asn();
    asn.setIpStart("1.1.1.0");
    asn.setIpEnd("1.1.1.255");

    IpBlockDataModel ipBlockDataModel = this.asnDataModelMapper.mapToAsnIpBlocksDataModel(asn);

    assertThat(ipBlockDataModel).isNotNull();
    assertThat(ipBlockDataModel.getIpStart()).isEqualTo("1.1.1.0");
    assertThat(ipBlockDataModel.getIpEnd()).isEqualTo("1.1.1.255");
  }

  @Test
  void testMapToDataModelWithIpBlocks() {
    Asn asn = new Asn();
    asn.setAsNumber(12345L);
    asn.setAsOrg("Example Org");
    asn.setIpStart("1.1.1.0");
    asn.setIpEnd("1.1.1.255");

    AsnDataModel dataModel = this.asnDataModelMapper.mapToDataModelWithIpBlocks(asn);

    assertThat(dataModel).isNotNull();
    assertThat(dataModel.getAsNumber()).isEqualTo(12345L);
    assertThat(dataModel.getAsOrg()).isEqualTo("Example Org");
    assertThat(dataModel.getIpBlocks()).hasSize(1);

    IpBlockDataModel ipBlock = dataModel.getIpBlocks().get(0);
    assertThat(ipBlock.getIpStart()).isEqualTo("1.1.1.0");
    assertThat(ipBlock.getIpEnd()).isEqualTo("1.1.1.255");
  }
}
