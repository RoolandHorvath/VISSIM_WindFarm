package com.example.demo.Controllers;

import com.example.demo.Entities.ManifestsJson;
import com.example.demo.Services.ManifestsJsonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/manifests")
public class ManifestsJsonController {

    private final ManifestsJsonService manifestsJsonService;

    public ManifestsJsonController(ManifestsJsonService manifestsJsonService) {
        this.manifestsJsonService = manifestsJsonService;
    }

    @GetMapping
    public ResponseEntity<List<ManifestsJson>> getAllManifests() {
        List<ManifestsJson> manifests = manifestsJsonService.findAll();
        return ResponseEntity.ok(manifests);
    }
}