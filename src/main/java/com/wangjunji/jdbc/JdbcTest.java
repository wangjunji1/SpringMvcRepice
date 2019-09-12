package com.wangjunji.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JdbcTest {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        InputStream is = JdbcTest.class.getClassLoader().getResource("jdbc.properties").openStream();
        Properties pro = new Properties();
        pro.load(is);
        String  url =(String) pro.get("url");
        String driver =(String) pro.get("driver");
        String username =(String) pro.get("username");
        String  password =(String) pro.get("password");
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
        ResultSet execute = preparedStatement.executeQuery();
        while(execute.next()){
            System.out.println("--------------------------------------------");
            System.out.print( execute.getString(1));
            System.out.print( execute.getString(2));
            System.out.print( execute.getString(3));
            System.out.println( execute.getString(4));
            System.out.println("--------------------------------------------");
        }

        execute.close();
        preparedStatement.close();
        connection.close();


    }
}
