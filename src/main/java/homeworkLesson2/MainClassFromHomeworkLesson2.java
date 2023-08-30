package homeworkLesson2;

import java.util.Scanner;

public class MainClassFromHomeworkLesson2 {
    public static void main(String[] args) {
        inputFlagNumberTask1();
        codeFixTask2();
        codeFixTask3();
        throwExeptionEmptyStringTask4();
    }
    private static void inputFlagNumberTask1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число в виде десятичной дроби: ");
        String number = scanner.nextLine();
        try {
            float num = Float.parseFloat(number);
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат данных!");
            inputFlagNumberTask1();
        }
        scanner.close();
    }
    private static void codeFixTask2() {
        int[] intArray = {1, 5, 7, 6, 4, 25, 17, -9, 70, -8};
//        int[] intArray = {1, 5, 7, -9, 0, 70, -8};
//        Integer[] intArray = {1, 5, 6, 4, 25, 17, -9, 7, null, 70};
        try {
            int d = 2;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException | NullPointerException e) {
            System.out.println("Catching exception: " + e);
        }
    }
    private static void codeFixTask3() {
        {
            try {
                int a = 90;
                int b = 3;
                System.out.println(a / b);
                printSum(23, 234);
                int[] abc = {1, 2};
                abc[3] = 9;
            } catch (NullPointerException ex) {
                System.out.println("Указатель не может указывать на null!");
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Массив выходит за пределы своего размера!");
            } catch (Throwable ex) {
                System.out.println("Что-то пошло не так...");
            }
        }
    }
    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }
    private static void throwExeptionEmptyStringTask4() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите данные: ");
        String str = scanner.nextLine();
        if (str.isEmpty()){
            throw new RuntimeException("Пустые строки вводить нельзя!");
        }
        scanner.close();
    }
}