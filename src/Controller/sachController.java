package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.SachBean;
import Bo.sachbo;

/**
 * Servlet implementation class sachController
 */
@WebServlet("/sachController")
public class sachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			response.setCharacterEncoding("utf-8");
	  		request.setCharacterEncoding("utf-8");
	  		//convert charater
	  		 ArrayList<SachBean>ds;
	  		sachbo sbo = new sachbo();
	  		String ml=(String)request.getParameter("ml");
	  		String seach=request.getParameter("key");
	  		ds = sbo.getsach();
	  		if(ml!=null)
	  			ds=sbo.TimMa(ml);
	  		if(seach!=null)
	  			ds=sbo.seachkey(seach);
	  		request.setAttribute("ds", ds);
	  		HttpSession session=request.getSession();
	  		if(session.getAttribute("user")!=null)
	  			request.setAttribute("user", session);
	  		RequestDispatcher rd=request.getRequestDispatcher("menu.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
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
