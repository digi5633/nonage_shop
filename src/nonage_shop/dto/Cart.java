package nonage_shop.dto;

import java.sql.Timestamp;

public class Cart {

	private int cseq;
	private String id;
	private int pseq;
	private String mname;
	private String pname;
	private int quantity;
	private int price2;
	private Timestamp indate;

	public Cart() {
		super();
	}

	public Cart(int cseq, String id, int pseq, String mname, String pname, int quantity, int price2, Timestamp indate) {
		this.cseq = cseq;
		this.id = id;
		this.pseq = pseq;
		this.mname = mname;
		this.pname = pname;
		this.quantity = quantity;
		this.price2 = price2;
		this.indate = indate;
	}

	public Cart(int cseq, String id, int pseq, int quantity, Timestamp indate) {
		this.cseq = cseq;
		this.id = id;
		this.pseq = pseq;
		this.quantity = quantity;
		this.indate = indate;
	}

	public Cart(String id, int pseq, int quantity) {
		this.id = id;
		this.pseq = pseq;
		this.quantity = quantity;
	}

	public Cart(int cseq) {
		this.cseq = cseq;
	}

	public Cart(String id) {
		this.id = id;
	}

	public int getCseq() {
		return cseq;
	}

	public void setCseq(int cseq) {
		this.cseq = cseq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPseq() {
		return pseq;
	}

	public void setPseq(int pseq) {
		this.pseq = pseq;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice2() {
		return price2;
	}

	public void setPrice2(int price2) {
		this.price2 = price2;
	}

	public Timestamp getIndate() {
		return indate;
	}

	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}

	@Override
	public String toString() {
		return "Cart [cseq=" + cseq + ", id=" + id + ", pseq=" + pseq + ", mname=" + mname + ", pname=" + pname
				+ ", quantity=" + quantity + ", price2=" + price2 + ", indate=" + indate + "]";
	}

}
