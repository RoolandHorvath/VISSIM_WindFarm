package com.example.demo.DTOs;

import java.time.LocalDate;

public class TrafficDataFilteredDTO {
    private LocalDate date;
    private int mmsi;
    private double avgSOG;
    private double avgCOG;

    public TrafficDataFilteredDTO(LocalDate date, int mmsi, double avgSOG, double avgCOG) {
        this.date = date;
        this.mmsi = mmsi;
        this.avgSOG = avgSOG;
        this.avgCOG = avgCOG;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getMmsi() {
        return mmsi;
    }

    public void setMmsi(int mmsi) {
        this.mmsi = mmsi;
    }

    public double getAvgSOG() {
        return avgSOG;
    }

    public void setAvgSOG(double avgSOG) {
        this.avgSOG = avgSOG;
    }

    public double getAvgCOG() {
        return avgCOG;
    }

    public void setAvgCOG(double avgCOG) {
        this.avgCOG = avgCOG;
    }
}
