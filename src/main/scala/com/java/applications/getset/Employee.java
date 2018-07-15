package com.java.applications.getset;

/**
 * Created by adity on 7/5/2018.
 */
public class Employee extends Person {

    public Employee(){

    }
    String ssNo;

    public String getSsNo() {
        return ssNo;
    }

    public void setSsNo(String ssNo) {
        this.ssNo = ssNo;
    }

    public String getDisplayText(){

        return toString()+"\nEmploye SSN:"+" "+ ssNo;
    }
}
