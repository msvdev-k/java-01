package com.geekbrains;

public class HomeWork_03 {

    public static void main(String[] args) {

        System.out.println("Задание № 1");
        invertArray();

        System.out.println("================\n");
        System.out.println("Задание № 2");
        fillArray();

        System.out.println("================\n");
        System.out.println("Задание № 3");
        changeArray();

        System.out.println("================\n");
        System.out.println("Задание № 4");
        fillDiagonal();

        System.out.println("================\n");
        System.out.println("Задание № 5");
        int[] arr5 = newArray(6, 15);
        printArray1D(arr5);

        System.out.println("================\n");
        System.out.println("Задание № 6");
        searchMinMaxValue();

        System.out.println("================\n");
        System.out.println("Задание № 7");
        int[] arr71 = {6, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(arr71));
        printArray1D(arr71, findBalance(arr71));

        int[] arr72 = {1, 1, 1, 2, 1};
        System.out.println(checkBalance(arr72));
        printArray1D(arr72, findBalance(arr72));

        int[] arr73 = {1};
        System.out.println(checkBalance(arr73));
        printArray1D(arr73, findBalance(arr73));

        int[] arr74 = {1,1};
        System.out.println(checkBalance(arr74));
        printArray1D(arr74, findBalance(arr74));

        int[] arr75 = {1,1,2};
        System.out.println(checkBalance(arr75));
        printArray1D(arr75, findBalance(arr75));

        int[] arr76 = {4,4,4};
        System.out.println(checkBalance(arr76));
        printArray1D(arr76, findBalance(arr76));

        System.out.println("================\n");
        System.out.println("Задание № 8");
        for (int i = -5; i <= 5; i++) {

            int[] arr81 = {1, 2, 3};
            int[] arr82 = {1, 3, 5, 6};

            printArray1D(arr81);
            System.out.println("При n = " + i);
            shiftArray(arr81, i);
            printArray1D(arr81);

            System.out.println("-----");

            printArray1D(arr82);
            System.out.println("При n = " + i);
            shiftArray(arr82, i);
            printArray1D(arr82);

            System.out.println("-----");
        }

    }

    public static void printArray1D(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void printArray1D(int[] arr, int delimiterIndex) {

        for (int i = 0; i < arr.length; i++) {
            if (i == delimiterIndex) {
                System.out.print("||| ");
            }
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }


    public static void printArray2D(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* Задать целочисленный массив, состоящий из элементов 0 и 1.
       Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
       С помощью цикла и условия заменить 0 на 1, 1 на 0.
     */
    public static void invertArray() {

        int[] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };

        printArray1D(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            }
            else {
                arr[i] = 0;
            }
        }

        printArray1D(arr);
    }



    /* Задать пустой целочисленный массив длиной 100.
       С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100.
     */
    public static void fillArray() {

        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        printArray1D(arr);
    }


    /* Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
       пройти по нему циклом, и числа меньшие 6 умножить на 2.
     */
    public static void changeArray() {

        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        printArray1D(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }

        printArray1D(arr);
    }


    /* Создать квадратный двумерный целочисленный массив
       (количество строк и столбцов одинаковое),
       и с помощью цикла(-ов) заполнить его диагональные элементы единицами
       (можно только одну из диагоналей, если обе сложно).
       Определить элементы одной из диагоналей можно по следующему принципу:
       индексы таких элементов равны, то есть [0][0], [1][1], [2][2], ..., [n][n].
     */
    public static void fillDiagonal() {

        int n = 11;
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            arr[i][i] = 1;
            arr[i][n-i-1] = 1;
        }

        printArray2D(arr);
    }


    /* Написать метод, принимающий на вход два аргумента:
       len и initialValue, и возвращающий одномерный массив типа int длиной len,
       каждая ячейка которого равна initialValue.
     */
    public static int[] newArray(int len, int initialValue) {

        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }

        return arr;
    }


    /* Задать одномерный массив и найти в нем минимальный и максимальный элементы.
     */
    public static void searchMinMaxValue() {

        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, -9, 1 };

        printArray1D(arr);

        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (min > arr[i]) {
                min = arr[i];
            }

            if (max < arr[i]) {
                max = arr[i];
            }
        }

        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
    }


    /* Написать метод, в который передается не пустой одномерный целочисленный массив,
       метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой
       части массива равны.
       Примеры:
       checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) -> true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
       checkBalance([1, 1, 1, ||| 2, 1]) -> true, т.е. 1 + 1 + 1 = 2 + 1
       граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.
     */
    public static int findBalance(int[] arr) {

        int leftSum = 0;
        int rightSum = 0;

        int i = 0;
        int j = arr.length - 1;

        while (i <= j) {

            if (leftSum < rightSum) {
                leftSum += arr[i];
                i++;
            }
            else if (leftSum > rightSum) {
                rightSum += arr[j];
                j--;
            }
            else if (i == j) {
                break;
            }
            else {
                leftSum += arr[i];
                rightSum += arr[j];
                i++;
                j--;
            }
        }

        if (i > j && leftSum == rightSum) {
            return i;
        }

        return -1;
    }

    public static boolean checkBalance(int[] arr) {
        if (findBalance(arr) > 0) {
            return true;
        }
        return false;
    }

    /* Написать метод, которому на вход подается одномерный массив и число n
       (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива
       на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться
       вспомогательными массивами.
       Примеры:
       [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
       [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
       При каком n в какую сторону сдвиг можете выбирать сами.
     */
    public static void shiftArray(int[] arr, int n) {

        n %= arr.length;

        if (n < 0) {
            n += arr.length;
        }
        else if (n == 0) {
            return;
        }

        int a = n;
        int b = arr.length;

        while (a != b) {
            b -= a;
            if (b < a) {
                int tmp = a;
                a = b;
                b = tmp;
            }
        }

        for (int i = 0; i < a; i++) {

            int j = i + n;
            int left = arr[i];

            while (i != j) {

                int right = arr[j];
                arr[j] = left;
                left = right;

                j += n;
                if (j >= arr.length) {
                    j -= arr.length;
                }
            }
            arr[i] = left;
        }

    }

}
