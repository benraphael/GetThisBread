import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomePagePO extends MainRunner {

	private BorderPane root;
	private Label title, subscript, cartL, checkoutL;
	private Button cart, checkout;
	private TextField search;

	private static final int SAMPLEPRODUCTSIZE = 10;
	private Button[] sampleProducts;

	// Tan(Bisque): #FFE4C4
	// Dark Brown: #362204
	// Money Green: #85bb65

	public HomePagePO() {
		root = new BorderPane();
		Home();
	}

	private void Home() {
		Image image1 = new Image("file:/store/BetterAttemptAtLogo.png");
		title = new Label();
		subscript = new Label();
		cartL = new Label();
		checkoutL = new Label();
		cart = new Button();
		sampleProducts = new Button[SAMPLEPRODUCTSIZE];
		
		int size = 230;
		search = new TextField();

		cart.setStyle("-fx-background-color: #362204;-fx-graphic: url(file:/store/cart.png)");
		cart.setScaleX(.2);
		cart.setScaleY(.2);
		cart.setTranslateX(0);
		cart.setTranslateY(-100);
		
		cartL.setTranslateY(-100);

		checkout = new Button();
		checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(file:/store/shopping-bag-outline.png)");
		checkout.setScaleX(.16);
		checkout.setScaleY(.16);
		checkout.setTranslateX(0);
		checkout.setTranslateY(-100);
		
		checkoutL.setTranslateY(-100);

		Pane center = new Pane();
		center.setPadding(new Insets(20));
		center.setStyle("-fx-background-color: white");

		Pane top = new Pane();
		top.setPadding(new Insets(20));
		top.setStyle("-fx-background-color: #362204");
		top.setPrefHeight(304);

		HBox centerTop = new HBox();
		centerTop.setAlignment(Pos.CENTER_LEFT);
		centerTop.setSpacing(20);
		centerTop.setPadding(new Insets(20));
		centerTop.setStyle("-fx-background-color: bisque");

		HBox centerBot = new HBox();
		centerBot.setAlignment(Pos.CENTER_LEFT);
		centerBot.setSpacing(20);
		centerBot.setPadding(new Insets(20));
		centerBot.setStyle("-fx-background-color: bisque");
		
		for (int i=0;i<sampleProducts.length;i++) {
			sampleProducts[i] = new Button();
			if (i<sampleProducts.length/2)
				centerTop.getChildren().add(sampleProducts[i]);
			else 
				centerBot.getChildren().add(sampleProducts[i]);
		}
		
		for (Button button: sampleProducts) {
			button.setPrefSize(size, size);
			button.setStyle("-fx-background-color: white;");
			button.setOnMouseEntered(e -> {
				button.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
				clickCursor();
			});
			button.setOnMouseExited(e -> {
				button.setStyle("-fx-background-color: white;");
				defaultCursor();	
			});
			button.setOnMousePressed(e -> button.setStyle("-fx-background-color: #f2f2f2;-fx-border-color: #85bb65;"));
			button.setOnMouseReleased(e -> button.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;"));
		}

		HBox bottom = new HBox();
		bottom.setAlignment(Pos.BOTTOM_CENTER);
		bottom.setSpacing(20);
		bottom.setPadding(new Insets(20));
		bottom.setStyle("-fx-background-color: #362204");

		HBox toptop = new HBox();
		toptop.setAlignment(Pos.CENTER_LEFT);
		toptop.setSpacing(20);
		toptop.setPadding(new Insets(20));
		toptop.setStyle("-fx-background-color: #362204");
		toptop.setPrefSize(1600, 200);

		HBox bottop = new HBox();
		bottop.setAlignment(Pos.CENTER_RIGHT);
		bottop.setSpacing(20);
		bottop.setPadding(new Insets(20));
		bottop.setStyle("-fx-background-color: #362204");
		bottop.setPrefSize(1600, 104);
		bottop.setTranslateY(200);

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
		root.setLeft(new DepartmentList().getRoot());
		root.setRight(right);

		cartL.setStyle("-fx-text-fill: #FFE4C4");
		checkoutL.setStyle("-fx-text-fill: #FFE4C4");
		cartL.setText("O");
		checkoutL.setText("O");

		title.setText("Let's Get This Bread");
		title.setStyle("-fx-text-fill: bisque;-fx-font: 64px \"Edwardian Script ITC\";");
		title.setWrapText(true);
		subscript.setText("© 2019-2019, LetsGetThisBread.com, Inc. or its affiliates");
		subscript.setStyle("-fx-text-fill: bisque");

		ImageView imgView = new ImageView(image1);
		imgView.setFitHeight(150);
		imgView.setFitWidth(129);
		top.getChildren().addAll(toptop, bottop);
		toptop.getChildren().addAll(imgView, title);
		bottop.getChildren().addAll(cartL, checkoutL, cart, checkout);
		bottom.getChildren().addAll(subscript);

		centerTop.setPrefSize(1600, 238);
		centerTop.setTranslateX(0);
		centerTop.setTranslateY(0);

		centerBot.setPrefSize(1600, 238);
		centerBot.setTranslateX(0);
		centerBot.setTranslateY(238);

		center.getChildren().addAll(centerTop, centerBot);

		cart.setOnMouseEntered(e -> mouseEnter("cart"));
		cart.setOnMouseExited(e -> mouseExit("cart"));
		checkout.setOnMouseEntered(e -> mouseEnter("checkout"));
		checkout.setOnMouseExited(e -> mouseExit("checkout"));
		cart.setOnMousePressed(e -> Click("cart"));
		checkout.setOnMousePressed(e -> Click("checkout"));

		cart.setOnMousePressed(e -> Pressed("cart"));
		checkout.setOnMousePressed(e -> Pressed("checkout"));
		cart.setOnMouseReleased(e -> Released("cart"));
		checkout.setOnMouseReleased(e -> Released("checkout"));
	}

	private void Pressed(String source) {
		switch (source) {
		case "cart":
			cart.setStyle("-fx-background-color: #362204;-fx-graphic: url(file:/store/cart3.png)");
			cartL.setStyle("-fx-text-fill: black");
			cart.setScaleX(.18);
			cart.setScaleY(.18);
			break;
		case "checkout":
			checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(file:/store/shopping-bag-outline3.png)");
			checkoutL.setStyle("-fx-text-fill: black");
			checkout.setScaleX(.14);
			checkout.setScaleY(.14);
			break;
		}
	}

	private void Released(String source) {
		switch (source) {
		case "cart":
			cart.setStyle("-fx-background-color: #362204;-fx-graphic: url(file:/store/cart2.png)");
			cartL.setStyle("-fx-text-fill: #FFE4C4");
			cart.setScaleX(.2);
			cart.setScaleY(.2);
			break;
		case "checkout":
			checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(file:/store/shopping-bag-outline2.png)");
			checkoutL.setStyle("-fx-text-fill: #FFE4C4");
			checkout.setScaleX(.16);
			checkout.setScaleY(.16);
			break;
		}
	}

	private void Click(String source) {
		if (source.equals("cart")) {
			System.out.println("cart");
		}
		if (source.equals("checkout")) {
			System.out.println("checkout");
		}
	}

	private void mouseEnter(String source) {
		switch (source) {
		case "cart":
			cart.setStyle("-fx-background-color: #362204;-fx-graphic: url(file:/store/cart2.png)");
			cartL.setText("Cart");
			clickCursor();
			break;
		case "checkout":
			checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(file:/store/shopping-bag-outline2.png)");
			checkoutL.setText("Checkout");
			clickCursor();
			break;
		}
	}

	private void mouseExit(String source) {
		switch (source) {
		case "cart":
			cart.setStyle("-fx-background-color: #362204;-fx-graphic: url(file:/store/cart.png)");
			cartL.setText("");
			defaultCursor();
			break;
		case "checkout":
			checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(file:/store/shopping-bag-outline.png)");
			checkoutL.setText("");
			defaultCursor();
			break;
		}
	}

	public Pane getRoot() {
		return root;
	}
}