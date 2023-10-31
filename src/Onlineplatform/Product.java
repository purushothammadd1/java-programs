package Onlineplatform;

public class Product {
	private int product_id;
	private String prod_name;
	private String description;
	private double price;
	private int stock_quantity;
	
	public Product() {
		super();
	}
	
	public Product(int product_id, String prod_name, String description, double price, int stock_quantity) {
		super();
		this.product_id = product_id;
		this.prod_name = prod_name;
		this.description = description;
		this.price = price;
		this.stock_quantity = stock_quantity;
	}
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock_quantity() {
		return stock_quantity;
	}
	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", prod_name=" + prod_name + ", description=" + description
				+ ", price=" + price + ", stock_quantity=" + stock_quantity + "]";
	}
	
	

}
