package SU4;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FilterFile {
    public static void main(String[] args) {

        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        if (!inputFile.exists()) {
            System.err.println("Грешка: Файлът input.txt не съществува!");
            return;
        }

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            writer.write("Филтриран файл, генериран на: " + now.format(formatter));
            writer.newLine();

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                if (line.trim().startsWith("#")) {
                    continue;
                }

                writer.write(line);
                writer.newLine();
            }

            System.out.println("Файлова обработка завършена успешно!");

        } catch (IOException e) {
            System.err.println("Грешка при обработка на файловете: " + e.getMessage());
        }
    }
}
