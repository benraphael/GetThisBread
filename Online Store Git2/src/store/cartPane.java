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
	private ArrayList<Product> cartItem;

	public cartPane(ArrayList<Product> cartItem) {
		this.cartItem = cartItem;
		root = new BorderPane();
		run();
	}

	private void run() {
		cart = new Label();

		Button checkout = new Button("Go to Checkout");
		Button goHome = new Button("Go to Home Page");
		//Button confirm = new Button("Confirm Purchase");
		checkout.setOnAction(event -> toCheckout()); // Change once all the classes are together
		goHome.setOnAction(event -> toHome()); // Change once all the classes are together
		//confirm.setOnAction(event -> System.out.println("test3"));

		center = new HBox();
		center.setStyle("-fx-background-color: Bisque;");
		center.setAlignment(Pos.CENTER);
		// insert tables (columns for Item name, price and quantity)
		// insert scroll bar

		bottom = new HBox();
		bottom.getChildren().addAll(checkout, goHome);
		bottom.setAlignment(Pos.CENTER);
		bottom.setStyle("-fx-background-color: #362204;");
		bottom.setPrefHeight(60);
		bottom.setSpacing(30);
		
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

		root.setTop(new DepartmentBar().getRoot());
		root.setCenter(center);
		root.setBottom(bottom);
		root.setRight(right);
		root.setLeft(left);
	}

	public Pane getRoot() {
		return root;
	}
}
