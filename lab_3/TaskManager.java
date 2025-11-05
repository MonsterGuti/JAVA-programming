package lab_3;

import java.util.Scanner;
import java.util.Stack;

public class TaskManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> tasks = new Stack<>();

        while (true) {
            System.out.print("Enter command: ");
            String input = sc.nextLine();

            if (input.startsWith("add ")) {
                String task = input.substring(4).trim();
                if (task.isEmpty()) {
                    System.out.println("Task name cannot be empty!");
                } else {
                    tasks.push(task);
                    System.out.println("Added task: " + task);
                }

            } else if (input.equals("done")) {
                if (tasks.isEmpty()) {
                    System.out.println("No tasks to remove!");
                } else {
                    String removed = tasks.pop();
                    System.out.println("Completed task: " + removed);
                }

            } else if (input.equals("list")) {
                if (tasks.isEmpty()) {
                    System.out.println("No current tasks!");
                } else {
                    System.out.println("Current tasks:");
                    for (int i = tasks.size() - 1; i >= 0; i--) {
                        System.out.println(" - " + tasks.get(i));
                    }
                }

            } else if (input.equals("exit")) {
                System.out.println("Exiting program...");
                break;

            } else {
                System.out.println("Invalid command!");
            }
        }

        sc.close();
    }
}
