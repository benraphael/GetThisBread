import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class DepartmentBar extends MainRunner {

	private BorderPane root;
	private Label cartLabel, checkoutLabel;
	private Button cart, checkout;
	private TextField search;
	private ComboBox<String> departmentList;

	// Tan(Bisque): #FFE4C4
	// Dark Brown: #362204
	// Money Green: #85bb65

	public DepartmentBar() {
		root = new BorderPane();
		Home();
	}

	private void Home() {
		cartLabel = new Label("Cart");
		checkoutLabel = new Label("Checkout");
		cart = new Button();
		search = new TextField();
		departmentList = new ComboBox<String>();

		cart.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/t8wgHDp.png)");
		cart.setScaleX(.2);
		cart.setScaleY(.2);
//		cart.setTranslateX(275);
//		cart.setTranslateY(-111);

//		cartLabel.setTranslateX(cart.getTranslateX());
//		cartLabel.setTranslateY(-111);
		cartLabel.setVisible(false);
		
		VBox cartIcons = new VBox();
//		cartIcons.setSpacing(20);
		cartIcons.getChildren().addAll(cart, cartLabel);
		cartIcons.setAlignment(Pos.CENTER);

		checkout = new Button();
		checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/zI5uhfZ.png)");
		checkout.setScaleX(.16);
		checkout.setScaleY(.16);
//		checkout.setTranslateX(75);
//		checkout.setTranslateY(-84);

//		checkoutLabel.setTranslateX(492);
//		checkoutLabel.setTranslateY(-180);
		checkoutLabel.setVisible(false);
		
		VBox checkoutIcons = new VBox();
//		checkoutIcons.setSpacing(20);
		checkoutIcons.getChildren().addAll(checkout, checkoutLabel);
		checkoutIcons.setAlignment(Pos.CENTER);

		HBox buttons = new HBox();
		buttons.setAlignment(Pos.BOTTOM_RIGHT);
//		buttons.setSpacing(20);
//		buttons.setPadding(new Insets(20));
		buttons.setStyle("-fx-background-color: transparent");
//		buttons.setPrefSize(1600, 100);
//		buttons.setTranslateY(200);

		HBox searchHBox = new HBox();
		searchHBox.setAlignment(Pos.BOTTOM_RIGHT);
		searchHBox.setSpacing(20);
		searchHBox.setPadding(new Insets(20));
		searchHBox.setStyle("-fx-background-color: #362204");
		searchHBox.setPrefSize(300, 100);
		searchHBox.setTranslateY(200);
		searchHBox.setTranslateX(1120);

		HBox departmentHBox = new HBox();
		departmentHBox.setAlignment(Pos.BOTTOM_LEFT);
		departmentHBox.setSpacing(20);
		departmentHBox.setPadding(new Insets(20));
		departmentHBox.setStyle("-fx-background-color: #362204");
		departmentHBox.setPrefSize(300, 100);
		departmentHBox.setTranslateY(200);
		departmentHBox.setTranslateX(71);

		search.setPrefWidth(200);
		search.setStyle("-fx-background-color: bisque;-fx-text-fill: #362204");
		search.setFocusTraversable(false);
		search.setPromptText("Search");

		HBox mainBox = new HBox();
		root.setTop(mainBox);

		cartLabel.setStyle("-fx-text-fill: #FFE4C4");
		checkoutLabel.setStyle("-fx-text-fill: #FFE4C4");

		departmentList.setPrefSize(200, 0);
		departmentList.setStyle(
				"-fx-background-color: bisque;-fx-text-fill: #362204;-fx-control-inner-background: bisque;-fx-base: #85bb65;");
		departmentList.setPromptText("Select a department...");
		departmentList.getItems().addAll("dept1", "dept2", "dept3", "etc");

//		top.getChildren().addAll(buttons, searchHBox, departmentHBox);
		buttons.getChildren().addAll(cartIcons, checkoutIcons);
//		searchHBox.getChildren().addAll(search);
//		departmentHBox.getChildren().addAll(departmentList);
		
		mainBox.setStyle("-fx-background-color: #362204");
		mainBox.getChildren().addAll(departmentList, search, buttons);
		mainBox.setSpacing(20);
		mainBox.setPadding(new Insets(20));

		cart.setOnMouseEntered(e -> mouseEnter("cart"));
		cart.setOnMouseExited(e -> mouseExit("cart"));
		checkout.setOnMouseEntered(e -> mouseEnter("checkout"));
		checkout.setOnMouseExited(e -> mouseExit("checkout"));
		// cart.setOnMousePressed(e -> Click("cart"));
		// checkout.setOnMousePressed(e -> Click("checkout"));

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
			cartLabel.setStyle("-fx-text-fill: black");
			cart.setScaleX(.18);
			cart.setScaleY(.18);
			break;
		case "checkout":
			checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/HLJIw6c.png)");
			checkoutLabel.setStyle("-fx-text-fill: black");
			checkout.setScaleX(.14);
			checkout.setScaleY(.14);
			break;

		}
	}

	private void Released(String source) {
		switch (source) {

		case "cart":
			cart.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/MZkcgvq.png)");
			cartLabel.setStyle("-fx-text-fill: #FFE4C4");
			cart.setScaleX(.2);
			cart.setScaleY(.2);
			System.out.println("Cart");
			break;
		case "checkout":
			checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/blMxO0J.png)");
			checkoutLabel.setStyle("-fx-text-fill: #FFE4C4");
			checkout.setScaleX(.16);
			checkout.setScaleY(.16);
			System.out.println("Checkout");
			break;

		}
	}

	// private void Click(String source) {
	//
	// if (source.equals("cart")) {
	// System.out.println("cart");
	// }
	// if (source.equals("checkout")) {
	// System.out.println("checkout");
	// }
	// }

	private void mouseEnter(String source) {
		switch (source) {

		case "cart":
			cart.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/MZkcgvq.png)");
			cartLabel.setVisible(true);
			clickCursor();
			break;
		case "checkout":
			checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/blMxO0J.png)");
			checkoutLabel.setVisible(true);
			clickCursor();
			break;
		}
	}

	private void mouseExit(String source) {
		switch (source) {
		case "cart":
			cart.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/t8wgHDp.png)");
			cartLabel.setVisible(false);
			defaultCursor();
			break;
		case "checkout":
			checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/zI5uhfZ.png)");
			checkoutLabel.setVisible(false);
			defaultCursor();
			break;
		}
	}

	public Pane getRoot() {
		return root;
	}
}