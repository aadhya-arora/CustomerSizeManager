package com.raanjhana.model;

import jakarta.persistence.*;

@Entity
@Table(name = "trouser_size")
public class TrouserSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    private String pleats;
    private double length;
    private double waist;
    private double il;
    private double hips;
    private double thigh;
    private double r;
    private double knee;
    private double calf;
    private double bottom;

    public TrouserSize() {}

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public String getPleats() {
        return pleats;
    }

    public void setPleats(String pleats) {
        this.pleats = pleats;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWaist() {
        return waist;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }

    public double getIl() {
        return il;
    }

    public void setIl(double il) {
        this.il = il;
    }

    public double getHips() {
        return hips;
    }

    public void setHips(double hips) {
        this.hips = hips;
    }

    public double getThigh() {
        return thigh;
    }

    public void setThigh(double thigh) {
        this.thigh = thigh;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getKnee() {
        return knee;
    }

    public void setKnee(double knee) {
        this.knee = knee;
    }

    public double getCalf() {
        return calf;
    }

    public void setCalf(double calf) {
        this.calf = calf;
    }

    public double getBottom() {
        return bottom;
    }

    public void setBottom(double bottom) {
        this.bottom = bottom;
    }

    // Other fields same pattern
}
