package org.syntax;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E3 {
    public static void main(String[] args) {


        try (Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USER_NAME, Constants.PASSWORD);){

            Statement statement = connection.createStatement();
            String query = "select * from employee";
            ResultSet rs = statement.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {

            }
            List<Map<String, String>> tableData = new ArrayList<>();
            while (rs.next()){
                Map<String, String > rowMAp = new HashMap<>();
                for (int i = 1; i <=rsmd.getColumnCount() ; i++) {
                    String key = rsmd.getColumnName(i);
                    String value = rs.getString(i);
                    rowMAp.put(key, value);

                }
                tableData.add(rowMAp);
            }
            System.out.println(tableData);

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
