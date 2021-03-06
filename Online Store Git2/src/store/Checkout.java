
import java.text.DecimalFormat;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Checkout extends MainRunner {

	private static final DecimalFormat df = new DecimalFormat("#.00");
	private final String[] stateList = { "Non-US", "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA",
			"GU", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MH", "MI", "MN", "MO", "MS", "MT",
			"NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "PR", "PW", "RI", "SC", "SD", "TN",
			"TX", "UT", "VA", "VI", "VT", "WA", "WI", "WV", "WY" };
	private final String[] countryList = { "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola",
			"Anguilla", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan",
			"The Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda",
			"Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso",
			"Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic",
			"Chad", "Chile", "People 's Republic of China", "Republic of China", "Christmas Island",
			"Cocos(Keeling) Islands", "Colombia", "Comoros", "Congo", "Cook Islands", "Costa Rica", "Cote d'Ivoire",
			"Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
			"Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia",
			"Falkland Islands", "Faroe Islands", "Fiji", "Finland", "France", "French Polynesia", "Gabon", "The Gambia",
			"Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam",
			"Guatemala", "Guernsey", "Guinea", "Guinea - Bissau", "Guyana", "Haiti", "Honduras", "Hong Kong", "Hungary",
			"Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jersey",
			"Jordan", "Kazakhstan", "Kenya", "Kiribati", "North Korea", "South Korea", "Kosovo", "Kuwait", "Kyrgyzstan",
			"Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg",
			"Macau", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands",
			"Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia",
			"Montenegro", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Nagorno - Karabakh", "Namibia", "Nauru",
			"Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger",
			"Nigeria", "Niue", "Norfolk Island", "Turkish Republic of Northern Cyprus", "Northern Mariana", "Norway",
			"Oman", "Pakistan", "Palau", "Palestine", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines",
			"Pitcairn Islands", "Poland", "Portugal", "Puerto Rico", "Qatar", "Romania", "Russia", "Rwanda",
			"Saint Barthelemy", "Saint Helena", "Saint Kitts and Nevis", "Saint Lucia", "Saint Martin",
			"Saint Pierre and Miquelon", "Saint Vincent and the Grenadines", "Samoa", "San Marino",
			"Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore",
			"Slovakia", "Slovenia", "Solomon Islands", "Somalia", "Somaliland", "South Africa", "South Ossetia",
			"Spain", "Sri Lanka", "Sudan", "Suriname", "Svalbard", "Swaziland", "Sweden", "Switzerland", "Syria",
			"Taiwan", "Tajikistan", "Tanzania", "Thailand", "Timor - Leste", "Togo", "Tokelau", "Tonga",
			"Transnistria Pridnestrovie", "Trinidad and Tobago", "Tristan da Cunha", "Tunisia", "Turkey",
			"Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates",
			"United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela",
			"Vietnam", "British Virgin Islands", "Isle of Man", "US Virgin Islands", "Wallis and Futuna",
			"Western Sahara", "Yemen", "Zambia", "Zimbabwe" };

	private static Label totalCost;
	private static HBox buttons;
	private static VBox centerInformation, centerReview;
	private static TableView<CartTable> table;
	private static ObservableList<CartTable> data = FXCollections.observableArrayList();

	private BorderPane root;
	private ScrollPane scroll;
	private String[] labelNames = { "Name", "Email", "Phone Number", "Address", "City", "Zipcode", "Credit Card Number",
			"Expiration Date", "Three Digits", "State", "Country" };
	private Label[] info;
	private TextField[] inputs;
	private Label subscript;
	private ComboBox<String> states, countries;

	public Checkout() {
		root = new BorderPane();
		scroll = new ScrollPane();
		scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
		scroll.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scroll.setStyle("-fx-background-color: transparent");

		centerInformation = new VBox();
		centerInformation.setPadding(new Insets(20));
		centerInformation.setSpacing(50);
		centerInformation.setPrefWidth(1600);
		centerInformation.setAlignment(Pos.CENTER);
		centerInformation.setStyle("-fx-background-color: bisque");
		centerInformation.setOnScroll(new EventHandler<ScrollEvent>() {
			@Override
			public void handle(ScrollEvent event) {
				double deltaY = event.getDeltaY() * 5; // *6 to make the scrolling a bit faster
				double width = scroll.getContent().getBoundsInLocal().getWidth();
				double vvalue = scroll.getVvalue();
				scroll.setVvalue(vvalue + -deltaY / width); // deltaY/width to make the scrolling equally fast
															// regardless of the actual width of the component
			}
		});
		makeInfoBox();

		centerReview = new VBox();
		centerReview.setPadding(new Insets(20));
		centerReview.setSpacing(50);
		centerReview.setPrefWidth(1600);
		centerReview.setAlignment(Pos.CENTER);
		centerReview.setStyle("-fx-background-color: bisque");
		centerReview.setOnScroll(new EventHandler<ScrollEvent>() {
			@Override
			public void handle(ScrollEvent event) {
				double deltaY = event.getDeltaY() * 5; // *6 to make the scrolling a bit faster
				double width = scroll.getContent().getBoundsInLocal().getWidth();
				double vvalue = scroll.getVvalue();
				scroll.setVvalue(vvalue + -deltaY / width); // deltaY/width to make the scrolling equally fast
															// regardless of the actual width of the component
			}
		});
		makeReviewBox();

		subscript = new Label();
		subscript.setText("� 2019-2019, LetsGetThisBread.com, Inc. or its affiliates");
		subscript.setStyle("-fx-text-fill: bisque");

		HBox bottom = new HBox();
		bottom.setAlignment(Pos.BOTTOM_CENTER);
		bottom.setSpacing(50);
		bottom.setPadding(new Insets(20));
		bottom.setStyle("-fx-background-color: #362204");
		bottom.getChildren().add(subscript);
		bottom.setPrefHeight(60);

		root.setTop(new DepartmentBar().getRoot());
		root.setBottom(bottom);
		root.setCenter(scroll);
		scroll.setContent(centerReview);
	}

	public void makeInfoBox() {
		info = new Label[labelNames.length];
		for (int i = 0; i < info.length; i++) {
			info[i] = new Label(labelNames[i] + ":");
			info[i].setStyle("-fx-text-fill: bisque;-fx-text-fill: #362204");
			info[i].setWrapText(true);
		}
		info[info.length-1].setVisible(false);

		inputs = new TextField[labelNames.length - 1];
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = new TextField();
			inputs[i].setPromptText(labelNames[i] + "...");
			inputs[i].setPrefWidth(400);
			inputs[i].setStyle("-fx-background-color: #85bb65;-fx-text-fill: #362204");
			inputs[i].setFocusTraversable(true);
		}

		states = new ComboBox<String>();
		states.setPrefSize(100, 0);
		states.setStyle(
				"-fx-background-color: #85bb65;-fx-text-fill: #362204;-fx-control-inner-background: bisque;-fx-base: #85bb65;");
		states.setPromptText("State...");
		for (String state : stateList) {
			states.getItems().add(state);
		}
		states.valueProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue ov, String old, String newValue) {
				if (newValue.equals("Non-US")) {
					countries.setVisible(true);
					info[info.length-1].setVisible(true);
				} else {
					countries.setVisible(false);
					info[info.length-1].setVisible(false);
				}
			}
		});

		countries = new ComboBox<String>();
		countries.setPrefSize(200, 0);
		countries.setStyle(
				"-fx-background-color: #85bb65;-fx-text-fill: #362204;-fx-control-inner-background: bisque;-fx-base: #85bb65;");
		countries.setPromptText("Country...");
		for (String country : countryList) {
			countries.getItems().add(country);
		}
		countries.setVisible(false);

		Button order = new Button();
		order.setText("ORDER");
		order.setOnAction(event -> {
			Alert alert = new Alert(AlertType.NONE, "Purchase has been printed to the console.", ButtonType.OK);
			alert.initOwner(order.getScene().getWindow());
			alert.showAndWait();

			if (alert.getResult() == ButtonType.OK) {
				alert.close();
			}
			String orderString = "";
			for (int i = 0; i < info.length; i++) {
				if (i < inputs.length - 1) {
					orderString += info[i].getText() + " " + inputs[i].getText() + "\n";
				} else if (info[i].getText().equals("State:")) {
					orderString += info[i].getText() + " " + states.getValue() + "\n";
				} else if (countries.isVisible() && info[i].getText().equals("Country:")) {
					orderString += info[i].getText() + " " + countries.getValue() + "\n";
				}
			}
			for (TextField text : inputs) {
				text.setText("");
			}
			states.setValue("");
			countries.setValue("");
			countries.setVisible(false);
			info[info.length-1].setVisible(false);
			
			orderString += "Total Cost: " + totalCost.getText() + "\n";
			System.out.println(orderString);
		});

		Button cancel = new Button();
		cancel.setText("CANCEL");
		cancel.setOnAction(event -> changeBox("Review"));

		HBox[] hboxes = new HBox[labelNames.length / 2 + 2];

		for (int i = 0; i < hboxes.length; i++) {
			hboxes[i] = new HBox();
			hboxes[i].setAlignment(Pos.CENTER);
			hboxes[i].setSpacing(20);
			hboxes[i].setPadding(new Insets(20));
			hboxes[i].setStyle("-fx-background-color: bisque");
			centerInformation.getChildren().add(hboxes[i]);
		}

		for (int i = 0; i < info.length; i++) {
			if (info[i].getText().equals("State:")) {
				hboxes[i / 2].getChildren().addAll(info[i], states);
			} else if (info[i].getText().equals("Country:")) {
				hboxes[i / 2].getChildren().addAll(info[i], countries);
			} else
				hboxes[i / 2].getChildren().addAll(info[i], inputs[i]);
		}

		hboxes[hboxes.length - 1].getChildren().addAll(order, cancel);
	}

	@SuppressWarnings("unchecked")
	public void makeReviewBox() {
		totalCost = new Label("$00.00");
		totalCost.setStyle("-fx-text-fill: bisque;-fx-text-fill: #362204");

		TableColumn<CartTable, String> nameColumn = new TableColumn<>("Item Name");
		nameColumn.setMinWidth(800);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
		nameColumn.setStyle("-fx-text-fill: bisque; -fx-background-color: #362204");

		TableColumn<CartTable, Double> costColumn = new TableColumn<>("Item Cost");
		costColumn.setMinWidth(400);
		costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
		costColumn.setStyle("-fx-text-fill: bisque; -fx-background-color: #362204");

		table = new TableView<CartTable>();
		table.setItems(data);
		table.setMaxWidth(1200);
		table.getColumns().addAll(nameColumn, costColumn);
		table.setStyle("-fx-text-fill: bisque; -fx-background-color: #85bb65");
		
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

		Button shopping = new Button("Continue Shopping");
		shopping.setStyle("-fx-background-color: white;");
		shopping.setOnMouseEntered(e -> {
			shopping.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			clickCursor();
		});
		shopping.setOnMouseExited(e -> {
			shopping.setStyle("-fx-background-color: white;");
			defaultCursor();
		});
		shopping.setOnMousePressed(e -> shopping.setStyle("-fx-background-color: #f2f2f2;-fx-border-color: #85bb65;"));
		shopping.setOnMouseReleased(e -> shopping.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;"));
		shopping.setOnAction(event -> toHome());

		Button purchase = new Button("Finalize Purchase");
		purchase.setStyle("-fx-background-color: white;");
		purchase.setOnMouseEntered(e -> {
			purchase.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			clickCursor();
		});
		purchase.setOnMouseExited(e -> {
			purchase.setStyle("-fx-background-color: white;");
			defaultCursor();
		});
		purchase.setOnMousePressed(e -> purchase.setStyle("-fx-background-color: #f2f2f2;-fx-border-color: #85bb65;"));
		purchase.setOnMouseReleased(e -> purchase.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;"));
		purchase.setOnAction(event -> changeBox("Info"));

		Button toCart = new Button("Edit Cart");
		toCart.setStyle("-fx-background-color: white;");
		toCart.setOnMouseEntered(e -> {
			toCart.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			clickCursor();
		});
		toCart.setOnMouseExited(e -> {
			toCart.setStyle("-fx-background-color: white;");
			defaultCursor();
		});
		toCart.setOnMousePressed(e -> toCart.setStyle("-fx-background-color: #f2f2f2;-fx-border-color: #85bb65;"));
		toCart.setOnMouseReleased(e -> toCart.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;"));
		toCart.setOnAction(event -> toCart());

		buttons = new HBox();
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);
		buttons.setPadding(new Insets(20));
		buttons.setStyle("-fx-background-color: bisque");
		buttons.getChildren().addAll(shopping, toCart, purchase);

		centerReview.getChildren().addAll(table, totalCost, buttons);
		root.setRight(right);
		root.setLeft(left);
	}

	public static void clearCart() {
		data.clear();
		cart.clear();
		totalCost.setText("$00.00");
	}

	public static void updateCart(Product prod) {
		data.clear();
		for (int i = 0; i < cart.size(); i++) {
			data.add(new CartTable(prod, cart.get(i).getName(), cart.get(i).getCost()));
		}
		double total = 0;
		for (CartTable item : table.getItems())
			total += item.getCost();
		totalCost.setText("$" + df.format(total));
	}

	public void changeBox(String boxName) {
		for (TextField text : inputs) {
			text.setText("");
		}
		if (boxName.equalsIgnoreCase("Review")) {
			scroll.setContent(centerReview);
			scroll.setVvalue(0);
		}
		if (boxName.equalsIgnoreCase("Info")) {
			scroll.setContent(centerInformation);
			scroll.setVvalue(0);
		}
	}

	public Pane getRoot() {
		return root;
	}
}