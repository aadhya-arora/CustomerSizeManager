package com.raanjhana.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="sherwani_size")
public class SherwaniSize {

    @Id
    private String id;

    @Field("customerPhoneNumber")
    private String customerPhoneNumber;


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
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SherwaniSize() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCustomerPhoneNumber() { return customerPhoneNumber; }
    public void setCustomerPhoneNumber(String customerPhoneNumber) { this.customerPhoneNumber = customerPhoneNumber; }

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

    // Same setters/getters as KurtaSize
}
