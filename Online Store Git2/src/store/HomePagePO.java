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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomePagePO extends HomePage {

	private BorderPane root;
	private Label title, subscript, cartL, checkoutL;
	private Button cart, checkout;
	private TextField search;

	private static final int SAMPLEPRODUCTSIZE = 12;
	private Button[] sampleProducts;

	// Tan(Bisque): #FFE4C4
	// Dark Brown: #362204
	// Money Green: #85bb65

	public HomePagePO() {
		root = new BorderPane();
		Home();
	}

	private void Home() {

		Image image1 = new Image("https://i.imgur.com/OVWPlbB.png");
		title = new Label();
		subscript = new Label();
		cartL = new Label();
		checkoutL = new Label();
		cart = new Button();
		sampleProducts = new Button[SAMPLEPRODUCTSIZE];
		search = new TextField();

		cart.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/t8wgHDp.png)");
		cart.setScaleX(.2);
		cart.setScaleY(.2);
		cart.setTranslateX(275);
		cart.setTranslateY(-111);

		cartL.setTranslateX(436);
		cartL.setTranslateY(-180);

		checkout = new Button();
		checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/zI5uhfZ.png)");
		checkout.setScaleX(.16);
		checkout.setScaleY(.16);
		checkout.setTranslateX(75);
		checkout.setTranslateY(-84);

		checkoutL.setTranslateX(492);
		checkoutL.setTranslateY(-180);

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
		bottop.setAlignment(Pos.BOTTOM_RIGHT);
		bottop.setSpacing(20);
		bottop.setPadding(new Insets(20));
		bottop.setStyle("-fx-background-color: #362204");
		bottop.setPrefSize(1600, 104);
		bottop.setTranslateY(200);

		HBox idontcareanymore = new HBox();
		idontcareanymore.setAlignment(Pos.BOTTOM_RIGHT);
		idontcareanymore.setSpacing(20);
		idontcareanymore.setPadding(new Insets(20));
		idontcareanymore.setStyle("-fx-background-color: #362204");
		idontcareanymore.setPrefSize(300, 100);
		idontcareanymore.setTranslateY(200);
		idontcareanymore.setTranslateX(1120);

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

		search.setPrefWidth(200);

		search.setStyle("-fx-background-color: bisque;-fx-text-fill: #362204");
		search.setFocusTraversable(false);

		root.setTop(top);
		root.setCenter(center);
		root.setBottom(bottom);
		root.setLeft(left);
		root.setRight(right);

		cartL.setStyle("-fx-text-fill: #FFE4C4");
		checkoutL.setStyle("-fx-text-fill: #FFE4C4");

		title.setText("Let's Get This Bread");
		title.setStyle("-fx-text-fill: bisque;-fx-font: 64px \"Edwardian Script ITC\";");
		title.setWrapText(true);
		subscript.setText("© 2019-2019, LetsGetThisBread.com, Inc. or its affiliates");
		subscript.setStyle("-fx-text-fill: bisque");

		for (int i = 0; i < sampleProducts.length; i++) {
			sampleProducts[i] = new Button();
			if (i < sampleProducts.length / 2)
				centerTop.getChildren().add(sampleProducts[i]);
			else
				centerBot.getChildren().add(sampleProducts[i]);
		}

		int size = 230;
		for (Button button : sampleProducts) {
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

		ImageView imgView = new ImageView(image1);
		imgView.setFitHeight(150);
		imgView.setFitWidth(129);
		top.getChildren().addAll(toptop, bottop, idontcareanymore);
		toptop.getChildren().addAll(imgView, title);
		bottop.getChildren().addAll(cartL, checkoutL, cart, checkout);
		bottom.getChildren().addAll(subscript);
		idontcareanymore.getChildren().addAll(search);

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

	public void enterPressed(KeyEvent event) {

		if (search.isFocused()) {
			switch (event.getCode()) {
			case ENTER:
				// make it search
				break;
			default:
				break;
			}
		}
	}

	private void Pressed(String source) {
		switch (source) {

		case "cart":
			cart.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/IF96gSL.png)");
			cartL.setStyle("-fx-text-fill: black");
			cart.setScaleX(.18);
			cart.setScaleY(.18);
			break;
		case "checkout":
			checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/HLJIw6c.png)");
			checkoutL.setStyle("-fx-text-fill: black");
			checkout.setScaleX(.14);
			checkout.setScaleY(.14);
			break;

		}
	}

	private void Released(String source) {
		switch (source) {

		case "cart":
			cart.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/MZkcgvq.png)");
			cartL.setStyle("-fx-text-fill: #FFE4C4");
			cart.setScaleX(.2);
			cart.setScaleY(.2);
			break;
		case "checkout":
			checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/blMxO0J.png)");
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
			cart.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/MZkcgvq.png)");
			cartL.setText("Cart");
			clickCursor();
			break;
		case "checkout":
			checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/blMxO0J.png)");
			checkoutL.setText("Checkout");
			clickCursor();
			break;
		}
	}

	private void mouseExit(String source) {
		switch (source) {
		case "cart":
			cart.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/t8wgHDp.png)");
			cartL.setText("");
			defaultCursor();
			break;
		case "checkout":
			checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/zI5uhfZ.png)");
			checkoutL.setText("");
			defaultCursor();
			break;
		}
	}

	public Pane getRoot() {
		return root;
	}
}