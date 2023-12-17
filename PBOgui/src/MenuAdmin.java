import java.awt.Color;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuAdmin implements ActionListener {
    private static JFrame frame = new JFrame();
    private static JPanel panel = new JPanel();
    private static JButton button2 = new JButton("Cek User");
    MenuAdmin(){
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.add(panel);
        panel.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        panel.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        button2.setBounds(130, 180, 150, 40);
        button2.addActionListener(this);
        panel.add(button2);
        
    }

    public void actionPerformed(ActionEvent e){ 
               if(e.getSource()==button2)
                {
                    
                }
                
            }  
}
