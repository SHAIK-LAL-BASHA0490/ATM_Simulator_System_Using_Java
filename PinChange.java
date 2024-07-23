
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PinChange extends JFrame implements ActionListener {
    
    JButton back,change;
    JPasswordField newpin,repin;
    String pinNumber;
    
    PinChange(String pinNumber)
    {
        this.pinNumber=pinNumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Change Your Pin Number");
        text.setForeground(Color.WHITE);
        text.setBounds(200,300,300,30);
        text.setFont(new Font("System",Font.BOLD,20));
        image.add(text);
        
        JLabel newpin1=new JLabel("Enter New Pin:");
        newpin1.setForeground(Color.WHITE);
        newpin1.setBounds(165,350,300,30);
        newpin1.setFont(new Font("System",Font.BOLD,16));
        image.add(newpin1);
        
        JLabel repin1=new JLabel("Re-Enter New Pin:");
        repin1.setForeground(Color.WHITE);
        repin1.setBounds(165,400,300,30);
        repin1.setFont(new Font("System",Font.BOLD,16));
        image.add(repin1);
        
        newpin=new JPasswordField();
        newpin.setFont(new Font("System",Font.BOLD,16));
        newpin.setBounds(320,350,190,30);
        image.add(newpin);
        
        repin=new JPasswordField();
        repin.setFont(new Font("System",Font.BOLD,16));
        repin.setBounds(320,400,190,30);
        image.add(repin);
        
        change=new JButton("Change");
        change.setFont(new Font("Raleway",Font.BOLD,16));
        change.setBackground(Color.BLACK);
        change.setForeground(Color.WHITE);
        change.setBounds(410,500,100,30);
        change.addActionListener(this);
        image.add(change);
        
        back=new JButton("Back");
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300,500,100,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setTitle("Pin Change Section");
        setUndecorated(true);
        setLocation(300,0);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        else if(ae.getSource()==change)
        {
            String str1=newpin.getText();
            String str2=repin.getText();
            if(str1.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Plez Enter New Pin");
                return;
            }
            else if(str2.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Plez Enter Re-Pin");
                return;
            }
            else if(!str1.equals(str2))
            {
                JOptionPane.showMessageDialog(null,"Entered Pin doesn't Match");
                return;
            }
            else
            {
                Conn c=new Conn();
                try
                {
                 String query1="update bank set Pin_Number='"+str1+"' where Pin_Number='"+pinNumber+"'";
                 String query2="update login set Pin_Number='"+str1+"' where Pin_Number='"+pinNumber+"'";
                 String query3="update signupthree set Pin_Number='"+str1+"' where Pin_Number='"+pinNumber+"'";
                 
                 c.s.executeUpdate(query1);
                 c.s.executeUpdate(query2);
                 c.s.executeUpdate(query3);
                 
                 JOptionPane.showMessageDialog(null,"Pin Number Changed Successfully");
                 setVisible(false);
                 new Transactions(str2).setVisible(true);
                }
                catch(Exception e)
                {
                   System.out.println(e);
                }
            }
            
        }
    }

//    public static void main(String args[]) {
//        // TODO code application logic here
//        new PinChange("").setVisible(true);
//    }
}
