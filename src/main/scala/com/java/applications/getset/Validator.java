package com.java.applications.getset;

import org.stringtemplate.v4.ST;
import scala.util.parsing.combinator.testing.Str;

import java.util.Scanner;

/**
 * Created by adity on 7/5/2018.
 */
public class Validator {

    Scanner sc = new Scanner(System.in);

    public String getOptionVeri(Scanner sc,String prompt){

        String S = "";
        boolean isValid = false;
        while (isValid == false){
            System.out.println(prompt);
            S = sc.next();
            if((S.equalsIgnoreCase("c")) || (S.equalsIgnoreCase("e"))){

                isValid = true;
            }else System.out.println("Error, Please input C or E. ");

        }return S;
    }

    public String getSSnVeri(Scanner sc, String prompt){

        String S = " ";
        String RegExp = "[0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9]";
        boolean isValid = false;
        while(isValid == false){

            System.out.println(prompt);
            S = sc.nextLine();
            if (S.equals(RegExp)){

                System.out.println("Error, Please enter valid SSN in the format of NNN-NN-NNNN");

            }else isValid = true;
        }return S;

    }

    public String getEmail(Scanner sc,String prompt){

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

    public  String getchoice(Scanner sc,String prompt){

        boolean isValid = false;
        String S = " ";
        while(isValid == false){
        System.out.println(prompt);
        S = sc.next();
        if((S.equalsIgnoreCase("Y") || S.equalsIgnoreCase("N"))){

            isValid = true;
        }else System.out.println("Error, Please input either Y or N to continue the app.");

        }return S;

    }



    }

