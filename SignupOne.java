package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{

    JTextField nameField, fNameField, emailField, addressField, pinField, stateField, cityField;
    JDateChooser dateChooser;
    JButton next;
    JRadioButton male,female,other,others,married,unmarried;
    long random;

    SignupOne() {
        setLayout(null);

        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 9000L + 1000L);

        JLabel formNo = new JLabel("APPLICATION FORM NO: " + random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setBounds(140, 20, 600, 40);
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(270, 80, 400, 30);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        name.setBounds(100, 150, 80, 30);
        add(name);

        nameField = new JTextField();
        nameField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameField.setBounds(300, 150, 350, 30);
        add(nameField);

        JLabel fName = new JLabel("Father's Name:");
        fName.setFont(new Font("Raleway", Font.BOLD, 18));
        fName.setBounds(100, 200, 200, 30);
        add(fName);

        fNameField = new JTextField();
        fNameField.setFont(new Font("Raleway", Font.BOLD, 14));
        fNameField.setBounds(300, 200, 350, 30);
        add(fNameField);

        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        dob.setBounds(100, 250, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 250, 350, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        gender.setBounds(100, 300, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 300, 80, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(420, 300, 80, 30);
        female.setBackground(Color.WHITE);
        add(female);

        other = new JRadioButton("Others");
        other.setBounds(540, 300, 80, 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        JLabel email = new JLabel("Email id:");
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        email.setBounds(100, 350, 200, 30);
        add(email);

        emailField = new JTextField();
        emailField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailField.setBounds(300, 350, 350, 30);
        add(emailField);

        JLabel marriedStatus = new JLabel("Marital Status:");
        marriedStatus.setFont(new Font("Raleway", Font.BOLD, 18));
        marriedStatus.setBounds(100, 400, 200, 30);
        add(marriedStatus);

        married = new JRadioButton("Married");
        married.setBounds(300, 400, 80, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(420, 400, 80, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        others = new JRadioButton("Others");
        others.setBounds(540, 400, 80, 30);
        others.setBackground(Color.WHITE);
        add(others);

        ButtonGroup marriedStatusGroup = new ButtonGroup();
        marriedStatusGroup.add(married);
        marriedStatusGroup.add(unmarried);
        marriedStatusGroup.add(others);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        address.setBounds(100, 450, 200, 30);
        add(address);

        addressField = new JTextField();
        addressField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressField.setBounds(300, 450, 350, 30);
        add(addressField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        city.setBounds(100, 500, 200, 30);
        add(city);

        cityField = new JTextField();
        cityField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityField.setBounds(300, 500, 350, 30);
        add(cityField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        state.setBounds(100, 550, 200, 30);
        add(state);

        stateField = new JTextField();
        stateField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateField.setBounds(300, 550, 350, 30);
        add(stateField);

        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        pin.setBounds(100, 600, 200, 30);
        add(pin);

        pinField = new JTextField();
        pinField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinField.setBounds(300, 600, 350, 30);
        add(pinField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(570, 650, 80, 30);
        next.setFont(new Font("Raleway", Font.BOLD, 18));
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(800, 800);
        setLocation(350, 10);
        setTitle("SignUp Page:1");
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String formno=""+random;
        String name=nameField.getText();// setText
        String fname=fNameField.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected())
        {
            gender="Male";
        }
        else if(female.isSelected())
        {
            gender="Female";
        }
        else
        {
            gender="Others";
        }
        String email=emailField.getText();
        String marital=null;
        if(unmarried.isSelected())
        {
            marital="Single";
        }
        else if(married.isSelected())
        {
            marital="Married";
        }
            
        String address=addressField.getText();
        String city=cityField.getText();
        String state=stateField.getText();
        String pin=pinField.getText();
        
        try{
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Name is Reqruried!");
            }
            else
            {
                Conn c=new Conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
    }

//    public static void main(String args[]) {
//        new SignupOne();
//    }
}
