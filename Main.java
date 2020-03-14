package com.company;
import java.util.Scanner;
import java.lang.Math;


public class Main {

    public static int reverse(int x){
        int c = 0, i = 0;
        while (x != 0){
            c = c * 10 + (x % 10);
            x /= 10;
            i++;
        }

        return c;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt(), b = scan.nextInt();
        int a1 = a, b1 = b;
        a = reverse(a);
        System.out.println(a);
        b = reverse(b);
        System.out.println(b);
        if(a > b)
            System.out.println(b1 + " < " + a1);
        else if(b > a)
            System.out.println(a1 + " < " + b1);
        else
            System.out.println(a1 + " = " + b1);

    }


}
