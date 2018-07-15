package com.java.applications.dice;

import java.util.Scanner;

/**
 * Created by adity on 7/2/2018.
 */
public class Die {
    int sides1,sides2;

    public  Die(){
        roll();
    }
    public void roll(){

        sides1 = (int)(Math.random()*6);
        sides2 = (int)(Math.random()*6);
    }

    public int getValue1(){

        return sides1;
    }

    public int getValue2(){

        return sides2;
    }

    public int getSum(){

        int sum = sides1 + sides2;
         return sum;
    }






    }


