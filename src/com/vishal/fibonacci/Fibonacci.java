package com.vishal.fibonacci;

public class Fibonacci {

    public static void main(String[] args) {
        int fib = fib(7);
        System.out.println(fib);
    }

    private static int fib(int i) {

        if(i == 0 || i == 1) {
            return i;
        }

        return fib(i - 1) + fib(i - 2);
    }
}
