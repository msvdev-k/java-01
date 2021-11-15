package com.geekbrains;

import java.util.Random;
import java.util.Scanner;

public class HomeWork_04 {

    /* Создание игрового поля.
     Игровое поле можно представить в виде символьного двумерного массива размером 3х3.
     В каждой ячейке массива могут находиться символы 'X', 'O', '•', которые означают
     фишки игроков и пустое поле. Для указания размера поля и количества фишек для победы
     добавим две константы SIZE и DOTS_TO_WIN.
     */
    public static char[][] map;
    public static final int SIZE = 3;
    public static final int SIZE_X = 5;
    public static final int SIZE_Y = 4;
    public static final int DOTS_TO_WIN = 3;

    /* Ячейки поля.
     Чтобы не забыть, какой символ за что отвечает, их можно записать в именные константы.
     */
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    /* Константы, определяющие направления на игровом поле.

       Четыре основных румба:
        NORTH - Север
        EAST  - Восток
        SOUTH - Юг
        WEST  - Запад

       Четыре румба, производных от основных:
        NORTH_WEST — Северо-запад
        NORTH_EAST — Северо-восток
        SOUTH_EAST — Юго-восток
        SOUTH_WEST — Юго-запад

       Направление от юга к северу соответствует увеличению координаты Y.
       Направление с запада на восток соответствует увеличению координаты X.

        NORTH_WEST  NORTH  NORTH_EAST     Y ^
              WEST         EAST             |
        SOUTH_WEST  SOUTH  SOUTH_EAST       |--->
                                                X
     */
    public static final int NORTH = 0;
    public static final int EAST  = 1;
    public static final int SOUTH = 2;
    public static final int WEST  = 3;
    public static final int NORTH_WEST = 4;
    public static final int NORTH_EAST = 5;
    public static final int SOUTH_EAST = 6;
    public static final int SOUTH_WEST = 7;




