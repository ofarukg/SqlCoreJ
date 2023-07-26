package org.example;

import java.sql.*;

public class DBOperation {

    private static final String connectionUrl = "jdbc:mysql://localhost:3306/sakila";
    private static final String userName ="root";
    private static final String password = "springstudent";

    // wrote down this line to connect to mysql database
    public static Connection openConnection () throws SQLException {
        //A connection (session) with a specific database. SQL statements are executed and results are returned within the context of a connection.
        return DriverManager.getConnection(connectionUrl, userName, password);
        //DriverManager controls the features of sql pack
    }
    // to read data from database
    public static ResultSet resultSet (String selectSql){

        try(Connection myConnection =openConnection()){
            Statement myConnectionStatement = myConnection.createStatement();
            return myConnectionStatement.executeQuery(selectSql);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    // to update data
    public static Integer updateProcess(String updateQuery, String name, String id){
        // establish connection again
        try(Connection myConnection = openConnection()){
            PreparedStatement myPreparedStatement = myConnection.prepareStatement(updateQuery);
            myPreparedStatement.setString(1, name);
            myPreparedStatement.setString(2, id);
            return myPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public static void deleteData(String deleteQuery, Integer id){
        try(Connection myConnection = openConnection()){
            PreparedStatement myPreparedStatement = myConnection.prepareStatement(deleteQuery);
            myPreparedStatement.setInt(1,id);
            myPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public static void insertData(String insertQuery,  String name, String email, Integer age){
        try(Connection myPreciousConnection = openConnection()){
            PreparedStatement myPreciousPS = myPreciousConnection.prepareStatement(insertQuery);
            myPreciousPS.setString(1, name);
            myPreciousPS.setString(2, email);
            myPreciousPS.setInt(3,age);
            myPreciousPS.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
