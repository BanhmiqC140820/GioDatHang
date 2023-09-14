package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.userbean;
import Bo.userbo;

/**
 * Servlet implementation class usercontroller
 */
@WebServlet("/usercontroller")
public class usercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usercontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("pswd");
		userbo ubo=new userbo();
		HttpSession session=request.getSession();	

		if(username!=null && password!=null){
			
			userbean user =null;
				try {
					user = ubo.ktdn(username, password);
					if (user!=null){
						session.setAttribute("user", user);
						long makh=user.getMakh();
						request.setAttribute("makh", makh);
					RequestDispatcher rd=request.getRequestDispatcher("sachController");
					rd.forward(request, response);
					}
				else {
					RequestDispatcher rd=request.getRequestDispatcher("sachController");
					rd.forward(request, response);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("sachController");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
