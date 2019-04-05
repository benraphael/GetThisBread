import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Ethan Jones
 * @date Mar 15, 2019
 * @file ProductPageOrganizer.java
 * @timestamp 10:16:34 AM
 */
public class ProductPageOrganizer2 {
	private final String BISQUE = "#FFE4C4", BROWN = "#362204", GREEN = "#85bb65";
	
	private Product product;
	private Stage stage;
	private Shirt thisShirt;
	private BorderPane root;
	// private Product product;
	private String productType;
	private ChoiceBox<String> size, colorx;
	private ChoiceBox<Integer> quantity;
	// private String[] tempSuggestions = {
	// "https://pbs.twimg.com/media/DEj0_L_UwAAEo5n.jpg",
	// "https://images.lookhuman.com/render/standard/0496005000292260/3600-athletic_gray-md-t-obama-confirmed-weeaboo.png",
	// "https://images.sunfrogshirts.com/2017/11/24/29942-1511508907152-Gildan-Hoo-Black-_w92_-front.jpg",
	// "https://i.pinimg.com/originals/84/20/3f/84203f29a4e7493c0caec66385e4bafd.jpg"
	// };
	private ArrayList<Image> sugImages = new ArrayList<Image>();
	private ArrayList<Product> sugProducts = new ArrayList<Product>();
	private ArrayList<Button> sugButtons = new ArrayList<Button>();

	public ProductPageOrganizer2(Product product, Stage stage, ArrayList<Product> suggestions) {
		this.product = product;
		root = new BorderPane();
//		if (product.getProductType().equals("Shirt")) {
//			thisShirt = (Shirt) product;
//		} else {
//			// this.product = product;
//		}

		// add suggested products to ArrayList and create image ArrayList
		for (Product p : suggestions) {
			sugProducts.add(p);
		}
//		for (Product p : sugProducts) {
//			sugImages.add(p.getImage());
//		}
		run();
		/*
		 * suggested products will pull product images from random items in the same
		 * department
		 * 
		 * hard coded images for suggestions
		 */
	}

	public void createImages(ArrayList<Product> p) {

		boolean canCreate = true;
		int i = 0, totalPix = 0;
		while (canCreate) {
			Product anotherP = p.get(i);
			Button button = new Button();
			button.setStyle("-fx-background-color: "+ BISQUE + ";");
			button.setOnMouseClicked(e -> openImage(anotherP));
			Image image = new Image(p.get(i).getImageURL());
			ImageView imageView = new ImageView(image);
			imageView.setPreserveRatio(true);
			imageView.setFitHeight(150);
			totalPix += imageView.getFitWidth();
			if (totalPix > 600)
				break;
			button.setGraphic(imageView);
			button.setPrefWidth(imageView.getFitWidth());
			button.setPrefHeight(imageView.getFitHeight());
			sugButtons.add(button);
			i++;
			if (i == p.size())
				canCreate = false;
		}
	}

	private void openImage(Product p) {
		Stage newStage = new Stage();
		sugProducts.remove(sugProducts.indexOf(p));
		sugProducts.add(this.product);
		ProductPageOrganizer2 redirect = new ProductPageOrganizer2(p, newStage, sugProducts);
		Scene scene = new Scene(redirect.getRoot(), 700, 600);
		newStage.setScene(scene);
		newStage.show();
		newStage.setResizable(false);
		// this.stage.close();
	}

