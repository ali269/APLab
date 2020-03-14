package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt(), y = scan.nextInt(), x1 = scan.nextInt(), y1 = scan.nextInt();
        int x3 = scan.nextInt(), y3 = scan.nextInt();
        if(y3 == y)
            y = y1;
        else if(y3 != y1)
            y = y3;
        if(x3 == x)
            x = x1;
        else if(x3 != x1)
            x = x3;
        System.out.println(x + " " + y);
    }
}
