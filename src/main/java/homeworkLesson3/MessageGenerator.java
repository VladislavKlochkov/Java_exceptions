package homeworkLesson3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MessageGenerator {
    public static void inputDataArray(String[] userData) {
        int count = 0;
        if (userData.length < 6) {
            System.out.println("Вы ввели меньше данных чем требуется, введите строку заново");
            count++;
        }
        if (userData.length > 6) {
            System.out.println("Вы ввели больше данных чем требуется, введите строку заново");
            count++;
        } else {
            if (!userData[0].matches("[а-яА-Яa-zA-Z]+")) {
                System.out.println("Некорректный ввод фамилии, введите данные заново");
                count++;
            }
            if (!userData[1].matches("[а-яА-Яa-zA-Z]+")) {
                System.out.println("Некорректный ввод имени, введите данные заново");
                count++;
            }
            if (!userData[2].matches("[а-яА-Яa-zA-Z]+")) {
                System.out.println("Некорректный ввод отчества, введите данные заново");
                count++;
            }
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            try {
                df.parse(userData[3]);
            } catch (ParseException e) {
                System.out.println("Неверный формат даты, введите данные заново");
                count++;
            }
            try {
                Long.parseLong(userData[4]);
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат телефона, введите данные заново");
                count++;
            }
            if (!userData[5].equalsIgnoreCase("f") && !userData[5].equalsIgnoreCase("m")) {
                System.out.println("Неверный ввод пола, введите данные заново");
                count++;
            }
        }
        if (count == 0) {
            StringBuilder text = new StringBuilder();
            for (int i = 0; i < userData.length; i++) {
                if (i == userData.length - 1) {
                    text.append(userData[i]);
                } else {
                    text.append(userData[i]).append(" ");
                }
            }
            FileHandler.createFile(text.toString(), userData[0]);
        }
    }
}
