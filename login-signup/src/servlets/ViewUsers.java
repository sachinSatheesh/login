package servlets;

import java.io.*;

import java.util.*;

import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(name = "ViewUsers", urlPatterns = { "/ViewUsers" })

public class ViewUsers extends HttpServlet{
	  String page="ViewUsers.jsp";



  private ServletConfig config;

  //Setting JSP page




  public void init(ServletConfig config)

  throws ServletException{

 this.config=config;

 }

  public void doGet(HttpServletRequest request, HttpServletResponse response)

    throws ServletException,IOException
{


  //Disptching request

  RequestDispatcher dispatcher = request.getRequestDispatcher(page);

  if (dispatcher != null){

  dispatcher.forward(request, response);

  } 

  }

}