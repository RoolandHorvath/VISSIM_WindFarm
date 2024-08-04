package com.example.demo.Services;

import com.example.demo.DTOs.AssetLocationDTO;
import com.example.demo.Repositories.AssetRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class AssetService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<AssetLocationDTO> getAllAssetLocations() {
        List<Object[]> results = entityManager.createNativeQuery("SELECT a.Name, a.Position.ToString() AS pointString FROM Assets a").getResultList();
        return results.stream()
                .map(this::convertToAssetLocationDTO)
                .collect(Collectors.toList());
    }

    private AssetLocationDTO convertToAssetLocationDTO(Object[] result) {
        if (result.length == 2 && result[0] instanceof String && result[1] instanceof String) {
            String name = (String) result[0];
            String pointString = (String) result[1];
            return parsePointString(name, pointString);
        }
        return null;
    }

    private AssetLocationDTO parsePointString(String name, String pointString) {
        Pattern pattern = Pattern.compile("POINT \\(([^ ]+) ([^ ]+)\\)");
        Matcher matcher = pattern.matcher(pointString.trim());
        if (matcher.matches()) {
            double longitude = Double.parseDouble(matcher.group(1));
            double latitude = Double.parseDouble(matcher.group(2));
            return new AssetLocationDTO(name, latitude, longitude);
        } else {
            System.out.println("Failed to parse POINT string: " + pointString);
            return null;
        }
    }

    public AssetLocationDTO getFirstAssetLocation() {
        List<Object[]> results = entityManager.createNativeQuery(
                "SELECT a.Name, a.Position.ToString() AS pointString FROM Assets a ORDER BY a.Id ASC"
        ).setMaxResults(1).getResultList();

        if (!results.isEmpty()) {
            Object[] result = results.get(0);
            if (result.length == 2 && result[0] instanceof String && result[1] instanceof String) {
                String name = (String) result[0];
                String pointString = (String) result[1];
                return parsePointString(name, pointString);
            }
        }
        System.out.println("No data found");
        return null;
    }
}
