package SU4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        final int PORT = 6000;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сървърът слуша на порт " + PORT + "...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиентът се свърза!");

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            PrintWriter writer =
                    new PrintWriter(clientSocket.getOutputStream(), true);

            int counter = 0;

            String line;
            while ((line = reader.readLine()) != null) {

                if (line.equalsIgnoreCase("quit")) {
                    writer.println("Bye");
                    break;
                }

                counter++;
                writer.println("#" + counter + ": " + line);
            }

            clientSocket.close();
            System.out.println("Сървърът приключи работа.");

        } catch (Exception e) {
            System.err.println("Грешка: " + e.getMessage());
        }
    }
}

