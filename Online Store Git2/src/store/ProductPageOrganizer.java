
import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * @author Ethan Jones
 * @date Mar 15, 2019
 * @file ProductPageOrganizer.java
 * @timestamp 10:16:34 AM
 */
public class ProductPageOrganizer extends MainRunner{

	private BorderPane root;
	private ScrollPane scroll;
	private Product product;
	private String[] tempSuggestions = { "https://pbs.twimg.com/media/DEj0_L_UwAAEo5n.jpg",
			"https://images.lookhuman.com/render/standard/0496005000292260/3600-athletic_gray-md-t-obama-confirmed-weeaboo.png",
			"https://images.sunfrogshirts.com/2017/11/24/29942-1511508907152-Gildan-Hoo-Black-_w92_-front.jpg" };
	private ArrayList<ImageView> sugImages = new ArrayList<ImageView>();
	private Label subscript;

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
		}
	}

	public void run() {
		createImages(tempSuggestions);
		
		scroll = new ScrollPane();
		scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
		scroll.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scroll.setStyle("-fx-background-color: bisque");

		VBox center = new VBox();
		center.setAlignment(Pos.CENTER);
		center.setSpacing(20);
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

		ImageView productImage = product.getImageView();
		productImage.setPreserveRatio(true);
		productImage.setFitHeight(300);

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

		VBox info = new VBox();
		info.setAlignment(Pos.CENTER);
		info.setPrefSize(300, 400);
		info.setStyle("-fx-background-color: AQUA;");
		info.getChildren().addAll(product.getNameLabel(), product.getCostLabel(), product.getDescriptionLabel());
		
		Label quantity = new Label("Quantity");
		quantity.setStyle("-fx-text-fill: bisque;-fx-text-fill: #362204");
		
		TextField qty = new TextField("0");
		qty.setPrefWidth(50);
		qty.setStyle("-fx-background-color: #85bb65;-fx-text-fill: #362204");
		qty.setFocusTraversable(true);
		qty.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("\\d*")) {
		            qty.setText(newValue.replaceAll("[^\\d]", ""));
		        }
		    }
		});
		
		HBox qtyBox = new HBox();
		qtyBox.setAlignment(Pos.CENTER);
		qtyBox.setPrefSize(600, 200);
		qtyBox.setStyle("-fx-background-color: purple;");
		qtyBox.getChildren().addAll(quantity, qty);
		
		Button add = new Button("Add To Cart");
		add.setPrefSize(100, 50);
		add.setStyle("-fx-background-color: white;");
		add.setOnMouseEntered(e -> {
			add.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			clickCursor();
		});
		add.setOnMouseExited(e -> {
			add.setStyle("-fx-background-color: white;");
			defaultCursor();
		});
		add.setOnMousePressed(e -> add.setStyle("-fx-background-color: #f2f2f2;-fx-border-color: #85bb65;"));
		add.setOnMouseReleased(e -> add.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;"));
		add.setOnAction(event -> {
			for (int i=0;i<Integer.parseInt(qty.getText());i++) {
				cart.add(product);
			}
			Checkout.updateCart();
			System.out.println(cart.toString());
		});
		
		info.getChildren().addAll(qtyBox, add);

		for (ImageView image : sugImages) {
			image.setPreserveRatio(true);
			image.setFitHeight(300);
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

		subscript = new Label();
		subscript.setText("© 2019-2019, LetsGetThisBread.com, Inc. or its affiliates");
		subscript.setStyle("-fx-text-fill: bisque");
		bottom.getChildren().add(subscript);

		root.setTop(new DepartmentBar().getRoot());
		root.setCenter(scroll);
		root.setBottom(bottom);
		root.setLeft(left);
		root.setRight(right);
		scroll.setContent(center);
	}

	public Pane getRoot() {
		return root;
	}
}
