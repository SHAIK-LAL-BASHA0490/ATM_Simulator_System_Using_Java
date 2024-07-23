    
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener{
    JButton withdrawl,back;
    JTextField amount;
    String pinNumber;
    Withdrawl(String pinNumber)
    {
        this.pinNumber=pinNumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Enter The Amount you want to Withdrwl.");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,14));
        text.setBounds(180,300,300,20);
        image.add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,300,25);
        image.add(amount);
        
        withdrawl=new JButton("Withdrawl");
        withdrawl.setBounds(355,485,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setTitle("Withdrawl Section");
        setLayout(null);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
  public void actionPerformed(ActionEvent ae)
  {
      if(ae.getSource()==withdrawl)
      {
          String withdrawl_amount=amount.getText();
          Date date=new Date();
          if(withdrawl_amount.equals(""))
          {
              JOptionPane.showMessageDialog(null,"Plez Enter the Amount you want to withdraw");
          }
          else
          {
              int balance=0;
              Conn c=new Conn();
              try
             {
                 String query="select * from bank where Pin_Number='"+pinNumber+"'";
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
                 if(Integer.parseInt(withdrawl_amount)<balance)
                 {
                     String query1="insert into bank values('"+pinNumber+"','"+date+"','Withdral','"+withdrawl_amount+"')";
                     c.s.executeUpdate(query1);
                     JOptionPane.showMessageDialog(null,"Rs "+withdrawl_amount+" withdrawl Succeessfully");
                     setVisible(false);
                     new Transactions(pinNumber).setVisible(true);
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null,"Insufficent Bank Balance !");
                     return;
                 }
             }
             catch(Exception e)
             {
                 System.out.println(e);
             }
          }
      }
      else if(ae.getSource()==back)
      {
          setVisible(false);
          new Transactions(pinNumber).setVisible(true);
      }
  }

//    public static void main(String args[]) {
//        // TODO code application logic here
//       new Withdrawl("");
//    }
}
