

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * MyWindow
 *
 * @author anton
 * @since 06/11/17
 */
public class Main extends JFrame {

    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;

    private JTextField login = new JTextField("Login");
    private JPasswordField password = new JPasswordField("Password");
    private JButton authBtn = new JButton("Auth");
    private JTextField jtf;
    private JTextArea jta;

    private Socket sock;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean authorized = false;

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    public Main() {
        initUI();
    }

    private void initUI() {
        setBounds(600, 300, 500, 500);
        setTitle("Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createAuthPanel();

    }

    private void createAuthPanel() {
        JPanel authPanel = new JPanel(new GridLayout());
        authPanel.add(login);
        login.setToolTipText("enter your login");
        password.setToolTipText("enter your password");
        authPanel.add(password);
        authPanel.add(authBtn);
        add(authPanel, BorderLayout.NORTH);
        authBtn.addActionListener(e -> connect(login.getText(), password.getText()));
    }

    private void connect(String login, String password) {

        try {
            sock = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new DataInputStream(sock.getInputStream());
            out = new DataOutputStream(sock.getOutputStream());
            out.writeUTF("/auth " + "login1" + " " + "pass1");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
