    
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
	private String description, title, type;
	
	public VBox root;
	
	
	public Product(String imageURL, String title, double cost, String description, String type) {
		this.type = type;
		this.cost = cost;
		this.description = description;
		this.title = title;
		
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
	
	
}