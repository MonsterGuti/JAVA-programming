package SU4;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BinaryStats {
    public static void main(String[] args) {

        String inputFile = "numbers.dat";
        String outputFile = "stats.txt";

        int count = 0;
        long sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        try (DataInputStream dis = new DataInputStream(new FileInputStream(inputFile))) {

            while (true) {
                int number = dis.readInt();
                count++;
                sum += number;

                if (number < min) min = number;
                if (number > max) max = number;
            }

        } catch (IOException e) {
        }

        double avg = (count > 0) ? (double) sum / count : 0;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("Count: " + count);
            writer.newLine();
            writer.write("Sum: " + sum);
            writer.newLine();
            writer.write("Avg: " + String.format("%.2f", avg));
            writer.newLine();
            writer.write("Min: " + min);
            writer.newLine();
            writer.write("Max: " + max);
        } catch (IOException e) {
            System.err.println("Грешка при запис в stats.txt: " + e.getMessage());
        }

        System.out.println("Обработката приключи. Данните са записани в stats.txt");
    }
}

