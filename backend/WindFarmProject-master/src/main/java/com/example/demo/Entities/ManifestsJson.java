package com.example.demo.Entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;
@Entity
@Table(name = "ManifestsJson", schema = "dbo")
public class ManifestsJson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer manifestId;

    @Column(name = "ManifestAbbreviationID")
    private String manifestAbbreviationId;

    @Column(name = "ProjectID")
    private Integer projectId;

    @Column(name = "DepartureTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureTime;

    @Column(name = "ArrivalTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalTime;

    @Column(name = "ResourceName")
    private String resourceName;

    @Column(name = "BasicJson", columnDefinition = "nvarchar(max)")
    private String basicJson;

    @Column(name = "FullJson", columnDefinition = "nvarchar(max)")
    private String fullJson;

    @Column(columnDefinition = "uniqueidentifier")
    private UUID uid;

    @Column(name = "PassengerDocumentsJson", columnDefinition = "nvarchar(max)")
    private String passengerDocumentsJson;

    @Column(name = "IsShipmentTypeEnable")
    private Boolean isShipmentTypeEnable;

    @Column(name = "AdvancedCargoManifest")
    private Boolean advancedCargoManifest;

    @Column(name = "CargoDocumentsJson", columnDefinition = "nvarchar(max)")
    private String cargoDocumentsJson;

    @Column(name = "LogsJson", columnDefinition = "nvarchar(max)")
    private String logsJson;

    @Column(name = "VResourceMMSI")
    private String vResourceMMSI;

    public Integer getManifestId() {
        return manifestId;
    }

    public void setManifestId(Integer manifestId) {
        this.manifestId = manifestId;
    }

    public String getManifestAbbreviationId() {
        return manifestAbbreviationId;
    }

    public void setManifestAbbreviationId(String manifestAbbreviationId) {
        this.manifestAbbreviationId = manifestAbbreviationId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getBasicJson() {
        return basicJson;
    }

    public void setBasicJson(String basicJson) {
        this.basicJson = basicJson;
    }

    public String getFullJson() {
        return fullJson;
    }

    public void setFullJson(String fullJson) {
        this.fullJson = fullJson;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public String getPassengerDocumentsJson() {
        return passengerDocumentsJson;
    }

    public void setPassengerDocumentsJson(String passengerDocumentsJson) {
        this.passengerDocumentsJson = passengerDocumentsJson;
    }

    public Boolean getShipmentTypeEnable() {
        return isShipmentTypeEnable;
    }

    public void setShipmentTypeEnable(Boolean shipmentTypeEnable) {
        isShipmentTypeEnable = shipmentTypeEnable;
    }

    public Boolean getAdvancedCargoManifest() {
        return advancedCargoManifest;
    }

    public void setAdvancedCargoManifest(Boolean advancedCargoManifest) {
        this.advancedCargoManifest = advancedCargoManifest;
    }

    public String getCargoDocumentsJson() {
        return cargoDocumentsJson;
    }

    public void setCargoDocumentsJson(String cargoDocumentsJson) {
        this.cargoDocumentsJson = cargoDocumentsJson;
    }

    public String getLogsJson() {
        return logsJson;
    }

    public void setLogsJson(String logsJson) {
        this.logsJson = logsJson;
    }

    public String getvResourceMMSI() {
        return vResourceMMSI;
    }

    public void setvResourceMMSI(String vResourceMMSI) {
        this.vResourceMMSI = vResourceMMSI;
    }
}
