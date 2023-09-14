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


import Bean.LichSuMuaHang;
import Bean.userbean;
import Bo.LichSuaMuaHangbo;

/**
 * Servlet implementation class LSmuaController
 */
@WebServlet("/LSmuaController")
public class LSmuaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LSmuaController() {
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
	  		HttpSession session=request.getSession();
	  		ArrayList<LichSuMuaHang> ds;
	  		LichSuaMuaHangbo lsbo=new LichSuaMuaHangbo();
	  		userbean user=(userbean)session.getAttribute("user");
	  		ds=lsbo.getLS(user.getMakh());
	  		request.setAttribute("dsls", ds);
	  		RequestDispatcher rd=request.getRequestDispatcher("LichSuMuaHang.jsp");
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
