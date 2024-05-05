package newpackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
public class adminpage implements ActionListener{
    JFrame f;
    JPanel p;
    JLabel l1,l2,L;
    JButton b1,b2,b3,b4,b5,b6,b7;
    Connection con;
    myconnection mycon;
    adminpage(){
        mycon=new myconnection();
        con=mycon.returnConnection();
        f=new JFrame("Admin Page");
        p=new JPanel();
        p.setBounds(1,1,1500,800);
        L=new JLabel();
        ImageIcon bg=new ImageIcon("F:\\javaswing\\HospitalManagementSystem\\src\\newpackage\\images\\image1.jpeg");
        L.setIcon(bg);
        L.setBounds(0,0,1500,800);
        l1=new JLabel("HOSPITAL MANAGEMENT SYSTEM");
        l2=new JLabel("Admin page");
        l1.setFont(new Font("Bookman Old Style",Font.BOLD,22));
        l1.setBounds(500,50,600,30);
        l2.setFont(new Font("Callibari",Font.BOLD,18));
        l2.setBounds(600,150,200,30);
        b1=new JButton("List Doctors");
        b1.setBounds(500,250,150,30);
        b2=new JButton("Add Doctor");
        b2.setBounds(500,300,150,30);
        b3=new JButton("Book Appointment");
        b3.setBounds(700,250,150,30);
        b4=new JButton("Add Patient");
        b4.setBounds(700,300,150,30);
        b5=new JButton("Cancel Apointment");
        b5.setBounds(500,350,150,30);
        b6=new JButton("Logout");
        b6.setBounds(1250,10,80,25);
        b7=new JButton("View Appointments");
        b7.setBounds(700,350,150,30);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        L.add(l1);
        L.add(l2);
        L.add(b1);
        L.add(b2);
        L.add(b3);
        L.add(b4);
        L.add(b5);
        L.add(b6);
        L.add(b7);
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
            new adminpage();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        

    }

    public void actionPerformed(ActionEvent e)
    {
        try{
            String url="jdbc:mysql://localhost:3306/hospital";
            String username="root";
            String password="";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();
            ResultSet resultset=statement.executeQuery("select*from doctors");
            
            JFrame f1;
            JLabel l,l1,L;
        if(e.getSource()==b1)
        {
            showTableData();
        }
        if(e.getSource()==b2)
        {
            new adddoctor();
            f.setVisible(false);
        }
        if(e.getSource()==b3)
        {
            new bookappointment();
            f.setVisible(false);
        }
        if(e.getSource()==b4)
        {
            new addpatient();
            f.setVisible(false);
        }
        if(e.getSource()==b5)
        {
            new admincancelappointment();
            f.setVisible(false);
        }
        if(e.getSource()==b6)
        {
            new mainmenu();
            f.setVisible(false);
        }
        if(e.getSource()==b7)
        {
            showAppointment();
        }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void showAppointment()
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
       f2.setLocation(500,150);
    }
    
     public void showTableData()
    {
      JFrame f2=new JFrame("Our Doctors");  
      JTable t;
      DefaultTableModel dtm;
      String col[]={"Doctor ID","Name","Specialization"};
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
               
            String sql="Select d_id,name,specialization from doctors";
            PreparedStatement str=con.prepareStatement(sql);
            ResultSet resultset=str.executeQuery();
            int data1,i=0;
            String data2 ,data3;
            
            while(resultset.next()){
                data1=resultset.getInt(1);
                data2=resultset.getString(2);
                data3=resultset.getString(3);
                
                dtm.addRow(new Object[]{data1,data2,data3});
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
       f2.setSize(400,300);
       f2.setLocation(500,150);
    }
    
}
