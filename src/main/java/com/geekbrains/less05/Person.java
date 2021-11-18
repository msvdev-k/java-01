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


    /* Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.*/
    public void printInfo() {

        System.out.println("ФИО сотрудника: " + this.name);
        System.out.println("Должность: " + this.function);
        System.out.println("Электронная почта: " + this.email);
        System.out.println("Телефон: " + this.phone);
        System.out.println("Зарплата: " + this.salary);
        System.out.println("Возраст: " + this.age);

    }


    public String getName() {
        return this.name;
    }

    public String getFunction() {
        return this.function;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public double getSalary() {
        return this.salary;
    }

    public int getAge() {
        return this.age;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
