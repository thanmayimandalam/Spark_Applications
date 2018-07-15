package com.java.applications.validator1;

import java.util.Scanner;

/**
 * Created by adity on 7/1/2018.
 */
public class MyValidator extends OOValidator{

    private Scanner sc;
    public MyValidator(Scanner sc){

        super(sc);
        this.sc = sc;
    }
    public String getrequiredstring(String prompt){
        String s = "";
        boolean isValid = false;
        while (isValid == false){
            System.out.println(prompt);
            s = sc.next();
            if (!s.equals("")){
                isValid = true;
            }else System.out.println("Please input any one of the option");
        }return s;
    }
    public String getChoiceString(String prompt, String s1, String s2){

        String s = null;
        boolean isValid = false;
        while (isValid == false){
            s = getrequiredstring(prompt);
            if ((s.equalsIgnoreCase(s1)|| s.equalsIgnoreCase(s2))){
                isValid = true;
            }else System.out.println("please input either X or Y ");
        }return s;




    }


}
