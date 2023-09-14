package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.SachBean;

public class sachdao {
	public ArrayList<SachBean> getsach() throws Exception{
		ArrayList<SachBean> ds= new ArrayList<SachBean>();
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="select * from sach";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			String masach=rs.getString("masach"); 
			String tensach=rs.getString("tensach"); 
			String tacgia=rs.getString("tacgia"); 
			long gia=rs.getLong("gia"); 
			long soluong=rs.getLong("soluong"); 
			String anh=rs.getString("anh");
			String maloai=rs.getString("maloai");
			ds.add(new SachBean(masach, tensach, tacgia, gia, soluong, anh, maloai));
		}
		rs.close();
		return ds;
	}
	public int Them(String masach, String tensach, String tacgia, long gia, long soluong, String anh, String maloai) throws Exception {
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="insert into sach([masach],[tensach],[soluong],[gia],[maloai],[anh],[tacgia]) values (?,?,?,?,?,?,?)";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		cmd.setNString(2, tensach);
		cmd.setLong(3, soluong);
		cmd.setLong(4, gia);
		cmd.setString(5, maloai);
		cmd.setString(6, anh);
		cmd.setString(7,tacgia);
		int kq=cmd.executeUpdate();
		cmd.close();kn.cn.close();
		return kq;
	}
	public int sua(String masach, String tensach, String tacgia, long gia, long soluong, String anh, String maloai) throws Exception {
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="UPDATE sach SET   [tensach]=?,[soluong]=?,[gia]=?,[maloai]=?,[anh]=?,[tacgia]=? WHERE [masach]=?;";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setNString(1,tensach);
		cmd.setLong(2, soluong);
		cmd.setLong(3, gia);
		cmd.setString(4, maloai);
		cmd.setString(5, anh);
		cmd.setNString(6,tacgia);
		cmd.setString(7, masach);
		int kq=cmd.executeUpdate();
		cmd.close();kn.cn.close();
		return kq;
	}
	public int deletesach(String masach) throws Exception {
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="DELETE FROM sach WHERE masach=?;";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		int kq=cmd.executeUpdate();
		cmd.close();kn.cn.close();
		return kq;
	}
}
