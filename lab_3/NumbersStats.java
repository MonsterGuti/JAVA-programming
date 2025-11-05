package lab_3;

import java.util.ArrayList;
import java.util.Scanner;

public class NumbersStats {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        while (true) {
            System.out.print("Enter number (or 'stop' to finish): ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("stop")) {
                break;
            }

            try {
                int num = Integer.parseInt(input);
                numbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter an integer or 'stop'.");
            }
        }

        if (numbers.isEmpty()) {
            System.out.println("No data for calculation.");
        } else {
            int sum = 0;
            for (int n : numbers) {
                sum += n;
            }
            double average = (double) sum / numbers.size();
            System.out.println("Count of numbers: " + numbers.size());
            System.out.printf("Average value: %.2f", average);
        }

        sc.close();
    }
}
