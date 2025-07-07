package org.dcistudent.geolocationstatisticsapi.managers;

import org.dcistudent.geolocationstatisticsapi.entities.Asn;
import org.dcistudent.geolocationstatisticsapi.mappers.manager.AsnDataModelMapper;
import org.dcistudent.geolocationstatisticsapi.models.data.AsnDataModel;
import org.dcistudent.geolocationstatisticsapi.repositories.AsnRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AsnManager {

  private final @NotNull AsnRepository asnRepository;
  private final @NotNull AsnDataModelMapper mapper;

  public AsnManager(@NotNull AsnRepository asnRepository, @NotNull AsnDataModelMapper mapper) {
    this.asnRepository = asnRepository;
    this.mapper = mapper;
  }

  public @NotNull Map<Long, AsnDataModel> findAsByNumber(@NotNull Long asNumber) {
    List<Asn> list = asnRepository.findAsByNumber(asNumber);
    return this.convertToDataModel(list);
  }

  public @NotNull Map<Long, AsnDataModel> findAsById(@NotNull Long id) {
    List<Asn> list = asnRepository.findAsById(id);
    return this.convertToDataModel(list);
  }

  public @NotNull Map<Long, AsnDataModel> findAsByName(@NotNull String name) {
    List<Asn> list = asnRepository.findAsByName(name);
    return this.convertToDataModel(list);
  }

  private @NotNull Map<Long, AsnDataModel> convertToDataModel(@NotNull List<Asn> list) {
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
