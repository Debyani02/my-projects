/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Driver;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class addpatient implements ActionListener
{
    JFrame f;
    JPanel p;
    JLabel L,l1,l2,l3,l4,l5;
    JTextField t1,t2,t3;
    JRadioButton r1,r2;        
    JButton b1,b2,b3;
    
    
    
    addpatient(){
        f=new JFrame("Add patient");
        L=new JLabel();
        ImageIcon bg=new ImageIcon("F:\\javaswing\\HospitalManagementSystem\\src\\newpackage\\images\\image3.jpeg");
        L.setIcon(bg);
        L.setBounds(0,0,1500,800);
        Font font=new Font("Callibari",Font.PLAIN,16);
        l1=new JLabel("ADD PATIENT");
        l1.setFont(new Font("Bookman Old Style",Font.BOLD,20));
        l1.setBounds(600,50,300,30);
        
        l2=new JLabel("Patient Name");
        l2.setBounds(500,200,100,30);
        l2.setFont(font);
        
        l3=new JLabel("Age");
        l3.setBounds(500,270,100,30);
        l3.setFont(font);
        
        l4=new JLabel("Gender");
        l4.setBounds(500,340,100,30);
        l4.setFont(font);
        
        t1=new JTextField();
        t1.setBounds(650,200,150,25);
        
        t2=new JTextField();
        t2.setBounds(650,270,150,25);
        
        b1=new JButton("BACK");
        b1.setBounds(550,480,100,30);
        
        b2=new JButton("ADD");
        b2.setBounds(700,480,100,30);
        
        r1=new JRadioButton("Male");
        r1.setBounds(650,340,100,30);
        
        r2=new JRadioButton("Female");
        r2.setBounds(800,340,100,30);
        
       ButtonGroup gender=new ButtonGroup();
        gender.add(r1);
        gender.add(r2);
        
        l5=new JLabel("Contact no.");
        l5.setBounds(500,410,100,30);
        l5.setFont(font);
        
        t3=new JTextField();
        t3.setBounds(650,410,150,25);
        
        p=new JPanel();
        p.setBounds(0,0,1500,800);
       
        L.add(l1);
        L.add(l1);
        L.add(l2);
        L.add(l3);
        L.add(l4);
        L.add(t1);
        L.add(t2);
        L.add(b1);
        L.add(b2);
        L.add(l5);
        L.add(r1);
        L.add(r2);
        L.add(t3);
        p.add(L);
        f.add(p);
        b1.addActionListener(this);
        b2.addActionListener(this);
        p.setLayout(null);
        f.setSize(1500,800);
        f.setLayout(null);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            new adminpage();
            f.setVisible(false);
        }
        
        if(e.getSource()==b2){
             try{
            String url="jdbc:mysql://localhost:3306/hospital";
            String username="root";
            String dbpwd="";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection(url,username,dbpwd);
            String sql="insert into patient (name,age,gender,contact_no) values(?,?,?,?)";
            PreparedStatement statement=connection.prepareStatement(sql);
            String gen=new String();
            
                if(r1.isSelected())
                    gen=("Male");
                else if(r2.isSelected())
                    gen="Female";
            
           
            
            statement.setString(1,t1.getText());
            statement.setString(2,t2.getText());
            statement.setString(3,gen);
            statement.setString(4,t3.getText());
            statement.execute();
            JOptionPane.showMessageDialog(null,"Inserted Successfully");
             }
             catch(Exception ex)
             {
                 JOptionPane.showMessageDialog(null, ex);
             }
            
        }
        
    }
    public static void main(String args[])
    {
        new addpatient();
    }
}
