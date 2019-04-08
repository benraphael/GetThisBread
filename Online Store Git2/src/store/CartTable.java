import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class CartTable {

	private SimpleStringProperty productName;
	private SimpleDoubleProperty cost;

	/**
	 * Table pane which displays item name and cost
	 * 
	 * @param product - might be needed to remove properly
	 * @param productName
	 * @param cost
	 */
	public CartTable(String productName, double cost) {
		this.productName = new SimpleStringProperty(productName);
		this.cost = new SimpleDoubleProperty(cost);
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
}