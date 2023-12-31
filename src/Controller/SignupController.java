package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bo.userbo;

/**
 * Servlet implementation class SignupController
 */
@WebServlet("/SignupController")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String hovaten=request.getParameter("HovaTen");
			String email=request.getParameter("email");
			String DiaChi=request.getParameter("DiaChi");
			String tendn=request.getParameter("tendn");
			String matKhau=request.getParameter("matKhau");
			userbo ubo=new userbo();
			int kt=ubo.dangky(hovaten, email, DiaChi, tendn, matKhau);
			if(kt>0) {
				request.setAttribute("kt",kt);
				RequestDispatcher rd=request.getRequestDispatcher("sachController");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("kt",kt);
				RequestDispatcher rd=request.getRequestDispatcher("sachController");
				rd.forward(request, response);
			}
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
