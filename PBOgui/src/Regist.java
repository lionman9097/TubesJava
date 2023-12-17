import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;


public class Regist implements ActionListener{
    private static JPanel panel;
    JSONObject user = new JSONObject();
    private static JFrame frame;
    private static JButton button;
    private static JLabel label1;
    private static JTextField userText;
    private static JLabel label2;
    private static JTextField HpText;
    private static JLabel label3;
    private static JPasswordField passText;
    private class datauser {
        String name;
        String pass;
        String noHp;
        String tipe;
    
    }
    private class reguser extends datauser{
        String tipe = "regular";


    }
    Regist()
    {
        new datauser();
        panel = new JPanel();  
        frame = new JFrame();      
        button = new JButton("Register");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        frame.add(panel);
        panel.setLayout(null);

        label1 = new JLabel("Masukan Username");
        label1.setBounds(50,80,80,25);
        panel.add(label1);
        userText = new JTextField();
        userText.setBounds(200,80,165,25);
        panel.add(userText);

        label2 = new JLabel("Masukan Password");
        label2.setBounds(50,120,80,25);
        panel.add(label2);
        passText = new JPasswordField();
        passText.setBounds(200,120,165,25);
        panel.add(passText);

        label3 = new JLabel("Masukan No. Telepon");
        label3.setBounds(50,160,80,25);
        panel.add(label3);
        HpText = new JTextField();
        HpText.setBounds(200,160,165,25);
        panel.add(HpText);

        button.setBounds(50, 200, 80, 25);
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
        user.put("name", userInput);
        user.put("pass",passInput);
        user.put("no",HpInput);
        try {
            FileWriter myWriter = new FileWriter("datauser.txt");
            myWriter.write(userInput + System.lineSeparator());
            myWriter.write(passInput + System.lineSeparator());
            myWriter.write(HpInput + System.lineSeparator());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException err) {
            System.out.println("An error occurred.");
            err.printStackTrace();
        }
        frame.dispose();

    }
}