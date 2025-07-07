package org.dcistudent.geolocationstatisticsapi.models.response;

import org.jetbrains.annotations.NotNull;

public record CountryIpBlocksResponse(@NotNull String country, @NotNull Long count) {
}
