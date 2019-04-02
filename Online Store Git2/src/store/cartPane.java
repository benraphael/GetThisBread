import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class cartPane extends MainRunner {
	private BorderPane root;
	private HBox top, center, bottom;
	private Label cart;
	private ArrayList<Product> cartItem = new ArrayList<Product>();
	private ArrayList<Product> quantity = new ArrayList<Product>();
	private ArrayList<Product> price = new ArrayList<Product>();

	public cartPane() {
		root = new BorderPane();
		run();
	}

	private void run() {
		cart = new Label();

		Button checkout = new Button("Go to Checkout");
		Button goHome = new Button("Go to Home Page");
		Button confirm = new Button("Confirm Purchase");
		checkout.setOnAction(event -> System.out.println("test1")); // Change once all the classes are together
		goHome.setOnAction(event -> System.out.println("test2")); // Change once all the classes are together
		confirm.setOnAction(event -> System.out.println("test3"));

		Image image1 = new Image("file:///Z:/git/GetThisBread/Online%20Store%20Git2/src/store/BetterAttemptAtLogo.png");
		ImageView imgView = new ImageView(image1);

		top = new HBox();
		top.setStyle("-fx-background-color: #362204;");
		top.setAlignment(Pos.TOP_LEFT);
		imgView.setFitHeight(200);
		imgView.setFitWidth(170);
		cart.setText("G");
		cart.setStyle("-fx-text-fill: bisque");
		// cart.setAllignment("");
		top.getChildren().addAll(imgView);

		center = new HBox();
		center.setStyle("-fx-background-color: Bisque;");
		center.setAlignment(Pos.CENTER);
		// insert tables (columns for Item name, price and quantity)
		// insert scroll bar

		bottom = new HBox();
		bottom.getChildren().addAll(checkout, goHome, confirm);
		bottom.setStyle("-fx-background-color: #362204;");
		bottom.setAlignment(Pos.BOTTOM_LEFT);
		bottom.setPrefHeight(100);

		root.setTop(top);
		root.setCenter(center);
		root.setBottom(bottom);
	}

	public Pane getRoot() {
		return root;
	}
}
