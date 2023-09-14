package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Bean.LichSuMuaHang;

public class LichSuaMuaHangdao {
	public ArrayList<LichSuMuaHang> getLS(long makh) throws Exception {
		ArrayList<LichSuMuaHang> ds=new ArrayList<LichSuMuaHang>();
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="select * from LichSu where makh=?";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setLong(1, makh);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			String masach=rs.getString("masach"); 
			String tensach=rs.getString("tensach"); 
			long gia=rs.getLong("gia"); 
			long SoLuongMua=rs.getLong("SoLuongMua"); 
			Date ngaySql=rs.getDate("NgayMua");
			java.util.Date NgayJava=new java.util.Date(ngaySql.getTime());
			boolean damua=rs.getBoolean("damua");
			long thanhtien=rs.getLong("Expr1");
			ds.add(new LichSuMuaHang(masach, tensach, gia, SoLuongMua, NgayJava, damua, thanhtien));
		}
		return ds;
	}
}
