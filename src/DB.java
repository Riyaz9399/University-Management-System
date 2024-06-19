package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/universitymanagementsystem";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    private Connection connection;
    private Statement statement;

    public DB() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        statement = connection.createStatement();
        System.out.println("DATA BASE connected...");
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public void close() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeUpdate(String query, Object... params) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            preparedStatement.executeUpdate();
        }
        return null;
    }
    public static void main(String args []){
        try {
            new DB();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


}

