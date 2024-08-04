package com.example.demo.Controllers;

import com.example.demo.Entities.CardSwipesOnAssets;
import com.example.demo.Repositories.CardSwipesOnAssetsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/cardswipes")
public class CardSwipesOnAssetsController {
    private final CardSwipesOnAssetsRepository cardSwipesOnAssetsRepository;

    public CardSwipesOnAssetsController(CardSwipesOnAssetsRepository cardSwipeOnAssetRepository) {
        this.cardSwipesOnAssetsRepository = cardSwipeOnAssetRepository;
    }

    @GetMapping
    public List<CardSwipesOnAssets> getAllCardSwipes() {
        return cardSwipesOnAssetsRepository.findAll();
    }

}