	public void run() {
		createImages(sugProducts);

		ImageView productImage = thisShirt.getImageView();
		productImage.setPreserveRatio(true);
		productImage.setFitHeight(300);
		productImage.setFitWidth(300);

		// Area for image and information
		HBox main = new HBox();
		main.setAlignment(Pos.TOP_CENTER);
		main.setStyle("-fx-background-color: "+ BISQUE + ";");
		main.setSpacing(20);
		main.setPadding(new Insets(20));

		// Suggested Products on the bottom
		HBox suggest = new HBox();
		suggest.setAlignment(Pos.CENTER);
		suggest.setPrefSize(600, 200);
		suggest.setStyle("-fx-background-color: "+ BROWN + ";");
		// suggest.getChildren().add(sugImages.get(0));
		// int sugCount = 0, totalPix = 0;
		for (Button button : sugButtons) {
			suggest.getChildren().add(button);
			button.setOnMouseEntered(e -> suggestedHoverOn(button));
			button.setOnMouseExited(e -> suggestedHoverOff(button));
			// sugCount++;
			// if (sugCount == 4)
			// break;
		}

		// Information and order customization

		VBox info = new VBox();
		info.setAlignment(Pos.CENTER_RIGHT);
		info.setPrefSize(300, 400);
		info.setStyle("-fx-background-color: "+ BROWN + ";");

		HBox title = new HBox();
		title.setAlignment(Pos.TOP_LEFT);
		title.setPrefSize(200, 50);
		title.setStyle("-fx-background-color: "+ BISQUE + ";");

		Text titleText = new Text();
		titleText.setText(thisShirt.getName());
		titleText.setStyle("-fx-font: 25 sansserif;");


		title.getChildren().addAll(titleText);

		HBox cost = new HBox();
		cost.setAlignment(Pos.TOP_RIGHT);
		cost.setPrefSize(200, 35);
		cost.setStyle("-fx-background-color: "+ BISQUE + ";");

		Text costText = new Text();
		costText.setText(thisShirt.getCost() + "");
		costText.setStyle("-fx-font: 20 sansserif;");
		
		cost.getChildren().addAll(costText);

		HBox desc = new HBox();
		desc.setAlignment(Pos.TOP_LEFT);
		desc.setPrefSize(300, 135);
		desc.setStyle("-fx-background-color: "+ BISQUE + ";");

		HBox selec = new HBox();
		selec.setAlignment(Pos.TOP_CENTER);
		selec.setPrefSize(300, 75);
		selec.setStyle("-fx-background-color: PINK;");

		VBox quantitySpot = new VBox();
		quantitySpot.setAlignment(Pos.CENTER);
		quantitySpot.setPrefSize(100, 10);
		quantitySpot.setStyle("-fx-background-color: "+ BISQUE + ";");
		quantitySpot.setSpacing(20);
		VBox colorSpot = new VBox();
		colorSpot.setAlignment(Pos.CENTER);
		colorSpot.setPrefSize(100, 60);
		colorSpot.setStyle("-fx-background-color: "+ BISQUE + ";");
		colorSpot.setSpacing(20);
		VBox sizeSpot = new VBox();
		sizeSpot.setAlignment(Pos.CENTER);
		sizeSpot.setPrefSize(100, 80);
		sizeSpot.setStyle("-fx-background-color: "+ BISQUE + ";");
		sizeSpot.setSpacing(20);

		quantity = new ChoiceBox<Integer>();
		colorx = new ChoiceBox<String>();
		size = new ChoiceBox<String>();
		
		quantity.setStyle("-fx-background-color: "+ BISQUE + ";");
		colorx.setStyle("-fx-background-color: "+ BISQUE + ";");
		size.setStyle("-fx-background-color: "+ BISQUE + ";");

//		quantity.setTooltip(new Tooltip("Do you not know what nubmbers are?"));
//		colorx.setTooltip(new Tooltip("Just get your weeb color and go"));
//		size.setTooltip(new Tooltip("If you're buying this you're mosrt likely an XXL"));

		for (int i = 0; i < 9; i++) {
			quantity.getItems().add(i + 1);
		}

		for (String s : thisShirt.getSizes()) {
			size.getItems().add(s);
		}
		for (String s : thisShirt.getColors()) {
			colorx.getItems().add(s);
		}
		quantity.setValue(1);
		size.setValue(thisShirt.getSizes()[0]);
		colorx.setValue(thisShirt.getColors()[0]);

		quantitySpot.getChildren().add(quantity);
		sizeSpot.getChildren().add(size);
		colorSpot.getChildren().add(colorx);

		selec.getChildren().addAll(quantitySpot, sizeSpot, colorSpot);

		Text descText = new Text();
		descText.setText(thisShirt.getDescription());
		descText.setStyle("-fx-font: 13 sansserif;");
		descText.setWrappingWidth(290);
		desc.getChildren().add(descText);

		info.getChildren().addAll(title, cost, desc, selec);

		// Product Image

		VBox picture = new VBox();
		picture.setAlignment(Pos.CENTER_LEFT);
		picture.setPrefSize(300, 400);
		picture.setStyle("-fx-background-color: "+ BISQUE + ";");
		picture.getChildren().addAll(productImage);

		// Navagation Bar

		VBox navBar = new VBox();
		navBar.setAlignment(Pos.TOP_CENTER);
		navBar.setPrefSize(600, 75);
		navBar.setStyle("-fx-background-color: "+ BROWN + ";");

		main.getChildren().addAll(picture, info);

		root.setCenter(main);
		root.setBottom(suggest);
		root.setTop(navBar);
	}

	private void suggestedHoverOff(Button button) {
		ImageView imageView = (ImageView) button.getGraphic();
		imageView.setPreserveRatio(true);
		imageView.setFitHeight(150);
		button.setGraphic(imageView);
		button.setPrefWidth(imageView.getFitWidth());
		button.setPrefHeight(imageView.getFitHeight());
	}

	private void suggestedHoverOn(Button button) {

		ImageView imageView = (ImageView) button.getGraphic();
		imageView.setPreserveRatio(true);
		imageView.setFitHeight(200);
		button.setGraphic(imageView);
		button.setPrefWidth(imageView.getFitWidth());
		button.setPrefHeight(imageView.getFitHeight());
	}

	public Pane getRoot() {
		return root;
	}

}
