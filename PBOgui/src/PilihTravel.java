import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;


public class PilihTravel implements ActionListener{
    private static JPanel panel;
    private static JFrame frame;
    private static JButton button;
    private static JLabel label1;
    private static JTextField textField;
    private static JComboBox combox1;
    private static JComboBox combox2;
    private static JLabel label2;
    private static JLabel label3;
    private static JDialog d;
    private static JButton logo = new JButton(new ImageIcon("C:\\Users\\rafim\\Documents\\Javagui\\PBOgui\\bin\\LOGOS.png"));
    String lokasi[]={"Indonesia","Korea","Cina","Amerika","Australia"};     
    PilihTravel(){
        panel = new JPanel();
        panel.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        frame = new JFrame();      
        button = new JButton(new ImageIcon("C:\\Users\\rafim\\Documents\\Javagui\\PBOgui\\bin\\HITUNG.png"));
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        frame.add(panel);
        panel.setLayout(null);

        logo.setBounds(10,10,80,80);
        logo.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        panel.add(logo);

        label1 = new JLabel("Pilih Lokasi Keberangkatan :");
        label1.setForeground(Color.WHITE);
        label1.setBounds(50,100,200,25);
        panel.add(label1);
        combox1 = new JComboBox(lokasi);
        combox1.setBounds(250, 100, 90, 20);
        panel.add(combox1);

        label2 = new JLabel("Pilih Destinasi :");
        label2.setBounds(50,140,160,25);
        label2.setForeground(Color.WHITE);
        panel.add(label2);
        combox2 = new JComboBox(lokasi);
        combox2.setBounds(250, 140, 90, 20);
        panel.add(combox2);

        label3 = new JLabel("Harga :");
        label3.setBounds(50,180,80,25);
        label3.setForeground(Color.WHITE);
        panel.add(label3);
        textField = new JTextField();
        textField.setBounds(250, 180, 90, 20);
        panel.add(textField);
        

        button.setBounds(50, 220, 100, 80);
        button.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        button.addActionListener(this);
        panel.add(button);
        frame.setVisible(true);
    }
public void actionPerformed(ActionEvent e){
    int lok = combox1.getSelectedIndex();
    int des = combox2.getSelectedIndex();
    int cost1=0,cost2=0,harga=0;
    if (lok==0) {
        cost1=10;
        
    }else if(lok==1){
        cost1=20;

    }else if(lok==2){
        cost1=30;

    }else if(lok==3){
        cost1=40;

    }else if(lok==4){
        cost1=50;

    }
    if (des==0) {
        cost2=10;
        
    }else if(des==1){
        cost2=20;

    }else if(des==2){
        cost2=30;

    }else if(des==3){
        cost2=40;

    }else if(des==4){
        cost2=50;

    }
    harga = cost1*cost2*1000;
    if (lok==des) {
        harga = 0;
    }
    textField.setText(Integer.toString(harga));


       
        }
}