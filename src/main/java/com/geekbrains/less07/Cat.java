package com.geekbrains.less07;

public class Cat {

    private final String name;

    private final int appetite;


    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }



    public void eat(Plate p) {
        p.decreaseFood(appetite);
    }



    public String getName() {
        return name;
    }

}
