package com.shares;

import java.sql.Connection ;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement ;

public class DeleteStatement {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql:///neha";
    private static String user = "root";
    private static String DELETE_QUERY = "delete from movies where `no`=1";

    private static String SELECT_QUERY = "select * from movies";

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet re = null;
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
        } finally {
            try {
                re.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
