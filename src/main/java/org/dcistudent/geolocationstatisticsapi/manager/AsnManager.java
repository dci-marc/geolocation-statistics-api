package org.dcistudent.geolocationstatisticsapi.manager;

import org.dcistudent.geolocationstatisticsapi.entity.Asn;
import org.dcistudent.geolocationstatisticsapi.mapper.manager.AsnDataModelMapper;
import org.dcistudent.geolocationstatisticsapi.model.data.AsnDataModel;
import org.dcistudent.geolocationstatisticsapi.repository.AsnRepository;
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

  public Map<Long, AsnDataModel> getAsByNumber(Long asNumber) {
    List<Asn> list = asnRepository.findAsByNumber(asNumber);
    return this.convertToDataModel(list);
  }

  public Map<Long, AsnDataModel> getAsById(Long id) {
    List<Asn> list = asnRepository.findAsById(id);
    return this.convertToDataModel(list);
  }

  public Map<Long, AsnDataModel> getAsByName(String name) {
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
