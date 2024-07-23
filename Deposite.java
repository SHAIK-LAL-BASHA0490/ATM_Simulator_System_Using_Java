    
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposite extends JFrame implements ActionListener{
    JButton deposite,back;
    JTextField amount;
    String pinNumber;
    Deposite(String pinNumber)
    {
        this.pinNumber=pinNumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Enter The Amount you want to Deposite.");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,14));
        text.setBounds(180,300,300,20);
        image.add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,300,25);
        image.add(amount);
        
        deposite=new JButton("Deposite");
        deposite.setBounds(355,485,150,30);
        deposite.addActionListener(this);
        image.add(deposite);
        
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setTitle("Deposite Section");
        setLayout(null);
        setLocation(300,0);
        setVisible(true);
        
    }
  public void actionPerformed(ActionEvent ae)
  {
      if(ae.getSource()==deposite)
      {
          String deposite_amount=amount.getText();
          Date date=new Date();
          if(deposite_amount.equals(""))
          {
              JOptionPane.showMessageDialog(null,"Plez Enter the Amount you want to deposite");
          }
          else
          {
              try
             {
              Conn c=new Conn();
              String query="insert into bank values('"+pinNumber+"','"+date+"','Deposite','"+deposite_amount+"')";
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"Rs "+deposite_amount+" Deposited Succeessfully");
              setVisible(false);
              new Transactions(pinNumber).setVisible(true);
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
//       new Deposite("");
//    }
}
