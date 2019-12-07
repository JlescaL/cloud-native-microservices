package com.crystalark.jpa.Model;

import javax.persistence.Embeddable;

@Embeddable
public final class UserName {
    protected UserName(){}

    private String fname;
    private String mname;
    private String lname;

    public String getFname() {
        return fname;
    }

    public String getMname() {
        return mname;
    }

    public String getLname() {
        return lname;
    }

    @Override
    public String toString() {
        return "UserName{" +
                "fname='" + fname + '\'' +
                ", mname='" + mname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }
}