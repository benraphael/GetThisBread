

import java.util.ArrayList;

public class Department {

	private String name;
	
	public ArrayList<Product> products;
	
	/**
	 * A class that stores the name and products for a department
	 * 
	 * @param name - the name of the department
	 */
	public Department(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	/**
	 * Use this to assign a department its products
	 * 
	 * @param products - the arraylist of type product containing the products
	 */
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
}
