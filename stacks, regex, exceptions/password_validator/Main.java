package SU3.password_validator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter password: ");
        String password = sc.nextLine();

        try {
            validatePassword(password);
            System.out.println("Password valid!");
        } catch (ShortPasswordException | NoUppercaseException | NoDigitException | NoSpecialCharacterException e) {
            System.err.println("error " + e.getMessage());
        }
    }

    public static void validatePassword(String pass)
            throws ShortPasswordException, NoUppercaseException, NoDigitException, NoSpecialCharacterException {

        if (pass.length() < 8) {
            throw new ShortPasswordException("Password too short (minimum 8 characters)!");
        }

        if (!Pattern.compile("[A-Z]").matcher(pass).find()) {
            throw new NoUppercaseException("Missing uppercase letter!");
        }

        if (!Pattern.compile("[0-9]").matcher(pass).find()) {
            throw new NoDigitException("Missing digit!");
        }

        if (!Pattern.compile("[!@#$%^&*]").matcher(pass).find()) {
            throw new NoSpecialCharacterException("Missing special character!");
        }
    }
}
