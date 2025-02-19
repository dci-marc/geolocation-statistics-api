package org.dcistudent.geolocationstatisticsapi.repositories;

import org.dcistudent.geolocationstatisticsapi.models.response.CountryIpBlocksResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class CityRepositoryTest {

  @MockitoBean
  private CityRepository cityRepository;

  @Test
  void testFindIpBlocksPerCountry() {
    CountryIpBlocksResponse response = new CountryIpBlocksResponse("US", 1000L);

    when(cityRepository.findIpBlocksPerCountry()).thenReturn(List.of(response));

    List<CountryIpBlocksResponse> result = cityRepository.findIpBlocksPerCountry();

    assertThat(result).hasSize(1);
    assertThat(result.get(0).country()).isEqualTo("US");
    verify(cityRepository, times(1)).findIpBlocksPerCountry();
  }
}
