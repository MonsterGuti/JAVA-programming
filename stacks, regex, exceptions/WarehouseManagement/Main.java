package SU3.WarehouseManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Warehouse warehouse = new Warehouse();

        while (true) {
            System.out.println("\n1. Add product");
            System.out.println("2. Show warehouse");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    try {
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Quantity: ");
                        int quantity = Integer.parseInt(sc.nextLine());
                        System.out.print("Hazard level (0–10): ");
                        int hazard = Integer.parseInt(sc.nextLine());

                        Product p = new Product(name, quantity, hazard);
                        warehouse.storeProduct(p);
                        System.out.println("Product added successfully!");
                    } catch (OverstockException | HazardousMaterialException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Invalid input!");
                    }
                    break;

                case "2":
                    if (warehouse.isEmpty())
                        System.out.println("The warehouse is empty!");
                    else
                        for (Product p : warehouse.getProducts()) {
                            System.out.println(p);
                        }
                    break;

                case "0":
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
