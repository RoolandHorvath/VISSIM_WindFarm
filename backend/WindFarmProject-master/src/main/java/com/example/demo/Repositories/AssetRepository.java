package com.example.demo.Repositories;

import com.example.demo.DTOs.AssetLocationDTO;
import com.example.demo.Entities.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Long> {

    @Query(value = "SELECT TOP 1 a.Name, a.Position.ToString() AS pointString FROM Assets a", nativeQuery = true)
    Object[] findFirstAssetLocation();

    @Query(value = "SELECT TOP 1 a.Name FROM Assets a", nativeQuery = true)
    String findFirstAssetName();

    @Query(value = "SELECT TOP 1 a.Position.ToString() AS pointString FROM Assets a", nativeQuery = true)
    String findFirstAssetPosition();

}