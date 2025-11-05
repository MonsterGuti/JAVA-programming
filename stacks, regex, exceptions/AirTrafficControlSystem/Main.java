package SU3.AirTrafficControlSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FlightManager manager = new FlightManager();

        while (true) {
            System.out.println("\n1. Add flight");
            System.out.println("2. Poll next flight");
            System.out.println("3. Change flight status");
            System.out.println("4. Show all flights");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                System.out.print("Flight number: ");
                String num = sc.nextLine();
                System.out.print("Departure time: ");
                String time = sc.nextLine();
                System.out.print("Destination: ");
                String dest = sc.nextLine();
                System.out.print("Status (PARKED, TAXING, RUNWAY, DEPARTED): ");
                FlightStatus status = FlightStatus.fromString(sc.nextLine());

                if (status == null) status = FlightStatus.PARKED;
                boolean added = manager.addFlight(new Flight(num, time, dest, status));
                System.out.println(added ? "Added." : "Flight already exists.");
            }

            else if (choice.equals("2")) {
                Flight f = manager.pollNextFlight();
                System.out.println(f == null ? "No flights." : f);
            }

            else if (choice.equals("3")) {
                System.out.print("Flight number: ");
                String num = sc.nextLine();
                System.out.print("New status: ");
                FlightStatus status = FlightStatus.fromString(sc.nextLine());
                boolean ok = manager.changeStatus(num, status);
                System.out.println(ok ? "Changed." : "Not found.");
            }

            else if (choice.equals("4")) {
                if (manager.listAllFlights().isEmpty()) {
                    System.out.println("No flights.");
                } else {
                    for (Flight f : manager.listAllFlights()) {
                        System.out.println(f);
                    }
                }
            }

            else if (choice.equals("0")) {
                System.out.println("Bye!");
                break;
            }

            else {
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}

