package Bean;

import java.util.Date;

public class XacNhanBean {
	private long makh;
	private String hoten;
	private String tensach;
	private long gia;
	private Date NgayMua;
	private long SoLuongMua;
	private boolean damua;
	private long thanhtien;
	private long MaChiTietHD;
	public XacNhanBean(long makh, String hoten, String tensach, long gia, Date ngayMua, long soLuongMua, boolean damua,
			long thanhtien, long maChiTietHD) {
		super();
		this.makh = makh;
		this.hoten = hoten;
		this.tensach = tensach;
		this.gia = gia;
		NgayMua = ngayMua;
		SoLuongMua = soLuongMua;
		this.damua = damua;
		this.thanhtien = thanhtien;
		MaChiTietHD = maChiTietHD;
	}
	public XacNhanBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}
	public long getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(long soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public long getMaChiTietHD() {
		return MaChiTietHD;
	}
	public void setMaChiTietHD(long maChiTietHD) {
		MaChiTietHD = maChiTietHD;
	}
	
}
