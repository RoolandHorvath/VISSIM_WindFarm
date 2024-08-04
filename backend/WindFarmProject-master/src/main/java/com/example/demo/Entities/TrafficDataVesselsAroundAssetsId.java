package com.example.demo.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class TrafficDataVesselsAroundAssetsId implements Serializable {
    private Integer mmsi;
    private Integer serverInstallationId;
    private String name;
    private Date startDateTime;
    private Date endDateTime;

    public Integer getMmsi() {
        return mmsi;
    }

    public void setMmsi(Integer mmsi) {
        this.mmsi = mmsi;
    }

    public Integer getServerInstallationId() {
        return serverInstallationId;
    }

    public void setServerInstallationId(Integer serverInstallationId) {
        this.serverInstallationId = serverInstallationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrafficDataVesselsAroundAssetsId that)) return false;
        return Objects.equals(getMmsi(), that.getMmsi()) && Objects.equals(getServerInstallationId(), that.getServerInstallationId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getStartDateTime(), that.getStartDateTime()) && Objects.equals(getEndDateTime(), that.getEndDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMmsi(), getServerInstallationId(), getName(), getStartDateTime(), getEndDateTime());
    }
}