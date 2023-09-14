package Bean;

public class userbean {
	private long makh;
	private String hoten;
	private String diachi;
	private String sodt;
	private String email;
	private String TenDangNhap;
	private String MatKhau;
	public userbean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public userbean(long makh, String hoten, String diachi, String sodt, String email, String tenDangNhap,
			String matKhau) {
		super();
		this.makh = makh;
		this.hoten = hoten;
		this.diachi = diachi;
		this.sodt = sodt;
		this.email = email;
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
	}
	
	public userbean(String hoten, String diachi, String sodt, String email, String tenDangNhap, String matKhau) {
		super();
		this.hoten = hoten;
		this.diachi = diachi;
		this.sodt = sodt;
		this.email = email;
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
	}
	
	public userbean(long makh, String hoten, String diachi, String tenDangNhap, String matKhau) {
		super();
		this.makh = makh;
		this.hoten = hoten;
		this.diachi = diachi;
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
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

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSodt() {
		return sodt;
	}

	public void setSodt(String sodt) {
		this.sodt = sodt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTenDangNhap() {
		return TenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	
	
}
