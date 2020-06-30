package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userBean.user;
import userDao.loginDao;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	  private loginDao loginDao;

	    public void init() {
	    	loginDao = new loginDao();
	    }

	    
	    
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userid = request.getParameter("id");
        String password = request.getParameter("password");		
        int id;
        try {
           id = Integer.parseInt(userid);
        }
        catch (NumberFormatException e)
        {
           id = 0;
        }

        user user = new user();
        user.setId(id);
        user.setPassword(password);
     
        try {
           int flag =  loginDao.validateLogin(user);
           if(flag==0)
           {
            
               request.getRequestDispatcher("login.jsp").forward(request, response);

           }
           else if(flag==1)
           {
        	   request.getSession().invalidate();
               HttpSession newSession=request.getSession(true);
               newSession.setMaxInactiveInterval(300);
               request.getRequestDispatcher("userHome.jsp").forward(request, response);

           }
           else if(flag==2)
           {
        	   request.getSession().invalidate();
               HttpSession newSession=request.getSession(true);
               newSession.setMaxInactiveInterval(300);
               request.getRequestDispatcher("AdminHome.jsp").forward(request, response);

           }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
	}

}
