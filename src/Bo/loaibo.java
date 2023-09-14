package Bo;

import java.util.ArrayList;

import Bean.loaibean;
import dao.loaidao;

public class loaibo {
	loaidao ldao=new loaidao();
	ArrayList<loaibean> ds;
	public ArrayList<loaibean> getloai()throws Exception{
		ds=ldao.getloai();
		return ds;
	}
	public String Tim(String maloai) throws Exception {
		for(loaibean l:ds)
			if(l.getMaloai().equals(maloai))
				return l.getMaloai();
		return null;
	}
	public int them(String maloai,String tenloai)throws Exception {
		return ldao.them(maloai, tenloai);
	}
	public int sua(String maloai,String tenloai)throws Exception {
		return ldao.sua(maloai, tenloai);
	}
	public int deleteloai(String maloai)throws Exception {
		return ldao.deleteloai(maloai);
	}
}
