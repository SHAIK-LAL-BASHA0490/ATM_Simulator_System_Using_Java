package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame  implements ActionListener{

    JButton clear,login,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login() {
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        setSize(800, 480);
        setLocation(300, 100);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label = new JLabel(i3); 
        label.setBounds(70,20,100,100);
        getContentPane().setBackground(Color.WHITE);
        add(label);
        
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200, 55, 400, 40);
        add(text);
        
        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,40);
        add(cardno);
        
        cardTextField=new JTextField();
        cardTextField.setBounds(300,160,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        JLabel pin=new JLabel("Pin No:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,200,150,40);
        add(pin);
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,210,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
         
        login=new JButton("SIGN IN");
        login.setBounds(300, 300, 100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        clear=new JButton("CLEAR");
        clear.setBounds(450, 300, 100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("SIGN UP");
        signup.setBounds(300, 350, 250,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        

        setVisible(true); // Should be called after adding components
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()==login)
        {
            String card_Number=cardTextField.getText();
            String pin_Number=pinTextField.getText();
            
            try{
                Conn c=new Conn();
                String query="select * from login where Card_Number='"+card_Number+"' and Pin_Number='"+pin_Number+"'";
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(pinTextField.getText()).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"incorrect Card Number or Pin");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
       
    }
    
    public static void main(String args[]) {
        new Login();
    }
}
