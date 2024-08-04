import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Asset} from "../models/asset.model";
import {TrafficData} from "../models/traffic-data.model";


@Injectable({
    providedIn: 'root'
})
export class BackendService {
    private baseUrl = '/api/assets'; // Assuming your backend is hosted on the same server

    constructor(private client_: HttpClient) {
        this.baseUrl = 'http://localhost:8080/api';
    }

    public findAll(): Observable<Asset[]> {
        return this.client_.get<Asset[]>(this.baseUrl + "/assets/locations");
    }

    public fetchTrafficData(date?: string): Observable<TrafficData[]> {
        let url = `${this.baseUrl}/traffic`;
        if (date) {
            const formattedDate = encodeURIComponent(date);
            url += `?date=${formattedDate}`;
        }
        return this.client_.get<TrafficData[]>(url);
    }


}
