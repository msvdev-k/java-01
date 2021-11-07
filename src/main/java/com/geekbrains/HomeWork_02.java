package com.geekbrains;

public class HomeWork_02 {

    public static void main(String[] args) {

        System.out.println("Задание № 1");
        boolean out = within10and20(6, 15);
        System.out.println(out);

        System.out.println("================\n");
        System.out.println("Задание № 2");
        isPositiveOrNegative(0);

        System.out.println("================\n");
        System.out.println("Задание № 3");
        out = isNegative(-10);
        System.out.println(out);

        System.out.println("================\n");
        System.out.println("Задание № 4");
        printWordNTimes("Строка текста", 10);

        System.out.println("================\n");
        System.out.println("Задание № 5");
        out = isLeapYear(2024);
        System.out.println(out);

    }


    public static boolean within10and20(int x1, int x2) {

        int sum = x1 + x2;

        if (sum >= 10 && sum <= 20) {
            return true;
        }

        return false;

    }


    public static void isPositiveOrNegative(int x) {

        if (x >= 0) {
            System.out.println("Передаваемое число положительное.");
        } else {
            System.out.println("Передаваемое число отрицательное.");
        }

    }


    public static boolean isNegative(int x) {

        if (x < 0) {
            return true;
        }
        return false;

    }


    public static void printWordNTimes(String word, int times) {

        for (int i = 0; i < times; i++) {
            System.out.println(word);
        }

    }


    public static boolean isLeapYear(int year){

        if (year % 4 == 0) {

            if (year % 100 == 0 && year % 400 != 0) {
                return false;
            }

            return true;
        }

        return false;

    }


}
