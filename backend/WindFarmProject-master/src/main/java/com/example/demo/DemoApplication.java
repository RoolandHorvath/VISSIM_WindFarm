package com.example.demo;

import com.example.demo.DTOs.TrafficDataFilteredDTO;
import com.example.demo.DTOs.TrafficDataDTO;
import com.example.demo.Services.AssetService;
import com.example.demo.Services.TrafficDataService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@EntityScan("com.example.demo.Entities")
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final AssetService assetService;
	private final TrafficDataService trafficDataService;

	public DemoApplication(AssetService assetService, TrafficDataService trafficDataService) {
		this.assetService = assetService;
		this.trafficDataService = trafficDataService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		//testAllTrafficData();
		//testDailyAverageTrafficData();
	}

	private void testAllTrafficData() {
		System.out.println("Fetching traffic data");
		List<TrafficDataDTO> data = trafficDataService.getAllTrafficData();
		if (data != null && !data.isEmpty()) {
			System.out.println("Traffic Data Retrieved: " + data.size() + " entries found.");
			for (TrafficDataDTO entry : data) {
				if (entry != null) {
					System.out.println("DatetimeUtc: " + entry.getDatetimeUtc() + ", MMSI: " + entry.getMMSI() +
							", Class: " + entry.getVesselClass() +
							", Latitude: " + entry.getLatitude() + ", Longitude: " + entry.getLongitude() +
							", SOG: " + entry.getSog() + ", COG: " + entry.getCog() + ", Heading: " + entry.getHeading());
				} else {
					System.out.println("Encountered a null entry");
				}
			}
		} else {
			System.out.println("No traffic data was retrieved.");
		}
	}

//	private void testDailyAverageTrafficData() {
//		System.out.println("Fetching average traffic data.");
//		List<TrafficDataFilteredDTO> averages = trafficDataService.getDailyAverageTrafficData();
//		if (averages != null && !averages.isEmpty()) {
//			System.out.println("Daily Traffic Data Averages Retrieved: " + averages.size() + " entries found.");
//			for (TrafficDataFilteredDTO avg : averages) {
//				if (avg != null) {
//					System.out.println("Date: " + avg.getDate() + ", MMSI: " + avg.getMmsi() +
//							", Average SOG: " + avg.getAvgSOG() + ", Average COG: " + avg.getAvgCOG());
//				} else {
//					System.out.println("Encountered a null entry");
//				}
//			}
//		} else {
//			System.out.println("No average traffic data was retrieved.");
//		}
//	}
}
