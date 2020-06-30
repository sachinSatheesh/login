package servlets;

import java.io.*;

import java.util.*;

import java.sql.*;

import javax.servlet.*;

import javax.servlet.http.*;



public class HomeServlet extends HttpServlet{
private ServletConfig config;
String page="userHome.jsp";

public void init(ServletConfig config)

throws ServletException
{
this.config=config;
}

 public void doGet(HttpServletRequest request, HttpServletResponse response)

    throws ServletException,IOException
{
PrintWriter out = response.getWriter();
String connectionURL = "jdbc:mysql://localhost:3306/sys";
Connection connection = null;
ResultSet rs;
response.setContentType("text/html");
List dataList = new ArrayList(); 
try 
{
Class.forName("com.mysql.jdbc.Driver");
connection = DriverManager.getConnection(connectionURL, "root", "redhat"); 
String sql = "select * from users";

  Statement s = connection.createStatement();

  s.executeQuery(sql);

  rs = s.getResultSet();

  while (rs.next ()){

  //Add records into data list

dataList.add(rs.getInt("id"));
dataList.add(rs.getString("fullName"));

 System.out.println("Inserted to arrayList");

  }

  rs.close ();

  s.close ();

  }catch(Exception e){

  System.out.println("Exception is ;"+e);

  }

  request.setAttribute("data",dataList);

  request.getRequestDispatcher("userHome.jsp").forward(request, response);


  }

}