import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Regist2 implements ActionListener{
    private static JPanel panel;
    private static JSONObject user = new JSONObject();
    private static JSONArray UserList = new JSONArray();
    private static JFrame frame;
    private static JButton button;
    private static JLabel label1,label2,label3,label4;
    private static JTextField userText;
    private static JTextField HpText;
    private static JPasswordField passText;
    private static JRadioButton rb1,rb2;
    private static JButton logo = new JButton(new ImageIcon("C:\\Users\\rafim\\Documents\\Javagui\\PBOgui\\bin\\LOGOS.png"));
    
    public class datauser {
         String name;
            String pass;
            String noHp;
            String tipe;
        
        datauser(String Name,String Pass, String NoHp){
            this.name=Name;
            this.pass=Pass;
            this.noHp=NoHp;
           

        }
    }
    public class VIPuser extends datauser
    {

        VIPuser(String Name,String Pass, String NoHp){
            super(Name,Pass,NoHp);
            this.tipe = "VIP";
        }


    } 
    public class reguser extends datauser
    {

        reguser(String Name,String Pass, String NoHp){
            super(Name,Pass,NoHp);
            this.tipe = "regular";
        }
    
    }
    
    Regist2()
    {
        panel = new JPanel();  
        panel.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        frame = new JFrame();      
        button = new JButton(new ImageIcon("C:\\Users\\rafim\\Documents\\Javagui\\PBOgui\\bin\\REGISTER.png"));
        
        rb1 = new JRadioButton("Regular");
        rb2 = new JRadioButton("VIP");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        frame.add(panel);
        panel.setLayout(null);

        logo.setBounds(10,10,80,70);
        logo.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        panel.add(logo);

        label1 = new JLabel("Masukan Username");
        label1.setBounds(50,80,160,25);
        label1.setForeground(Color.WHITE);
        panel.add(label1);
        userText = new JTextField();
        userText.setBounds(200,80,165,25);
        panel.add(userText);

        label2 = new JLabel("Masukan Password");
        label2.setBounds(50,120,160,25);
        label2.setForeground(Color.WHITE);
        panel.add(label2);
        passText = new JPasswordField();
        passText.setBounds(200,120,165,25);
        panel.add(passText);

        label3 = new JLabel("Masukan No. Telepon");
        label3.setBounds(50,160,160,25);
        label3.setForeground(Color.WHITE);
        panel.add(label3);
        HpText = new JTextField();
        HpText.setBounds(200,160,165,25);
        panel.add(HpText);

        label4 = new JLabel("Pilih tipe akun: ");
        label4.setBounds(50,200,160,25);
        label4.setForeground(Color.WHITE);
        panel.add(label4);
        rb1.setBounds(150, 200, 100, 30);
        rb2.setBounds(250, 200, 100, 30);
        rb1.setForeground(Color.WHITE);
        rb2.setForeground(Color.WHITE);
        rb1.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        rb2.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        panel.add(rb1);panel.add(rb2);


        button.setBounds(50, 250, 100, 80);
        button.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        button.addActionListener(this);
        panel.add(button);
        frame.setVisible(true);
    }
public void actionPerformed(ActionEvent e)
    {
        String userInput = userText.getText();
        String passInput = passText.getText();
        String HpInput = HpText.getText();
        userText.setText("");
        passText.setText("");
        HpText.setText("");    
        if(rb1.isSelected())
        {    
        reguser User = new reguser(userInput,passInput,HpInput);
        user.put("Name", User.name);
        user.put("Pass",User.pass);
        user.put("No",User.noHp);
        user.put("Type",User.tipe);
        
        }    
        if(rb2.isSelected())
        {   
        VIPuser User = new VIPuser(userInput,passInput,HpInput);
        user.put("Name", User.name);
        user.put("Pass",User.pass);
        user.put("No",User.noHp);
        user.put("Type",User.tipe);
        }
        UserList.add(user);
        
        try {
            FileWriter myWriter = new FileWriter("datauser.json");
            myWriter.write(UserList.toJSONString());
            myWriter.flush();
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException err) {
            System.out.println("An error occurred.");
            err.printStackTrace();
        }
        frame.dispose();

    }
}