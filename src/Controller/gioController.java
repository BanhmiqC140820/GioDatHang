package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bo.giohangbo;

/**
 * Servlet implementation class gioController
 */
@WebServlet("/gioController")
public class gioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String masach=request.getParameter("ms");
		String tensach=request.getParameter("ts");
		String gias=request.getParameter("gia");
		
		if(masach!=null&&tensach!=null&&gias!=null){
			long gia=Long.parseLong(gias);
			HttpSession session=request.getSession();
			if(session.getAttribute("cart")==null){
				giohangbo g=new giohangbo();
				g.ThemHang(masach, tensach, gia, 1);
				session.setAttribute("cart", g);
			}
		
				giohangbo g=(giohangbo)session.getAttribute("cart");
				g.ThemHang(masach, tensach, gia, 1);
				session.setAttribute("cart",g);
			
	  		response.sendRedirect("htgioController");
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
