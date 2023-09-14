package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bo.giohangbo;

/**
 * Servlet implementation class UpdateGio
 */
@WebServlet("/UpdateGio")
public class UpdateGio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		giohangbo g=(giohangbo)session.getAttribute("cart");
		if(request.getParameter("SuaSL")!=null) {
			long sl=Long.parseLong(request.getParameter("txtsua"));
			g.suaSL(request.getParameter("SuaSL"), sl);
			session.setAttribute("cart", g);
		}
		if(request.getParameter("xoams")!=null) {
			
			g.xoahang(request.getParameter("xoams"));
			session.setAttribute("cart", g);
		}
		String [] checkbox=request.getParameterValues("checkbox");
		if(checkbox!=null) {
			for(String ms:checkbox) {
				g.xoahang(ms);
			}
		session.setAttribute("cart", g);
		}
//		Enumeration<String> d=request.getParameterNames();
//		int i=0;
//		
//		while(d.hasMoreElements()) {
//			String checkbox=d.nextElement();
//			if(checkbox.equals("checkbox"+i)) {
//				String gt=request.getParameter(checkbox);
//				g.xoahang(gt);
//				session.setAttribute("cart", g);
//				}
//			i++;
//			}
		if(request.getParameter("xoahet")!=null) {
			g.xoahet();
			session.setAttribute("cart", g);
		}
		request.setAttribute("cart", session);
  		RequestDispatcher rd=request.getRequestDispatcher("htgioController");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
