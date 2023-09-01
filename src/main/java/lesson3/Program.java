package lesson3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Program {
    public static void main(String[] args) {

        try (Counter counter = new Counter()) {

            System.out.println(counter.getCount());
            System.out.println(counter.isStatus());
            counter.add();
            System.out.println(counter.getCount());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void rwLine(Path pathRead, Path pathWrite) {

        try (BufferedReader in = Files.newBufferedReader(pathRead);
             BufferedWriter out = Files.newBufferedWriter(pathWrite)) {
            out.write(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}