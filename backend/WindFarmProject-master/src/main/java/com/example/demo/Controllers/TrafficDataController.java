package com.example.demo.Controllers;

import com.example.demo.DTOs.TrafficDataDTO;
import com.example.demo.DTOs.TrafficDataFilteredDTO;
import com.example.demo.Services.TrafficDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/traffic")
public class TrafficDataController {
    private final TrafficDataService trafficDataService;

    public TrafficDataController(TrafficDataService trafficDataService) {
        this.trafficDataService = trafficDataService;
    }

    @GetMapping
    public ResponseEntity<List<TrafficDataDTO>> getTrafficDataByDate(String date) {
        List<TrafficDataDTO> trafficData = trafficDataService.getTrafficDataByDate(date);
        if (trafficData.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(trafficData);
    }

    @GetMapping("/daily-averages")
    public ResponseEntity<List<TrafficDataFilteredDTO>> getDailyAverages(@RequestParam(required = false) String date) {
        List<TrafficDataFilteredDTO> averages;
        if (date != null) {
            averages = trafficDataService.getDailyAverageTrafficDataByDate(date);
        } else {
            averages = trafficDataService.getDailyAverageTrafficData();
        }
        if (averages.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(averages);
    }
}