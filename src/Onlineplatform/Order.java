package Onlineplatform;

import java.sql.Timestamp;

public class Order extends Transaction{
	private int orderid;
	private Timestamp orderDate;
	private int userId;
	private double totalPrice;
		
	public Order() {
		super();
	}

	public Order(int orderid, Timestamp orderDate, int userId, double totalPrice) {
		super();
		this.orderid = orderid;
		this.orderDate = orderDate;
		this.userId = userId;
		this.totalPrice = totalPrice;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", orderDate=" + orderDate + ", userId=" + userId + ", totalPrice="
				+ totalPrice + "]";
	}
	
	
	
	
	

}
