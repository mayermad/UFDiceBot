package me.mayermad.jdabot.storage;

import java.io.File;
import java.io.IOException;
import java.sql.*;

public class LiteSQL {
    private static Connection connection;
    private static Statement statement;

    public static void setConnection() {
        connection = null;

        try {
            File file = new File("dbase.db");
            if(!file.exists()){
                file.createNewFile();
            }
            String url = "jdbc:sqlite:" + file.getPath();
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            System.out.println("Connected");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void onUpdate(String sql) {
        try {
            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet onQuery(String sql) {
        try {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
