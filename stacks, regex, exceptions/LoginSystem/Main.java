package SU3.LoginSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User("marto", "1234");

        while (true) {
            System.out.print("Input password: ");
            String input = sc.nextLine();

            try {
                user.login(input);
                break;
            } catch (WrongPasswordException e) {
                System.out.println(e.getMessage());
            } catch (UserBlockedException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}

