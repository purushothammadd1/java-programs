package Productjdbc;

public class ProductManagerMain {
	public static void main(String[] args) throws Exception {
		
		Product newProduct = new Product();
		newProduct.setName("Laptop");
		newProduct.setPrice(89499.99);
		newProduct.setDescription("High performance laptop");
		
		String url="jdbc:mysql://localhost:3306/product";
		String username= "root";
		String password= "4724";
		
		ProductManager productManager = new ProductManager(url, username, password);
	}

}
