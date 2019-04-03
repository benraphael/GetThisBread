
import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * @author Ethan Jones
 * @date Mar 15, 2019
 * @file ProductPageOrganizer.java
 * @timestamp 10:16:34 AM
 */
public class ProductPageOrganizer {

	private BorderPane root;
	private ScrollPane scroll;
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
		run();
		/*
		 * suggested products will pull product images from random items in the same
		 * department
		 * 
		 * hard coded images for suggestions
		 */
	}

	public void createImages(String[] imageURLs) {
		for (int i = 0; i < imageURLs.length; i++) {
			Image image = new Image(imageURLs[i]);
			ImageView pic = new ImageView(image);
			sugImages.add(pic);
			System.out.println(i);
		}
	}

	public void run() {
		createImages(tempSuggestions);

		VBox center = new VBox();
//		center.setAlignment(Pos.CENTER);
//		center.setSpacing(20);
		center.setPrefWidth(1600);
//		center.setPadding(new Insets(20));
		center.setStyle("-fx-background-color: bisque");
		center.setOnScroll(new EventHandler<ScrollEvent>() {
			@Override
			public void handle(ScrollEvent event) {
				double deltaY = event.getDeltaY() * 5; // *6 to make the scrolling a bit faster
				double width = scroll.getContent().getBoundsInLocal().getWidth();
				double vvalue = scroll.getVvalue();
				// deltaY/width to make the scrolling equally fast regardless of the actual
				// width of the component
				scroll.setVvalue(vvalue + -deltaY / width);
			}
		});

		scroll = new ScrollPane();
		scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
		scroll.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scroll.setContent(center);
		scroll.setFitToHeight(true);

		ImageView productImage = product.getImageView();
		productImage.setPreserveRatio(true);
		productImage.setFitHeight(300);
//		productImage.setFitWidth(300);

		// Area for image and information
		HBox productBox = new HBox();
		productBox.setAlignment(Pos.CENTER);
		productBox.setStyle("-fx-background-color: bisque;");
		productBox.setSpacing(20);
		productBox.setPadding(new Insets(20));

		// Suggested Products on the bottom
		HBox suggest = new HBox();
		suggest.setAlignment(Pos.CENTER);
		suggest.setPrefSize(600, 200);
		suggest.setStyle("-fx-background-color: ALICEBLUE;");
		// suggest.getChildren().add(sugImages.get(0));

		VBox info = new VBox();
		info.setAlignment(Pos.CENTER);
		info.setPrefSize(300, 400);
		info.setStyle("-fx-background-color: AQUA;");
		info.getChildren().addAll(product.getNameLabel(), product.getCostLabel(), product.getDescriptionLabel());

		for (ImageView image : sugImages) {
			image.setPreserveRatio(true);
			image.setFitHeight(300);
//			image.setFitWidth(300);
			suggest.getChildren().add(image);
		}

		// Information and order customization
		HBox customizations = new HBox();
		customizations.setAlignment(Pos.TOP_CENTER);

		HBox bottom = new HBox();
		bottom.setAlignment(Pos.BOTTOM_CENTER);
		bottom.setSpacing(20);
		bottom.setPadding(new Insets(20));
		bottom.setStyle("-fx-background-color: #362204");

		VBox left = new VBox();
		left.setAlignment(Pos.CENTER);
		left.setSpacing(20);
		left.setPadding(new Insets(20));
		left.setStyle("-fx-background-color: white");

		VBox right = new VBox();
		right.setAlignment(Pos.CENTER);
		right.setSpacing(20);
		right.setPadding(new Insets(20));
		right.setStyle("-fx-background-color: white");

		productBox.getChildren().addAll(productImage, info);
		center.getChildren().addAll(productBox, suggest);

		root.setCenter(scroll);
		root.setBottom(bottom);
		root.setLeft(left);
		root.setRight(right);
		root.setTop(new DepartmentBar().getRoot());
	}

	public Pane getRoot() {
		return root;
	}
}
