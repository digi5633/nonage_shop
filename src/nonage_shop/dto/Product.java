package nonage_shop.dto;

import java.util.Date;

public class Product {
	private int pseq;
	private String name;
	private String kind;
	private int price1;
	private int price2;
	private int price3;
	private String content;
	private String image;
	private String useyn;
	private String bestyn;
	private Date indate;

	public Product() {

	}

	public Product(int pseq, String name, String kind, int price1, int price2, int price3, String content, String image,
			String useyn, String bestyn, Date indate) {
		this.pseq = pseq;
		this.name = name;
		this.kind = kind;
		this.price1 = price1;
		this.price2 = price2;
		this.price3 = price3;
		this.content = content;
		this.image = image;
		this.useyn = useyn;
		this.bestyn = bestyn;
		this.indate = indate;
	}

	public Product(String kind) {
		this.kind = kind;
	}

	public Product(int pseq) {
		this.pseq = pseq;
	}

	public int getPseq() {
		return pseq;
	}

	public void setPseq(int pseq) {
		this.pseq = pseq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getPrice1() {
		return price1;
	}

	public void setPrice1(int price1) {
		this.price1 = price1;
	}

	public int getPrice2() {
		return price2;
	}

	public void setPrice2(int price2) {
		this.price2 = price2;
	}

	public int getPrice3() {
		return price3;
	}

	public void setPrice3(int price3) {
		this.price3 = price3;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUseyn() {
		return useyn;
	}

	public void setUseyn(String useyn) {
		this.useyn = useyn;
	}

	public String getBestyn() {
		return bestyn;
	}

	public void setBestyn(String bestyn) {
		this.bestyn = bestyn;
	}

	public Date getIndate() {
		return indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}

	@Override
	public String toString() {
		return "Product [pseq=" + pseq + ", name=" + name + ", kind=" + kind + ", price1=" + price1 + ", price2="
				+ price2 + ", price3=" + price3 + ", content=" + content + ", image=" + image + ", useyn=" + useyn
				+ ", bestyn=" + bestyn + ", indate=" + indate + "]";
	}

}
