package Bo;

import java.util.ArrayList;

import Bean.XacNhanBean;
import dao.CTHDdao;

public class CTHDbo {
	CTHDdao ctdao=new CTHDdao();
	public int them(String masach, long SoluongMua, long MaHoaDon) throws Exception {
		return ctdao.them(masach, SoluongMua, MaHoaDon);
	}
	public int capnhat(long maCTHD)throws Exception {
		return ctdao.capnhat(maCTHD);
	}
	public ArrayList<XacNhanBean> gethoadonchuaxacnhan()throws Exception {
		return ctdao.gethoadonchuaxacnha();
	}
}
