package Bo;

import java.util.ArrayList;import Bean.giohangbean;

public class giohangbo {
	public ArrayList<giohangbean> ds =new ArrayList<giohangbean>();
	public void ThemHang(String masach, String tensach, long gia, long soluongmua) {
		
		for(giohangbean h :ds) {
			if(h.getMasach().equals(masach)) {
				h.setSoluongmua(h.getSoluongmua()+soluongmua);
				return;
			}
		}
		giohangbean h=new giohangbean(masach,tensach,gia,soluongmua);
		ds.add(h);
	}
	//xoa hang ra khoi ds
	public void xoahang(String masach) {
		for(giohangbean h:ds) {
			if(h.getMasach().equals(masach)) {
				ds.remove(h);
				return;
			}
		}
			
	}
	public void suaSL(String masach, long sl) {
		int n=ds.size();
		for(int i=0;i<n;i++) {
			giohangbean h=ds.get(i);
			if(h.getMasach().equals(masach)) {
				h.setSoluongmua(sl);
				ds.set(i, h);
				return;
			}
		}
	}
	public long TongTien() {
		long tong = 0;
		for(giohangbean h:ds) 
			tong=tong+h.getThanhtien();
		return tong;
	}
	public void xoahet() {
		ds.removeAll(ds);
	}
	public void xoacheck(ArrayList<String> danhSachMaSachXoa) {
        ArrayList<giohangbean> dsSauKhiXoa = new ArrayList<>();

        for (giohangbean h : ds) {
            if (!danhSachMaSachXoa.contains(h.getMasach())) {
                // Giữ lại các phần tử không nằm trong danh sách xóa
                dsSauKhiXoa.add(h);
            }
        }
        // Cập nhật lại danh sách hàng hóa sau khi xóa các phần tử được chọn
        ds = dsSauKhiXoa;
	}
}
