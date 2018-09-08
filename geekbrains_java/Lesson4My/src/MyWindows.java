import javax.swing.*;
import java.awt.*;

public class MyWindows extends JFrame {

    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTextArea textArea;
    private JTextArea textArea1;

    public MyWindows() throws HeadlessException {
        super("Massanger");
        initComponents();

    }

    public void initComponents() {
        jLabel1 = new JLabel("History");
        textArea = new JTextArea();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 200, 600);
        setLayout(new GridLayout(2, 1));
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();

    }
}
