package SU4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Употреба: java FileServer <filename>");
            return;
        }

        String fileName = args[0];
        File file = new File(fileName);

        if (!file.exists()) {
            System.err.println("Грешка: Файлът " + fileName + " не съществува!");
            return;
        }

        final int PORT = 7000;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("FileServer слуша на порт " + PORT + "...");
            System.out.println("Очаква се клиент за изпращане на файла: " + fileName);

            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиентът се свърза!");

            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            FileInputStream fis = new FileInputStream(file);

            long length = file.length();
            dos.writeLong(length);
            dos.flush();

            System.out.println("Изпращам дължина на файла: " + length + " байта");

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                dos.write(buffer, 0, bytesRead);
            }

            dos.flush();

            System.out.println("Файлът е изпратен успешно!");

            fis.close();
            clientSocket.close();

        } catch (IOException e) {
            System.err.println("Грешка: " + e.getMessage());
        }
    }
}

