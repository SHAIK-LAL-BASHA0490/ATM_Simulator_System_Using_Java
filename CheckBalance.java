
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CheckBalance extends JFrame  implements ActionListener{
    
    String pinNumber;
    JButton back;
    CheckBalance(String pinNumber)
    {
        this.pinNumber=pinNumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        int balance=0;
        try{
            Conn c=new Conn();
            String query="select * from bank where Pin_number='"+pinNumber+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                if(rs.getString("Type").equals("Deposite"))
                {
                    balance=balance+Integer.parseInt(rs.getString("Amount"));
                }
                else
                {
                    balance=balance-Integer.parseInt(rs.getString("Amount"));
                }
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        JLabel amount=new JLabel("Your Current Account Balance is: "+balance);
        amount.setFont(new Font("System",Font.BOLD,14));
        amount.setForeground(Color.WHITE);
        amount.setBounds(170,300,300,30);
        image.add(amount);
        
        back=new JButton("Back");
        back.setFont(new Font("Raleway",Font.BOLD,16));
//        back.setBackground(Color.BLACK);
//        back.setForeground(Color.WHITE);
        back.setBounds(410,500,100,25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLayout(null);
        setTitle("Check Balance Section");
        setBounds(0,0,900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }
            

//    public static void main(String args[]) {
//        // TODO code application logic here
//        new CheckBalance("");
//    }
}
