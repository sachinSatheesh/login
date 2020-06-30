package userDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import userBean.user;

public class loginDao {
	public int validateLogin(user user) throws ClassNotFoundException {
	
		   String SQL_CHECK = "Select * from users Where id='" + user.getId() + "' and password='" +  user.getPassword() + "'";

        Class.forName("com.mysql.jdbc.Driver");
    	int flag=0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useSSL=false", "root", "redhat");
                PreparedStatement preparedStatement = connection.prepareStatement(SQL_CHECK))
        {

              ResultSet rs = preparedStatement.executeQuery();
                if(rs.next()) 
                {
                    flag = 1;
                    boolean isAdmin = rs.getBoolean("isAdmin");
                    if(isAdmin==true)
                    flag=2;

                }	
                	
        		
        		
	}
    	catch (SQLException e) 
        {
            // process sql exception
            printSQLException(e);
        }
        
		return flag;
	    		
     
        

 
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