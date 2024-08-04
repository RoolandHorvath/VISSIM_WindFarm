package com.example.demo.Entities;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
public class TrafficDataId implements Serializable {
    private Date datetimeUtc;
    private int mmsi;

    public TrafficDataId() {
    }

    public TrafficDataId(Date datetimeUtc, int mmsi) {
        this.datetimeUtc = datetimeUtc;
        this.mmsi = mmsi;
    }

    public Date getDatetimeUtc() {
        return datetimeUtc;
    }

    public void setDatetimeUtc(Date datetimeUtc) {
        this.datetimeUtc = datetimeUtc;
    }

    public int getMmsi() {
        return mmsi;
    }

    public void setMmsi(int mmsi) {
        this.mmsi = mmsi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrafficDataId that)) return false;
        return getMmsi() == that.getMmsi() && Objects.equals(getDatetimeUtc(), that.getDatetimeUtc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDatetimeUtc(), getMmsi());
    }
}