import java.awt.Color;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu implements ActionListener {
    private JFrame frame;
    private static JPanel panel = new JPanel();
    private static JButton button1 = new JButton(new ImageIcon("C:\\Users\\rafim\\Documents\\Javagui\\PBOgui\\bin\\LOGIN_USER.png"));
    private static JButton button2 = new JButton(new ImageIcon("C:\\Users\\rafim\\Documents\\Javagui\\PBOgui\\bin\\REGISTER_USER.png"));
    private static JButton button3 = new JButton(new ImageIcon("C:\\Users\\rafim\\Documents\\Javagui\\PBOgui\\bin\\LOGIN_ADMIN.png"));
    private static JButton logo = new JButton(new ImageIcon("C:\\Users\\rafim\\Documents\\Javagui\\PBOgui\\bin\\LOGOS.png"));
    
    
    
    MainMenu(){
        frame = new JFrame();
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.add(panel);
        panel.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));

        logo.setBounds(10,10,80,80);
        logo.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        panel.add(logo);

      
        panel.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        button1.setBounds(140, 50, 100, 80);
        button1.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        button1.addActionListener(this);
        panel.add(button1);

        button2.setBounds(140, 150, 100, 80);
        button2.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        button2.addActionListener(this);
        panel.add(button2);

        button3.setBounds(140, 250, 100, 80);
        button3.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        button3.addActionListener(this);
        panel.add(button3);
        
    }

    public void actionPerformed(ActionEvent e){ 
                if(e.getSource()==button1)
                {
                    new login();
                    frame.dispose();
                    
                } else if(e.getSource()==button2)
                {
                    new Regist2();
                    
                } else if(e.getSource()==button3)
                {
                    new MenuAdmin();
                }
                
            }  
}
