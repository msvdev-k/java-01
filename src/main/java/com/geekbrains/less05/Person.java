package com.geekbrains.less05;

public class Person {

    /* Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.*/

    private String name;
    private String function;
    private String email;
    private String phone;
    private double salary;
    private int age;

    /* Конструктор класса должен заполнять эти поля при создании объекта.*/
    public Person(String name, String function, String email, String phone, double salary, int age) {

        this.name = name;
        this.function = function;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;

    }



    



}
