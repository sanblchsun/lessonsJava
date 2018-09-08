

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * MyServer
 *
 * @author anton
 * @since 06/11/17
 */
public class MyServer {

    private Map<ClientHandler,Long> clients = new HashMap<>();
    private AuthService authService;

    public static void main(String[] args) {
        new MyServer(new BaseAuthService());
    }

    public MyServer(AuthService authService) {
        this.authService = authService;

        Socket s = null;
        ServerSocket server = null;
        try {
            server = new ServerSocket(8189);
            System.out.println("Server created. Waiting for client...");
            new Thread(()-> {
                while (true) {
                    try {
                        Thread.sleep(500);
                        for (ClientHandler clientNext:clients.keySet()) {
                            if ((!clientNext.isActive() && (new Date().getTime()-clients.get(clientNext))>10000)) {
                                clientNext.getSocket().close();
                                clients.remove(clientNext);
                                System.out.println("сокет: " + clientNext + " не активен и устарел");
                                clientNext = null;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            while (true) {
                s = server.accept();
                ClientHandler client = new ClientHandler(this, s);
                System.out.println("сокет: " + client + " создан");
                new Thread(client).start();
                clients.put(client, new Date().getTime());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
                System.out.println("Server closed");
                if (s != null) s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public AuthService getAuthService() {
        return authService;
    }

    public void sendBroadcastMessage(String msg) {
        for (ClientHandler c : clients.keySet()) {
            if (c.isActive()) c.sendMessage(msg);
        }
    }

    public void close(Socket socket) {
        clients.keySet().removeIf(clientHandler -> clientHandler.getSocket().equals(socket));
        //FIXME
    }

    void sendPrivateMessage(String from, String userName, String message) {
        for (ClientHandler c : clients.keySet()) {
            String name = c.getName();
            if (name.equals(userName) && c.isActive())
                c.sendMessage(from + " написал лично " + userName + ": " + message);
        }
    }
}
