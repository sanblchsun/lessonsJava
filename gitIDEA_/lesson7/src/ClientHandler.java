

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * ClientHandler
 *
 * @author anton
 * @since 06/11/17
 */
public class ClientHandler implements Runnable {
    private MyServer server;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private String name = null;
    private boolean isAuth = false;

    public ClientHandler(MyServer server, Socket socket) {
        this.server = server;
        try {
            this.socket = socket;
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Client handler initialization failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String msg = in.readUTF();
                if (msg.startsWith("/auth")) {
                    String[] data = msg.split(" ");

                    if (data.length == 3) {
                        name = server.getAuthService().getNick(data[1], data[2]);
                        if (name != null) {
                            isAuth = true;
                            sendBroadcastMessage(name + " зашел в чат!");
                        } else {
                            sendMessage("Неверные логин/пароль");
                        }
                    } else {
                        server.close(socket);
                    }
                } else if (isAuth) {
                    if (msg.startsWith("/w")) {
                        String[] data1 = msg.split(" ");
                        if (data1.length > 2 &&
                                server.getAuthService().authorizedNick(data1[1])) {
                            sendMessageToNike(data1[1],msg);
                        }
                    }
                    else sendBroadcastMessage(name + " написал: " + msg);
                } else {
                    server.close(socket);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Client disconnected");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessageToNike(String nick, String msg) {
        server.sendMessageToNike(nick, msg);
    }

    private void sendBroadcastMessage(String msg) { server.sendBroadcastMessage(msg); }

    public void sendMessage(String msg) {
        System.out.println(name + ": " + msg);
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String GetCurrentNick() {return name;}

    public boolean isActive() {
        return isAuth;
    }

    public Socket getSocket() {
        return socket;
    }
}
