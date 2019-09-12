package com.wangjunji.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.impl.C3P0PooledConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C3P0Demo  {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource comboPooled = new ComboPooledDataSource();
        Connection connection = comboPooled.getConnection();
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
