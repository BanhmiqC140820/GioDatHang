package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.giohangbean;
import Bean.userbean;
import Bo.CTHDbo;
import Bo.giohangbo;
import Bo.hoadonbo;

/**
 * Servlet implementation class xacnhanController
 */
@WebServlet("/xacnhanController")
public class xacnhanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacnhanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Kiểm tra đăng nhập
		try {
			HttpSession session=request.getSession();
			userbean user=(userbean)session.getAttribute("user");
			if(session.getAttribute("user")==null) {
				RequestDispatcher rd=request.getRequestDispatcher("htgioController?checkUser=1");
				rd.forward(request, response);
			}else {
				giohangbo cart=(giohangbo)session.getAttribute("cart");
				if(cart!=null) {
					hoadonbo hdbo=new hoadonbo();
					hdbo.them(user.getMakh());
					long mahd=hdbo.getMaxHD();
					CTHDbo ct=new CTHDbo();
					for(giohangbean g:cart.ds)
						ct.them(g.getMasach(), g.getSoluongmua(), mahd);
					session.removeAttribute("cart");
					RequestDispatcher rd=request.getRequestDispatcher("sachController");
					rd.forward(request, response);
				}
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
