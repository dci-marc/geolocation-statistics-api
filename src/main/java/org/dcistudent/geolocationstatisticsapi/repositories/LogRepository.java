package org.dcistudent.geolocationstatisticsapi.repositories;

import org.dcistudent.geolocationstatisticsapi.entities.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LogRepository extends JpaRepository<Log, Long> {

  default List<Log> findWithLimit(Integer limit) {
    limit = Optional.ofNullable(limit).orElse(10);
    if (limit < 1 || limit > 100) {
      throw new IllegalArgumentException("Limit must be between 1 and 100");
    }
    return findWithLimitStatement(limit);
  }

  @Query(
      "SELECT l " +
      "FROM Log AS l " +
      "ORDER BY datetime DESC " +
      "LIMIT :limit"
  )
  List<Log> findWithLimitStatement(@Param("limit") Integer limit);

  @Modifying
  @Query(
      "INSERT INTO Log (id, level, datetime, message) " +
      "VALUES (:id, :level, :datetime, :message)"
  )
  void insert(
      @Param("id") String uuid,
      @Param("level") Integer level,
      @Param("datetime") String datetime,
      @Param("message") String message
  );
}
