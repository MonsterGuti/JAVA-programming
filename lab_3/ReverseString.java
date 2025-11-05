package lab_3;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        if (input.isEmpty()) {
            System.out.println("No text entered.");
        } else {
            StringBuilder reversed = new StringBuilder();

            for (int i = input.length() - 1; i >= 0; i--) {
                reversed.append(input.charAt(i));
            }

            System.out.println("Reversed string: " + reversed);
        }

        sc.close();
    }
}
