import java.util.ArrayList;

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

public class cartPane {
	private BorderPane root;
	private HBox top, center, bottom;
	private Label cart;
	private ArrayList<Product> cartItem = new ArrayList<Product>();
	// implement scroll bar, arrays

	public cartPane() {
		root = new BorderPane();
		createCart();
		run();
	}

	private void createCart() {
		HBox bottom = new HBox();
		Button checkout = new Button("Go to Checkout");
		Button goHome = new Button("Go to Home Page");
		bottom.getChildren().addAll(checkout, goHome);
		root.setBottom(bottom);

		checkout.setOnAction(event -> System.out.println("test1")); // Change once all the classes are together
		goHome.setOnAction(event -> System.out.println("test2")); // Change once all the classes are together
	}

	private void run() {
		Image image1 = new Image("File: /store/BetterAttemptAtLogo.png");
		ImageView imgView = new ImageView(image1);

		top = new HBox();
		top.setStyle("-fx-background-color: Bisque;");
		top.setAlignment(Pos.CENTER);
		imgView.setFitHeight(200);
		imgView.setFitWidth(170);
		top.getChildren().addAll(imgView);
		
//		center.setStyle("-fx-background-color: BLUE;");
//		center.setAlignment(Pos.CENTER);
//		imgView.setFitHeight(100);
//		imgView.setFitWidth(170);
//		center.getChildren().addAll(imgView);

		root.setTop(top);
		root.setCenter(center);
		root.setBottom(bottom);

		// top.setPadding();
		// top.setSpacing();

	}

	public Pane getRoot() {
		return root;
	}

}
