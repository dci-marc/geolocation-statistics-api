package org.dcistudent.geolocationstatisticsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
public class GeolocationStatisticsApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(GeolocationStatisticsApiApplication.class, args);
  }

}
