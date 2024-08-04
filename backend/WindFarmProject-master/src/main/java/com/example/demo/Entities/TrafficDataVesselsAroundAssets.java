package com.example.demo.Entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TrafficDataVesselsAroundAssets", schema = "dbo")
@IdClass(TrafficDataVesselsAroundAssetsId.class)
public class TrafficDataVesselsAroundAssets {

    @Id
    @Column(name = "MMSI")
    private Integer mmsi;

    @Id
    @Column(name = "ServerInstallationId")
    private Integer serverInstallationId;

    @Id
    @Column(name = "Name")
    private String name;

    @Id
    @Column(name = "StartDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDateTime;

    @Id
    @Column(name = "EndDateTime")
    @Temporal(TemporalType.TIMESTAMP)
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
}