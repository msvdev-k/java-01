package com.geekbrains.less07;

public class Cat {

    private final String name;

    private final int appetite;

    private boolean satiety;



    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }



    public void eat(Plate p) {

        if (satiety) {
            System.out.printf("%s не хочет есть.", name);

        } else {

            satiety = p.decreaseFood(appetite);

            if (satiety) {
                System.out.printf("%s наелся(ась).", name);
            } else {
                System.out.printf("%s не смог(ла) поесть. В тарелке мало еды.", name);
            }
        }
        System.out.println();

    }



    public String getName() {
        return name;
    }

}
