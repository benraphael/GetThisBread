import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DepartmentBar extends Application {

	private BorderPane test;
	
	private HBox root;
	private Label cartLabel, checkoutLabel;
	private Button cart, checkout;
	private TextField search;
	private ComboBox<String> departments;
	
	public DepartmentBar() {
		root = new HBox();
		test = new BorderPane();
		cartLabel = new Label();
		checkoutLabel = new Label();
		cart = new Button();
		search = new TextField();
		departments = new ComboBox<String>();
		
		cart.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/t8wgHDp.png)");
		cart.setScaleX(.2);
		cart.setScaleY(.2);
//		cart.setTranslateX(275);
//		cart.setTranslateY(-111);
//
//		cartLabel.setTranslateX(436);
//		cartLabel.setTranslateY(-180);
//		
//		departments.setPrefSize(200, 0);
		departments.setStyle(
				"-fx-background-color: bisque;-fx-text-fill: #362204;-fx-control-inner-background: bisque;-fx-base: #85bb65;");
		departments.setPromptText("Select a department...");
		departments.getItems().addAll("dept1", "dept2", "dept3", "etc");
		
//		search.setPrefWidth(200);
		search.setStyle("-fx-background-color: bisque;-fx-text-fill: #362204");
		search.setFocusTraversable(false);

		checkout = new Button();
		checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/zI5uhfZ.png)");
		checkout.setScaleX(.16);
		checkout.setScaleY(.16);
//		checkout.setTranslateX(75);
//		checkout.setTranslateY(-84);
//
//		checkoutLabel.setTranslateX(492);
//		checkoutLabel.setTranslateY(-180);
//		
//		root.setAlignment(Pos.BOTTOM_RIGHT);
		root.setSpacing(20);
		root.setPadding(new Insets(20));
		root.setStyle("-fx-background-color: #362204");
//		root.setPrefSize(1600, 104);
//		root.setTranslateY(200);

		HBox departmentHBox = new HBox();
		departmentHBox.setAlignment(Pos.BOTTOM_RIGHT);
		departmentHBox.setSpacing(20);
		departmentHBox.setPadding(new Insets(20));
		departmentHBox.setStyle("-fx-background-color: #362204");
//		departmentHBox.setPrefSize(300, 100);
//		departmentHBox.setTranslateY(200);
//		departmentHBox.setTranslateX(1120);

		HBox searchBox = new HBox();
		searchBox.setAlignment(Pos.BOTTOM_LEFT);
		searchBox.setSpacing(20);
		searchBox.setPadding(new Insets(20));
		searchBox.setStyle("-fx-background-color: #362204");
//		searchBox.setPrefSize(300, 100);
//		searchBox.setTranslateY(200);
//		searchBox.setTranslateX(58);
		
		HBox buttons = new HBox();
		buttons.setAlignment(Pos.BOTTOM_LEFT);
		buttons.setSpacing(20);
		buttons.setPadding(new Insets(20));
		buttons.setStyle("-fx-background-color: #362204");
		
		departmentHBox.getChildren().add(departments);
		searchBox.getChildren().add(search);
		buttons.getChildren().addAll(cart, cartLabel, checkout, checkoutLabel);
		
		root.getChildren().addAll(departmentHBox, searchBox, buttons);
		test.setTop(root);
		
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
				// TODO make it search
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
			break;
		case "checkout":
			checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/blMxO0J.png)");
			checkoutLabel.setStyle("-fx-text-fill: #FFE4C4");
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
			cartLabel.setText("Cart");
			clickCursor();
			break;
		case "checkout":
			checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/blMxO0J.png)");
			checkoutLabel.setText("Checkout");
			clickCursor();
			break;
		}
	}

	private void mouseExit(String source) {
		switch (source) {
		case "cart":
			cart.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/t8wgHDp.png)");
			cartLabel.setText("");
			defaultCursor();
			break;
		case "checkout":
			checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/zI5uhfZ.png)");
			checkoutLabel.setText("");
			defaultCursor();
			break;
		}
	}
	
	static Scene scene;
	public static void defaultCursor() {
		 scene.setCursor(Cursor.DEFAULT);
		
	}
	public static void clickCursor() {
		 scene.setCursor(Cursor.HAND);
		
	}
	
	public Parent getRoot() {
		return test;
	}

	@Override
	public void start(Stage stage) throws Exception {
		scene = new Scene(this.getRoot(), 1600, 800);
		stage.setTitle("https://LetsGetThisBread.com");
		stage.setMaximized(true);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
