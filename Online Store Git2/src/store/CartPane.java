import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CartPane extends MainRunner {
	private static final int SCROLLSPEED = 3;
	private BorderPane root;
	private HBox top, center, bottom;
	private Label cart;
	private ArrayList<Product> cartItem;
    private ScrollPane scroll;
	
	public CartPane(ArrayList<Product> cartItem) {
		this.cartItem = cartItem;
		root = new BorderPane();
		run();
	}

	private ObservableList<cartTable> run() {
		cart = new Label();
		cart.setText("© 2019-2019, LetsGetThisBread.com, Inc. or its affiliates");
		cart.setStyle("-fx-text-fill: bisque");

		center = new HBox();
		center.setStyle("-fx-background-color: Bisque;");
		center.setAlignment(Pos.CENTER);
		center.setPadding(new Insets(20));

		
		// insert tables (columns for Item name, price and quantity)
		//Cart Table Pane 
		
		
		bottom = new HBox();
		bottom.getChildren().addAll(cart);
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
		root.setCenter(scroll);
		root.setCenter(center);
		root.setBottom(bottom);
		root.setRight(right);
		root.setLeft(left);

	}

	public Pane getRoot() {
		return root;
	}
}
