package newpackage;


import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class loginadmin implements ActionListener
{
    JFrame f;
    JLabel L,l1,l2,l3;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2,b3;
    JPanel p;
    loginadmin()
    {
        f=new JFrame("Login");
        p=new JPanel();
        p.setBounds(0,0,1500,800);
        l1=new JLabel("Username");
        l2=new JLabel("Password");
        l3=new JLabel("ADMIN LOGIN PAGE");
        l3.setFont(new Font("Bookman Old Style",Font.BOLD,22));
        l3.setBounds(600,10,300,30);
        
        L=new JLabel();
        ImageIcon bg=new ImageIcon("F:\\javaswing\\HospitalManagementSystem\\src\\newpackage\\images\\image7.jpeg");
        L.setIcon(bg);
        L.setBounds(0,0,1500,800);
        
        Font font=new Font("Arial Black",Font.BOLD,12);
        l1.setBounds(500, 100, 100, 30);
        l2.setBounds(500, 150, 100, 30);
        l1.setHorizontalAlignment(JLabel.CENTER);
        l2.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(font);
        l2.setFont(font);
        L.add(l1);
        L.add(l2);
        L.add(l3);


        t1=new JTextField();
        t2=new JPasswordField(8);
        t1.setBounds(620, 100, 100, 25);
        t2.setBounds(620,150,100,25);
        L.add(t1);
        L.add(t2);

        b1=new JButton("Log In");
        b1.setBounds(500,200,80,30);
        
        b2=new JButton("BACK");
        b2.setBounds(1200,650,80,30);
        
        b3=new JButton("Forgot Password?");
        b3.setBounds(600,200,150,30);
        L.add(b1);
        L.add(b2);
        L.add(b3);
        p.add(L);
        p.setLayout(null);
        f.add(p);
        
        f.setLayout(null);   
        f.setSize(1500,800);
        f.setVisible(true);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
         }
                
            public void actionPerformed(ActionEvent e)
            {
                
                if(e.getSource()==b1)
                {
                try{
            String url="jdbc:mysql://localhost:3306/hospital";
            String username="root";
            String dbpwd="";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection(url,username,dbpwd);
            String sql="Select admin_id, password from admin where admin_id=? and password=?";
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1,t1.getText());
            statement.setString(2,t2.getText());
            ResultSet resultset=statement.executeQuery();
            if(resultset.next())
            {
                     JOptionPane.showMessageDialog(null,"Login Successfull!");
                     new adminpage();
                     f.setVisible(false);
                    
                }
                else{
                      JOptionPane.showMessageDialog(null,"Wrong Credentials! Try Again");
                    
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
                    new mainmenu();
                }
                 if(e.getSource()==b3)
                {
                    f.setVisible(false);
                    new forgotpasswordadmin();
                }
            }
       public static void main(String args[])
       {
           new loginadmin();
       }
        
        
 
}

