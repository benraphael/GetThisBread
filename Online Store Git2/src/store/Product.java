
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Product {

	private ImageView imageView;
	private Image image;
	private Label costLabel, descriptionLabel, nameLabel;
	private VBox root;

	private String imageURL;
	private String name;
	private double cost;
	private String description;

	/**
	 * A class that holds the image, name, cost, and description of a product
	 * 
	 * @param imageURL - the URL for the image of the product
	 * @param name - the name of the product
	 * @param cost - the cost of the product as a double
	 * @param description - a written description of the product
	 */
	public Product(String imageURL, String name, double cost, String description) {
		this.imageURL = imageURL;
		this.name = name;
		this.cost = cost;
		this.description = description;

		image = new Image(imageURL);
		imageView = new ImageView(image);
		costLabel = new Label("$" + this.cost);
		descriptionLabel = new Label(description);
		nameLabel = new Label(name);
		root = new VBox();
		root.getChildren().addAll(imageView, nameLabel, costLabel, descriptionLabel);
	}
	
	//We could have this
	public void changeFonts(String fontName, double size) {

	}

	/**
	 * returns the cost of the product
	 * 
	 * @return cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * sets the cost of the product
	 * 
	 * @param cost - the number to change to
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * returns the written description of the product
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	//TODO to be implemented based on the product page
	public void setOnClick() {
		
	}

	public Parent getRoot() {
		return root;
	}
}