package com.geekbrains.less06;

public class Animal {

    // Кличка животного
    private final String name;

    // Количество животных
    private static int animalCount = 0;

    // Максимальная длина, которую может пробежать животное в метрах
    private final int maxRunDist;

    // Максимальная дистанция, которую животное может проплыть в метрах
    private final int maxSwimDist;



    public Animal(String name, int maxRunDist, int maxSwimDist) {

        this.name = name;
        this.maxRunDist = maxRunDist;
        this.maxSwimDist = maxSwimDist;

        animalCount++;
    }



    public void run(int dist) {

        if (maxRunDist <= 0) {
            System.out.println(name + " не умеет бегать!");
        }
        else if (dist > maxRunDist) {
            System.out.print(name + " пробежал(а) " + maxRunDist + " м. ");
            System.out.println(name + " больше бежать не может.");
        }
        else {
            System.out.println(name + " пробежал(а) " + dist + " м.");
        }

    }



    public void swim(int dist) {

        if (dist <= maxSwimDist) {
            System.out.println(name + " проплыл(а) " + dist + " м.");
        }
        else if (maxSwimDist > 0) {
            System.out.println(name + " проплыл(а) " + maxSwimDist + " м.");
        }
        else {
            System.out.println(name + " не умеет плавать!");
        }

    }



    public static int count() {
        return animalCount;
    }


    public String getName() {
        return name;
    }



}
