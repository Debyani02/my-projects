
package newpackage;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Driver;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class cancelappointment implements ActionListener 
{
 
    JFrame f;
    JLabel L,l1,l2,l3,l4,l5;
    JButton b1,b2,b3;
    JComboBox cb1,cb2;
    JTextField t1,t2;
    JPanel p;
    Connection con;
    myconnection mycon;
    cancelappointment()
    {
        mycon=new myconnection();
        con=mycon.returnConnection();
        String sql;
        f=new JFrame("Cancel Appointment");
        p=new JPanel();
        p.setBounds(1,1,1500,800);
        L=new JLabel();
        Font font=new Font("Callibari",Font.PLAIN,16);
        ImageIcon bg=new ImageIcon("F:\\javaswing\\HospitalManagementSystem\\src\\newpackage\\images\\image1.jpeg");
        L.setIcon(bg);
        L.setBounds(0,0,1500,800);
        l1=new JLabel("CANCEL APPOINTMENT PAGE");
        l1.setFont(new Font("Bookman Old Style",Font.BOLD,22));
        l1.setBounds(500,50,600,30);
        
        l2=new JLabel("Patient ID");
        l2.setBounds(500,200,200,30);
        l2.setFont(font);
        cb1=new JComboBox();
        cb1.setBounds(650,200,100,25);
        
        try{
        sql="Select p_id from patient  ";    
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        cb1.addItem("Select");
        while(rs.next())
        {
           int id=rs.getInt(1);
           cb1.addItem(id);
        }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        l3=new JLabel("Doctor ID");
        l3.setBounds(500,250,200,30);
        l3.setFont(font);
        cb2=new JComboBox();
        cb2.setBounds(650,250,100,25);
        cb2.addItem("Select");
        try{
        sql="Select d_id from doctors ";    
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        while(rs.next())
        {
           int id=rs.getInt(1);
           cb2.addItem(id);
        }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        l4=new JLabel("Appointment Date");
        l4.setBounds(500,300,150,30);
        l4.setFont(font);
        t1=new JTextField("YYYY/MM/DD");
        t1.setBounds(650,300,100,25);
        
        b3=new JButton("Check");
        b3.setBounds(780,300,100,25);
        
        l5=new JLabel("Appointment ID");
        l5.setBounds(500,350,150,30);
        l5.setFont(font);
        t2=new JTextField();
        t2.setBounds(650,350,100,25);
        t2.setEditable(false);
       
        b1=new JButton("CANCEL ");
        b1.setBounds(500,420,100,30);
        
        b2=new JButton("BACK");
        b2.setBounds(650,420,70,30);
        
       
        
        L.add(l1);
        L.add(l2);
        L.add(l3);
        L.add(l4);
        L.add(l5);
        L.add(b1);
        L.add(b2);
        L.add(b3);
        L.add(t1);
        L.add(t2);
        L.add(cb2);
        L.add(cb1);
        
        p.add(L);
        f.add(p);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        p.setLayout(null);
        f.setSize(1500,800);
        f.setLocation(0,0);
        f.setLayout(null);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b1)
        {
      try
      {
          String sql="Delete from appointment where a_id=?";
          PreparedStatement str=con.prepareStatement(sql);
          int id=Integer.parseInt(t2.getText());
          str.setInt(1,id);
          str.execute();
          JOptionPane.showMessageDialog(null,"Appointment id = "+id+"\n Cancelled!");
          
       }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, ex);
      }
        }
         if(e.getSource()==b2)
        {
            f.setVisible(false);
            new doctorpage();
        }
         if(e.getSource()==b3)
         {
             try{
                 String sql="Select a_id from appointment where d_id=? and appointment_date=? and p_id=?";
                 PreparedStatement str=con.prepareStatement(sql);
                 str.setInt(1,(int)cb2.getSelectedItem());
                 str.setString(2,t1.getText());
                 str.setInt(3,(int)cb1.getSelectedItem());
                 ResultSet rs=str.executeQuery();
                 
                 if(rs.next())
                 {
                     int aid=rs.getInt(1);
                     String result=String.valueOf(aid);
                     t2.setText(result);
                     
                 }
                 else{ JOptionPane.showMessageDialog(null, "No appointments found!");}
             }
             catch(Exception ex)
             {
                 JOptionPane.showMessageDialog(null, ex);
             }
         }
    }
    public static void main(String args[])
    {
        new cancelappointment();
    }

    
    
}
