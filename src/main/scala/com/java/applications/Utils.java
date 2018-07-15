package com.java.applications;

import java.util.Scanner;

/**
 * Created by adity on 6/28/2018.
 */
public class Utils {


    public static double getDouble(String prompt) {


        Scanner sc = new Scanner(System.in);

        double d = 0.0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine(); // discard any other data entered on the line
        }
        return d;

    }

    public static double getDoubleWithinRange(String prompt, double min, double max) {

        double d = 0.0;
        boolean isValid = false;
        while (isValid == false) {
            d = getDouble(prompt);
            if (d < min)
                System.out.println("Error! Number must be greater than "
                        + (min - 1) + ".");
            else if (d > max)
                System.out.println("Error! Number must be less than "
                        + (max + 1) + ".");
            else
                isValid = true;
        }
        return d;
    }

    public static int getInt(String prompt) {


        Scanner sc = new Scanner(System.in);

        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine(); // discard any other data entered on the line
        }
        return i;

    }

    public static int getintWithinRange(String prompt, int min, int max) {

        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            i = getInt(prompt);
            if (i < min)
                System.out.println("Error! Number must be greater than "
                        + (min - 1) + ".");
            else if (i > max)
                System.out.println("Error! Number must be less than "
                        + (max + 1) + ".");
            else
                isValid = true;
        }
        return i;
    }

}
