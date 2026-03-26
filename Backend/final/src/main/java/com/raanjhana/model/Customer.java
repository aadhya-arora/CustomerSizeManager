package com.raanjhana.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="customers")
public class Customer {

    @Id
    private String phoneNumber;

    private String name;

    public Customer() {}

    public Customer(String phoneNumber, String name) {
        this.phoneNumber = phoneNumber;
        this.name = name;
    }


    public String getCustomerPhoneNumber() { return phoneNumber; }
    public void setCustomerPhoneNumber(String customerPhoneNumber) { this.phoneNumber = customerPhoneNumber; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
