package SU3.configapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConfigManager manager = new ConfigManager();

        while (true) {
            System.out.println("\n1. Add configuration");
            System.out.println("2. Edit configuration");
            System.out.println("3. Show all configurations");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter key: ");
                    String key = sc.nextLine();
                    System.out.print("Enter value: ");
                    String value = sc.nextLine();
                    manager.addConfig(key, value);
                    System.out.println("Added!");
                    break;

                case "2":
                    if (manager.isEmpty()) {
                        System.out.println("No configurations!");
                        break;
                    }
                    System.out.print("Enter ID to edit: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("New key: ");
                    String newKey = sc.nextLine();
                    System.out.print("New value: ");
                    String newValue = sc.nextLine();

                    if (manager.editConfig(id, newKey, newValue))
                        System.out.println("Successfully edited!");
                    else
                        System.out.println("No configuration with that ID!");
                    break;

                case "3":
                    if (manager.isEmpty()) System.out.println("Empty list!");
                    else {
                        System.out.printf("%s | %s | %n", "ID", "KEY", "VALUE");
                        manager.getAllConfigs().forEach(System.out::println);
                    }
                    break;

                case "0":
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("❌ Invalid option!");
            }
        }
    }
}

