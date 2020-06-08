import java.lang.String;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket client = new Socket("127.0.0.1", 8567)) {
            ClientHandler handler = new ClientHandler(client);
            handler.connect();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler {

    private Socket connection;
    private String data;
    private byte[] dataToSend = new byte[1024];



    public ClientHandler (Socket connection) {
        this.connection = connection;
    }

    private void createDataToSend() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        dataToSend = s.getBytes();
    }

    private void showData() {
        System.out.println("Data: ");
        System.out.println(data);
    }

    public void connect() {
        try (OutputStream out = connection.getOutputStream();
                InputStream in = connection.getInputStream()) {
            byte[] buffer = new byte[128];
            int read = 0;
             do {
                 showData();
                 createDataToSend();
                 out.write(dataToSend);
                 read = in.read(buffer);
             }while (!convertByteToString(buffer, read).equals("over"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String convertByteToString (byte[] buffer, int read) {
        String s = new String(buffer, 0, read);
        if (!s.equals("over"))
            data = s;
        return s;
    }
}
