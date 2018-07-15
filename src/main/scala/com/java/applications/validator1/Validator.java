package com.java.applications.validator1;

import java.util.Scanner;

/**
 * Created by adity on 7/2/2018.
 */
public class Validator {

    Scanner sc = new Scanner(System.in);
    MyValidator validator = new MyValidator(sc);
    public void intTest(){
        System.out.println("Int Test");
        validator.getIntWithinRange("Enter an integer between -100 and 100:",-100,100);
        doubleTest();
    }

    public void doubleTest(){

        System.out.println("Double test");
        validator.getdoubleWithinRange("Enter double between -100 and 100:",-100,100);
        email();
    }

    public void email(){
        System.out.println("Email Test");
        validator.getemail("Enter valid Email Id:");
        check();
    }

    public void check(){
        System.out.println("String Choice test");
        validator.getChoiceString("select oneX/Y","X","Y" );

    }

}
