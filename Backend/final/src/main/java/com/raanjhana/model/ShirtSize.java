package com.raanjhana.model;

import jakarta.persistence.*;

@Entity
@Table(name = "shirt_size")
public class ShirtSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

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

    public ShirtSize() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

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

}
