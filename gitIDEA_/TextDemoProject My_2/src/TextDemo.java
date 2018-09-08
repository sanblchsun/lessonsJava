
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class TextDemo extends JFrame implements ActionListener {
    private  Style     normal_1     = null; // стиль текста
    private  Style     normal_2     = null; // стиль текста
    protected JTextField textField;
    protected JTextPane textArea;
    private final static String newline = "\n";
    private int i = 0;
    String[] strArray = {"купи слона", "все так говорят, а ты купи слона"};

    public TextDemo() {
        super("Massanger");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        textField = new JTextField(30);
        textField.addActionListener(this);

        textArea = new JTextPane();
        createStyles(textArea);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        //Add Components to this panel.
        getContentPane().add(new JScrollPane(textArea));
        getContentPane().add(new JScrollPane(textField),BorderLayout.SOUTH);
        // Открытие окна
        setSize(380, 240);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        String text = textField.getText();
        Style style = normal_1;
        // Загружаем в документ текст
        try{
            Document doc = textArea.getDocument();
            doc.insertString(doc.getLength(), text + newline, style);
        }catch (Exception e) {
            e.printStackTrace();
        }
        textField.selectAll();
        answer();
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    private void createStyles(JTextPane editor) {
        // Создание стилей
        normal_1 = textArea.addStyle("normal_1", null);
        StyleConstants.setFontFamily(normal_1, "Times New Roman");
        StyleConstants.setFontSize(normal_1, 20);
        StyleConstants.setForeground(normal_1,Color.RED);

        normal_2 = textArea.addStyle("normal_2", normal_1);
        StyleConstants.setForeground(normal_2,Color.ORANGE);
    }

    private void answer() {
        Style style = normal_2;
        try{
            Document doc = textArea.getDocument();
            doc.insertString(doc.getLength(), "  " + strArray[i] + newline, style);
        }catch (Exception e) {
            e.printStackTrace();
        }
        if(i<strArray.length-1) ++i;
        else i=0;
    }


    public static void main(String[] args) {
        new TextDemo();
    }
}
