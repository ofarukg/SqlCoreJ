package org.example;

import java.sql.SQLException;

public class Main {

    private static final String USER_SELECT_STRING = "select * from stajerler";

    // String updateQuery =             "UPDATE ogrenci     SET ogrenci_isim = ?    WHERE ogrenci_id = ?";
    private static String updateQuery = "UPDATE stajerler    SET name = ?      WHERE id = ?";

    private static String deleteQuery = "DELETE FROM stajerler WHERE id = ?";

    private static String insertQuery = "INSERT INTO stajerler (name, email, age) VALUES ( ?, ?, ?)";


    public static void main(String[] args) throws SQLException {

        //DBOperation.resultSet(USER_SELECT_STRING);


        //DBOperation.updateProcess(updateQuery,"dedeneme","8");


        //DBOperation.deleteData(deleteQuery,7);


        //DBOperation.insertData(insertQuery,"Enes Tuna","ennes@gg.com",39);

    }
}