    public static void main(String[] args) {

        initMap();
        printMap();

        // Основной игровой цикл
        while (true) {

            humanTurn();
            printMap();

            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }

            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();

            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }

            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }


    /**
     * Метод, подсчитывающий количество идущих друг за другом идентичных элементов
     * на игровом поле вдоль соответствующих направлений. Идентичными считаются те
     * элементы, которые совпадают с центральным элементом.
     * @param x Координата центрального элемента вдоль оси X (от 0 до SIZE_X - 1).
     * @param y Координата центрального элемента вдоль оси Y (от 0 до SIZE_Y - 1).
     * @return Массив содержащий количество идущих друг за другом идентичных элементов
     *         вдоль всех 8-ми направлений. Индексы направлений в массиве определяются
     *         соответствующими константами (NORTH, EAST,SOUTH, WEST, NORTH_WEST,
     *         NORTH_EAST, SOUTH_EAST, SOUTH_WEST).
     */
    public static int[] numberOfMatchesAlongDirections(int x, int y) {

        int[] arr = new int[8];

        boolean north = true;
        boolean east  = true;
        boolean south = true;
        boolean west  = true;
        boolean north_west = true;
        boolean north_east = true;
        boolean south_east = true;
        boolean south_west = true;

        int shift = 1;

        while (north || east || south || west ||
               north_west || north_east || south_east || south_west) {

            int xMin = x - shift;
            int xMax = x + shift;
            int yMin = y - shift;
            int yMax = y + shift;


            if (xMin >= 0) {
                if (west && map[y][x] != map[y][xMin]) {
                    arr[WEST] = shift - 1;
                    west = false;
                }
            }
            else {
                if (west) {
                    arr[WEST] = shift - 1;
                    west = false;
                }
                if (north_west) {
                    arr[NORTH_WEST] = shift - 1;
                    north_west = false;
                }
                if (south_west) {
                    arr[SOUTH_WEST] = shift - 1;
                    south_west = false;
                }
            }


            if (xMax < SIZE_X) {
                if (east && map[y][x] != map[y][xMax]) {
                    arr[EAST] = shift - 1;
                    east = false;
                }
            }
            else {
                if (east) {
                    arr[EAST] = shift - 1;
                    east = false;
                }
                if (north_east) {
                    arr[NORTH_EAST] = shift - 1;
                    north_east = false;
                }
                if (south_east) {
                    arr[SOUTH_EAST] = shift - 1;
                    south_east = false;
                }
            }


            if (yMin >= 0) {
                if (south && map[y][x] != map[yMin][x]) {
                    arr[SOUTH] = shift - 1;
                    south = false;
                }
            }
            else {
                if (south) {
                    arr[SOUTH] = shift - 1;
                    south = false;
                }
                if (south_west) {
                    arr[SOUTH_WEST] = shift - 1;
                    south_west = false;
                }
                if (south_east) {
                    arr[SOUTH_EAST] = shift - 1;
                    south_east = false;
                }
            }


            if (yMax < SIZE_Y) {
                if (north && map[y][x] != map[yMax][x]) {
                    arr[NORTH] = shift - 1;
                    north = false;
                }
            }
            else {
                if (north) {
                    arr[NORTH] = shift - 1;
                    north = false;
                }
                if (north_west) {
                    arr[NORTH_WEST] = shift - 1;
                    north_west = false;
                }
                if (north_east) {
                    arr[NORTH_EAST] = shift - 1;
                    north_east = false;
                }
            }


            if (north_west && map[y][x] != map[yMax][xMin]) {
                arr[NORTH_WEST] = shift - 1;
                north_west = false;
            }

            if (north_east && map[y][x] != map[yMax][xMax]) {
                arr[NORTH_EAST] = shift - 1;
                north_east = false;
            }

            if (south_west && map[y][x] != map[yMin][xMin]) {
                arr[SOUTH_WEST] = shift - 1;
                south_west = false;
            }

            if (south_east && map[y][x] != map[yMin][xMax]) {
                arr[SOUTH_EAST] = shift - 1;
                south_east = false;
            }


            shift++;
        }


        return arr;
    }



    /* Инициализация поля.
     При запуске программы необходимо инициализировать поле и заполнить все его ячейки символом,
     обозначающим пустое поле.
     */
    public static void initMap() {

        map = new char[SIZE_Y][SIZE_X];

        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }


    /* Вывод поля в консоль.
     */
    public static void printMap() {

        for (int i = 0; i <= SIZE_X; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE_Y; i++) {

            System.out.print((i + 1) + " ");

            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }


    /* Метод, проверяющий отсутствие свободных ходов, то есть заполнено поле целиком или нет.
     */
    public static boolean isMapFull() {

        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }


    /* Mетод, отвечающий за ход человека-игрока.
     */
    public static Scanner sc = new Scanner(System.in);
    public static void humanTurn() {

        int x, y;

        do {
            System.out.println("Введите координаты в формате: Y X");
            y = sc.nextInt() - 1;
            x = sc.nextInt() - 1;
        } while (!isCellValid(x, y));

        map[y][x] = DOT_X;
    }


    /* Проверка ячеек.
     Метод проверяет возможность установки фишки в указанную ячейку.
     */
    public static boolean isCellValid(int x, int y) {

        if (x < 0 || x >= SIZE_X || y < 0 || y >= SIZE_Y) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }


    /* Ход компьютера.
     Для реализации хода компьютера достаточно чуть изменить метод хода игрока,
     добавив туда генератор случайных чисел.
     */
    public static Random rand = new Random();
    public static void aiTurn() {

        int x, y;

        do {
            x = rand.nextInt(SIZE_X);
            y = rand.nextInt(SIZE_Y);
        } while (!isCellValid(x, y));

        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));

        map[y][x] = DOT_O;
    }


    /* Проверка победы.
     Необходимо проверить все выигрышные комбинации. Если хотя бы одна будет найдена,
     вернуть true. В приведённом ниже варианте производится проверка всех возможных
      омбинаций с помощью 8 условий.
     */
    public static boolean checkWin(char symbol) {

        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {

                if  (map[i][j] == symbol) {

                    int[] arr = numberOfMatchesAlongDirections(j, i);

                    if (arr[WEST] + arr[EAST] + 1 >= DOTS_TO_WIN) return true;
                    if (arr[SOUTH] + arr[NORTH] + 1 >= DOTS_TO_WIN) return true;
                    if (arr[NORTH_WEST] + arr[SOUTH_EAST] + 1 >= DOTS_TO_WIN) return true;
                    if (arr[NORTH_EAST] + arr[SOUTH_WEST] + 1 >= DOTS_TO_WIN) return true;
                }
            }
        }

        return false;
    }


}
