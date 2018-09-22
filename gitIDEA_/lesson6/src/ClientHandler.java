

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * ClientHandler
 *
 * @author anton
 * @since 02/11/17
 */
public class ClientHandler implements Runnable {
    private Socket s;
    private PrintWriter out;
    private Scanner in;
    private String name;

    public ClientHandler(Socket s) {
        try {
            this.s = s;
            out = new PrintWriter(s.getOutputStream());
            in = new Scanner(s.getInputStream());
            name = "Client #";
            new Thread(new ToClientFlush()).start();
        } catch (IOException e) {
        }
    }

    @Override
    public void run() {
        while (true) {
            if(in.hasNext()) {
                String w = in.nextLine();
                System.out.println(name + ": " + w);
                if(w.equalsIgnoreCase("END")) break;
            }
        }
        try {
            System.out.println("Client disconnected");
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ToClientFlush implements Runnable {
        Scanner input;
        String w;
        public ToClientFlush() {
            input = new Scanner(System.in);
        }

        @Override
        public void run() {
            while (true) {
                if (input.hasNext())
                    w = input.nextLine();
                    out.println("Сервер: " + w);
                    out.flush();
                }
            }
        }
    }

