package com.example.demo.Repositories;

import com.example.demo.Entities.TrafficDataVesselsAroundAssets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TrafficDataVesselsAroundAssetsRepository extends JpaRepository<TrafficDataVesselsAroundAssets, Long> {

    @Query(value = "SELECT TOP 1 * FROM dbo.TrafficDataVesselsAroundAssets ORDER BY StartDateTime ASC", nativeQuery = true)
    TrafficDataVesselsAroundAssets findFirstTrafficDataVesselsAroundAssets();
}