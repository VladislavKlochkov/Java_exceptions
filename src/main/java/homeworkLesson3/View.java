package homeworkLesson3;

import java.util.Scanner;

public class View {
    public static void dataInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите данные пользователя через пробел в формате: \n" +
                "Фамилия Имя Отчество дата_рождения номер_телефона пол \n" +
                "\n" +
                "Формат ввода данных: \n" +
                "Фамилия (на латинице или кириллице) \n" +
                "Имя (на латинице или кириллице) \n" +
                "Отчество (на латинице или кириллице) \n" +
                "Дата_рождения (в формате dd.MM.yyyy) \n" +
                "Номер_телефона (в формате 79999999999) \n" +
                "пол (символ f - женский, m - мужской)");
        System.out.println();
        System.out.println("Введите Exit для выхода из программы");
        boolean run = true;
        while (run) {
            String[] arr = sc.nextLine().split(" ");
            if (arr[0].equalsIgnoreCase("Exit")) {
                break;
            }
            MessageGenerator.inputDataArray(arr);
        }
    }
}
