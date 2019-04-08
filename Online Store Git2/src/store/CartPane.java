import java.text.DecimalFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class CartPane extends MainRunner {

	private static final int SCROLLSPEED = 6;
	private static final DecimalFormat df = new DecimalFormat("#.00");

	private BorderPane root;
	private VBox center, bottom;
	private Label subscript;
	private ScrollPane scroll;

	private static Label totalCost;
	private static TableView<CartTable> table;
	private static ObservableList<CartTable> data = FXCollections.observableArrayList();

	public CartPane() {
		root = new BorderPane();
		run();
	}

	@SuppressWarnings("unchecked")
	private void run() {
		subscript = new Label();
		subscript.setText("© 2019-2019, LetsGetThisBread.com, Inc. or its affiliates");
		subscript.setStyle("-fx-text-fill: bisque");

		scroll = new ScrollPane();
		scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
		scroll.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scroll.setStyle("-fx-background-color: transparent");

		center = new VBox();
		center.setStyle("-fx-background-color: Bisque;");
		center.setAlignment(Pos.CENTER);
		center.setPadding(new Insets(20));
		center.setSpacing(20);
		center.setPrefWidth(1600);
		center.setOnScroll(new EventHandler<ScrollEvent>() {
			@Override
			public void handle(ScrollEvent event) {
				double deltaY = event.getDeltaY() * SCROLLSPEED; // *6 to make the scrolling a bit faster
				double width = scroll.getContent().getBoundsInLocal().getWidth();
				double vvalue = scroll.getVvalue();
				// deltaY/width to make the scrolling equally fast regardless of the actual
				// width of the component
				scroll.setVvalue(vvalue + -deltaY / width);
			}
		});

		// insert tables (columns for Item name, price and quantity)
		// Cart Table Pane
		// Observable list is supposed to be implemented in runner class

		// product column
		TableColumn<CartTable, String> nameColumn = new TableColumn<>("Item Name");
		nameColumn.setMinWidth(800);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));

		// quantity column
		// TableColumn<CartTable, Integer> quantityColumn = new
		// TableColumn<>("Quantity");
		// quantityColumn.setMinWidth(200);
		// quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

		// cost column
		TableColumn<CartTable, Double> costColumn = new TableColumn<>("Item Cost");
		costColumn.setMinWidth(800);
		costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));

		table = new TableView<>();
		table.setItems(data);
		table.getColumns().addAll(nameColumn, costColumn);
		// print total cost in the bottom right of the table

		totalCost = new Label("$00.00");
		totalCost.setStyle("-fx-text-fill: bisque;-fx-text-fill: #362204");
		center.getChildren().addAll(table, totalCost);

		bottom = new VBox();
		bottom.getChildren().addAll(subscript);
		bottom.setAlignment(Pos.CENTER);
		bottom.setStyle("-fx-background-color: #362204;");
		bottom.setPrefHeight(60);
		bottom.setSpacing(30);

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

		root.setTop(new DepartmentBar().getRoot());
		root.setCenter(scroll);
		root.setBottom(bottom);
		root.setRight(right);
		root.setLeft(left);
		scroll.setContent(center);
	}

	public static void updateCart(int quantity) {
		for (int i = 0; i < cart.size(); i++) {
			data.add(new CartTable(cart.get(i).getName(), quantity, cart.get(i).getCost()));
		}
		double total = 0;
		for (CartTable item : table.getItems())
			total += item.getCost();
		totalCost.setText("$" + df.format(total));
	}

	public Parent getRoot() {
		return root;
	}
}
