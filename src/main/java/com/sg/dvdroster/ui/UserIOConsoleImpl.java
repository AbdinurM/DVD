/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdroster.ui;

import java.util.Scanner;

/**
 *
 * @author Nur
 */
public class UserIOConsoleImpl implements UserIO {
    Scanner sc = new Scanner(System.in);

    public double readDouble(String prompt) {
        System.out.println(prompt);
        double num = Double.parseDouble(sc.nextLine());
        return num;

    }

    public double readDouble(String prompt, double min, double max) {
        System.out.println(prompt);
        double num = Double.parseDouble(sc.nextLine());
        while (min > num || max < num) {
            System.out.println("Error, number not in range");
        num = Double.parseDouble(sc.nextLine());

        }
        return num;
    }

    public float readFloat(String prompt) {
        System.out.println(prompt);
        float num = Float.parseFloat(sc.nextLine());
        return num;
    }

    public float readFloat(String prompt, float min, float max) {
        System.out.println(prompt);
        float num = Float.parseFloat(sc.nextLine());
        while (min < num || max < num) {
            System.out.println("Error, number not in range");
         num = Float.parseFloat(sc.nextLine()); 

        }
        return num;
    }

    public int readInt(String prompt) {
        System.out.println(prompt);
         int num = Integer.parseInt(sc.nextLine());
        return num;
    }

    public int readInt(String prompt, int min, int max) {
        System.out.println(prompt);
        int num = Integer.parseInt(sc.nextLine());
        while (min > num || max < num) {
            System.out.println("Error, number not in range");
        num = Integer.parseInt(sc.nextLine());

        }
        return num;
    }

    public long readLong(String prompt) {
        System.out.println(prompt);
        long num = Long.parseLong(sc.nextLine());
        return num;
    }

    public long readLong(String prompt, long min, long max) {
        System.out.println(prompt);
        long num = Long.parseLong(sc.nextLine());
        while (min < num || max < num) {
            System.out.println("Error, number not in range");
        num = Long.parseLong(sc.nextLine());    
        
        }
        return num;
    }

    public String readString(String prompt) {
        System.out.println(prompt);
        String num = sc.nextLine();
        return num;
    }

    public void print(String message) {
        System.out.println(message);

    }  
}
