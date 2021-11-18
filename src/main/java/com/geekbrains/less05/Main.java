package com.geekbrains.less05;

public class Main {
    public static void main(String[] args) {

        /* Создать массив из 5 сотрудников.
            Пример:
            Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
            persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
            persArray[1] = new Person(...);
            ...
            persArray[4] = new Person(...);
            С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
        */

        Person[] staff = new Person[5];

        staff[0] = new Person("Иванов В.С.", "Инженер", "ivanov@mailbox.com", "892312312", 60000, 36);
        staff[1] = new Person("Петров Д.С.", "Старший инженер", "petrov@mailbox.com", "892312303", 70000, 41);
        staff[2] = new Person("Никитин К.Н.", "Консультант", "nikitin@mailbox.com", "892312394", 35000, 30);
        staff[3] = new Person("Семёнов П.К.", "Младший иженер", "semionov@mailbox.com", "892312385", 40000, 25);
        staff[4] = new Person("Берестов Н.А.", "Ведущий инженер", "berestov@mailbox.com", "892312376", 80000, 47);


        for (int i = 0; i < 5; i++) {
            if (staff[i].getAge() > 40) {

                System.out.println("--------------");
                staff[i].printInfo();

            }
        }



    }
}
