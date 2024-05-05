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

public class bookappointment implements ActionListener ,ItemListener{
    JFrame f;
    JPanel p;
    JLabel L,l1,l2,l3,l4,l5,l6;
    JTextField t1,t3;
    JComboBox cb1,cb2,cb3;
    JButton b1,b2;
    Connection con;
    myconnection mycon;
    bookappointment()
    {
        mycon=new myconnection();
        con=mycon.returnConnection();
        String sql;
        
        f=new JFrame("Booking Appointment");
        p=new JPanel();
        p.setBounds(1,1,1500,800);
        L=new JLabel();
        Font font=new Font("Callibari",Font.PLAIN,16);
        ImageIcon bg=new ImageIcon("F:\\javaswing\\HospitalManagementSystem\\src\\newpackage\\images\\image1.jpeg");
        L.setIcon(bg);
        L.setBounds(0,0,1500,800);
        l1=new JLabel("BOOK APPOINTMENT PAGE");
        l1.setFont(new Font("Bookman Old Style",Font.BOLD,22));
        l1.setBounds(500,50,600,30);
        
        l5=new JLabel("Doctor");
        l5.setBounds(500,200,100,30);
        l5.setFont(font);
        
        
        
        cb1=new JComboBox();
        cb1.setBounds(650,200,100,25);
        
        
        try{
        sql="Select name from doctors ";    
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        cb1.addItem("Select");
        while(rs.next())
        {
           String department=rs.getString(1);
           cb1.addItem(department);
        }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
        cb2=new JComboBox();
        cb2.setBounds(650,300,100,30);
        cb2.addItem("Select");
        try{
        sql="Select p_id from patient ";    
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        while(rs.next())
        {
           String department=rs.getString(1);
           cb2.addItem(department);
        }
        }
        catch(Exception ex1)
        {
            JOptionPane.showMessageDialog(null, ex1);
        }
       
        
        l2=new JLabel("Doctor ID");
        l2.setBounds(500,250,150,30);
        l2.setFont(font);
        
        
        
        l3=new JLabel("Patient ID");
        l3.setBounds(500,300,100,30);
        l3.setFont(font);
        
        l4=new JLabel("Appointment date");
        l4.setBounds(500,350,150,30);
        l4.setFont(font);
        
        l6=new JLabel("Time Slot");
        l6.setBounds(500,400,100,30);
        l6.setFont(font);
        
        cb3=new JComboBox();
        cb3.setBounds(650,400,100,30);
        cb3.addItem("Select");
        cb3.addItem("11:00-11:30");
        cb3.addItem("11:30-12:00");
        cb3.addItem("12:00-12:30");
        cb3.addItem("12:30-01:00");
        cb3.addItem("05:00-05:30");
        cb3.addItem("05:30-06:00");
        cb3.addItem("06:00-06:30");
        cb3.addItem("06:30-07:00");
        cb3.addItem("07:00-07:30");
        cb3.addItem("07:30-08:00");

        
        t1=new JTextField();
        t1.setBounds(650,250,100,25);
        t1.setEditable(false);
        
        
        
        t3=new JTextField("YYYY/MM/DD");
        t3.setBounds(650,350,100,25);
        
       
        b1=new JButton("BACK");
        b1.setBounds(500,450,70,30);
        b2=new JButton("BOOK APPOINTMENT");
        b2.setBounds(600,450,170,30);
        L.add(b1);
        L.add(b2);
        L.add(l1);
        L.add(l2);
        L.add(l3);
        L.add(l4);
        L.add(l5);
        L.add(l6);
        
        L.add(t1);
        L.add(t3);
        L.add(cb1);
        L.add(cb2);
        L.add(cb3);
        
       
        p.add(L);
        b1.addActionListener(this);
        b2.addActionListener(this);
        cb1.addItemListener(this);
        cb2.addItemListener(this);
        p.setLayout(null);
        f.add(p);
        f.setSize(1500,800);
        f.setLocation(0,0);
        f.setLayout(null);
        f.setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            new adminpage();
            f.setVisible(false);
        }
        if(e.getSource()==b2)
        {
            try{
            
            String sql="Select d_id,appointment_date,appointment_time from appointment where d_id=? and appointment_date=? and appointment_time=?";
            PreparedStatement statement=con.prepareStatement(sql);
            statement.setString(1,t1.getText());
            statement.setString(2,t3.getText());
            statement.setString(3,(String)cb3.getSelectedItem());
            ResultSet resultset1=statement.executeQuery();
            
            if(!resultset1.next())
            {
                String sql2="Insert into appointment(d_id,p_id,appointment_date,appointment_time) values(?,?,?,?)";
                PreparedStatement statement2=con.prepareStatement(sql2);
                statement2.setString(1,t1.getText());
                statement2.setString(2,(String)cb2.getSelectedItem());
                statement2.setString(3,t3.getText());
                statement2.setString(4,(String)cb3.getSelectedItem());
                statement2.execute();
                JOptionPane.showMessageDialog(null,"Appointment Booked !");
            }
            else{
                JOptionPane.showMessageDialog(null,"Doctor not available . Try another date!");
            }
            
            
            
        }
        catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex);
        }
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent ev) 
    {
        
        if(ev.getStateChange()==ItemEvent.SELECTED)
        {
       try{
           String name=(String)cb1.getSelectedItem();
           String sql3="Select d_id from doctors where name=?";
           PreparedStatement st2=con.prepareStatement(sql3);
           st2.setString(1,name);
           ResultSet rs2=st2.executeQuery();
           
           if(rs2.next())
           {
               int id=rs2.getInt(1);
               String result=String.valueOf(id);
               t1.setText(result);
           }
           
           
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        
        
     }
    
    
    public static void main(String args[])
    {
     new bookappointment();   
    }

    
}

