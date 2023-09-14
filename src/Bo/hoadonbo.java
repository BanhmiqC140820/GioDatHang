package Bo;

import dao.hoadondao;

public class hoadonbo {
	hoadondao hddao= new hoadondao();
	public int them(long makh) throws Exception {
		return hddao.them(makh);
	}
	public long getMaxHD() throws Exception {
		return hddao.getMaxHD();
	}
}
