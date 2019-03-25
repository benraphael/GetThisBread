import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CartName extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	private BorderPane root;
	private ArrayList<Product> cartItem = new ArrayList<Product>();
	
	public CartName() {
		root = new BorderPane();
		createCart();
	}
	
	private void createCart() {
		HBox bottom = new HBox();
		Button checkout = new Button("Go to Checkout");
	Button goHome = new Button("Go to Home Page");
		bottom.getChildren().addAll(checkout, goHome);
		root.setBottom(bottom);
		
		cartPane organizer = new cartPane();
		System.out.println("ger");
		
		
		checkout.setOnAction(event -> System.out.println("test1")); //Change once all the classes are together
		goHome.setOnAction(event -> System.out.println("test2")); //Change once all the classes are together
	}
	
	public Pane getRoot() {
		return root;
	}

	@Override
	public void start(Stage stage) throws Exception {
		System.out.println("nig");

		cartPane organizer = new cartPane();
		
		Scene scene = new Scene(organizer.getRoot());
		//Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
		
	}
}
