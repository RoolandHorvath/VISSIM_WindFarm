package com.example.demo.Controllers;

import com.example.demo.Entities.TrafficDataVesselsAroundAssets;
import com.example.demo.Services.TrafficDataVesselsAroundAssetsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/trafficdatavesselsaroundassets")
public class TrafficDataVesselsAroundAssetsController {

    private final TrafficDataVesselsAroundAssetsService trafficDataVesselsAroundAssetsService;

    public TrafficDataVesselsAroundAssetsController(TrafficDataVesselsAroundAssetsService trafficDataVesselsAroundAssetsService) {
        this.trafficDataVesselsAroundAssetsService = trafficDataVesselsAroundAssetsService;
    }

    @GetMapping
    public ResponseEntity<List<TrafficDataVesselsAroundAssets>> getAllTrafficDataVesselsAroundAssets() {
        List<TrafficDataVesselsAroundAssets> trafficDataVesselsAroundAssets = trafficDataVesselsAroundAssetsService.findAll();
        return ResponseEntity.ok(trafficDataVesselsAroundAssets);
    }
}
