

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * MyServer
 *
 * @author anton
 * @since 02/11/17
 */
public class MyServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket s = null;
        try {
            server = new ServerSocket(8189);
            System.out.println("Server created. Waiting for client...");
            s = server.accept();
            System.out.println("Client connected");
            Thread threadClientHandler = new Thread(new ClientHandler(s));
            threadClientHandler.start();
            threadClientHandler.join();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
                System.out.println("Server closed");
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
