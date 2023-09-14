package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;



import Bean.userbean;

public class userdao {
	public userbean ktdn(String tendn, String pass) throws Exception{
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="select * from khachhang where tendn=? and pass=?";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1, tendn);
		cmd.setString(2, pass);
		ResultSet rs=cmd.executeQuery();
		userbean user=null;
		if(rs.next()) {
			long makh=rs.getLong("makh");
			String hoten=rs.getString("hoten");
			String diachi=rs.getString("diachi");
			user= new userbean(makh, hoten, diachi,tendn, pass);
			System.out.println(user);
			return user;
		}
		return user;
	}

	public int Dangky(String hoten, String diachi,String email, String tendn, String pass) throws Exception{
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="INSERT INTO khachhang (hoten, diachi, email, tendn, pass) SELECT ?, ?, ?, ?, ?\r\n"
				+ "WHERE NOT EXISTS (SELECT 1 FROM khachhang WHERE tendn = ?)";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1, hoten);
		cmd.setString(2, email);
		cmd.setString(3, diachi);
		cmd.setString(4, tendn);
		cmd.setString(5, pass);
		cmd.setString(6, tendn);
		int kq = cmd.executeUpdate();
		return kq;
	}

}
