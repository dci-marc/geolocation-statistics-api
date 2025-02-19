package org.dcistudent.geolocationstatisticsapi.repositories;

import org.dcistudent.geolocationstatisticsapi.entities.Asn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@Disabled("Disabled in favour of SpringBootTest")
class AsnRepositoryMockitoTest {

  @Mock
  private AsnRepository asnRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testFindAsByNumber() {
    Asn asn = new Asn();
    asn.setId(1L);
    asn.setAsNumber(12345L);
    asn.setAsOrg("Example Org 1");

    when(asnRepository.findAsByNumber(12345L)).thenReturn(List.of(asn));

    List<Asn> result = asnRepository.findAsByNumber(12345L);

    assertThat(result).hasSize(1);
    assertThat(result.get(0).getAsOrg()).isEqualTo("Example Org 1");
    verify(asnRepository, times(1)).findAsByNumber(12345L);
  }

  @Test
  void testFindAsById() {
    Asn asn = new Asn();
    asn.setId(1L);
    asn.setAsNumber(12345L);

    when(asnRepository.findAsById(1L)).thenReturn(List.of(asn));

    List<Asn> result = asnRepository.findAsById(1L);

    assertThat(result).hasSize(1);
    assertThat(result.get(0).getAsNumber()).isEqualTo(12345L);
    verify(asnRepository, times(1)).findAsById(1L);
  }

  @Test
  void testFindAsByName() {
    Asn asn = new Asn();
    asn.setId(2L);
    asn.setAsNumber(67890L);
    asn.setAsOrg("Example Org 2");

    when(asnRepository.findAsByName("Org 2")).thenReturn(List.of(asn));

    List<Asn> result = asnRepository.findAsByName("Org 2");

    assertThat(result).hasSize(1);
    assertThat(result.get(0).getAsNumber()).isEqualTo(67890L);
    verify(asnRepository, times(1)).findAsByName("Org 2");
  }
}
