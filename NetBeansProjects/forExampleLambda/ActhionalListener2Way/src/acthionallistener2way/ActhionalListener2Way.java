package acthionallistener2way;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActhionalListener2Way {

    public static void main(String[] args) {
        Button but = new Button();
        
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Старый способ");
            }
        });
        
        but.addActionListener(((e) -> System.out.println("Lamba способ")));
        
    }
    
}
