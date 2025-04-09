package com.example.sqlinjectiontest;

public class Main {
    public static void main(String[] args) {
        System.out.println("Resultado suma: " + sumar(2, 3));
    }

    public static int sumar(int a, int b) {
        return a + b;
    }
}
