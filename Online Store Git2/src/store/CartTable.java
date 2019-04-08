import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CartTable {

	// TODO Auto-generated method stub
	// Table pane which displays item name, quantity and cost

	private SimpleStringProperty productName;
	private SimpleIntegerProperty quantity;
	private SimpleDoubleProperty cost;

	public CartTable(String productName, int quantity, double cost) {
		this.productName = new SimpleStringProperty(productName);
		this.quantity = new SimpleIntegerProperty(quantity);
		this.cost = new SimpleDoubleProperty(cost);
	}

	public String getProductName() {
		return productName.get();
	}

	public void setProductName(String product) {
		productName.set(product);
	}

	public int getQuantity() {
		return quantity.get();
	}

	public void setQuantity(int lquantity) {
		quantity.set(lquantity);
	}

	public double getCost() {
		return cost.get();
	}

	public void setCost(double lcost) {
		cost.set(lcost);
	}

}
