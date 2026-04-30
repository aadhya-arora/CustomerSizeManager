package com.raanjhana.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="trouser_size")
public class TrouserSize {

    @Id
    private String id;

    @Field("customerPhoneNumber")
    private String customerPhoneNumber;


    private Double frontDown;
    private Double frontUp;
    private Double backDown;
    private Double fitting;
    private Double comfort;
    private Double shoeCut;
    private String pleats;
    private Double length;
    private Double waist;
    private Double il;
    private Double hips;
    private Double thigh;
    private Double r;
    private Double r1;
    private Double knee;
    private Double calf;
    private Double bottom;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TrouserSize() {}

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCustomerPhoneNumber() { return customerPhoneNumber; }
    public void setCustomerPhoneNumber(String customerPhoneNumber) { this.customerPhoneNumber = customerPhoneNumber; }


    public String getPleats() {
        return pleats;
    }

    public void setPleats(String pleats) {
        this.pleats = pleats;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWaist() {
        return waist;
    }

    public void setWaist(Double waist) {
        this.waist = waist;
    }

    public Double getIl() {
        return il;
    }

    public void setIl(Double il) {
        this.il = il;
    }

    public Double getHips() {
        return hips;
    }

    public void setHips(Double hips) {
        this.hips = hips;
    }

    public Double getThigh() {
        return thigh;
    }

    public void setThigh(Double thigh) {
        this.thigh = thigh;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public Double getKnee() {
        return knee;
    }

    public void setKnee(Double knee) {
        this.knee = knee;
    }

    public Double getCalf() {
        return calf;
    }

    public void setCalf(Double calf) {
        this.calf = calf;
    }

    public Double getBottom() {
        return bottom;
    }

    public void setBottom(Double bottom) {
        this.bottom = bottom;
    }

    public Double getR1() {
        return r1;
    }

    public void setR1(Double r1) {
        this.r1 = r1;
    }

    public Double getBackDown() {
        return backDown;
    }

    public void setBackDown(Double backDown) {
        this.backDown = backDown;
    }

    public Double getComfort() {
        return comfort;
    }

    public void setComfort(Double comfort) {
        this.comfort = comfort;
    }

    public Double getFitting() {
        return fitting;
    }

    public void setFitting(Double fitting) {
        this.fitting = fitting;
    }

    public Double getFrontDown() {
        return frontDown;
    }

    public void setFrontDown(Double frontDown) {
        this.frontDown = frontDown;
    }

    public Double getFrontUp() {
        return frontUp;
    }

    public void setFrontUp(Double frontUp) {
        this.frontUp = frontUp;
    }

    public Double getShoeCut() {
        return shoeCut;
    }

    public void setShoeCut(Double shoeCut) {
        this.shoeCut = shoeCut;
    }


// Other fields same pattern
}
