
package newpackage;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Driver;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class doctorpage implements ActionListener {
    
     JFrame f;
    JPanel p;
    JLabel l1,l2,L;
    JButton b1,b2,b3;
    Connection con;
    myconnection mycon;
    doctorpage()
    {
         mycon=new myconnection();
        con=mycon.returnConnection();
        f=new JFrame("Doctor's Page");
        p=new JPanel();
        p.setBounds(1,1,1500,800);
        L=new JLabel();
        Font font=new Font("Callibari",Font.PLAIN,16);
        ImageIcon bg=new ImageIcon("F:\\javaswing\\HospitalManagementSystem\\src\\newpackage\\images\\image1.jpeg");
        L.setIcon(bg);
        L.setBounds(0,0,1500,800);
        l1=new JLabel("HOSPITAL MANAGEMENT SYSTEM");
        l2=new JLabel("DOCTOR'S PAGE");
        l1.setFont(new Font("Bookman Old Style",Font.BOLD,22));
        l1.setBounds(500,50,600,30);
        l2.setFont(new Font("Callibari",Font.BOLD,16));
        l2.setBounds(600,150,200,30);
        
        b1=new JButton("View my Appointments");
        b1.setBounds(500,300,200,30);
        //b1.setFont(font);
        
        b2=new JButton("Cancel appointment");
        b2.setBounds(750,300,200,30);
        //b2.setFont(font);
        
        b3=new JButton("Logout");
        b3.setBounds(1250,10,80,25);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        L.add(l1);
        L.add(l2);
        L.add(b1);
        L.add(b2);
        L.add(b3);
        p.add(L);
        p.setLayout(null);
        f.add(p);
        f.setSize(1500,800);
        f.setLocation(0,0);
        f.setLayout(null);
        f.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ev) 
    {
        try{
            String url="jdbc:mysql://localhost:3306/hospital";
            String username="root";
            String password="";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection(url,username,password);
            //Statement statement=connection.createStatement();
            //ResultSet resultset=statement.executeQuery("select*from doctors");
            
            
        if(ev.getSource()==b1)
        {
            showTableData();
                    
        }
        if(ev.getSource()==b2)
        {
           new cancelappointment();
           f.setVisible(false);
          
        }
        if(ev.getSource()==b3)
        {
            f.setVisible(false);
            new mainmenu();
        }
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void showTableData()
    {
      JFrame f2=new JFrame("Our Doctors");  
      JTable t;
      DefaultTableModel dtm;
      String col[]={"Appointment ID","Doctor ID","Patient ID","Appointment date"};
      dtm=new DefaultTableModel();
      dtm.setColumnIdentifiers(col);
      t=new JTable();
      t.setModel(dtm);
      t.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
      t.setFillsViewportHeight(true);
      JScrollPane scroll=new JScrollPane(t);
      scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
       try{
               
            String sql="Select a_id,d_id,p_id,appointment_date from appointment";
            PreparedStatement str=con.prepareStatement(sql);
            ResultSet resultset=str.executeQuery();
            int data1,data2,i=0;
            String data4 ,data3;
            
            while(resultset.next()){
                data1=resultset.getInt(1);
                data2=resultset.getInt(2);
                data3=resultset.getString(3);
                data4=resultset.getString(4);
                
                dtm.addRow(new Object[]{data1,data2,data3,data4});
                i++;
            }
            if(i<1)
            {
                JOptionPane.showMessageDialog(null,"No records found!");
            }
            
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
            }
       f2.add(scroll);
       f2.setVisible(true);
       f2.setSize(500,300);
       f2.setLocation(500,100);
    }
    public static void main(String args[])
    {
        
        new doctorpage();
        
    }
}
