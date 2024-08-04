package com.example.demo.Repositories;

import com.example.demo.Entities.ManifestsJson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ManifestsJsonRepository extends JpaRepository<ManifestsJson, Long> {

    @Query(value = "SELECT TOP 1 * FROM dbo.ManifestsJson ORDER BY manifestId ASC", nativeQuery = true)
    ManifestsJson findFirstManifest();
}