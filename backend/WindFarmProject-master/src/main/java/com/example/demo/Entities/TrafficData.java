package com.example.demo.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.locationtech.jts.geom.Point;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TrafficData", schema = "dbo")
@IdClass(TrafficDataId.class)
public class TrafficData {
    @Id
    @Column(name = "DatetimeUtc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetimeUtc;

    @Id
    @Column(name = "MMSI")
    private Integer mmsi;

    @Column(name = "Class", columnDefinition = "CHAR(5)")
    private String vesselClass;

    @Column(name = "MsgTypeID")
    private Byte msgTypeId;

    @Transient
    private Point position;

    @Column(name = "SOG", precision = 5, scale = 1)
    private BigDecimal sog;

    @Column(name = "COG", precision = 5, scale = 1)
    private BigDecimal cog;

    @Column(name = "Heading")
    private Short heading;

    public Date getDatetimeUtc() {
        return datetimeUtc;
    }

    public void setDatetimeUtc(Date datetimeUtc) {
        this.datetimeUtc = datetimeUtc;
    }

    public Integer getMmsi() {
        return mmsi;
    }

    public void setMmsi(Integer mmsi) {
        this.mmsi = mmsi;
    }

    public String getVesselClass() {
        return vesselClass;
    }

    public void setVesselClass(String vesselClass) {
        this.vesselClass = vesselClass;
    }

    public Byte getMsgTypeId() {
        return msgTypeId;
    }

    public void setMsgTypeId(Byte msgTypeId) {
        this.msgTypeId = msgTypeId;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public BigDecimal getSog() {
        return sog;
    }

    public void setSog(BigDecimal sog) {
        this.sog = sog;
    }

    public BigDecimal getCog() {
        return cog;
    }

    public void setCog(BigDecimal cog) {
        this.cog = cog;
    }

    public Short getHeading() {
        return heading;
    }

    public void setHeading(Short heading) {
        this.heading = heading;
    }
}
