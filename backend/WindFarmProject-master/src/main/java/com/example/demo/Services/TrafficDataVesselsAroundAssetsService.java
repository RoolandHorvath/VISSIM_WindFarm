package com.example.demo.Services;

import com.example.demo.Entities.TrafficDataVesselsAroundAssets;
import com.example.demo.Repositories.TrafficDataVesselsAroundAssetsRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrafficDataVesselsAroundAssetsService {

    private final TrafficDataVesselsAroundAssetsRepository trafficDataVesselsAroundAssetsRepository;

    public TrafficDataVesselsAroundAssetsService(TrafficDataVesselsAroundAssetsRepository repository) {
        this.trafficDataVesselsAroundAssetsRepository = repository;
    }

    public List<TrafficDataVesselsAroundAssets> findAll() {
        return trafficDataVesselsAroundAssetsRepository.findAll();
    }
    public TrafficDataVesselsAroundAssets getFirstTrafficDataVesselsAroundAssets() {
        return trafficDataVesselsAroundAssetsRepository.findFirstTrafficDataVesselsAroundAssets();
    }
}
