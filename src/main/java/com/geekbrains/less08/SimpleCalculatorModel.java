package com.geekbrains.less08;

public class SimpleCalculatorModel {

    private String display;

    private boolean isStartNewValue;
    private boolean isInsertedPoint;

    private double register;

    private Operator operator;


    public SimpleCalculatorModel() {

        clear();

    }

    /**
     * Вычислить выражение.
     */
    public void claculation() {

    }

    /**
     * Оператор умножения.
     */
    public void multiplication() {

    }

    /**
     * Оператор деления.
     */
    public void division() {

    }

    /**
     * Оператор сложения.
     */
    public void addition() {

    }

    /**
     * Оператор вычитания.
     */
    public void subtraction() {

    }


    /**
     * Сброс параметров в исходное состояние.
     */
    public void clear() {

        display = "0";
        isStartNewValue = true;
        isInsertedPoint = false;
        register = 0.0;
        operator = new Operator() {
            @Override
            public double evaluate(double a, double b) {
                return a;
            }
        };


    }


    /**
     * Ввод очередной цифры.
     * @param digit Вводимая цифра от 0 до 9.
     */
    public void addDigit(int digit) {

        if (isStartNewValue) {
            if (digit > 0) {
                display = "" + digit;
                isStartNewValue = false;
            }
        }
        else {
            display += digit;
        }

    }


    /**
     * Воод десятичной точки.
     */
    public void addPoint() {
        if (!isInsertedPoint) {
            display += ".";
            isInsertedPoint = true;
            isStartNewValue = false;
        }
    }


    /**
     * Получить значение, отображаемое на дисплее.
     * @return Отображаемое на дисплее значение.
     */
    public String getDisplayText() {
        return display;
    }



    private interface Operator {
        public double evaluate(double a, double b);
    }


}
