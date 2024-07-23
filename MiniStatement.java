package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class MiniStatement extends JFrame implements ActionListener{

    String pinNumber;
    JButton back;
    MiniStatement(String pinNumber) {
        this.pinNumber = pinNumber;

        JLabel bank = new JLabel("State Bank Of India");
        bank.setFont(new Font("Raleway", Font.BOLD, 16));
        bank.setBounds(110, 20, 200, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel text = new JLabel();
        text.setBounds(20, 100, 360, 400);
        add(text);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("RaleWay",Font.BOLD,16));
        back.setBounds(270,520,80,25);
        back.addActionListener(this);
        add(back);
        
        

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where Pin_Number='" + pinNumber + "'");
            while (rs.next()) {
                card.setText("Card Number: " + rs.getString("Card_Number").substring(0, 4) + "-XXXX-XXXX-" + rs.getString("Card_Number").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn con = new Conn();
            ResultSet result = con.s.executeQuery("select * from bank where Pin_Number='" + pinNumber + "'");
            StringBuilder sb = new StringBuilder("<html>");
            while (result.next()) {
                sb.append(result.getString("Date"))
                  .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                  .append(result.getString("Type"))
                  .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                  .append(result.getString("Amount"))
                  .append("<br>");
            }
            sb.append("</html>");
            text.setText(sb.toString());
        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(400, 600);
        setTitle("Mini Statement");
        setLayout(null);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }

//    public static void main(String[] args) {
//        new MiniStatement("");
//    }
}
