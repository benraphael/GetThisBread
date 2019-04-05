
public class CartTable {

		// TODO Auto-generated method stub
      //Table pane which displays item name, quantity and cost
	
	private String product;
	private int quantity;
	private double cost;
	
	public CartTable() {
		this.product = "";
		this.quantity = 0;
		this.cost = 0;
	}
	public CartTable(String product, int quantity, double cost) {
		this.product = product;
		this.quantity = quantity;
		this.cost = cost;
		
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	
	}
	

