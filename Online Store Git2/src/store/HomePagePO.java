import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class HomePagePO extends MainRunner {

	private BorderPane root;
	private Label title, subscript, cartL, checkoutL;
	private Button cart, checkout;
	private TextField search;
	private ComboBox<String> box;
	private ScrollPane scroll;
	private static final int SAMPLEPRODUCTSIZE = 24;
	private static final int PRODUCTNUMBER = 6;
	private static final int BUTTONSIZE = 220;
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
		box = new ComboBox<String>();
		scroll = new ScrollPane();
		
		scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
		scroll.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scroll.setStyle("-fx-background-color: transparent");
		

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

		VBox center = new VBox();
		center.setPadding(new Insets(20));
		center.setStyle("-fx-background-color: bisque");

		Pane top = new Pane();
		top.setPadding(new Insets(20));
		top.setStyle("-fx-background-color: #362204");
		top.setPrefHeight(304);

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
		bottop.setStyle("-fx-background-color: transparent");
		bottop.setPrefSize(1600, 100);
		bottop.setTranslateY(200);

		HBox idontcareanymore = new HBox();
		idontcareanymore.setAlignment(Pos.BOTTOM_RIGHT);
		idontcareanymore.setSpacing(20);
		idontcareanymore.setPadding(new Insets(20));
		idontcareanymore.setStyle("-fx-background-color: #362204");
		idontcareanymore.setPrefSize(300, 100);
		idontcareanymore.setTranslateY(200);
		idontcareanymore.setTranslateX(1120);
		
		HBox departmentboxbox = new HBox();
		departmentboxbox.setAlignment(Pos.BOTTOM_LEFT);
		departmentboxbox.setSpacing(20);
		departmentboxbox.setPadding(new Insets(20));
		departmentboxbox.setStyle("-fx-background-color: #362204");
		departmentboxbox.setPrefSize(300, 100);
		departmentboxbox.setTranslateY(200);
		departmentboxbox.setTranslateX(71);

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
		search.setPromptText("Search");

		root.setTop(top);
		root.setCenter(scroll);
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
		
		box.setPrefSize(200,0);
		box.setStyle("-fx-background-color: bisque;-fx-text-fill: #362204;-fx-control-inner-background: bisque;-fx-base: #85bb65;");
		box.setPromptText("Select a department...");
		box.getItems().addAll("dept1", "dept2", "dept3", "etc");
		
		HBox[] hboxes = new HBox[(sampleProducts.length%PRODUCTNUMBER != 0) ? sampleProducts.length/PRODUCTNUMBER + 1 : sampleProducts.length/PRODUCTNUMBER];
		
		for (int i=0;i<hboxes.length;i++) {
			hboxes[i] = new HBox();
			hboxes[i].setAlignment(Pos.CENTER_LEFT);
			hboxes[i].setSpacing(20);
			hboxes[i].setPadding(new Insets(20));
			hboxes[i].setStyle("-fx-background-color: bisque");
			center.getChildren().add(hboxes[i]);
		}
		
		for (int i=0;i<sampleProducts.length;i++) {
			sampleProducts[i] = new Button();
			sampleProducts[i].setText("(Product " + (i + 1) + ")");
			hboxes[i/PRODUCTNUMBER].getChildren().add(sampleProducts[i]);
		}

		for (Button button : sampleProducts) {
			button.setPrefSize(BUTTONSIZE, BUTTONSIZE);
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
		top.getChildren().addAll(toptop, bottop, idontcareanymore, departmentboxbox);
		toptop.getChildren().addAll(imgView, title);
		bottop.getChildren().addAll(cartL, checkoutL, cart, checkout);
		bottom.getChildren().addAll(subscript);
		idontcareanymore.getChildren().addAll(search);
		departmentboxbox.getChildren().addAll(box);

		scroll.setContent(center);

		cart.setOnMouseEntered(e -> mouseEnter("cart"));
		cart.setOnMouseExited(e -> mouseExit("cart"));
		checkout.setOnMouseEntered(e -> mouseEnter("checkout"));
		checkout.setOnMouseExited(e -> mouseExit("checkout"));
		//cart.setOnMousePressed(e -> Click("cart"));
		//checkout.setOnMousePressed(e -> Click("checkout"));

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
			toCart();
			break;
		case "checkout":
			checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/blMxO0J.png)");
			checkoutL.setStyle("-fx-text-fill: #FFE4C4");
			checkout.setScaleX(.16);
			checkout.setScaleY(.16);
			toCheckout();
			break;

		}
	}

//	private void Click(String source) {
//
//		if (source.equals("cart")) {
//			System.out.println("cart");
//		}
//		if (source.equals("checkout")) {
//			System.out.println("checkout");
//		}
//	}

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