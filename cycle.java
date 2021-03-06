  
/**
* Cycle? practice
* 
* (c) Yaroslav Kasperovhych
* MIT License
* /

package com.company;

import java.lang.reflect.Field;

public class Main {
    // Facts about myself
    int age = 22;
    boolean isStudent = true;
    String position = "full stack web developer; team leader @ datacrafts.io";
    double salary = 0.0;
    float wishedSalary = 999999.9f;
    char firstCharInFirstName = 'Y';
    byte limbsCount = 4;
    long height = 1000000000000000l;

    public static void main(String[] args) throws IllegalAccessException {
        printFacts();

        String palindrome = "ABBA";
        System.out.println(String.format("%s is %s", palindrome, checkPalindrome(palindrome) ? "a palindrome" : "not a palindrome"));
        System.out.println(String.format("Area equals to %s", getArea()));
    }
    
    // Fact printing methods
    private static void printFacts() throws IllegalAccessException {
        Main fakeInstance = new Main();

        for (Field field : Main.class.getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println(String.format("%s is %s", field.getName(), field.get(fakeInstance).toString()));
        }
    }

    // Palindrome method
    private static boolean checkPalindrome(String possiblyPalindrome) {
        String pureString = possiblyPalindrome.replaceAll("[^a-zA-Z]", "").toLowerCase();
        StringBuilder sb = new StringBuilder(pureString);

        return pureString.equals(sb.reverse().toString());
    }

    // Iterative computing method
    private static double getArea() {
        double range = 3.14;
        double y = 0.8f;
        double dx = 0.01;
        double area = 0.0;
        
        for (double x = 0; x < range; x+= dx)
        {
            double sin = Math.sin(x);
            if (sin <= y) {
                area += sin * dx;
            } else {
                area += dx * y;
            }            
        }

        return area;
    }
}

