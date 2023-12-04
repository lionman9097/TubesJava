import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu implements ActionListener {
    private static JFrame frame = new JFrame();
    private static JPanel panel = new JPanel();
    private static JButton button1 = new JButton("Login User");
    private static JButton button2 = new JButton("Register User");
    private static JButton button3 = new JButton("Login Admin");
    MainMenu(){
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        button1.setBounds(150, 80, 100, 40);
        button1.addActionListener(this);
        panel.add(button1);

        button2.setBounds(130, 180, 150, 40);
        button2.addActionListener(this);
        panel.add(button2);

        button3.setBounds(140, 280, 120, 40);
        button3.addActionListener(this);
        panel.add(button3);
        
    }

    public void actionPerformed(ActionEvent e){ 
                if(e.getSource()==button1)
                {
                    new App();
                    
                } else if(e.getSource()==button2)
                {
                    new Regist();
                    
                } else if(e.getSource()==button3)
                {
                    
                }
                
            }  
}
