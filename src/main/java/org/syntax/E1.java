package org.syntax;

import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class E1 {
    public static void main(String[] args) {

    String dbURL="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
    String userName="syntax_hrm";
    String password="syntaxhrm123";
        try {
            //helps to establish the connection
            Connection connection=DriverManager.getConnection(dbURL,userName,password);

            // helps us take the query on the DB server, execute it and bring the results back
            Statement statement=connection.createStatement();
            String query="select * from person";
            //this method executes the query and return the results back in form of a resultSet
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                String firstname=resultSet.getString("firstname");
                int age=resultSet.getInt("age");
                String city=resultSet.getString("city");
                System.out.println(firstname+" "+age+" "+city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}