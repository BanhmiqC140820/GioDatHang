package Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class tam123
 */
@WebServlet("/tam123")
public class tam123 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tam123() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		 ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		 String dirUrl1 = request.getServletContext().getRealPath("") +  File.separator + "image_sach";
		 response.getWriter().println(dirUrl1);
		 String hoten=null;
		 String ms=request.getParameter("txthoten");
		 response.getWriter().println(ms);
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
					
					
                    // Xây dựng tên file mới sử dụng giá trị của "txthoten"
					String newFileName = "a1"+".png";
                    String fileImg = dirUrl + File.separator + newFileName;
                    File file = new File(fileImg); // tạo file
				            try {
				               fileItem.write(file);//lưu file
				              System.out.println("UPLOAD THÀNH CÔNG...!");
				              System.out.println("Đường dẫn lưu file là: "+dirUrl);
				              response.getWriter().println(dirUrl);
				 } catch (Exception e) {
				    e.printStackTrace();
				}
			}
		 }
			else//Neu la control
			{
				String tentk=fileItem.getFieldName();
				if(tentk.equals("txthoten")) {
					hoten=fileItem.getString();
					response.getWriter().println(fileItem.getString());
					}
				if(tentk.equals("txtdiachi"))
					response.getWriter().println(fileItem.getString());
			}
			}
			File oldfile=new File(dirUrl1, "a1"+".png");
			File newFile = new File(dirUrl1, hoten+".png");

	        // Thực hiện việc đổi tên tệp
	        boolean renamed = oldfile.renameTo(newFile);
	        if (renamed) {
	            System.out.println("Đổi tên tệp thành công.");
	        } else {
	            System.out.println("Đổi tên tệp thất bại.");
	        }
		} catch (FileUploadException e) {
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
