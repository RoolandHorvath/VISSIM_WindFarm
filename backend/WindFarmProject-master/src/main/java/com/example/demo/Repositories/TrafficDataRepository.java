package com.example.demo.Repositories;

import com.example.demo.Entities.TrafficData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TrafficDataRepository extends JpaRepository<TrafficData, Long> {

    @Query(value = "SELECT TOP 1 * FROM dbo.TrafficData ORDER BY DatetimeUtc ASC", nativeQuery = true)
    TrafficData findFirstTrafficData();
}