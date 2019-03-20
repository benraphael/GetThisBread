

import java.io.File;
import java.net.MalformedURLException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class HomePagePO {
	
	private BorderPane root;
	private Label title, subscript, cartL,checkoutL;
	private Button cart,checkout;
	
	//Tan(Bisque): #FFE4C4
	//Dark Brown: #362204
	//Money Green: #85bb65
	
	public HomePagePO() {
		root = new BorderPane();
		Home();
	}
	
	private void Home() {
		
		Image image1 = new Image("/store/BetterAttemptAtLogo.png");
		title = new Label();
		subscript = new Label();
		cartL = new Label();
		checkoutL = new Label();
		cart = new Button();
		
		cart.setStyle("-fx-background-color: #FFE4C4;-fx-graphic: url(/store/cart.png)");
		cart.setScaleX(.2);
		cart.setScaleY(.2);
		cart.setTranslateX(700);
		cart.setTranslateY(120);
		
		checkout = new Button();
		checkout.setStyle("-fx-background-color: #FFE4C4;-fx-graphic: url(/store/shopping-bag-outline.png)");
		checkout.setScaleX(.16);
		checkout.setScaleY(.16);
		checkout.setTranslateX(500);
		checkout.setTranslateY(120);
		
		HBox center = new HBox();
		center.setAlignment(Pos.CENTER);
		center.setSpacing(20);
		center.setPadding(new Insets(20));
		center.setStyle("-fx-background-color: white");
		
		HBox bottom = new HBox();
		bottom.setAlignment(Pos.BOTTOM_CENTER);
		bottom.setSpacing(20);
		bottom.setPadding(new Insets(20));
		bottom.setStyle("-fx-background-color: #FFE4C4");
		
		HBox top = new HBox();
		top.setAlignment(Pos.CENTER_LEFT);
		top.setSpacing(20);
		top.setPadding(new Insets(20));
		top.setStyle("-fx-background-color: #FFE4C4");
		
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
		
		root.setTop(top);
		root.setCenter(center);
		root.setBottom(bottom);
		root.setLeft(left);
		root.setRight(right);
		
		cartL.setTranslateX(272);
		cartL.setTranslateY(145);
		checkoutL.setTranslateX(298);
		checkoutL.setTranslateY(145);
		
		cartL.setStyle("-fx-text-fill: #362204;");
		checkoutL.setStyle("-fx-text-fill: #362204;");
		
		title.setText("Let's Get This Bread");
		title.setStyle("-fx-text-fill: #362204;-fx-font: 64px \"Edwardian Script ITC\";");
		subscript.setText("© 2019-2019, LetsGetThisBread.com, Inc. or its affiliates");
		subscript.setStyle("-fx-text-fill: #362204");
		
		ImageView imgView = new ImageView(image1);
		imgView.setFitHeight(200);
		imgView.setFitWidth(172);
        top.getChildren().addAll(imgView,title,cart,checkout);
        top.getChildren().addAll(cartL,checkoutL);
        bottom.getChildren().add(subscript);
        
        cart.setOnMouseEntered(e->cartMouseEnter());
        cart.setOnMouseExited(e->cartMouseExit());
       checkout.setOnMouseEntered(e->checkoutMouseEnter());
       checkout.setOnMouseExited(e->checkoutMouseExit());
        
		
	}
	
	private void checkoutMouseEnter() {
		checkout.setStyle("-fx-background-color: #FFE4C4;-fx-graphic: url(/store/shopping-bag-outline2.png)");
		checkoutL.setText("Checkout");
	}

	private void checkoutMouseExit() {
		checkout.setStyle("-fx-background-color: #FFE4C4;-fx-graphic: url(/store/shopping-bag-outline.png)");
		checkoutL.setText("");
	}
	
	private void cartMouseEnter() {
		cart.setStyle("-fx-background-color: #FFE4C4;-fx-graphic: url(/store/cart2.png)");
		cartL.setText("Cart");
	}

	private void cartMouseExit() {
		cart.setStyle("-fx-background-color: #FFE4C4;-fx-graphic: url(/store/cart.png)");
		cartL.setText("");
	}

	public Pane getRoot() {
		return root; 
	}

}
