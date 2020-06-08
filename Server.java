import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8567)) {
            ExecutorService executor = Executors.newCachedThreadPool();
            int i = 0;
            while (i < 10) {
                System.out.println("waiting for connection");
                Socket conn = server.accept();
                System.out.println("a client connected");
                i++;
                executor.execute(new Handler(conn));
            }
            executor.shutdown();
        }catch(IOException e) {
            System.err.println(e);
        }
    }
}


class Handler implements Runnable{

    Socket client;

    public Handler(Socket connection) {
        client = connection;
    }

    @Override
    public void run() {
        try (InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream()) {
            byte[] data = new byte[128];
            int totalOccupied = 0;
            while (totalOccupied < 128) {
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException ex) {
                    System.err.println(ex);
                }
                byte[] b = new byte[128];
                if (client.isClosed())
                    break;
                int read = in.read(b);
                if (read == -1)
                    break;
                dataRec(b, read);
                if (totalOccupied + read < 128) {
                    for (int i = 0; i < read; i++) {
                        data[totalOccupied++] = b[i];
                    }
                }
                else {
                    totalOccupied = 128;
                    out.write("over".getBytes());
                }
                out.write(data);
                dataSent(data, totalOccupied);
            }
            System.out.print("all massages sent.\nclosing...");
        }catch (IOException e) {
            System.err.println(e);;
        } finally {
            try {
                client.close();
                System.out.print("done");
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    private void dataRec(byte[] data, int read) {
        System.out.println("Receive");
        System.out.println(new String(data, 0, read));
    }

    private void dataSent(byte[] data, int read) {
        System.out.print("Sent: ");
        System.out.println(new String(data, 0, read));
    }
}