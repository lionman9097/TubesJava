import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;


public class OverLoad implements ActionListener{
    private static JPanel panel;
    private static JFrame frame;
    private static JButton button;
    private static JLabel label1;
    private static JTextField x= new JTextField();
    private static JLabel label2;
    private static JTextField y = new JTextField();
    private static JDialog d;
    private static JButton logo = new JButton(new ImageIcon("C:\\Users\\rafim\\Documents\\Javagui\\PBOgui\\bin\\LOGOS.png"));

    static int plusMethod(int x, int y)
    {
        return x + y;
    }
      
    static double plusMethod(double x, double y)
    {
        return x + y;
    }

    OverLoad(){
        
        panel = new JPanel();
        panel.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        frame = new JFrame();      
        logo.setBounds(10,10,80,80);
        logo.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        panel.add(logo);
        button = new JButton(new ImageIcon("C:\\Users\\rafim\\Documents\\Javagui\\PBOgui\\bin\\HITUNG.png"));
        frame.setSize(400,350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        frame.add(panel);
        panel.setLayout(null);

        label1 = new JLabel("Masukan Angka Pertama");
        label1.setBounds(50,100,160,25);
        label1.setForeground(Color.WHITE);
        panel.add(label1);
        x.setBounds(200,100,165,25);
        panel.add(x);

        label2 = new JLabel("Masukan Angka Kedua");
        label2.setBounds(50,140,160,25);
        label2.setForeground(Color.WHITE);
        panel.add(label2);
        y.setBounds(200,140,165,25);
        panel.add(y);

        button.setBounds(50, 180, 100, 80);
        button.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        button.addActionListener(this);
        panel.add(button);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        double xinput = Double.parseDouble(x.getText());
        double yinput = Double.parseDouble(y.getText());
        double output = plusMethod(xinput, yinput);
        d = new JDialog(frame, "OverLoad");
        JLabel l = new JLabel();
        l.setText("Hasil dari " + xinput + " + " + yinput + " adalah "+ output);
        l.setBounds(75, 50, 250, 50);
        JButton buttond = new JButton("Ok");
        buttond.setBounds(75, 150, 100, 50);
        buttond.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                d.dispose();
            }
            });
            JPanel paneld = new JPanel();
            paneld.add(l);
            paneld.add(buttond);
            d.getContentPane().add(paneld);
 
            // setsize of dialog
            d.setSize(300, 100);
            
 
            // set visibility of dialog
            d.setVisible(true);

    }
}