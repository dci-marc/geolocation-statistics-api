package org.dcistudent.geolocationstatisticsapi.repositories;

import org.dcistudent.geolocationstatisticsapi.entities.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public interface LogRepository extends JpaRepository<Log, Long> {

  default List<Log> findWithLimit(Integer limit) {
    limit = Optional.ofNullable(limit).orElse(10);
    if (limit <= 0 || limit > 100) {
      limit = 10;
    }
    return findWithLimitStatement(limit);
  }

  @Query("SELECT l " +
      "FROM Log AS l " +
      "ORDER BY datetime DESC " +
      "LIMIT :limit")
  List<Log> findWithLimitStatement(@Param("limit") Integer limit);

  @Modifying
  @Query("INSERT INTO Log (level, datetime, message) " +
      "VALUES (:level, :datetime, :message)")
  void insert(
      @Param("level") Integer level,
      @Param("datetime") String datetime,
      @Param("message") String message
  );
}
