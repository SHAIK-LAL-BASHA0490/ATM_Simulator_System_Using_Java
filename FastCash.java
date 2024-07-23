package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JButton hundred,fivehundred,thuosand,twothuosand,fivethuosand,tenthuosand,back;
    String pinNumber;
    JLabel amount;
    FastCash(String pinNumber)
    {
        this.pinNumber=pinNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3); 
        image.setBounds(0,0,900,900);
//        getContentPane().setBackground(Color.WHITE);
        add(image);
        
        amount=new JLabel("Select Withdrawl Amount");
        amount.setFont(new Font("System",Font.BOLD,16));
        amount.setForeground(Color.WHITE);
        amount.setBounds(210,300,700,35);
        image.add(amount);
        
        hundred=new JButton("Rs 100");
        hundred.setBounds(170,415, 150,30);
        hundred.addActionListener(this);
        image.add(hundred);
        
        fivehundred=new JButton("Rs 500");
        fivehundred.setBounds(355,415, 150,30);
        fivehundred.addActionListener(this);
        image.add(fivehundred);
        
        thuosand=new JButton("Rs 1000");
        thuosand.setBounds(170,450, 150,30);
        thuosand.addActionListener(this);
        image.add(thuosand);
        
        twothuosand=new JButton("Rs 2000");
        twothuosand.setBounds(355,450, 150,30);
        twothuosand.addActionListener(this);
        image.add(twothuosand);
        
        fivethuosand=new JButton("Rs 5000");
        fivethuosand.setBounds(170,485, 150,30);
        fivethuosand.addActionListener(this);
        image.add(fivethuosand);
        
        tenthuosand=new JButton("Rs 10000");
        tenthuosand.setBounds(355,485, 150,30);
        tenthuosand.addActionListener(this);
        image.add(tenthuosand);
        
        back=new JButton("Back");
        back.setBounds(355,520, 150,30);
        back.addActionListener(this);
        image.add(back);

        
        setSize(900,900);
        setTitle("Transaction Page");
        setLayout(null);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        else
        {
            String number=((JButton)ae.getSource()).getText().substring(3);
//            int total_amount=Integer.parseInt(number);
            Conn c=new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where Pin_Number='"+pinNumber+"'");
                int balance=0;
                while(rs.next())
                {
                    if(rs.getString("Type").equals("Deposite"))
                    {
                        balance=balance+ Integer.parseInt(rs.getString("Amount"));
                    }
                    else
                    {
                        balance=balance-Integer.parseInt(rs.getString("Amount"));
                    }
                }
                if(balance<Integer.parseInt(number))
                {
                    JOptionPane.showMessageDialog(null,"Insufficent Balance");
                    return;    
                }
                else
                {
                    Date date=new Date();
                    String query="insert into bank values('"+pinNumber+"','"+date+"','Withdrawl','"+number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" Debited Successfully.");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
//        else if(ae.getSource()==deposite)
//        {

//            setVisible(false);
//            new Deposite(pinNumber).setVisible(true);
//        }
//        else if(ae.getSource()==withdrawl)
//        {
//            setVisible(false);
//            new Withdrawl(pinNumber).setVisible(true);
//        }
    }
//    public static void main(String args[]) {
//        // TODO code application logic here
//        new FastCash("");
//    }
}
