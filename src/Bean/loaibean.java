package Bean;

public class loaibean {
	private String maloai;
	private String tenloai;

	public loaibean() {
		super();
	}
	public loaibean(String maloai, String tenloai) {
		super();
		this.maloai = maloai;
		this.tenloai = tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}
	public String getTenloai() {
		return tenloai;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
}
