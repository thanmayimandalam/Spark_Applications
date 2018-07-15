package com.java.applications;

/**
 * Created by adity on 6/28/2018.
 */
public class Test {

    int number;
    String name;

    static int sal = 10000;
    static String country = "brazil";

    public static void main(String args[]){

        String region = "asdf";

        String asdf = null;
        Test ref = new Test();

       System.out.println(ref.number);
        System.out.println(ref.name);
        System.out.println(asdf);
       //System.out.println(ref.number);

        //System.out.println(sal);
    }

    public void f1(){

        System.out.println(number);
        System.out.println(sal);
    }

    public void testing(){
        System.out.println("this is only for testing");
    }

}
