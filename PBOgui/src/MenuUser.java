import java.awt.Color;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuUser implements ActionListener {
    private static JFrame frame = new JFrame();
    private static JPanel panel = new JPanel();
    private static JButton button1 = new JButton(new ImageIcon("C:\\Users\\rafim\\Documents\\Javagui\\PBOgui\\bin\\PESAN_TIKET.png"));
    private static JButton button2 = new JButton(new ImageIcon("C:\\Users\\rafim\\Documents\\Javagui\\PBOgui\\bin\\OVERLOAD.png"));
    private static JButton logo = new JButton(new ImageIcon("C:\\Users\\rafim\\Documents\\Javagui\\PBOgui\\bin\\LOGOS.png"));
    MenuUser(){
        
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.add(panel);
        logo.setBounds(10,10,80,80);
        logo.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        panel.add(logo);
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        button1.setBounds(140, 50, 100, 80);
        button1.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        button1.addActionListener(this);
        panel.add(button1);
        button2.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        button2.setBounds(140, 160, 100, 80);
        button2.addActionListener(this);
        panel.add(button2);

        
    }

    public void actionPerformed(ActionEvent e){ 
                if(e.getSource()==button1)
                {
                    new PilihTravel();
                }
                if(e.getSource()==button2)
                {
                    new OverLoad();
                }
                
            }  
}
