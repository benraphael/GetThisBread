import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;

public class DepartmentBar extends MainRunner {

	private Pane mainPane;
	private Label storeName, cartLabel, checkoutLabel;
	private Button cart, checkout;
	private TextField search;
	private ComboBox<String> departmentList;
	private boolean isMuted = false;

	// Tan(Bisque): #FFE4C4
	// Dark Brown: #362204
	// Money Green: #85bb65

	/**
	 * Class that stores a Pane object and hold the store name, logo, and the
	 * navigation options. There is a list of departments to choose from, a search
	 * bar to search for a product, a cart button to look at the current cart, a
	 * checkout button to finalize a purchase, and clicking the logo leads to the
	 * home page.
	 */
	public DepartmentBar() {
		mainPane = new Pane();
		Home();
	}

	private void Home() {
		storeName = new Label();
		cartLabel = new Label("Cart");
		checkoutLabel = new Label("Checkout");
		cart = new Button();
		checkout = new Button();
		search = new TextField();
		departmentList = new ComboBox<String>();

		// Cart button and label
		cart.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/t8wgHDp.png)");
		cart.setScaleX(.2);
		cart.setScaleY(.2);
		cart.setTranslateX(275);
		cart.setTranslateY(-111);

		cartLabel.setTranslateX(487);
		cartLabel.setTranslateY(-180);
		cartLabel.setStyle("-fx-text-fill: #FFE4C4");
		cartLabel.setVisible(false);

		// Checkout button and label
		checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/zI5uhfZ.png)");
		checkout.setScaleX(.16);
		checkout.setScaleY(.16);
		checkout.setTranslateX(75);
		checkout.setTranslateY(-84);

		checkoutLabel.setTranslateX(492);
		checkoutLabel.setTranslateY(-180);
		checkoutLabel.setStyle("-fx-text-fill: #FFE4C4");
		checkoutLabel.setVisible(false);

		// Pane to hold everything
		mainPane.setPadding(new Insets(20));
		mainPane.setStyle("-fx-background-color: #362204");
		mainPane.setPrefHeight(268);
		mainPane.setOnKeyPressed(event -> {
			KeyCode keyCode = event.getCode();
			if (keyCode.equals(KeyCode.N)) {
				play[0].getOnEndOfMedia().run();
			} else if (keyCode.equals(KeyCode.M)) {
				isMuted = !isMuted;
				mute(isMuted);
			}
		});

		HBox storeNamePane = new HBox();
		storeNamePane.setAlignment(Pos.CENTER_LEFT);
		storeNamePane.setSpacing(20);
		storeNamePane.setPadding(new Insets(20));
		storeNamePane.setStyle("-fx-background-color: #362204");
		storeNamePane.setPrefSize(1600, 200);

		HBox navigation = new HBox();
		navigation.setAlignment(Pos.BOTTOM_RIGHT);
		navigation.setSpacing(20);
		navigation.setPadding(new Insets(20));
		navigation.setStyle("-fx-background-color: transparent");
		navigation.setPrefSize(1600, 100);
		navigation.setTranslateY(160);

		HBox searchBarBox = new HBox();
		searchBarBox.setAlignment(Pos.BOTTOM_RIGHT);
		searchBarBox.setSpacing(20);
		searchBarBox.setPadding(new Insets(20));
		searchBarBox.setStyle("-fx-background-color: #362204");
		searchBarBox.setPrefSize(300, 100);
		searchBarBox.setTranslateY(160);
		searchBarBox.setTranslateX(1120);
		searchBarBox.getChildren().addAll(search);

		HBox departmentListBox = new HBox();
		departmentListBox.setAlignment(Pos.BOTTOM_LEFT);
		departmentListBox.setSpacing(20);
		departmentListBox.setPadding(new Insets(20));
		departmentListBox.setStyle("-fx-background-color: #362204");
		departmentListBox.setPrefSize(300, 100);
		departmentListBox.setTranslateY(160);
		departmentListBox.setTranslateX(71);
		departmentListBox.getChildren().addAll(departmentList);

		search.setPrefWidth(200);
		search.setStyle("-fx-background-color: bisque;-fx-text-fill: #362204");
		search.setFocusTraversable(false);
		search.setPromptText("Search...");
		search.setOnKeyPressed(e -> {
			if (e.getCode().equals(KeyCode.ENTER))
				enterPressed();
		});

		storeName.setText("Let's Get This Bread");
		storeName.setStyle("-fx-text-fill: bisque;-fx-font: 64px \"Edwardian Script ITC\";");
		storeName.setWrapText(true);

		departmentList.setPrefSize(200, 0);
		departmentList.setStyle(
				"-fx-background-color: bisque;-fx-text-fill: #362204;-fx-control-inner-background: bisque;-fx-base: #85bb65;");
		departmentList.setPromptText("Select a department...");
		for (Department dep : deps) {
			departmentList.getItems().add(dep.getName());
		}
		departmentList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				toDepartment(newValue);
			}
		});

		ImageView storeLogo = new ImageView(new Image("https://i.imgur.com/OVWPlbB.png"));
		storeLogo.setFitHeight(150);
		storeLogo.setFitWidth(129);

		storeNamePane.getChildren().addAll(storeLogo, storeName);
		navigation.getChildren().addAll(cartLabel, checkoutLabel, cart, checkout);
		mainPane.getChildren().addAll(storeNamePane, navigation, searchBarBox, departmentListBox);

		cart.setOnMouseEntered(e -> mouseEnter("cart"));
		cart.setOnMouseExited(e -> mouseExit("cart"));
		cart.setOnMousePressed(e -> Pressed("cart"));
		cart.setOnMouseReleased(e -> Released("cart"));
		checkout.setOnMouseEntered(e -> mouseEnter("checkout"));
		checkout.setOnMousePressed(e -> Pressed("checkout"));
		checkout.setOnMouseReleased(e -> Released("checkout"));
		checkout.setOnMouseExited(e -> mouseExit("checkout"));
		storeLogo.setOnMouseReleased(e -> toHome());
		storeLogo.setOnMouseEntered(e -> clickCursor());
		storeLogo.setOnMouseExited(e -> defaultCursor());
	}

	public void enterPressed() {
		if (search.isFocused()) {
			Product prod = null;
			for (Department dep : deps) {
				for (Product prods : dep.getProducts()) {
					if (search.getText().equalsIgnoreCase(prods.getName()))
						prod = prods;
				}
			}
			if (prod != null) {
				toProduct(prod);
			} else {
				Alert alert = new Alert(AlertType.NONE, "\t\t\t\tThe speficified product \n\t\t\t\t\t"
						+ search.getText() + "\n\t\t\t\tdoes not exist in the store.", ButtonType.OK);
				alert.initOwner(search.getScene().getWindow());
				alert.showAndWait();

				if (alert.getResult() == ButtonType.OK) {
					alert.close();
				}
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
			toCart();
			break;
		case "checkout":
			checkout.setStyle("-fx-background-color: #362204;-fx-graphic: url(https://i.imgur.com/blMxO0J.png)");
			checkoutLabel.setStyle("-fx-text-fill: #FFE4C4");
			checkout.setScaleX(.16);
			checkout.setScaleY(.16);
			toCheckout();
			break;
		}
	}

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
		return mainPane;
	}
}