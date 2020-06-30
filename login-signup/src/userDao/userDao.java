package userDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import userBean.user;

public class userDao {

    public int registerEmployee(user user) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO users" +
            "  (fullName, age, password,mail,mobile,dob,isAdmin) " +
            " values(?, ?, ?,?, ?, ?,?);";
       int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/sys?useSSL=false", "root", "redhat");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
//            preparedStatement.setInt(1, 2);
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getAge());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getMail());
            preparedStatement.setInt(5, user.getMobile());
            preparedStatement.setString(6, user.getDob());
            preparedStatement.setBoolean(7, false);


            



            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
