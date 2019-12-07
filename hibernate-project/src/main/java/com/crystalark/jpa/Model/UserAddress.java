package com.crystalark.jpa.Model;

import javax.persistence.Embeddable;

@Embeddable
public final class UserAddress {
    private String city;
    private String state;
    private String country;
    private String zip;

    public UserAddress(String city, String state, String country, String zip) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;
    }
    protected UserAddress(){}

    @Override
    public String toString() {
        return "UserAddress{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZip() {
        return zip;
    }
}