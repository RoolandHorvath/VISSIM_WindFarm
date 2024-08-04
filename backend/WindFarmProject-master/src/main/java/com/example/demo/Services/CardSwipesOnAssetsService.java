package com.example.demo.Services;

import com.example.demo.Entities.CardSwipesOnAssets;
import com.example.demo.Repositories.CardSwipesOnAssetsRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CardSwipesOnAssetsService {

    private final CardSwipesOnAssetsRepository cardSwipesOnAssetsRepository;

    public CardSwipesOnAssetsService(CardSwipesOnAssetsRepository repository) {
        this.cardSwipesOnAssetsRepository = repository;
    }

    public List<CardSwipesOnAssets> findAll() {
        return cardSwipesOnAssetsRepository.findAll();
    }

}
