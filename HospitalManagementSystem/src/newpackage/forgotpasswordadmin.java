
package newpackage;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class forgotpasswordadmin implements ActionListener{
    JFrame f;
    JLabel L,l1,l2,l3;
    JTextField t1,t2;
    JButton b1,b2;
    Connection con;
    myconnection mycon;
    forgotpasswordadmin()
    {
        mycon=new myconnection();
        con=mycon.returnConnection();
        f=new JFrame("Forgot Password");
        l1=new JLabel("Admin ID");
        l1.setBounds(500,150,100,30);
        l2=new JLabel("Mobile Number");
        l2.setBounds(500,200,150,30);
        t1=new JTextField();
        t1.setBounds(680,150,100,25);
        t2=new JTextField();
        t2.setBounds(680,200,100,25);
        Font font=new Font("Arial Black",Font.BOLD,12);
        l1.setHorizontalAlignment(JLabel.CENTER);
        l2.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(font);
        l2.setFont(font);
        l3=new JLabel("FORGOT PASSWORD?");
        l3.setFont(new Font("Bookman Old Style",Font.BOLD,22));
        l3.setBounds(550,30,300,30);
        
        L=new JLabel();
        ImageIcon bg=new ImageIcon("F:\\javaswing\\HospitalManagementSystem\\src\\newpackage\\images\\image7.jpeg");
        L.setIcon(bg);
        L.setBounds(0,0,1500,800);
        b1=new JButton("Submit");
        b1.setBounds(600,300,80,30);
        
        b2=new JButton("BACK");
        b2.setBounds(700,300,80,30);
        L.add(l1);
        L.add(l2);
        L.add(l3);
        L.add(t1);
        L.add(t2);
        L.add(b1);
        L.add(b2);
        f.add(L);
        f.setSize(1500,800);
        f.setVisible(true);
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        
    }
    public static void main(String args[])
    {
        new forgotpasswordadmin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            String sql;
           try
           {
                sql="Select * from admin where admin_id=? and phone_no=?";
                PreparedStatement st=con.prepareStatement(sql);
                st.setString(1,t1.getText());
                st.setString(2,t2.getText());
                ResultSet rs=st.executeQuery();
                if(rs.next())
                {
                  JOptionPane.showMessageDialog(null,"Your Details \n"+"Admin ID              Password \n"+"--------------------------------------------\n"+"  "+rs.getString(1)+"       "+rs.getString(2));
                }
           }
           catch(Exception ex)
           {
               JOptionPane.showMessageDialog(null, ex);
           }
            
        }
        if(e.getSource()==b2)
        {
            f.setVisible(false);
            new loginadmin();
        }
    }
}
