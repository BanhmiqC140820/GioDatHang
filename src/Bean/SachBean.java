package Bean;

import java.util.Date;

public class SachBean {
	private String masach;
	private String tensach;
	private String tacgia;
	private long gia;
	private long soluong;
	private String anh;
	private String maloai;
	private Date NgayNhap;
	private String SoTap;

	public SachBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SachBean(String masach, String tensach, String tacgia, long gia, long soluong, String anh, String maloai) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.tacgia = tacgia;
		this.gia = gia;
		this.soluong = soluong;
		this.anh = anh;
		this.maloai = maloai;
		}
	
	public SachBean(String masach, String tensach, String tacgia, long gia, long soluong, String anh, String maloai,
			Date ngayNhap, String soTap) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.tacgia = tacgia;
		this.gia = gia;
		this.soluong = soluong;
		this.anh = anh;
		this.maloai = maloai;
		NgayNhap = ngayNhap;
		SoTap = soTap;
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
	public String getTacgia() {
		return tacgia;
	}
	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getSoluong() {
		return soluong;
	}
	public void setSoluong(long soluong) {
		this.soluong = soluong;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	public Date getNgayNhap() {
		return NgayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		NgayNhap = ngayNhap;
	}
	public String getSoTap() {
		return SoTap;
	}
	public void setSoTap(String soTap) {
		SoTap = soTap;
	}
	
}
