package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.loaibean;
import Bo.loaibo;

/**
 * Servlet implementation class QLLoaiController
 */
@WebServlet("/QLLoaiController")
public class QLLoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QLLoaiController() {
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
			loaibo lbo=new loaibo();
			String tab=request.getParameter("tab");
			String ml=request.getParameter("txtmaloai");
			String tenloai=request.getParameter("txttenloai");
			ArrayList<loaibean> dsloai=lbo.getloai();
			request.setAttribute("dsloai", dsloai);
			if(request.getParameter("add")!=null)
				lbo.them(ml, tenloai);
			else {
				if(request.getParameter("update")!=null)
					lbo.sua(ml, tenloai);
				else {String ml1=request.getParameter("ml");
						String tenloai1=request.getParameter("tenloai");
					if(tab!=null && tab.equals("xoa"))
						lbo.deleteloai(ml1);
					else {
						if(tab!=null && tab.equals("chon")) {
							request.setAttribute("ml", ml1);
							request.setAttribute("tenloai", tenloai1);
						}
					}
				}
			}
			request.setAttribute("dsloai", lbo.getloai());
			RequestDispatcher rd=request.getRequestDispatcher("HtqlLoai.jsp");
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
