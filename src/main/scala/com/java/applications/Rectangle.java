package com.java.applications;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Scanner;

/**
 * Created by thanu on 6/28/2018.
 */
public class Rectangle {


   Scanner sc = new Scanner(System.in);

    public static void main(String args[])
    {
        Rectangle rec = new Rectangle();
        System.out.println("Welcome to the Area and Perimeter Calculator");
        rec.core();
    }

    public void core(){

        double length,width;
        length = Utils.getDoubleWithinRange(
                "\nPlease enter the lenght of rectangle : ", 0, 1000);

        width = Utils.getDoubleWithinRange(
                "\nPlease enter the width of rectangle : ", 0, 1000);

        System.out.println("\nthe perimeter of a rectangle is : "
                + (length * width));
        System.out.println("\nthe perimeter of a rectangle is : "
                + (2 * (length + width)));
        confirmer();

    }

    public  void confirmer(){

        String letter;
        System.out.print("Continue (Y/N) ?\n");
        letter = sc.nextLine();
        if (letter == "Y" || letter == "y")
        {
            core();

        }else {
            System.out.println("TY");
            System.exit(1);
        }

    }
}
