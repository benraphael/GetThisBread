
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * @author Ethan Jones
 * @date Mar 15, 2019
 * @file ProductPageOrganizer.java
 * @timestamp 10:16:34 AM
 */
public class ProductPageOrganizer {
	private BorderPane root;
	private Product product;
	private Product[] suggestedItems;
	private ChoiceBox<String> size, color;
	private String[] tempSuggestions = { "https://pbs.twimg.com/media/DEj0_L_UwAAEo5n.jpg",
			"https://images.lookhuman.com/render/standard/0496005000292260/3600-athletic_gray-md-t-obama-confirmed-weeaboo.png",
			"https://images.sunfrogshirts.com/2017/11/24/29942-1511508907152-Gildan-Hoo-Black-_w92_-front.jpg" };
	private ArrayList<ImageView> sugImages = new ArrayList<ImageView>();

	public ProductPageOrganizer(Product product) {
		root = new BorderPane();
		this.product = product;
		//this.product = (Shirt)this.product;
		run();
		/*
		 * suggested products will pull product images from random items in the same
		 * department
		 * 
		 * hard coded images for suggestions
		 */
	}

	public void createImages(String[] imageURLs) {
		boolean canCreate = true;
		int i = 0;
		while (canCreate) {
			Image image = new Image(imageURLs[i]);
			ImageView pic = new ImageView(image);
			sugImages.add(pic);
			i++;
			System.out.println(i);
		}
	}

	public void run() {
		createImages(tempSuggestions);

		ImageView productImage = product.getImageView();
		productImage.setPreserveRatio(true);
		productImage.setFitHeight(300);
		productImage.setFitWidth(300);

		//Area for image and information
		HBox main = new HBox();
		main.setAlignment(Pos.TOP_CENTER);
		main.setStyle("-fx-background-color: PINK;");
		main.setSpacing(20);
		main.setPadding(new Insets(20));
		
		//Suggested Products on the bottom
		HBox suggest = new HBox();
		suggest.setAlignment(Pos.BOTTOM_CENTER);
		suggest.setPrefSize(600, 200);
		suggest.setStyle("-fx-background-color: ALICEBLUE;");
//		suggest.getChildren().add(sugImages.get(0));
		
		for (ImageView image : sugImages) {
			image.setPreserveRatio(true);
			image.setFitHeight(300);
			image.setFitWidth(300);
			suggest.getChildren().add(image);
		}
		
		//Information and order customization

		VBox info = new VBox();
		info.setAlignment(Pos.CENTER_RIGHT);
		info.setPrefSize(300, 400);
		info.setStyle("-fx-background-color: AQUA;");

		HBox title = new HBox();
		title.setAlignment(Pos.TOP_LEFT);
		title.setPrefSize(200, 100);
		title.setStyle("-fx-background-color: GREEN;");

		Text titleText = new Text();
		titleText.setText(product.getName());
		titleText.setStyle("-fx-font: 30 sansserif;");

		title.getChildren().add(titleText);

		HBox desc = new HBox();
		desc.setAlignment(Pos.TOP_LEFT);
		desc.setPrefSize(300, 200);
		desc.setStyle("-fx-background-color: LIGHTGREEN;");

		Text descText = new Text();
		descText.setText(product.getDescription());
		descText.setStyle("-fx-font: 12 sansserif;");
		desc.getChildren().add(descText);
		
		HBox customizations = new HBox();
		customizations.setAlignment(Pos.TOP_CENTER);
		
		info.getChildren().addAll(title, desc);
		
		//Product Image

		VBox picture = new VBox();
		picture.setAlignment(Pos.CENTER_LEFT);
		picture.setPrefSize(300, 400);
		picture.setStyle("-fx-background-color: BLACK;");
		picture.getChildren().addAll(productImage);
		
		//Navagation Bar

		VBox navBar = new VBox();
		navBar.setAlignment(Pos.TOP_CENTER);
		navBar.setPrefSize(600, 75);
		navBar.setStyle("-fx-background-color: GREY;");


		main.getChildren().addAll(picture, info);

		root.setCenter(main);
		root.setBottom(suggest);
		root.setTop(navBar);
		
		
	}

	public Pane getRoot() {
		return root;
	}

}
