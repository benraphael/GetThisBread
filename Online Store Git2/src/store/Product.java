


import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Product {

	private ImageView imageView;
	private Image image;
	private Label costLabel, descriptionLabel;
	
	private double cost;
	private String description, title, imageURL;
	
	public VBox root;
	
	
	public Product(String imageURL, String title, double cost, String description) {
		this.cost = cost;
		this.description = description;
		this.title = title;
		this.imageURL = imageURL;
		
		image = new Image(imageURL);
		imageView = new ImageView(image);
		costLabel = new Label("$" + this.cost);
		descriptionLabel = new Label(description);
		root = new VBox();
		root.getChildren().addAll(imageView, costLabel, descriptionLabel);
	}


	public void setCost(double cost) {
		this.cost = cost;
		costLabel.setText("$" + this.cost);
	}


	public void setDescription(String description) {
		this.description = description;
		descriptionLabel.setText(this.description);
	}
	
	public Parent getRoot() {
		return root;
	}


	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}
	
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	public ImageView getImageView() {
		return imageView;
	}
	
	public double getCost() {
		return cost;
	}
	
	public String getImageURL() {
		return imageURL;
	}
}