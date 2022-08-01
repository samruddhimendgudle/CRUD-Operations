package com.shares;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

//com.mysql.jdbc.Driver - For Mysql
//oracle.jdbc.driver.OracleDriver - Oracle
public class SelectStatement {
    private static String CREATE_QUERY ="CREATE TABLE `neha`.`movies` (`no` INT(10) NOT NULL , `name` VARCHAR(20) NOT NULL , `hero` VARCHAR(20) NOT NULL , `heroine` VARCHAR(20) NOT NULL ) ENGINE = InnoDB";
    public static void main(String args[])  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql:///neha","root",null );
            if(con!=null) {
                System.out.println("database connected successfully");
            }
            else
            {
                System.out.println("database not connected");
            }
            Statement st=con.createStatement();
            st.executeUpdate(CREATE_QUERY);
                    System.out.println("table created....");
            ResultSet rs=st.executeQuery("select * from saki");
            while(rs.next())
            {
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" " +rs.getString(3)+" " +rs.getString(4));
            }
        }

        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    }
