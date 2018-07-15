package com.java.applications.getset;

import org.stringtemplate.v4.ST;

import java.util.Scanner;

/**
 * Created by adity on 7/5/2018.
 */
public class PersonApp {


    public static void main(String args[]) {
        Validator v = new Validator();
        String c = "";

        //String thanu = v.toString();


        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Person Tester application");
        do {
            String core = v.getOptionVeri(sc, "Create customer or employee? (c/e):");

            if (core.equalsIgnoreCase("C")) {

                Customer customer = new Customer();
                System.out.println("Enter Customer First name :");
                customer.setFirstName(sc.next());
                System.out.println("Enter Customer Last name:");
                customer.setLastName(sc.next());

                customer.setEmail(v.getEmail(sc,"Enter Customer EMail ID:"));
                System.out.println("Enter Customer Cus.no :");
                customer.setCustomerno(sc.next());
                System.out.println("please check the data entered");
                System.out.println(customer.getDisplayText());

            } else if (core.equalsIgnoreCase("E")) {

                Employee employee = new Employee();
                System.out.println("Enter Employee First name :");
                employee.setFirstName(sc.next());
                System.out.println("Enter Employee Last name:");
                employee.setLastName(sc.next());

                employee.setEmail(v.getEmail(sc,"Enter Employee EMail ID:"));
                v.getSSnVeri(sc,"Enter Employee SSN:");
                employee.setSsNo(sc.next());
                System.out.println(employee.getDisplayText());


            } else System.out.println("Error, Please input either E or C");

            c = v.getchoice(sc,"Continue? (y/n):");

        }while(c.equalsIgnoreCase("y"));
    }


}

