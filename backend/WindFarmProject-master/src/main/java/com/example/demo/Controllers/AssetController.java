package com.example.demo.Controllers;

import com.example.demo.DTOs.AssetLocationDTO;
import com.example.demo.Repositories.AssetRepository;
import com.example.demo.Services.AssetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {
    private final AssetService assetService;

    public AssetController(AssetService assetService, AssetRepository assetRepository) {
        this.assetService = assetService;
    }

    @GetMapping("/locations")
    public ResponseEntity<List<AssetLocationDTO>> getAllAssetLocations() {
        List<AssetLocationDTO> assetLocations = assetService.getAllAssetLocations();
        if (assetLocations != null && !assetLocations.isEmpty()) {
            System.out.println("Sending asset: " + assetLocations);
            return ResponseEntity.ok(assetLocations);
        } else {
            System.out.println("No asset found");
            return ResponseEntity.noContent().build();
        }
    }
}