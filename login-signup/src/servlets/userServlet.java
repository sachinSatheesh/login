package servlets;


import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userBean.user;
import userDao.userDao;


/**
 * @email Ramesh Fadatare
 */

@WebServlet("/register")
public class userServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private userDao userDao;

    public void init() {
        userDao = new userDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String fullName = request.getParameter("fullName");
        String age = request.getParameter("age");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("mail");
        String dob = request.getParameter("dob");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String password = request.getParameter("password");
        

        int mobileNo;
        try {
        	mobileNo = Integer.parseInt(mobile);
        }
        catch (NumberFormatException e)
        {
        	mobileNo = 0;
        }
        
        	
        user user = new user();
        user.setFullName(fullName);
        user.setAge(age);
        user.setPassword(password);
        user.setMail(email);
        user.setMobile(mobileNo);
        user.setDob(dob);

        try {
            userDao.registerEmployee(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        request.getRequestDispatcher("login.jsp").forward(request, response);
     
    }
}