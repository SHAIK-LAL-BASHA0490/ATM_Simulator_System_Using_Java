
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

    JLabel additional_details,religion,category,income,educational,occupation,pan_number,adhar_number,senior_citizen,exisiting_account;
    JButton next;
    JComboBox religionTextField,categoryTextField,incomeTextField,educationalTextField,occupationTextField;
    JTextField panTextField,adharTextField;
    JRadioButton syes,sno,eyes,eno;
    ButtonGroup seniorcitizenTextField, exisiting_accountTextField;
    String formno;
    
    SignupTwo(String formno)
    {
        this.formno=formno;
        additional_details=new JLabel("Page 2: Additional Details");
        additional_details.setFont(new Font("Raleway",Font.BOLD,28));
        additional_details.setBounds(200,15, 350, 32);
        add(additional_details);
        
        religion=new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,22));
        religion.setBounds(100,80,100,30);
        add(religion);
        
        String Religion[]={"Hindu","Muslim","Christian","Sikh","Other"};
        religionTextField=new JComboBox(Religion);
        religionTextField.setBounds(320,80,300,30);
        religionTextField.setBackground(Color.WHITE);
        add(religionTextField);
        
        category=new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,22));
        category.setBounds(100,130,100,30);
        add(category);
        
        String Category[]={"General","OBC","SC","ST","Other"};
        categoryTextField=new JComboBox(Category);
        categoryTextField.setBounds(320,130,300,30);
        categoryTextField.setBackground(Color.WHITE);
        add(categoryTextField);
        
        income=new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,22));
        income.setBounds(100,180,100,30);
        add(income);
        
        String Income[]={"Null","<1,50,000","< 2,50,000","< 5,00,000","upto 10,00,000"};
        incomeTextField=new JComboBox(Income);
        incomeTextField.setBounds(320,180,300,30);
        incomeTextField.setBackground(Color.WHITE);
        add(incomeTextField);
        
        educational=new JLabel("Educational:");
        educational.setFont(new Font("Raleway",Font.BOLD,22));
        educational.setBounds(100,230,150,30);
        add(educational);
        
        String Educational[]={"non Graduation","Graduation","Post Graduation","Doctrate","Others"};
        educationalTextField=new JComboBox(Educational);
        educationalTextField.setBounds(320,230,300,30);
        educationalTextField.setBackground(Color.WHITE);
        add(educationalTextField);
        
//        qualification=new JLabel("Qualification:");
//        qualification.setFont(new Font("Raleway",Font.BOLD,22));
//        qualification.setBounds(100,280,150,30);
//        add(qualification);
       
        occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,22));
        occupation.setBounds(100,280,150,30);
        add(occupation);
        
        String Occupation[]={"Salaried","Self  Employed","Bussiness","Student","Retired","Others"};
        occupationTextField=new JComboBox(Occupation);
        occupationTextField.setBounds(320,280,300,30);
        occupationTextField.setBackground(Color.WHITE);
        add(occupationTextField);
        
        pan_number=new JLabel("PAN Number:");
        pan_number.setFont(new Font("Raleway",Font.BOLD,18));
        pan_number.setBounds(100,330,150,30);
        add(pan_number);
        
        panTextField=new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,18));
        panTextField.setBounds(320,330,300,30);
        add(panTextField);
        
        adhar_number=new JLabel("Adhar Number:");
        adhar_number.setFont(new Font("Raleway",Font.BOLD,18));
        adhar_number.setBounds(100,380,160,30);
        add(adhar_number);
        
        adharTextField=new JTextField();
        adharTextField.setFont(new Font("Raleway",Font.BOLD,18));
        adharTextField.setBounds(320,380,300,30);
        add(adharTextField);
        
        senior_citizen=new JLabel("Senior Citizen:");
        senior_citizen.setFont(new Font("Raleway",Font.BOLD,22));
        senior_citizen.setBounds(100,430,160,30);
        add(senior_citizen);
        
        syes=new JRadioButton("Yes");
        syes.setFont(new Font("Raleway",Font.BOLD,22));
        syes.setBackground(Color.WHITE);
        syes.setBounds(320,430,80,18);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setFont(new Font("Raleway",Font.BOLD,22));
        sno.setBackground(Color.WHITE);
        sno.setBounds(450,430,80,18);
        add(sno);
        
        seniorcitizenTextField=new ButtonGroup();
        seniorcitizenTextField.add(syes);
        seniorcitizenTextField.add(sno);
        
        exisiting_account=new JLabel("Exisiting Account:");
        exisiting_account.setFont(new Font("Raleway",Font.BOLD,22));
        exisiting_account.setBounds(100,480,200,30);
        add(exisiting_account);
        
        eyes=new JRadioButton("Yes");
        eyes.setFont(new Font("Raleway",Font.BOLD,22));
        eyes.setBackground(Color.WHITE);
        eyes.setBounds(320,480,80,18);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setFont(new Font("Raleway",Font.BOLD,22));
        eno.setBackground(Color.WHITE);
        eno.setBounds(450,480,80,18);
        add(eno);
        
        exisiting_accountTextField=new ButtonGroup();
        exisiting_accountTextField.add(syes);
        exisiting_accountTextField.add(sno);
        
        next=new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,25));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(500, 530, 100,30);
        next.addActionListener(this);
        add(next);
        
        setSize(750,700);
        setLayout(null);
        setLocation(350,10);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
            
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String sreligion=(String)religionTextField.getSelectedItem();
        String scategory=(String)categoryTextField.getSelectedItem();
        String sincome=(String)incomeTextField.getSelectedItem();
        String seducational=(String)educationalTextField.getSelectedItem();
        String soccupation=(String)occupationTextField.getSelectedItem();
        String spannumber=panTextField.getText();
        String sadharnumber=adharTextField.getText();
        String sseniorcitizen=null;
        if(syes.isSelected())
        {
            sseniorcitizen="yes";
        }
        else if(sno.isSelected())
        {
            sseniorcitizen="No";
        }
        
        String exisitingaccount=null;
        if(eyes.isSelected())
        {
            exisitingaccount="Yes";
        }
        else if(eno.isSelected())
        {
            exisitingaccount="No";
        }
            
        
        try{
                Conn c=new Conn();
                String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducational+"','"+soccupation+"','"+spannumber+"','"+sadharnumber+"','"+sseniorcitizen+"','"+exisitingaccount+"')";
                c.s.executeUpdate(query);
//                signup3 objext
                  setVisible(false);
                  new SignupThree(formno).setVisible(true);
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
   
//    public static void main(String args[]) {
//        // TODO code application logic here
//        new SignupTwo("");
//    }
}
