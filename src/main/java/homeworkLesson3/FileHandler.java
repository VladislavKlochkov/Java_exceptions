package homeworkLesson3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {
    public static void createFile(String text, String fileName) {
        boolean fileIndicator = false;
        String str = "";
        if (Files.exists(Path.of(fileName + ".txt"))) {
            str = readFile(fileName);
            if (!str.contains(text)) {
                writerFile(fileName, text, true);
                System.out.println("Данные успешно добавлены");
            } else {
                System.out.println("Данные существуют");
            }
        } else {
            writerFile(fileName, text, fileIndicator);
            System.out.println("Файл " + fileName + ".txt успешно создан");
        }
    }

    public static String readFile(String fileName) {
        try (FileReader reader = new FileReader(fileName + ".txt")) {
            int item;
            StringBuilder str = new StringBuilder();
            while ((item = reader.read()) != -1) {
                str.append((char) item);
            }
            return str.toString();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла " + e);
        }
    }

    public static void writerFile(String fileName, String text, boolean indicator) {
        try (FileWriter writer = new FileWriter(fileName + ".txt", indicator)) {
            writer.write(text + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи файла" + e);
        }
    }
}
