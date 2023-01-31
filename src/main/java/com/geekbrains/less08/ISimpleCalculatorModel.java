package com.geekbrains.less08;

public interface ISimpleCalculatorModel {

    /**
     * Вычислить выражение.
     */
    void calculation();

    /**
     * Оператор умножения.
     */
    void multiplication();

    /**
     * Оператор деления.
     */
    void division();

    /**
     * Оператор сложения.
     */
    void addition();

    /**
     * Оператор вычитания.
     */
    void subtraction();


    /**
     * Сброс параметров в исходное состояние.
     */
    void clear();


    /**
     * Ввод очередной цифры.
     * @param digit Вводимая цифра от 0 до 9.
     */
    void addDigit(int digit);


    /**
     * Ввод десятичной точки.
     */
    void addPoint();


    /**
     * Получить значение, отображаемое на дисплее.
     * @return Отображаемое на дисплее значение.
     */
    String getDisplayText();

}
