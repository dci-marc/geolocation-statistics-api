package org.dcistudent.geolocationstatisticsapi.managers;

import org.dcistudent.geolocationstatisticsapi.models.data.AsnDataModel;
import org.dcistudent.geolocationstatisticsapi.models.data.IpBlockDataModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class AsnManagerTest {

  @MockitoBean
  private AsnManager asnManager;

  private static AsnDataModel createTestData() {
    AsnDataModel model = new AsnDataModel(12345L, "Example Org 1");
    model.getIpBlocks().add(new IpBlockDataModel("1.1.1.0", "1.1.1.255"));
    return model;
  }

  @BeforeEach
  void setup() {
    AsnDataModel model = createTestData();
    when(asnManager.findAsByNumber(12345L)).thenReturn(Map.of(12345L, model));
    when(asnManager.findAsById(1L)).thenReturn(Map.of(12345L, model));
    when(asnManager.findAsByName("Example Org 1")).thenReturn(Map.of(12345L, model));
  }

  @Test
  void testFindAs() {
    Map<Integer, Map<Long, AsnDataModel>> results = new HashMap<>();

    AsnDataModel model = new AsnDataModel(12345L, "Example Org 1");
    model.getIpBlocks().add(new IpBlockDataModel("1.1.1.0", "1.1.1.255"));

    when(asnManager.findAsByNumber(12345L)).thenReturn(Map.of(12345L, model));
    when(asnManager.findAsById(1L)).thenReturn(Map.of(12345L, model));
    when(asnManager.findAsByName("Example Org 1")).thenReturn(Map.of(12345L, model));

    results.put(1, asnManager.findAsByNumber(12345L));
    results.put(2, asnManager.findAsById(1L));
    results.put(3, asnManager.findAsByName("Example Org 1"));

    results.forEach((key, result) -> {
      assertThat(result).hasSize(1);
      assertThat(result.get(12345L).getAsNumber()).isEqualTo(12345L);
      assertThat(result.get(12345L).getAsOrg()).isEqualTo("Example Org 1");
      assertThat(result.get(12345L).getIpBlocks()).hasSize(1);
      assertThat(result.get(12345L).getIpBlocks().get(0).getIpStart()).isEqualTo("1.1.1.0");
      assertThat(result.get(12345L).getIpBlocks().get(0).getIpEnd()).isEqualTo("1.1.1.255");
    });

    verify(asnManager, times(1)).findAsByNumber(12345L);
    verify(asnManager, times(1)).findAsById(1L);
    verify(asnManager, times(1)).findAsByName("Example Org 1");
  }
}
