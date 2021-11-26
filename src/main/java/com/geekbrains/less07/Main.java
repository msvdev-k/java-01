package com.geekbrains.less07;

public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat("Барсик", 5);
        Plate plate = new Plate(100);

        plate.info();
        
        cat.eat(plate);

        plate.info();

    }
}
