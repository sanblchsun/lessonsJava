import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {
    public static void main(String args[]) { ;
        JFrame frame = new JFrame("Editable JComboBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();

        final JLabel textLabel = new JLabel();
        JScrollPane scrollPane1Label = new JScrollPane(textLabel);
        contentPane.add(scrollPane1Label, BorderLayout.CENTER);

        final JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        contentPane.add(scrollPane, BorderLayout.SOUTH);


        textLabel.setText("dsoakdsalpk");


        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("oljsdlkvjsdlvjsd");
//                textArea1.append("Selected: " + comboBox.getSelectedItem());
//                textArea1.append(", Position: " + comboBox.getSelectedIndex());
//                textArea1.append(System.getProperty("line.separator"));
            }
        };
//        comboBox.addActionListener(actionListener);

        frame.setSize(200, 600);
        frame.setVisible(true);
    }
}