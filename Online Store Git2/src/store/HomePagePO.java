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

	private Button t1, t2, t3, t4, t5, t6, b1, b2, b3, b4, b5, b6;

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

		t1 = new Button();
		t2 = new Button();
		t3 = new Button();
		t4 = new Button();
		t5 = new Button();
		t6 = new Button();
		b1 = new Button();
		b2 = new Button();
		b3 = new Button();
		b4 = new Button();
		b5 = new Button();
		b6 = new Button();

		int size = 230;
		t1.setPrefSize(size, size);
		t2.setPrefSize(size, size);
		t3.setPrefSize(size, size);
		t4.setPrefSize(size, size);
		t5.setPrefSize(size, size);
		t6.setPrefSize(size, size);
		b1.setPrefSize(size, size);
		b2.setPrefSize(size, size);
		b3.setPrefSize(size, size);
		b4.setPrefSize(size, size);
		b5.setPrefSize(size, size);
		b6.setPrefSize(size, size);

		t1.setStyle("-fx-background-color: white;");
		t2.setStyle("-fx-background-color: white;");
		t3.setStyle("-fx-background-color: white;");
		t4.setStyle("-fx-background-color: white;");
		t5.setStyle("-fx-background-color: white;");
		t6.setStyle("-fx-background-color: white;");
		b1.setStyle("-fx-background-color: white;");
		b2.setStyle("-fx-background-color: white;");
		b3.setStyle("-fx-background-color: white;");
		b4.setStyle("-fx-background-color: white;");
		b5.setStyle("-fx-background-color: white;");
		b6.setStyle("-fx-background-color: white;");

		search = new TextField();

		cart.setStyle("-fx-background-color: #362204;-fx-graphic: url(/store/cart.png)");
		cart.setScaleX(.2);
		cart.setScaleY(.2);
		cart.setTranslateX(0);
		cart.setTranslateY(-100);
		
		cartL.setTranslateY(-100);

		checkout = new Button();
		checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(/store/shopping-bag-outline.png)");
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
		root.setLeft(left);
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

		centerTop.getChildren().addAll(t1, t2, t3, t4, t5, t6);
		centerBot.getChildren().addAll(b1, b2, b3, b4, b5, b6);
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

		t1.setOnMouseEntered(e -> mouseEnter("t1"));
		t1.setOnMouseExited(e -> mouseExit("t1"));
		t2.setOnMouseEntered(e -> mouseEnter("t2"));
		t2.setOnMouseExited(e -> mouseExit("t2"));
		t3.setOnMouseEntered(e -> mouseEnter("t3"));
		t3.setOnMouseExited(e -> mouseExit("t3"));
		t4.setOnMouseEntered(e -> mouseEnter("t4"));
		t4.setOnMouseExited(e -> mouseExit("t4"));
		t5.setOnMouseEntered(e -> mouseEnter("t5"));
		t5.setOnMouseExited(e -> mouseExit("t5"));
		t6.setOnMouseEntered(e -> mouseEnter("t6"));
		t6.setOnMouseExited(e -> mouseExit("t6"));
		b1.setOnMouseEntered(e -> mouseEnter("b1"));
		b1.setOnMouseExited(e -> mouseExit("b1"));
		b2.setOnMouseEntered(e -> mouseEnter("b2"));
		b2.setOnMouseExited(e -> mouseExit("b2"));
		b3.setOnMouseEntered(e -> mouseEnter("b3"));
		b3.setOnMouseExited(e -> mouseExit("b3"));
		b4.setOnMouseEntered(e -> mouseEnter("b4"));
		b4.setOnMouseExited(e -> mouseExit("b4"));
		b5.setOnMouseEntered(e -> mouseEnter("b5"));
		b5.setOnMouseExited(e -> mouseExit("b5"));
		b6.setOnMouseEntered(e -> mouseEnter("b6"));
		b6.setOnMouseExited(e -> mouseExit("b6"));

		t1.setOnMousePressed(e -> Pressed("t1"));
		t1.setOnMouseReleased(e -> Released("t1"));
		t2.setOnMousePressed(e -> Pressed("t2"));
		t2.setOnMouseReleased(e -> Released("t2"));
		t3.setOnMousePressed(e -> Pressed("t3"));
		t3.setOnMouseReleased(e -> Released("t3"));
		t4.setOnMousePressed(e -> Pressed("t4"));
		t4.setOnMouseReleased(e -> Released("t4"));
		t5.setOnMousePressed(e -> Pressed("t5"));
		t5.setOnMouseReleased(e -> Released("t5"));
		t6.setOnMousePressed(e -> Pressed("t6"));
		t6.setOnMouseReleased(e -> Released("t6"));

		b1.setOnMousePressed(e -> Pressed("b1"));
		b1.setOnMouseReleased(e -> Released("b1"));
		b2.setOnMousePressed(e -> Pressed("b2"));
		b2.setOnMouseReleased(e -> Released("b2"));
		b3.setOnMousePressed(e -> Pressed("b3"));
		b3.setOnMouseReleased(e -> Released("b3"));
		b4.setOnMousePressed(e -> Pressed("b4"));
		b4.setOnMouseReleased(e -> Released("b4"));
		b5.setOnMousePressed(e -> Pressed("b5"));
		b5.setOnMouseReleased(e -> Released("b5"));
		b6.setOnMousePressed(e -> Pressed("b6"));
		b6.setOnMouseReleased(e -> Released("b6"));

	}

	private void Pressed(String source) {
		switch (source) {

		case "cart":
			cart.setStyle("-fx-background-color: #362204;-fx-graphic: url(/store/cart3.png)");
			cartL.setStyle("-fx-text-fill: black");
			cart.setScaleX(.18);
			cart.setScaleY(.18);
			break;
		case "checkout":
			checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(/store/shopping-bag-outline3.png)");
			checkoutL.setStyle("-fx-text-fill: black");
			checkout.setScaleX(.14);
			checkout.setScaleY(.14);
			break;
		case "t1":
			t1.setStyle("-fx-background-color: #f2f2f2;-fx-border-color: #85bb65;");
			break;
		case "t2":
			t2.setStyle("-fx-background-color: #f2f2f2;-fx-border-color: #85bb65;");
			break;
		case "t3":
			t3.setStyle("-fx-background-color: #f2f2f2;-fx-border-color: #85bb65;");
			break;
		case "t4":
			t4.setStyle("-fx-background-color: #f2f2f2;-fx-border-color: #85bb65;");
			break;
		case "t5":
			t5.setStyle("-fx-background-color: #f2f2f2;-fx-border-color: #85bb65;");
			break;
		case "t6":
			t6.setStyle("-fx-background-color: #f2f2f2;-fx-border-color: #85bb65;");
			break;

		case "b1":
			b1.setStyle("-fx-background-color: #f2f2f2;-fx-border-color: #85bb65;");
			break;
		case "b2":
			b2.setStyle("-fx-background-color: #f2f2f2;-fx-border-color: #85bb65;");
			break;
		case "b3":
			b3.setStyle("-fx-background-color: #f2f2f2;-fx-border-color: #85bb65;");
			break;
		case "b4":
			b4.setStyle("-fx-background-color: #f2f2f2;-fx-border-color: #85bb65;");
			break;
		case "b5":
			b5.setStyle("-fx-background-color: #f2f2f2;-fx-border-color: #85bb65;");
			break;
		case "b6":
			b6.setStyle("-fx-background-color: #f2f2f2;-fx-border-color: #85bb65;");
			break;
		}
	}

	private void Released(String source) {
		switch (source) {

		case "cart":
			cart.setStyle("-fx-background-color: #362204;-fx-graphic: url(/store/cart2.png)");
			cartL.setStyle("-fx-text-fill: #FFE4C4");
			cart.setScaleX(.2);
			cart.setScaleY(.2);
			break;
		case "checkout":
			checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(/store/shopping-bag-outline2.png)");
			checkoutL.setStyle("-fx-text-fill: #FFE4C4");
			checkout.setScaleX(.16);
			checkout.setScaleY(.16);
			break;
		case "t1":
			t1.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			break;
		case "t2":
			t2.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			break;
		case "t3":
			t3.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			break;
		case "t4":
			t4.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			break;
		case "t5":
			t5.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			break;
		case "t6":
			t6.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			break;

		case "b1":
			b1.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			break;
		case "b2":
			b2.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			break;
		case "b3":
			b3.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			break;
		case "b4":
			b4.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			break;
		case "b5":
			b5.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			break;
		case "b6":
			b6.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
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
			cart.setStyle("-fx-background-color: #362204;-fx-graphic: url(/store/cart2.png)");
			cartL.setText("Cart");
			clickCursor();
			break;
		case "checkout":
			checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(/store/shopping-bag-outline2.png)");
			checkoutL.setText("Checkout");
			clickCursor();
			break;

		case "t1":
			t1.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			clickCursor();
			break;
		case "t2":
			t2.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			clickCursor();
			break;
		case "t3":
			t3.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			clickCursor();
			break;
		case "t4":
			t4.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			clickCursor();
			break;
		case "t5":
			t5.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			clickCursor();
			break;
		case "t6":
			t6.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			clickCursor();
			break;

		case "b1":
			b1.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			clickCursor();
			break;
		case "b2":
			b2.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			clickCursor();
			break;
		case "b3":
			b3.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			clickCursor();
			break;
		case "b4":
			b4.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			clickCursor();
			break;
		case "b5":
			b5.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			clickCursor();
			break;
		case "b6":
			b6.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			clickCursor();
			break;
		}

	}

	private void mouseExit(String source) {
		switch (source) {
		case "cart":
			cart.setStyle("-fx-background-color: #362204;-fx-graphic: url(/store/cart.png)");
			cartL.setText("");
			defaultCursor();
			break;
		case "checkout":
			checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(/store/shopping-bag-outline.png)");
			checkoutL.setText("");
			defaultCursor();
			break;

		case "t1":
			t1.setStyle("-fx-background-color: white;");
			defaultCursor();
			break;
		case "t2":
			t2.setStyle("-fx-background-color: white;");
			defaultCursor();
			break;
		case "t3":
			t3.setStyle("-fx-background-color: white;");
			defaultCursor();
			break;
		case "t4":
			t4.setStyle("-fx-background-color: white;");
			defaultCursor();
			break;
		case "t5":
			t5.setStyle("-fx-background-color: white;");
			defaultCursor();
			break;
		case "t6":
			t6.setStyle("-fx-background-color: white;");
			defaultCursor();
			break;

		case "b1":
			b1.setStyle("-fx-background-color: white;");
			defaultCursor();
			break;
		case "b2":
			b2.setStyle("-fx-background-color: white;");
			defaultCursor();
			break;
		case "b3":
			b3.setStyle("-fx-background-color: white;");
			defaultCursor();
			break;
		case "b4":
			b4.setStyle("-fx-background-color: white;");
			defaultCursor();
			break;
		case "b5":
			b5.setStyle("-fx-background-color: white;");
			defaultCursor();
			break;
		case "b6":
			b6.setStyle("-fx-background-color: white;");
			defaultCursor();
			break;
		}
	}

	public Pane getRoot() {
		return root;
	}

}
