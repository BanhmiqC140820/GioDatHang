package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;



public class hoadondao {
	public int them(long makh) throws Exception{
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "insert into hoadon (makh, NgayMua, damua ) values(?, ?, ?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		int kq = 0;
		        cmd = kn.cn.prepareStatement(sql);
		        cmd.setLong(1, makh);
		        Date n1 = new Date();
		        SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
		        String tam = dd.format(n1);
		        Date n2 = dd.parse(tam);
		        cmd.setDate(2, new java.sql.Date(n2.getTime()));
		        cmd.setBoolean(3, false);
		       kq = cmd.executeUpdate();
		 cmd.close();
		 kn.cn.close();
		 return kq;
	}
	public long getMaxHD() throws Exception {
		ketnoidao kn=new ketnoidao();
		kn.ketnoi();
		String sql ="select MAX(MaHoaDon) from hoadon";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		long max=0;
		if(rs.next()) {
			max=rs.getLong(1);
		}
		rs.close();kn.cn.close();
		return max;
	}
}
