package com.wangjunji.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) {
        Properties ps= new Properties();
        InputStream rStream = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            ps.load(rStream);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(ps);
            Connection connection = dataSource.getConnection();
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

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
