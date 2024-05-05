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
import javax.swing.JOptionPane;

public class myconnection {
    Connection con;
    public myconnection()
    {
        try{
            String url="jdbc:mysql://localhost:3306/hospital";
            String username="root";
            String password="";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,username,password);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
        public Connection returnConnection()
        {
            return con;
        }
    }
    
