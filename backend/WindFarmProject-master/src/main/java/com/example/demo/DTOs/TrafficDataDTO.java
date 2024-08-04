package com.example.demo.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrafficDataDTO {
    private String datetimeUtc;
    @JsonProperty("MMSI")
    private int mmsi;
    private String vesselClass;
    private double latitude;
    private double longitude;
    private double sog;
    private double cog;
    private int heading;

    public String getDatetimeUtc() {
        return datetimeUtc;
    }

    public void setDatetimeUtc(String datetimeUtc) {
        this.datetimeUtc = datetimeUtc;
    }

    public int getMMSI() {
        return mmsi;
    }

    public void setMMSI(int mmsi) {
        this.mmsi = mmsi;
    }

    public String getVesselClass() {
        return vesselClass;
    }

    public void setVesselClass(String vesselClass) {
        this.vesselClass = vesselClass;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getSog() {
        return sog;
    }

    public void setSog(double sog) {
        this.sog = sog;
    }

    public double getCog() {
        return cog;
    }

    public void setCog(double cog) {
        this.cog = cog;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public TrafficDataDTO(String datetimeUtc, int mmsi, String vesselClass, double latitude, double longitude, double sog, double cog, int heading) {
        this.datetimeUtc = datetimeUtc;
        this.mmsi = mmsi;
        this.vesselClass = vesselClass;
        this.latitude = latitude;
        this.longitude = longitude;
        this.sog = sog;
        this.cog = cog;
        this.heading = heading;
    }

    @Override
    public String toString() {
        return "TrafficDataDTO{" +
                "datetimeUtc='" + datetimeUtc + '\'' +
                ", mmsi=" + mmsi +
                ", vesselClass='" + vesselClass + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", sog=" + sog +
                ", cog=" + cog +
                ", heading=" + heading +
                '}';
    }
}