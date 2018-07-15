package com.java.applications.getset;

/**
 * Created by adity on 7/5/2018.
 */
public class Customer extends Person {

   String customerno;

    public String getCustomerno() {
        return customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }
        public String getDisplayText(){
        return toString() +"\n Customer Number :"+" "+customerno;

    }
}
