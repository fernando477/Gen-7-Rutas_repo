package com.grande.app.rutas.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static String url = "jdbc:oracle:thin:@// 127.0.0.1:1521/xe";
    private static String username  = "SYSTEM";
    private  static String password = "12345";


    public static Connection getInstance(){

        try {
            return DriverManager.getConnection(url,username,password);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

}
