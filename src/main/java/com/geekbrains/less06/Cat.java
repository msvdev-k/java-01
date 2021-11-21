package com.geekbrains.less06;


public class Cat extends Animal {

    // Количество кошек
    private static int catCount = 0;


    public Cat(String name) {
        super(name, 200, 0);

        catCount++;
    }


    public static int getCount() {
        return catCount;
    }

}
