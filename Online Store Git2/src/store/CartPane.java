import java.text.DecimalFormat;

import com.sun.prism.impl.Disposer.Record;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

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
		subscript.setText("� 2019-2019, LetsGetThisBread.com, Inc. or its affiliates");
		subscript.setStyle("-fx-text-fill: bisque");

		scroll = new ScrollPane();
		scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
		scroll.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scroll.setStyle("-fx-background-color: transparent;");

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
		
		nameColumn.setMinWidth(500);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
		nameColumn.setStyle("-fx-text-fill: bisque; -fx-background-color: #362204");


		// cost column
		TableColumn<CartTable, Double> costColumn = new TableColumn<>("Item Cost");
		costColumn.setMinWidth(500);
		costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
		costColumn.setStyle("-fx-text-fill: bisque; -fx-background-color: #362204");

		// Remove item from cart.
		@SuppressWarnings("rawtypes")
		TableColumn removeColumn = new TableColumn<>("Action");
		removeColumn.setStyle("-fx-text-fill: bisque; -fx-background-color: #362204; -fx-alignment: CENTER");
		removeColumn.setMinWidth(200);
		removeColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Record, Boolean>, ObservableValue<Boolean>>() {
					@Override
					public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Record, Boolean> p) {
						return new SimpleBooleanProperty(p.getValue() != null);
					}
				});

		// Adding the Button to the cell
		removeColumn.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {
			@Override
			public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
				return new ButtonCell();
			}
		});

		table = new TableView<>();
		table.setItems(data);
		table.setMaxWidth(1200);
		table.setStyle("-fx-text-fill: bisque; -fx-background-color: #85bb65");
		table.getColumns().addAll(nameColumn, costColumn, removeColumn);
		
		// print total cost in the bottom right of the table

		totalCost = new Label("$00.00");
		totalCost.setStyle("-fx-text-fill: bisque;-fx-text-fill: #362204");
		center.getChildren().addAll(table, totalCost);
		
		Button clear = new Button("Clear Cart");
		clear.setStyle("-fx-background-color: white;");
		clear.setOnMouseEntered(e -> {
			clear.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
			clickCursor();
		});
		clear.setOnMouseExited(e -> {
			clear.setStyle("-fx-background-color: white;");
			defaultCursor();
		});
		clear.setOnMousePressed(e -> clear.setStyle("-fx-background-color: #f2f2f2;-fx-border-color: #85bb65;"));
		clear.setOnMouseReleased(e -> clear.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;"));
		clear.setOnAction(event -> {
			clearCart();
			Checkout.clearCart();
		});
		
		Button purchase = new Button("Head to Checkout");
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
		purchase.setOnAction(event -> toCheckout());
		
		HBox buttons = new HBox();
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);
		buttons.setPadding(new Insets(20));
		buttons.setStyle("-fx-background-color: bisque");
		buttons.getChildren().addAll(clear, purchase);
		center.getChildren().add(buttons);

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
	
	private void clearCart() {
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

	public Parent getRoot() {
		return root;
	}

	private class ButtonCell extends TableCell<Record, Boolean> {
		final Button cellButton = new Button("X");

		ButtonCell() {
			cellButton.setOnAction(e -> {
				CartTable currentPerson = (CartTable) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
				data.remove(currentPerson);
				cart.remove(currentPerson.getProduct());
				//System.out.println(cart.toString()); //dont uncomment pls
				Checkout.updateCart(currentPerson.getProduct());
				double total = 0;
				for (CartTable item : table.getItems())
					total += item.getCost();
				totalCost.setText("$" + df.format(total));
			});
		}

		@Override
		protected void updateItem(Boolean t, boolean empty) {
			super.updateItem(t, empty);
			if (!empty)
				setGraphic(cellButton);
			else
				setGraphic(null);
		}
	}
}
