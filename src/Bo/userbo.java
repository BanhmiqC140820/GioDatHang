package Bo;

import Bean.userbean;
import dao.userdao;

public class userbo {
	
	public userbean ktdn(String tendn,String matkhau) throws Exception {
		userdao udao=new userdao();
		return udao.ktdn(tendn, matkhau);
	}
	public int dangky(String hoten,String email, String diachi, String tendn, String pass) throws Exception {
		userdao udao=new userdao();
		return udao.Dangky(hoten, email, diachi, tendn, pass);
	}
}
