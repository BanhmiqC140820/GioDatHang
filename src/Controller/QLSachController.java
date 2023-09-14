package Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import Bean.SachBean;
import Bo.sachbo;

/**
 * Servlet implementation class QLSachController
 */
@WebServlet("/QLSachController")
public class QLSachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QLSachController() {
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
	  		sachbo sbo=new sachbo();
	  		ArrayList<SachBean> ds=sbo.getsach();
	  		request.setAttribute("ds", ds);
	  		String masach=null,tensach=null,maloai=null,Anh="image_sach/",TacGia=null,Add=null,update=null;
	  		long gia=0,soluong=0;
	  		String tab=request.getParameter("tab");
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			String dirUrl1 = request.getServletContext().getRealPath("") +  File.separator + "image_sach";
			System.out.println(dirUrl1);
			try {
				List<FileItem> fileItems = upload.parseRequest(request);//Lấy về các đối tượng gửi lên
				//duyệt qua các đối tượng gửi lên từ client gồm file và các control
				for (FileItem fileItem : fileItems) {
	 			 if (!fileItem.isFormField()) {//Nếu ko phải các control=>upfile lên
					// xử lý file
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
				           //Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = request.getServletContext().getRealPath("") +  File.separator + "image_sach";
						File dir = new File(dirUrl);
						if (!dir.exists()) {//nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
					           String fileImg = dirUrl + File.separator + "Up.jpg";
					           File file = new File(fileImg);//tạo file
					            try {
					               fileItem.write(file);//lưu file
					              System.out.println("UPLOAD THÀNH CÔNG...!");
					              System.out.println("Đường dẫn lưu file là: "+dirUrl);
					              System.out.println(dirUrl); 
					            } catch (Exception e) {
					            	e.printStackTrace();
					}
				}
			 }
				else//Neu la control
				{
					String tentk=fileItem.getFieldName();
					if(tentk.equals("masach"))
						 masach=fileItem.getString();
					if(tentk.equals("tensach"))
						tensach=fileItem.getString();
					if(tentk.equals("soluong"))
						soluong=Long.parseLong(fileItem.getString());
					if(tentk.equals("gia"))
						gia=Long.parseLong(fileItem.getString());
					if(tentk.equals("maloai"))
						maloai=fileItem.getString();
					if(tentk.equals("tacgia"))
						TacGia=fileItem.getString();
					if(tentk.equals("Add"))
						Add=fileItem.getString();
					if(tentk.equals("update"))
						update=fileItem.getString();
				}
			}
				File oldfile=new File(dirUrl1, "Up.jpg");
				if(masach!=null) {
					File newFile = new File(dirUrl1, masach+".jpg");
			        // Thực hiện việc đổi tên tệp
			        boolean renamed = oldfile.renameTo(newFile);
			        if (renamed) {
			        	Anh="image_sach/"+masach+".jpg";
			            System.out.println("Đổi tên tệp thành công.");
			        } else {
			            System.out.println("Đổi tên tệp thất bại.");
			        }
		        }
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
	  		if(Add!=null)
	  			sbo.them(masach, tensach, TacGia, gia, soluong, Anh, maloai);
	  		else  {
	  			if(update!=null)
	  				sbo.sua(masach, tensach, TacGia, gia, soluong, Anh, maloai);
	  			else {
	  				if(tab!=null && tab.equals("select")) {	
			  			String msSelect=request.getParameter("msSelect");
			  			SachBean sach=sbo.timMasach(msSelect);
		  			request.setAttribute("sach",sach);
	  				}else if(tab!=null && tab.equals("delete")){
			  			String msDelete=request.getParameter("msDelete");
			  			sbo.deletesach(msDelete);
	  				}
				}
	  				
	  		}
		  	
	  		request.setAttribute("ds",sbo.getsach());
	  		RequestDispatcher rd=request.getRequestDispatcher("AdminHtSach.jsp");
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
