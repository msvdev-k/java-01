package com.geekbrains.less07;

public class Main {
    public static void main(String[] args) {

        Cat[] cats = new Cat[5];

        cats[0] = new Cat("Барсик", 5);
        cats[1] = new Cat("Вася", 15);
        cats[2] = new Cat("Мурка", 12);
        cats[3] = new Cat("Шон", 8);
        cats[4] = new Cat("Комок", 2);


        Plate plate = new Plate(30);
        plate.addFood(8);

        plate.info();

        for (Cat cat: cats) {
            cat.eat(plate);
        }

        plate.info();

        for (Cat cat: cats) {
            System.out.print(cat.getName());
            if (cat.isSatiety()) {
                System.out.println(" наелся(лась).");
            } else {
                System.out.println(" не наелся(лась).");
            }
        }


    }
}
