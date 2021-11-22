package com.geekbrains.less06;


public class Dog extends Animal {

    // Количество собак
    private static int dogCount = 0;


    public Dog(String name) {
        super(name, 500, 10);

        dogCount++;
    }


    public static int count() {
        return dogCount;
    }

}
