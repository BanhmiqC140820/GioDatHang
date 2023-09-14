package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import Bean.XacNhanBean;


public class CTHDdao {
	public int them(String masach, long SoluongMua, long MaHoaDon) throws Exception {
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="insert into ChiTietHoaDon (Masach,SoluongMua,MaHoaDon,damua) values(?,?,?,?)";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		int kq=0;	
			cmd.setString(1, masach);
			cmd.setLong(2, SoluongMua);
			cmd.setLong(3, MaHoaDon);
			cmd.setBoolean(4, false);
			kq=cmd.executeUpdate();
		
		cmd.close();kn.cn.close();
		return kq;
	}
	public int capnhat(long maCTHD) throws Exception {
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="update ChiTietHoaDon set damua=1 where MaChiTietHD=?";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setLong(1, maCTHD);
		int kq=cmd.executeUpdate();
		cmd.close(); kn.cn.close();
		return kq;
	}
	public ArrayList<XacNhanBean> gethoadonchuaxacnha()throws Exception {
		ArrayList<XacNhanBean> ds=new ArrayList<>();
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql="select * from VXacNhan";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			long makh=rs.getLong("makh"); 
			String hoten=rs.getString("hoten"); 
			String tensach=rs.getString("tensach"); 
			long gia=rs.getLong("gia"); 
			Date ngayMua=rs.getDate("NgayMua"); 
			long soLuongMua=rs.getLong("SoLuongMua"); 
			boolean damua=rs.getBoolean("damua");
			long thanhtien=rs.getLong("thanhtien");
			long maChiTietHD=rs.getLong("MaChiTietHD");
			ds.add(new XacNhanBean(makh, hoten, tensach, gia, ngayMua, soLuongMua, damua, thanhtien, maChiTietHD));
		}
		rs.close(); kn.cn.close();
		return ds;
	}
}
