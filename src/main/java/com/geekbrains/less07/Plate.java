package com.geekbrains.less07;

public class Plate {

    private int food;


    public Plate(int food) {
        this.food = food;
    }



    public boolean decreaseFood(int n) {

        int food = this.food - n;

        if (food >= 0) {
            this.food = food;
            return true;
        }

        return false;
    }



    public void addFood(int food) {
        this.food += food;
        System.out.printf("В тарелку добавлено %s единиц еды.", food);
        System.out.println();
    }


    public void info() {
        System.out.println("В тарелке " + food + " единиц еды.");
    }

}
