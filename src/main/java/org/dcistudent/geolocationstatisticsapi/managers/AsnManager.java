package org.dcistudent.geolocationstatisticsapi.managers;

import org.dcistudent.geolocationstatisticsapi.entities.Asn;
import org.dcistudent.geolocationstatisticsapi.mappers.manager.AsnDataModelMapper;
import org.dcistudent.geolocationstatisticsapi.models.data.AsnDataModel;
import org.dcistudent.geolocationstatisticsapi.repositories.AsnRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AsnManager {

  private final AsnRepository asnRepository;
  private final AsnDataModelMapper mapper;

  public AsnManager(AsnRepository asnRepository, AsnDataModelMapper mapper) {
    this.asnRepository = asnRepository;
    this.mapper = mapper;
  }

  public Map<Long, AsnDataModel> findAsByNumber(Long asNumber) {
    List<Asn> list = asnRepository.findAsByNumber(asNumber);
    return this.convertToDataModel(list);
  }

  public Map<Long, AsnDataModel> findAsById(Long id) {
    List<Asn> list = asnRepository.findAsById(id);
    return this.convertToDataModel(list);
  }

  public Map<Long, AsnDataModel> findAsByName(String name) {
    List<Asn> list = asnRepository.findAsByName(name);
    return this.convertToDataModel(list);
  }

  private Map<Long, AsnDataModel> convertToDataModel(List<Asn> list) {
    return list.stream().collect(
        Collectors.toMap(
            Asn::getAsNumber,
            this.mapper::mapToDataModelWithIpBlocks,
            (existingValue, newValue) -> {
              existingValue.getIpBlocks().addAll(newValue.getIpBlocks());
              return existingValue;
            }
        )
    );
  }
}
