import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class CartTable {

	private SimpleStringProperty productName;
	private SimpleDoubleProperty cost;
	private Product product;

	/**
	 * Table pane which displays item name and cost
	 * 
	 * @param product - Links product from cart to table for removing
	 * @param productName - Name of the product from the cart
	 * @param cost - Cost of the product from the cart
	 */
	public CartTable(Product prod, String productName, double cost) {
		this.productName = new SimpleStringProperty(productName);
		this.cost = new SimpleDoubleProperty(cost);
		product = prod;
	}

	public String getProductName() {
		return productName.get();
	}

	public void setProductName(String product) {
		productName.set(product);
	}

	public double getCost() {
		return cost.get();
	}

	public void setCost(double lcost) {
		cost.set(lcost);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}