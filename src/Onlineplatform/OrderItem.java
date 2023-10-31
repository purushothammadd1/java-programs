package Onlineplatform;

public class OrderItem {
	private int orderitemId;
	private int orderid;
	private int productid;
	private int quanity;
	private double subtotalPrice;
	
	public OrderItem() {
		
	}

	public OrderItem(int orderitemId, int orderid, int productid, int quanity, double subtotalPrice) {
		this.orderitemId = orderitemId;
		this.orderid = orderid;
		this.productid = productid;
		this.quanity = quanity;
		this.subtotalPrice = subtotalPrice;
	}

	public int getOrderitemId() {
		return orderitemId;
	}

	public void setOrderitemId(int orderitemId) {
		this.orderitemId = orderitemId;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public double getSubtotalPrice() {
		return subtotalPrice;
	}

	public void setSubtotalPrice(double subtotalPrice) {
		this.subtotalPrice = subtotalPrice;
	}
	
	
	

}
