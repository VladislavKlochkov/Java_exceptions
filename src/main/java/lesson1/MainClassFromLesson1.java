package lesson1;

import java.util.Arrays;
import java.util.Scanner;

public class MainClassFromLesson1 {
    public static void main(String[] args) {
        System.out.println("Поиск числа в массиве");
        int[] array = new int[]{2, 5, -7, 12, 0};
//        int[] array = null;
        Scanner in = new Scanner(System.in);
        System.out.printf("Введите искомое число в массиве: ");
        int number = in.nextInt();
        int result = findNumberInArray(array, number);
        if (result == -1) {
            System.out.println("Код ошибки: " + result + " - Длина массива меньше заданного минимума");
        } else if (result == -2) {
            System.out.println("Код ошибки: " + result + " - Искомый элемент не найден");
        } else if (result == -3) {
            System.out.println("Код ошибки: " + result + " - null");
        } else {
            System.out.println("Индекс искомого числа в массиве: " + result);
        }


        int[][] twoDimensionalArray = new int[][]{
                {1, 1, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
//        int[][] twoDimensionalArray = new int[][]{
//                {1, 2, 0, 9},
//                {-7, 4, 9},
//                {5, 16, -34}
//        };
//        int[][] twoDimensionalArray = new int[][]{
//                {1, 2, 0},
//                {-7, 4, 9},
//                {5, 16, -34}
//        };
        System.out.println(sumElementsTwoDimensionalArray(twoDimensionalArray));


        checkArray(new Integer[]{3, null, -8, 57, null});


        int[] array1 = new int[]{5, -9, 82, 0, 4};
        int[] array2 = new int[]{-5, 9, -82, 0, -4};
        int[] array3 = new int[]{0, 3, 8, 5};
        System.out.println(Arrays.toString(arraysElementsSum(array1, array2)));
        System.out.println(Arrays.toString(arraysElementsSum(array1, array3)));
    }

    private static int findNumberInArray(int[] arr, int num) {
        Scanner in = new Scanner(System.in);
        System.out.printf("Введите минимальный размер массива: ");
        int minSize = in.nextInt();
        if (arr == null) {
            return -3;
        }
        if (arr.length < minSize) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -2;
    }

    private static int sumElementsTwoDimensionalArray(int[][] array2D) {
        int sumEl = 0;
        for (int i = 0; i < array2D.length; i++) {
            if (array2D.length != array2D[i].length) {
                throw new RuntimeException("Массив не квадратный!");
            }
            for (int j = 0; j < array2D[i].length; j++) {
                if (array2D[i][j] != 0 && array2D[i][j] != 1) {
                    throw new RuntimeException("Элемент массива не равен 0 или 1!");
                }
                sumEl += array2D[i][j];
            }
        }
        return sumEl;
    }

    private static void checkArray(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            try {
                if (arr[i] == null)
                    throw new NullPointerException("Элемент с индексом " + i + " равен null");
            } catch (NullPointerException exception) {
                exception.printStackTrace();
            }
        }
    }

    private static int[] arraysElementsSum(int[] arrOne, int[] arrTwo) {
        int[] newArr = null;
        try {
            if (arrOne.length != arrTwo.length)
                throw new RuntimeException("Длины массивов не равны!");
            newArr = new int[arrOne.length];
            for (int i = 0; i < arrOne.length; i++) {
                newArr[i] = arrOne[i] + arrTwo[i];
            }
            return newArr;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return newArr;
    }
}
