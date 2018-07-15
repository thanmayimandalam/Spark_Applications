package com.java.applications.validator1;

import java.util.Scanner;

/**
 * Created by adity on 6/30/2018.
 */
public class OOValidator {

    Scanner sc;
    public OOValidator(Scanner sc){
     this.sc = sc;
    }
    public int getInt(String prompt){

        int i = 0;
        boolean isValid = false;
        while(isValid == false){
            System.out.println(prompt);
            if (sc.hasNextInt()){
                i = sc.nextInt();
                isValid = true;
            }else {
                System.out.println("Error, please provide valid integer value");
            }


        }return i;
    }

    public int getIntWithinRange(String prompt, int min, int max){
        int i = 0;
        boolean isValid = false;
        while(isValid == false){
            i = getInt(prompt);
            if(i < min){
                System.out.println("Minimum vale is" +(min - 1));
            }else if(i > max){
                System.out.println("Max value is " +(max + 1));
            }else {
                isValid = true;
            }
        }return i;
    }

    public double getdouble(String prompt){

        double d = 0;
        boolean isValid = false;
        while(isValid == false){
            System.out.println(prompt);
            if (sc.hasNextDouble()){
                d = sc.nextDouble();
                isValid = true;
            }else {
                System.out.println("Error, please provide valid double value");
            }


        }return d;
    }

    public double getdoubleWithinRange(String prompt, double min, double max){
        double d = 0;
        boolean isValid = false;
        while(isValid == false){
            d = getdouble(prompt);
            if(d < min){
                System.out.println("Minimum vale is" +(min - 1));
            }else if(d > max){
                System.out.println("Max value is " +(max + 1));
            }else {
                isValid = true;
            }
        }return d;
    }

    public String getemail(String prompt){

        String string = "";
        String Regexp = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        boolean isValid = false;
        while (isValid == false){
            System.out.println(prompt);
            string = sc.next();
            if (string.matches(Regexp)){
                isValid = true;
            }else {
                System.out.println("Please input valid email ID");
            }
        }return string;
    }

}


