package Bean;

import java.util.Date;

public class LichSuMuaHang {
	private String masach;
	private String tensach;
	private long gia;
	private long SoluongMua;
	private Date NgayMua;
	private boolean damua;
	private long thanhtien;
	public LichSuMuaHang(String masach, String tensach, long gia, long soluongMua, Date ngayMua, boolean damua,
			long thanhtien) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.gia = gia;
		SoluongMua = soluongMua;
		NgayMua = ngayMua;
		this.damua = damua;
		this.thanhtien = thanhtien;
	}
	public String getMasach() {
		return masach;
	}
	public void setMasach(String masach) {
		this.masach = masach;
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
	public long getSoluongMua() {
		return SoluongMua;
	}
	public void setSoluongMua(long soluongMua) {
		SoluongMua = soluongMua;
	}
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
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

	
}
