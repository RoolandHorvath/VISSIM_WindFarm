package com.example.demo.Entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "CardSwipesOnAssets", schema = "dbo")
public class CardSwipesOnAssets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EventID")
    private Integer eventId;

    @Column(name = "CardID")
    private Long cardId;

    @Column(name = "Action")
    private String action;

    @Column(name = "Explanation")
    private String explanation;

    @Column(name = "Lon", precision = 9, scale = 6)
    private BigDecimal longitude;

    @Column(name = "Lat", precision = 8, scale = 6)
    private BigDecimal latitude;

    @Column(name = "LocationID")
    private Integer locationId;

    @Column(name = "ProjectInstallationTypeID")
    private Byte projectInstallationTypeId;

    @Column(name = "EntryTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entryTime;

    @Column(name = "LocationName")
    private String locationName;

    @Column(name = "CreatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "UpdatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "IsAutomatic")
    private Boolean isAutomatic;

    @Column(name = "EmployeeID")
    private Integer employeeId;

    @Column(name = "ProjectID")
    private Integer projectId;

    @Column(name = "LocationProject")
    private Integer locationProject;

    @Column(name = "AssetName")
    private String assetName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Byte getProjectInstallationTypeId() {
        return projectInstallationTypeId;
    }

    public void setProjectInstallationTypeId(Byte projectInstallationTypeId) {
        this.projectInstallationTypeId = projectInstallationTypeId;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getAutomatic() {
        return isAutomatic;
    }

    public void setAutomatic(Boolean automatic) {
        isAutomatic = automatic;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getLocationProject() {
        return locationProject;
    }

    public void setLocationProject(Integer locationProject) {
        this.locationProject = locationProject;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }
}

