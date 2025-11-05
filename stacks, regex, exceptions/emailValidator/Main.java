package SU3.emailValidator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter email ");
        String email = sc.nextLine();

        try {
            validateEmail(email);
            System.out.println("The email is accepted " + email);
        } catch (InvalidEmailException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void validateEmail(String email) throws InvalidEmailException {
        String regex = "^[\\w._]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new InvalidEmailException("Invalid email!");
        }
    }
}

