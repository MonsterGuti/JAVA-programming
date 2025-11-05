package lab_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LastActions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> actions = new LinkedList<>();

        while (true) {
            System.out.print("Enter action (or 'exit' to stop): ");
            String action = sc.nextLine();

            if (action.equalsIgnoreCase("exit")) {
                System.out.println("Program ended.");
                break;
            }

            actions.offer(action);

            if (actions.size() > 3) {
                actions.poll();
            }

            System.out.println("Current actions: " + actions);
        }

        sc.close();
    }
}
