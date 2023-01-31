package com.geekbrains.less08;

public class SimpleCalculatorModel implements ISimpleCalculatorModel{

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
    public void calculation() {

        register = operator.evaluate(Double.parseDouble(display), register);
        display = String.valueOf(register);
        operator = (display, register) -> display;
        isStartNewValue = true;
        isInsertedPoint = false;

    }

    /**
     * Оператор умножения.
     */
    public void multiplication() {
        calculation();
        operator = (display, register) -> register * display;
    }

    /**
     * Оператор деления.
     */
    public void division() {
        calculation();
        operator = (display, register) -> register / display;
    }

    /**
     * Оператор сложения.
     */
    public void addition() {
        calculation();
        operator = (display, register) -> register + display;
    }

    /**
     * Оператор вычитания.
     */
    public void subtraction() {
        calculation();
        operator = (display, register) -> register - display;
    }


    /**
     * Сброс параметров в исходное состояние.
     */
    public void clear() {

        display = "0";
        isStartNewValue = true;
        isInsertedPoint = false;
        register = 0.0;
        operator = (display, register) -> display;


    }


    /**
     * Ввод очередной цифры.
     * @param digit Вводимая цифра от 0 до 9.
     */
    public void addDigit(int digit) {

        if (isStartNewValue) {
            if (digit > 0) {
                display = String.valueOf(digit);
                isStartNewValue = false;
            }
        }
        else {
            display += digit;
        }

    }


    /**
     * Ввод десятичной точки.
     */
    public void addPoint() {
        if (!isInsertedPoint) {
            if (isStartNewValue) {
                display = "0.";
                isStartNewValue = false;
            }
            else {
                display += ".";
            }
            isInsertedPoint = true;
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
        double evaluate(double display, double register);
    }


}
