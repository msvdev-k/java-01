package com.geekbrains.less07;

public class Plate {

    private int food;



    public Plate(int food) {
        this.food = food;
    }
    


    public void info() {
        System.out.println("В тарелке " + food + " единиц еды.");
    }

}
