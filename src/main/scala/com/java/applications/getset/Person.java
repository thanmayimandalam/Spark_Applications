package com.java.applications.getset;

/**
 * Created by adity on 7/5/2018.
 */
public abstract class Person {

    String FirstName;
    String LastName;
    String Email;

    public abstract String getDisplayText();

    public String toString(){
        return "Name:"+" " + FirstName + " " + LastName+"\nEmail:"+" "+ Email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
