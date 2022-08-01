package com.shares;

import java.sql.Connection ;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement ;
import java.util.Scanner;
public class SwitchStatement{
    private static String CREATE_QUERY ="CREATE TABLE `neha`.`samruddhi` (`no` VARCHAR(10) NOT NULL , `name` VARCHAR(20) NOT NULL , `city` VARCHAR(20) NOT NULL , `state` VARCHAR(20) NOT NULL ) ENGINE = InnoDB;";
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql:///neha";
    private static String user = "root";
    private static String INSERT_QUERY = "insert into samruddhi values(1,'swarali','solapur','maharastra')";

    private static String SELECT_QUERY = "select * from samruddhi";

    private static String UPDATE_QUERY = "update `samruddhi` set name='sakshi' where name='swarali'";
    private static String DELETE_QUERY = "delete from samruddhi where `no`=1";

    public static void main(String args[])
             {
                 Scanner sc=new Scanner(System.in);
                Connection con = null;
                Statement st = null;
                ResultSet re = null;
                int ch;

               do {
                   System.out.println("1.Create Table");
                   System.out.println("2.Insert Table");
                   System.out.println("3.update Table");
                   System.out.println("4.Delete Table");
                   System.out.println("5.exit");
                   System.out.println("enter choice");
                   ch = sc.nextInt();
                   switch (ch) {
                       case 1:
                           try {
                               Class.forName("com.mysql.jdbc.Driver");
                               con = DriverManager.getConnection("jdbc:mysql:///neha", "root", null);
                               if (con != null) {
                                   System.out.println("database connected successfully");
                               } else {
                                   System.out.println("database not connected");
                               }
                               st = con.createStatement();
                               st.executeUpdate(CREATE_QUERY);
                               System.out.println("table created....");
                               ResultSet rs = st.executeQuery("select * from swarali");
                               while (rs.next()) {
                                   System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
                               }
                           } catch (ClassNotFoundException e) {
                               e.printStackTrace();
                           } catch (SQLException e) {
                               e.printStackTrace();
                           } catch (Exception e) {
                               e.printStackTrace();
                           }
                           break;
                       case 2:
                           try {
                               Class.forName(driver);
                               con = DriverManager.getConnection(url, user, "");
                               st = con.createStatement();
                               int recordcount = st.executeUpdate(INSERT_QUERY);
                               System.out.println(recordcount + " record inserted");
                               re = st.executeQuery(SELECT_QUERY);
                               while (re.next()) {
                                   System.out.println(re.getInt(1) + " " + re.getString(2) + " " + re.getString(3) + " " + re.getString(4));
                               }
                           } catch (ClassNotFoundException e) {
                               e.printStackTrace();
                           } catch (SQLException e) {
                               e.printStackTrace();
                           } catch (Exception e) {
                               e.printStackTrace();
                           }

                           break;
                       case 3:
                           try {
                               Class.forName(driver);
                               con = DriverManager.getConnection(url, user, "");
                               st = con.createStatement();
                               int recordcount = st.executeUpdate(UPDATE_QUERY);
                               System.out.println(recordcount + " record updated");
                               re = st.executeQuery(SELECT_QUERY);
                               while (re.next()) {
                                   System.out.println(re.getInt(1) + " " + re.getString(2) + " " + re.getString(3) + " " + re.getString(4));
                               }
                           } catch (ClassNotFoundException e) {
                               e.printStackTrace();
                           } catch (SQLException e) {
                               e.printStackTrace();
                           } catch (Exception e) {
                               e.printStackTrace();
                           }
                           break;
                       case 4:
                           try {
                               Class.forName(driver);
                               con = DriverManager.getConnection(url, user, "");
                               st = con.createStatement();
                               int recordcount = st.executeUpdate(DELETE_QUERY);
                               System.out.println(recordcount + " record deleted");
                               re = st.executeQuery(SELECT_QUERY);
                               while (re.next()) {
                                   System.out.println(re.getInt(1) + " " + re.getString(2) + " " + re.getString(3) + " " + re.getString(4));
                               }
                           } catch (ClassNotFoundException e) {
                               e.printStackTrace();
                           } catch (SQLException e) {
                               e.printStackTrace();
                           } catch (Exception e) {
                               e.printStackTrace();
                           }
                           break;
                       default:
                           System.out.println("invalid option");
                           break;
                   }

                   }while(ch!=5);

               }


                    }


