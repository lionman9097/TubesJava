import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App implements ActionListener{
    private static JPanel panel;
    private static JFrame frame;
    private static JButton button;
    private static JLabel label1;
    private static JTextField userText;
    private static JLabel label2;
    private static JPasswordField passText;
    private static JDialog d;
    App(){
        panel = new JPanel();  
        frame = new JFrame();      
        button = new JButton("Login");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        frame.add(panel);
        panel.setLayout(null);

        label1 = new JLabel("User");
        label1.setBounds(50,80,80,25);
        panel.add(label1);
        userText = new JTextField();
        userText.setBounds(150,80,165,25);
        panel.add(userText);

        label2 = new JLabel("Pass");
        label2.setBounds(50,120,80,25);
        panel.add(label2);
        passText = new JPasswordField();
        passText.setBounds(150,120,165,25);
        panel.add(passText);

        button.setBounds(50, 160, 80, 25);
        button.addActionListener(this);
        panel.add(button);
        frame.setVisible(true);
    }
public void actionPerformed(ActionEvent e){
        String userInput = userText.getText();
        String passInput = passText.getText();
        boolean userFound = false;
        boolean passFound = false;
        userText.setText("");
        passText.setText("");
        try 
        {
            File myObj = new File("datauser.txt");
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                if (userInput.equals(data)) 
                {
                    userFound = true;
                }
                if (passInput.equals(data)) 
                {
                    passFound = true;
                }
            }
            myReader.close();
        } catch (FileNotFoundException err) 
        {
            System.out.println("An error occurred.");
            err.printStackTrace();
        }
        if(userFound && passFound)
        {
            d = new JDialog(frame, "Login");
 
            // create a label
            JLabel l = new JLabel("Login Berhasil");
            l.setBounds(75, 100, 150, 50);
            JButton buttond = new JButton("Ok");
            
            buttond.setBounds(75, 150, 100, 50);
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
}