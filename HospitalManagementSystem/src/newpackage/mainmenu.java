/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class mainmenu implements ActionListener
{
    JFrame f;
    JPanel p,p1;
    JLabel l1,l2,L,l3,l4,l5,l6,l7,l8;
    JButton b2,b4;
    mainmenu(){
        f=new JFrame("Welcome Page");
        p=new JPanel();
        p.setBounds(1,1,1500,800);
        L=new JLabel();
        ImageIcon bg=new ImageIcon("F:\\javaswing\\HospitalManagementSystem\\src\\newpackage\\images\\image7.jpeg");
        L.setIcon(bg);
        L.setBounds(0,0,1500,800);
        
        l1=new JLabel("HOSPITAL MANAGEMENT SYSTEM");
        l2=new JLabel("WELCOME");
        l1.setFont(new Font("Bookman Old Style",Font.BOLD,22));
        l1.setBounds(500,50,600,30);
        l2.setFont(new Font("Callibari",Font.BOLD,18));
        
        
        p1=new JPanel();
        p1.setBounds(400,150,600,400);
        p1.setFont(new Font("Callibari",Font.ITALIC,18));
        p1.setLayout(null);
        p1.add(l2);
        l2.setBounds(250,50,200,30);
        
        l3=new JLabel();
        ImageIcon bg1=new ImageIcon("F:\\javaswing\\HospitalManagementSystem\\src\\newpackage\\images\\doctorlogo1.jpeg");
        l3.setIcon(bg1);
        p1.add(l3);
        l3.setBounds(30,130,150,150);
        
        l4=new JLabel();
        ImageIcon bg2=new ImageIcon("F:\\javaswing\\HospitalManagementSystem\\src\\newpackage\\images\\emergencylogo1.jpeg");
        l4.setIcon(bg2);
        p1.add(l4);
        l4.setBounds(230,130,150,150);
        
        l5=new JLabel();
        ImageIcon bg3=new ImageIcon("F:\\javaswing\\HospitalManagementSystem\\src\\newpackage\\images\\modernlogo1.jpeg");
        l5.setIcon(bg3);
        p1.add(l5);
        l5.setBounds(420,130,150,150);
        
        l6=new JLabel("Specialized Doctors");
        p1.add(l6);
        l6.setBounds(50,280,200,30);
        
        l7=new JLabel("Emergency Services");
        p1.add(l7);
        l7.setBounds(250,280,200,30);
        
        l8=new JLabel("Diagnosis");
        p1.add(l8);
        l8.setBounds(470,280,200,30);
        
        b2=new JButton("Admin Login");
        b2.setBounds(500,600,150,30);
       
        b4=new JButton("Doctor's Login");
        b4.setBounds(700,600,150,30);
        
        b2.addActionListener(this);
        b4.addActionListener(this);
        L.add(p1);
        L.add(l1);
        L.add(b2);
        L.add(b4);
        p.add(L);
        p.setLayout(null);
        f.add(p);
        f.setSize(1500,800);
        f.setLocation(0,0);
        f.setLayout(null);
        f.setVisible(true);
        
    }
            
    public static void main(String args[])
    {
        try{
            new mainmenu();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        

    }

    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource()==b2)
        {
            f.setVisible(false);
            new loginadmin();
        }
        
        if(e.getSource()==b4)
        {
            f.setVisible(false);
            new logindoctor();
        }
     
        
    }

    }
    
