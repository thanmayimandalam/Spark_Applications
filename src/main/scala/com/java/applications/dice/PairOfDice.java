package com.java.applications.dice;

import org.stringtemplate.v4.ST;
import scala.tools.cmd.gen.AnyVals;

import java.util.Scanner;

/**
 * Created by adity on 7/2/2018.
 */
public class PairOfDice {
    Die dice = new Die();

    Scanner sc = new Scanner(System.in);
    int rollcount = 0;


    public static void main(String args[]){
    

    System.out.println("Welcome to the Paradise Roller application");
    new PairOfDice().choice();


   }
   public void test(){

    int dice1 = dice.getValue1();
    int dice2 = dice.getValue2();
    boolean isValid = false;
    while(isValid == false){
        dice.roll();
        rollcount++;
        System.out.println("First Dice"+"  "+dice.getValue1()+"  "+"second dice" +"  "+dice.getValue2());
        System.out.println(" Roll"+"  "+rollcount);
        choice();
        if ((dice1 == 6 && dice2 == 6)){
            System.out.println("First Dice"+"  "+dice.getValue1()+"  "+"second dice" +"  "+dice.getValue2());
            System.out.println(" Roll"+"  "+rollcount);
            choice();
            System.out.println("Box cars");


        }else if ((dice1 == 1 && dice2 == 1)){
            System.out.println("First Dice"+"  "+dice.getValue1()+"  "+"second dice" +"  "+dice.getValue2());
            System.out.println(" Roll"+"  "+rollcount);
            choice();
            System.out.println("Snake Eyes");


        }else {
            dice.roll();

            rollcount++;


        }
     isValid = true;

    }


   }

    public void choice(){
        //PairOfDice PD = new PairOfDice();
        Scanner sc = new Scanner(System.in);
        System.out.print("Roll the dice? (y/n):");
        String letter = sc.nextLine();
        if (letter.equalsIgnoreCase("Y")){
            test();
        }else System.out.println("Good Bye!!!");

    }




}
