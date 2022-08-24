package Model;

public class Cart {
	private int cid,cusid,pid,sid;
	private String pname,image;
	private double pprice;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCusid() {
		return cusid;
	}
	public void setCusid(int cusid) {
		this.cusid = cusid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", cusid=" + cusid + ", pid=" + pid + ", sid=" + sid + ", pname=" + pname
				+ ", image=" + image + ", pprice=" + pprice + "]";
	}
}
