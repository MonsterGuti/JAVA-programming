package lab_3;

import java.util.Scanner;
import java.util.regex.Pattern;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int validCount = 0;

        Pattern emailPattern = Pattern.compile("^[\\w.%+-]+@[\\w.-]+\\.(com|bg|org)$");

        while (true) {
            System.out.print("Enter email (or 'stop' to finish): ");
            String email = sc.nextLine();

            if (email.equalsIgnoreCase("stop")) break;

            try {
                if (!emailPattern.matcher(email).matches()) {
                    throw new Exception("Invalid email format! Must contain one '@' and end with .com, .bg, or .org");
                }

                System.out.println("Valid email!");
                validCount++;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nTotal valid emails: " + validCount);
        sc.close();
    }
}
