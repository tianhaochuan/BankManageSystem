package Practice;

import javax.swing.*;
import java.awt.*;

public class The_Frame_Windows {
    public static void main(String[] args) {
        JFrame x = new JFrame();
        /*x.setLocation(100,100);
        x.setSize(100,100);*/
        x.setBounds(100,100,800,800);
        x.setTitle("hello");
        Container y = x.getContentPane();
       // JPanel y = new JPanel();
        y.setBackground(Color.red);
        x.setLayout(null);
        JButton z = new JButton("nihao");
        z.setBounds(100,100,100,100);
        x.add(z);
        x.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        x.setVisible(true);
    }
}
