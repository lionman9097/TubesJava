import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class login implements ActionListener{
    private static JPanel panel;
    private static JFrame frame;
    private static JButton button;
    private static JLabel label1;
    private static JTextField userText= new JTextField();
    private static JLabel label2;
    private static JPasswordField passText = new JPasswordField();
    private static JDialog d;
    private static JSONParser jsonParser = new JSONParser();
    private static String userInput;
    private static String passInput;
    private static boolean userFound = false;
    private static boolean passFound = false;
    private static JButton logo = new JButton(new ImageIcon("C:\\Users\\rafim\\Documents\\Javagui\\PBOgui\\bin\\LOGOS.png"));
    login(){
        panel = new JPanel();
        panel.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        frame = new JFrame();      
        button = new JButton(new ImageIcon("C:\\Users\\rafim\\Documents\\Javagui\\PBOgui\\bin\\LOGIN_USER_2.png"));
        frame.setSize(400,350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        frame.add(panel);
        panel.setLayout(null);

        
        logo.setBounds(10,10,80,80);
        logo.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        panel.add(logo);

        label1 = new JLabel("User");
        label1.setBounds(50,100,80,25);
        label1.setForeground(Color.WHITE);
        panel.add(label1);
        userText.setBounds(150,100,165,25);
        panel.add(userText);

        label2 = new JLabel("Pass");
        label2.setBounds(50,140,80,25);
        label2.setForeground(Color.WHITE);
        panel.add(label2);
        passText.setBounds(150,140,165,25);
        panel.add(passText);

        button.setBounds(50, 180, 100, 80);
        button.setBackground(Color.getHSBColor(0.0f,0.0f,0.1373f));
        button.addActionListener(this);
        panel.add(button);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        userInput = userText.getText();
        passInput = passText.getText();
    
        
        
        userText.setText("");
        passText.setText("");
        try 
        {
            FileReader myReader = new FileReader("datauser.json");
            Object obj = jsonParser.parse(myReader);
            JSONArray Userlist = (JSONArray) obj;
            Userlist.forEach(user -> checkuser((JSONObject) user));
        } catch (FileNotFoundException err) 
        {
            System.out.println("An error occurred.");
            err.printStackTrace();
        }catch (IOException err) {
            err.printStackTrace();
        } catch (ParseException err) {
            err.printStackTrace();
        }
        System.out.println(userFound);
        System.out.println(passFound);
        if(userFound && passFound)
        {
            d = new JDialog(frame, "Login");
 
            // create a label
            JLabel l = new JLabel("Login Berhasil");
            l.setBounds(75, 10, 150, 50);
            JButton buttond = new JButton("Ok");        
            buttond.setBounds(75, 100, 100, 50);
            buttond.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    d.dispose();
                    frame.dispose();
                    new MenuUser();
                }
            });
            JPanel paneld = new JPanel();
            paneld.add(l);
            paneld.add(buttond);
            d.getContentPane().add(paneld);
 
            // setsize of dialog
            d.setSize(200, 100);
            
 
            // set visibility of dialog
            d.setVisible(true);

           

        }else
        {
            d = new JDialog(frame, "Login");
 
            // create a label
            JLabel l = new JLabel("Username atau Password salah");
            l.setBounds(75, 100, 150, 50);
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
            d.setSize(200, 100);
            
 
            // set visibility of dialog
            d.setVisible(true);

        }
        }
    private static void checkuser(JSONObject user)
    {
        JSONObject userObject = (JSONObject) user;
        String username = (String) userObject.get("Name");
        String userpass = (String) userObject.get("Pass");
        if (username.equals(userInput)){
            System.out.println("found");
            userFound = true;
        }
        if (userpass.equals(passInput)){
            passFound = true;
        }
    }
    
}