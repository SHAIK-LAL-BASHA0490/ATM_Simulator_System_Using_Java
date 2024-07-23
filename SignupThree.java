
package bank.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    JLabel account_details,account_type,card_number,card_password,card_details,pin_number,pin_password,pin_details,service_required;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    SignupThree(String formno){
        this.formno=formno;
        setSize(750,750);
        setLayout(null);
        setLocation(350,10);
        setTitle("ACCOUNT DETAILS");
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
        account_details=new JLabel("Page 3: Account Details");
        account_details.setFont(new Font("Raleway",Font.BOLD,30));
        account_details.setBounds(250,20,400,30);
        add(account_details);
        
        account_type=new JLabel("Account Type:");
        account_type.setFont(new Font("Raleway",Font.BOLD,25));
        account_type.setBounds(100,80,300,30);
        add(account_type);
        
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,18));
        r1.setBounds(100,120,200,20);
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2=new JRadioButton("Fixed Deposite Account");
        r2.setFont(new Font("Raleway",Font.BOLD,18));
        r2.setBounds(300,120,250,20);
        r2.setBackground(Color.WHITE);
        add(r2);
        
        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,18));
        r3.setBounds(100,160,200,20);
        r3.setBackground(Color.WHITE);
        add(r3);
        
        r4=new JRadioButton("Recurring Deposite Account");
        r4.setFont(new Font("Raleway",Font.BOLD,18));
        r4.setBounds(300,160,300,20);
        r4.setBackground(Color.WHITE);
        add(r4);
        
        ButtonGroup account=new ButtonGroup();
        account.add(r1);
        account.add(r2);
        account.add(r3);
        account.add(r4);
        
        card_number=new JLabel("Card Number:");
        card_number.setFont(new Font("Raleway",Font.BOLD,25));
        card_number.setBounds(100,220,300,30);
        add(card_number);
        
        card_password=new JLabel("XXXX-XXXX-XXXX-XXXX-3412");
        card_password.setFont(new Font("Raleway",Font.BOLD,20));
        card_password.setBounds(300,220,300,30);
        add(card_password);
        
        card_details=new JLabel("Your 16 Digit Card Number");
        card_details.setFont(new Font("Raleway",Font.BOLD,12));
        card_details.setBounds(100,255,300,15);
        add(card_details);
        
        pin_number=new JLabel("Pin Number:");
        pin_number.setFont(new Font("Raleway",Font.BOLD,25));
        pin_number.setBounds(100,300,300,30);
        add(pin_number);
        
        pin_password=new JLabel("XXXX");
        pin_password.setFont(new Font("Raleway",Font.BOLD,20));
        pin_password.setBounds(300,300,300,30);
        add(pin_password);
        
        pin_details=new JLabel("Your 4 Digit Pincode/Password");
        pin_details.setFont(new Font("Raleway",Font.BOLD,12));
        pin_details.setBounds(100,335,300,15);
        add(pin_details);
        
        service_required=new JLabel("Services Required:");
        service_required.setFont(new Font("Raleway",Font.BOLD,25));
        service_required.setBounds(100,390,300,30);
        add(service_required);
        
        c1=new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway",Font.BOLD,14));
        c1.setBounds(100, 440, 150, 20);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        c2=new JCheckBox("internet banking");
        c2.setFont(new Font("Raleway",Font.BOLD,14));
        c2.setBounds(300, 440, 150, 20);
        c2.setBackground(Color.WHITE);
        add(c2);
        
        c3=new JCheckBox("Mobile banking");
        c3.setFont(new Font("Raleway",Font.BOLD,14));
        c3.setBounds(500, 440, 150, 20);
        c3.setBackground(Color.WHITE);
        add(c3);
        
        c4=new JCheckBox("Email & SMS alert");
        c4.setFont(new Font("Raleway",Font.BOLD,14));
        c4.setBounds(100, 500, 150, 20);
        c4.setBackground(Color.WHITE);
        add(c4);
        
        c5=new JCheckBox("Cheque book");
        c5.setFont(new Font("Raleway",Font.BOLD,14));
        c5.setBounds(300, 500, 150, 20);
        c5.setBackground(Color.WHITE);
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,14));
        c6.setBounds(500, 500, 150, 20);
        c6.setBackground(Color.WHITE);
        add(c6);
        
        c7=new JCheckBox("I hereby declres the above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("Raleway",Font.BOLD,10));
        c7.setBounds(100, 540, 600, 20);
        c7.setBackground(Color.WHITE);
        add(c7);
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(400,580,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(550,580,100,30);
        submit.addActionListener(this);
        add(submit);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
     if(ae.getSource()==submit)
     {
         String account=null;
         if(r1.isSelected())
         {
             account="Saving Account";
         }
         else if(r2.isSelected())
         {
             account="Fixed Deposite Account";
         }
         else if(r3.isSelected())
         {
             account="Current Account";
         }
         else if(r4.isSelected())
         {
             account="Reccuring Deposite Account";
         }
          Random random=new Random();
          String card_Number= ""+Math.abs(1914113412000000L+random.nextLong()%900000L);
          String pinNumber=""+Math.abs((random.nextLong()%9000L)+1000L);
          
          String facility="";
          if(c1.isSelected())
          {
              facility=facility+" ATM Card";
          }
          else if(c2.isSelected())
          {
              facility=facility+" Internet Banking";
          }
          else if(c3.isSelected())
          {
              facility=facility+" Mobile Banking";
          }
          else if(c4.isSelected())
          {
              facility=facility+" Email & SMS alerts";
          }
          else if(c5.isSelected())
          {
              facility=facility+" Cheque Book";
          }
          else if(c6.isSelected())
          {
              facility=facility+" E-Statement";
          }
          
          try{
              if(account.equals(""))
              {
                  JOptionPane.showMessageDialog(null,"Account type is Required !");
              }
              else
              {
               Conn c=new Conn();
               String query="insert into signupthree values('"+formno+"','"+account+"','"+card_Number+"','"+pinNumber+"','"+facility+"')";   
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Successfully Signup\nCard Number: "+card_Number+" \nPin Number: "+pinNumber);
               String query2="insert into login values('"+formno+"','"+card_Number+"','"+pinNumber+"')";
               c.s.executeUpdate(query2);
               setVisible(false);
               new Deposite(pinNumber).setVisible(true);
              }          
          }
          catch(Exception e)
          {
              System.out.println(e);
          }
     }
    
     else if(ae.getSource()==cancel)
     {
         setVisible(false);
         new Login().setVisible(true);
     }
    }

//    public static void main(String args[]) {
//        // TODO code application logic here
//        new SignupThree("");
//    }
}
