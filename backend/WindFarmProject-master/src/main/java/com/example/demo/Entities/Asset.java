package com.example.demo.Entities;

import jakarta.persistence.*;
import java.util.Date;
@SqlResultSetMapping(
        name = "AssetLocationMapping",
        classes = @ConstructorResult(
                targetClass = com.example.demo.DTOs.AssetLocationDTO.class,
                columns = {
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "latitude", type = Double.class),
                        @ColumnResult(name = "longitude", type = Double.class)
                }
        )
)
@Entity
@Table(name = "Assets", schema = "dbo")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "uniqueidentifier")
    private String uid;

    @Column(name = "ServerInstallationId")
    private Integer serverInstallationId;

    @Column(name = "ProjectID")
    private Integer projectId;

    @Column(name = "TypeID")
    private Short typeId;

    @Column(name = "ProjectInstallationStatusID")
    private Integer projectInstallationStatusId;

    @Column(name = "Name")
    private String name;

    @Transient
    private Object position;

    @Column(name = "CreatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "UpdatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "ModifiedBy")
    private String modifiedBy;

    @Column(name = "ChangedOnServer")
    @Temporal(TemporalType.TIMESTAMP)
    private Date changedOnServer;

    @Column(name = "HasPhoto")
    private Boolean hasPhoto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getServerInstallationId() {
        return serverInstallationId;
    }

    public void setServerInstallationId(Integer serverInstallationId) {
        this.serverInstallationId = serverInstallationId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Short getTypeId() {
        return typeId;
    }

    public void setTypeId(Short typeId) {
        this.typeId = typeId;
    }

    public Integer getProjectInstallationStatusId() {
        return projectInstallationStatusId;
    }

    public void setProjectInstallationStatusId(Integer projectInstallationStatusId) {
        this.projectInstallationStatusId = projectInstallationStatusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getPosition() {
        return position;
    }

    public void setPosition(Object position) {
        this.position = position;
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

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getChangedOnServer() {
        return changedOnServer;
    }

    public void setChangedOnServer(Date changedOnServer) {
        this.changedOnServer = changedOnServer;
    }

    public Boolean getHasPhoto() {
        return hasPhoto;
    }

    public void setHasPhoto(Boolean hasPhoto) {
        this.hasPhoto = hasPhoto;
    }

}

