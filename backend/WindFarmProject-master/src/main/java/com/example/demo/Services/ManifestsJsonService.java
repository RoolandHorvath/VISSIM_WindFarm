package com.example.demo.Services;

import com.example.demo.Entities.ManifestsJson;
import com.example.demo.Repositories.ManifestsJsonRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ManifestsJsonService {

    private final ManifestsJsonRepository manifestsJsonRepository;

    public ManifestsJsonService(ManifestsJsonRepository repository) {
        this.manifestsJsonRepository = repository;
    }

    public List<ManifestsJson> findAll() {
        return manifestsJsonRepository.findAll();
    }
    public ManifestsJson getFirstManifest() {
        return manifestsJsonRepository.findFirstManifest();
    }
}
