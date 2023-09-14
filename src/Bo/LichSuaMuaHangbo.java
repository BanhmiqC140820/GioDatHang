package Bo;

import java.util.ArrayList;

import Bean.LichSuMuaHang;
import dao.LichSuaMuaHangdao;

public class LichSuaMuaHangbo {
	LichSuaMuaHangdao LSdao=new LichSuaMuaHangdao();
	ArrayList<LichSuMuaHang> ds;
	public ArrayList<LichSuMuaHang> getLS(long makh)throws Exception {
		ds=LSdao.getLS(makh);
		return ds;
	}
}
