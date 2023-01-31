package com.geekbrains.less06;

public class Main {
    public static void main(String[] args) {

        Animal[] animals = new Animal[9];

        animals[0] = new Dog("Дружёк");
        animals[1] = new Dog("Мухтар");
        animals[2] = new Dog("Черныш");
        animals[3] = new Dog("Азор");
        animals[4] = new Dog("Бальтазар");

        animals[5] = new Cat("Шон");
        animals[6] = new Cat("Барсик");
        animals[7] = new Cat("Муся");
        animals[8] = new Cat("Мурка");

        System.out.println("Количество животных: " + Animal.count());
        System.out.println("Количество собак: " + Dog.count());
        System.out.println("Количество кошек: " + Cat.count());

        System.out.println("---------------");
        System.out.println("Бег животных");
        animals[0].run(50);
        animals[1].run(150);
        animals[2].run(250);
        animals[3].run(250);
        animals[4].run(550);
        animals[5].run(50);
        animals[6].run(150);
        animals[7].run(250);
        animals[8].run(350);

        System.out.println("---------------");
        System.out.println("Плавание животных");
        animals[0].swim(2);
        animals[1].swim(5);
        animals[2].swim(7);
        animals[3].swim(9);
        animals[4].swim(12);
        animals[5].swim(5);
        animals[6].swim(1);
        animals[7].swim(2);
        animals[8].swim(3);



    }
}
