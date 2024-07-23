package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    
    JButton deposite,withdrawl,fastcash,ministatement,pinchange,checkbalance,exit;
    String pinNumber;
    Transactions(String pinNumber)
    {
        this.pinNumber=pinNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3); 
        image.setBounds(0,0,900,900);
//        getContentPane().setBackground(Color.WHITE);
        add(image);
        
        JLabel text=new JLabel("Plez  Select Your Transaction.");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        text.setBounds(210,300,700,35);
        image.add(text);
        
        deposite=new JButton("Deposite");
        deposite.setBounds(170,415, 150,30);
        deposite.addActionListener(this);
        image.add(deposite);
        
        withdrawl=new JButton("Withdrawl");
        withdrawl.setBounds(355,415, 150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170,450, 150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(355,450, 150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange=new JButton("Pin Change");
        pinchange.setBounds(170,485, 150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        checkbalance=new JButton("Check Balance");
        checkbalance.setBounds(355,485, 150,30);
        checkbalance.addActionListener(this);
        image.add(checkbalance);
        
        exit=new JButton("Exit");
        exit.setBounds(355,520, 150,30);
        exit.addActionListener(this);
        image.add(exit);

        
        setSize(900,900);
        setTitle("Transaction Page");
        setLayout(null);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            System.exit(0);
        }
        else if(ae.getSource()==deposite)
        {
            setVisible(false);
            new Deposite(pinNumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawl)
        {
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash)
        {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }
         else if(ae.getSource()==pinchange)
        {
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }
         else if(ae.getSource()==checkbalance)
         {
             setVisible(false);
             new CheckBalance(pinNumber).setVisible(true);
         }
         else if(ae.getSource()==ministatement)
         {
            setVisible(false);
            new MiniStatement(pinNumber).setVisible(true);
         }
    }
//    public static void main(String args[]) {
//        // TODO code application logic here
//        new Transactions("");
//    }
}
