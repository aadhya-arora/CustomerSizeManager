package com.raanjhana.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="coat_size")
public class CoatSize {

    @Id
    private String id;

    @Field("customerPhoneNumber")
    private String customerPhoneNumber;

    private Integer rsd;
    private Integer lsd;
    private Integer sd;
    private Integer ss;
    private Integer fitting;
    private Integer comfort;
    private Integer loose;
    private Integer backRound;
    private Integer backDown;
    private String name;
    private Double length;
    private Double chest;
    private Double gap;
    private Double waist;
    private Double hips;
    private Double shoulder;
    private Double sleeve;
    private Double bicep;
    private Double elbow;
    private Double cuff;
    private Double cb;
    private Double neck;

    public CoatSize() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getChest() {
        return chest;
    }

    public void setChest(Double chest) {
        this.chest = chest;
    }

    public Double getGap() {
        return gap;
    }

    public void setGap(Double gap) {
        this.gap = gap;
    }

    public Double getWaist() {
        return waist;
    }

    public void setWaist(Double waist) {
        this.waist = waist;
    }

    public Double getHips() {
        return hips;
    }

    public void setHips(Double hips) {
        this.hips = hips;
    }

    public Double getShoulder() {
        return shoulder;
    }

    public void setShoulder(Double shoulder) {
        this.shoulder = shoulder;
    }

    public Double getSleeve() {
        return sleeve;
    }

    public void setSleeve(Double sleeve) {
        this.sleeve = sleeve;
    }

    public Double getBicep() {
        return bicep;
    }

    public void setBicep(Double bicep) {
        this.bicep = bicep;
    }

    public Double getElbow() {
        return elbow;
    }

    public void setElbow(Double elbow) {
        this.elbow = elbow;
    }

    public Double getCuff() {
        return cuff;
    }

    public void setCuff(Double cuff) {
        this.cuff = cuff;
    }

    public Double getCb() {
        return cb;
    }

    public void setCb(Double cb) {
        this.cb = cb;
    }

    public Double getNeck() {
        return neck;
    }

    public void setNeck(Double neck) {
        this.neck = neck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBackDown() {
        return backDown;
    }

    public void setBackDown(Integer backDown) {
        this.backDown = backDown;
    }

    public Integer getBackRound() {
        return backRound;
    }

    public void setBackRound(Integer backRound) {
        this.backRound = backRound;
    }

    public Integer getComfort() {
        return comfort;
    }

    public void setComfort(Integer comfort) {
        this.comfort = comfort;
    }

    public Integer getFitting() {
        return fitting;
    }

    public void setFitting(Integer fitting) {
        this.fitting = fitting;
    }

    public Integer getLoose() {
        return loose;
    }

    public void setLoose(Integer loose) {
        this.loose = loose;
    }

    public Integer getLsd() {
        return lsd;
    }

    public void setLsd(Integer lsd) {
        this.lsd = lsd;
    }

    public Integer getRsd() {
        return rsd;
    }

    public void setRsd(Integer rsd) {
        this.rsd = rsd;
    }

    public Integer getSd() {
        return sd;
    }

    public void setSd(Integer sd) {
        this.sd = sd;
    }

    public Integer getSs() {
        return ss;
    }

    public void setSs(Integer ss) {
        this.ss = ss;
    }

    // Standard getters & setters
}
