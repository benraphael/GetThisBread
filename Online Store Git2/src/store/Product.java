

import java.text.DecimalFormat;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Product {

	private DecimalFormat df = new DecimalFormat("#.00");
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
	 * @param imageURL
	 *            - the URL for the image of the product
	 * @param name
	 *            - the name of the product
	 * @param cost
	 *            - the cost of the product as a double
	 * @param description
	 *            - a written description of the product
	 */
	public Product(String imageURL, String name, double cost, String description) {
		this.cost = cost;
		this.description = description;
		this.name = name;
		this.imageURL = imageURL;

		image = new Image(imageURL);
		imageView = new ImageView(image);
		nameLabel = new Label(name);
		nameLabel.setWrapText(true);
		costLabel = new Label("$" + df.format(this.cost));
		costLabel.setWrapText(true);
		descriptionLabel = new Label(description);
		descriptionLabel.setWrapText(true);
		root = new VBox();
		root.getChildren().addAll(imageView, nameLabel, costLabel, descriptionLabel);
	} 

	// We could have this
	public void changeFonts(String fontName, double size) {
		nameLabel.setFont(Font.font(fontName, size));
		costLabel.setFont(Font.font(fontName, size));
		descriptionLabel.setFont(Font.font(fontName, size));
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
	 * @param cost
	 *            - the number to change to
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

	public ImageView getImageView() {
		return imageView;
	}

	public Label getCostLabel() {
		return costLabel;
	}

	public Label getDescriptionLabel() {
		return descriptionLabel;
	}

	public Label getNameLabel() {
		return nameLabel;
	}

	// TODO to be implemented based on the product page
	public void setOnClick() {

	}

	public Parent getRoot() {
		return root;
	}
}