package com.s2p.FCT.model;

import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.s2p.FCT.entity.Customers;
import jakarta.persistence.*;

@Entity
@Table(name = "customer_address")
public class CustomerAddress {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String name;
    private String phone;
    private String alternatePhone;
    private String pincode;
    private String locality;
    private String street;
    private String city;
    private String state;
    private String landmark;
    private String addressType;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customers customers;

    // Correct setter
    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Customers getCustomers() {
        return customers;
    }

    // Getters & Setters for all fields
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAlternatePhone() {
        return alternatePhone;
    }

    public void setAlternatePhone(String alternatePhone) {
        this.alternatePhone = alternatePhone;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    // REMOVE isEmpty() entirely
}
