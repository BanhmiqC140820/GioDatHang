package Bo;

import java.util.ArrayList;

import Bean.SachBean;
import dao.sachdao;

public class sachbo {
	sachdao sdao=new sachdao();
	ArrayList<SachBean> ds;
	public ArrayList<SachBean> getsach()throws Exception{
		ds =sdao.getsach();
		return ds;
	};
	
	public sachbo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<SachBean> TimMa(String maloai) throws Exception {
		int n=ds.size();
		ArrayList<SachBean> temp=new ArrayList<SachBean>();
		for(int i=0;i<n;i++) {
			if(ds.get(i).getMaloai().toLowerCase().trim().equals(maloai.toLowerCase()))
				temp.add(ds.get(i));
		}
		return temp;
	}
	public SachBean timMasach(String masach) {
		for(SachBean sach:ds) {
			if(sach.getMasach().equals(masach))
				return sach;
		}
		return null;
	}
	public ArrayList<SachBean> seachkey(String key) {
		ArrayList<SachBean> temp =new ArrayList<>();
		int n=ds.size();
		for(int i=0; i<n;i++) {
			if(ds.get(i).getTensach().contains(key)) {
				temp.add(ds.get(i));
			}
		}
		return temp;
	}
	public ArrayList<SachBean> Cart(String maloai) throws Exception {
		int n=ds.size();
		ArrayList<SachBean> temp=new ArrayList<SachBean>();
		for(int i=0;i<n;i++) {
			if(ds.get(i).getMaloai().toLowerCase().trim().equals(maloai.toLowerCase()))
				temp.add(ds.get(i));
		}
		return temp;
	}
	public int them(String masach, String tensach, String tacgia, long gia, long soluong, String anh, String maloai) throws Exception {
		return sdao.Them(masach, tensach, tacgia, gia, soluong, anh, maloai);
	}
	public int sua(String masach, String tensach, String tacgia, long gia, long soluong, String anh, String maloai) throws Exception {
		return sdao.sua(masach, tensach, tacgia, gia, soluong, anh, maloai);
	}
	public int deletesach(String masach) throws Exception {
		return sdao.deletesach(masach);
	}
}