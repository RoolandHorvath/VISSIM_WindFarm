import {AfterViewInit, Component, OnInit} from '@angular/core';
import {BackendService} from './service/backend.service';
import {Asset} from "./models/asset.model";
import * as L from "leaflet";
import {TrafficData} from "./models/traffic-data.model";

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, AfterViewInit {
    title = 'WindFarm';
    private map!: L.Map;
    turbine: Asset[] | undefined;
    trafficData: TrafficData[] | undefined;
    markers: L.Marker[] = [];

    turbineIcon = L.icon({
        iconUrl: 'assets/turbine-icon.png',
        iconSize: [15, 15], // size of the icon
        iconAnchor: [7.5, 7.5], // center point of the icon
        popupAnchor: [0, -7.5] // point from which the popup should open relative to the iconAnchor
    });

    constructor(private backendService: BackendService) {
    }

    ngOnInit(): void {
        this.initializeMap();
    }

    fetchData(): void {
        const dateInput = (document.getElementById('start') as HTMLInputElement).value;
        if (dateInput) {
            this.backendService.fetchTrafficData(dateInput).subscribe(data => {
                this.trafficData = data;
                this.clearMapLayers();
                this.plotTrafficData();
            });
        }
    }


    private plotTrafficData(): void {
        const allowedMMSIs = new Set([232031394, 235108492, 211303540, 235071392, 235090162, 235092439]);

        if (this.trafficData && this.trafficData.length > 0) {
            this.clearMapLayers();  // Clear the map before plotting new data

            const groupedByShip = new Map<number, { coordinates: L.LatLng[], sog: number[], cog: number[] }>();

            this.trafficData.filter(data => allowedMMSIs.has(data.MMSI))
                .forEach(data => {
                    if (!groupedByShip.has(data.MMSI)) {
                        groupedByShip.set(data.MMSI, {coordinates: [], sog: [], cog: []});
                    }
                    groupedByShip.get(data.MMSI)?.coordinates.push(L.latLng(data.latitude, data.longitude));
                    groupedByShip.get(data.MMSI)?.sog.push(data.sog);
                    groupedByShip.get(data.MMSI)?.cog.push(data.cog);
                });

            groupedByShip.forEach((data, mmsi) => {
                const validCoordinates = data.coordinates.filter(coord => coord && coord.lat && coord.lng);
                if (validCoordinates.length > 1) {
                    try {
                        const polyline = L.polyline(validCoordinates, {color: this.getRandomColor(), weight: 3}).addTo(this.map);

                        const avgSOG = data.sog.reduce((a, b) => a + b, 0) / data.sog.length;
                        const avgCOG = data.cog.reduce((a, b) => a + b, 0) / data.cog.length;

                        polyline.bindPopup(`Ship MMSI: ${mmsi}<br>Average SOG: ${avgSOG.toFixed(2)} knots<br>Average COG: ${avgCOG.toFixed(2)} degrees`);
                    } catch (error) {
                        console.error(`Error plotting MMSI: ${mmsi}`, error);
                    }
                } else {
                    console.warn(`Skipping MMSI: ${mmsi} due to insufficient valid coordinates`);
                }
            });

            if (groupedByShip.size > 0) {
                const allCoordinates = Array.from(groupedByShip.values()).flatMap(data => data.coordinates);
                const validAllCoordinates = allCoordinates.filter(coord => coord && coord.lat && coord.lng);
                if (validAllCoordinates.length > 0) {
                    this.map.fitBounds(L.latLngBounds(validAllCoordinates));
                } else {
                    console.warn('No valid coordinates to fit map bounds');
                }
            }
        } else {
            console.warn('No traffic data available to plot');
        }
    }

    private clearMapLayers(): void {
        this.map.eachLayer(layer => {
            if (layer instanceof L.Polyline) {
                this.map.removeLayer(layer);
            }
        });
    }

    private getRandomColor(): string {
        const letters = '0123456789ABCDEF';
        let color = '#';
        for (let i = 0; i < 6; i++) {
            color += letters[Math.floor(Math.random() * 16)];
        }
        return color;
    }

    ngAfterViewInit(): void {
        // This method is intentionally left empty because the map is initialized in ngOnInit
    }

    private initializeMap(): void {
        const baseMapURL = 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png';
        this.map = L.map('map', {
            center: [58, 3],  // Example coordinates, adjust as needed
            zoom: 5
        });
        L.tileLayer(baseMapURL).addTo(this.map);

        this.backendService.findAll().subscribe(data => {
            this.turbine = data;
            this.addMarkers();
        });
    }

    private addMarkers(): void {
        this.turbine?.forEach(turbine => {
            const marker = L.marker([turbine.latitude, turbine.longitude], {icon: this.turbineIcon})
                .addTo(this.map)
                .bindPopup(`<b>Turbine:</b> ${turbine.name}<br><b>Latitude:</b> ${turbine.latitude}<br><b>Longitude:</b> ${turbine.longitude}`);
            this.markers.push(marker);
        });

        if (this.markers.length > 0) {
            const bounds = L.latLngBounds(this.markers.map(marker => marker.getLatLng()));
            this.map.fitBounds(bounds);
        }
    }
}
