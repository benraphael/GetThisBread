
import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Cart {
	
	private BorderPane root;
	private ArrayList<Product> cartItem = new ArrayList<Product>();
	
	public Cart() {
		root = new BorderPane();
		createCart();
	}
	
	private void createCart() {
		HBox bottom = new HBox();
		Button checkout = new Button("Go to Checkout");
		Button goHome = new Button("Go to Home Page");
		bottom.getChildren().addAll(checkout, goHome);
		root.setBottom(bottom);
		
		
		checkout.setOnAction(event -> System.out.println("test1")); //Change once all the classes are together
		goHome.setOnAction(event -> System.out.println("test2")); //Change once all the classes are together
	}
	
	public Pane getRoot() {
		return root;
	}
}
