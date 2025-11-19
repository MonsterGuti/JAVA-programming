package SU4;

import java.io.*;
import java.net.Socket;

public class FileClient {
    public static void main(String[] args) {

        final String HOST = "localhost";
        final int PORT = 7000;

        try (Socket socket = new Socket(HOST, PORT)) {

            System.out.println("Свързан към сървъра на " + HOST + ":" + PORT);

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            FileOutputStream fos = new FileOutputStream("received.bin");

            long fileLength = dis.readLong();
            System.out.println("Очаквана дължина: " + fileLength);

            byte[] buffer = new byte[4096];
            long totalRead = 0;
            int bytesRead;

            while (totalRead < fileLength &&
                    (bytesRead = dis.read(buffer)) != -1) {

                fos.write(buffer, 0, bytesRead);
                totalRead += bytesRead;
            }

            fos.close();

            System.out.println("Получени байтове: " + totalRead);
            System.out.println("Очаквана дължина: " + fileLength);

        } catch (IOException e) {
            System.err.println("Грешка: " + e.getMessage());
        }
    }
}
