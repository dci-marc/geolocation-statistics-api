package org.dcistudent.geolocationstatisticsapi.configs;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptionConfig {

  @Bean
  public @NotNull String passwordEncoder(@NotNull String password) {
    return new BCryptPasswordEncoder().encode(password);
  }
}
