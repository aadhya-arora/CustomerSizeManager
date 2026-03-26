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

    private String name;
    private double length;
    private double chest;
    private double gap;
    private double waist;
    private double hips;
    private double shoulder;
    private double sleeve;
    private double bicep;
    private double elbow;
    private double cuff;
    private double cb;
    private double neck;

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

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getChest() {
        return chest;
    }

    public void setChest(double chest) {
        this.chest = chest;
    }

    public double getGap() {
        return gap;
    }

    public void setGap(double gap) {
        this.gap = gap;
    }

    public double getWaist() {
        return waist;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }

    public double getHips() {
        return hips;
    }

    public void setHips(double hips) {
        this.hips = hips;
    }

    public double getShoulder() {
        return shoulder;
    }

    public void setShoulder(double shoulder) {
        this.shoulder = shoulder;
    }

    public double getSleeve() {
        return sleeve;
    }

    public void setSleeve(double sleeve) {
        this.sleeve = sleeve;
    }

    public double getBicep() {
        return bicep;
    }

    public void setBicep(double bicep) {
        this.bicep = bicep;
    }

    public double getElbow() {
        return elbow;
    }

    public void setElbow(double elbow) {
        this.elbow = elbow;
    }

    public double getCuff() {
        return cuff;
    }

    public void setCuff(double cuff) {
        this.cuff = cuff;
    }

    public double getCb() {
        return cb;
    }

    public void setCb(double cb) {
        this.cb = cb;
    }

    public double getNeck() {
        return neck;
    }

    public void setNeck(double neck) {
        this.neck = neck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
// Standard getters & setters
}
