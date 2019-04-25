import java.util.ArrayList;
import java.util.HashSet;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class HomePagePO extends MainRunner {

	private static final int SAMPLEPRODUCTSIZE = 12;
	private static final int PRODUCTNUMBER = 6;
	private static final int BUTTONSIZE = 220;
	private static final int SCROLLSPEED = 3;

	private BorderPane root;
	private ScrollPane scroll;
	private Label subscript;
	private Button[] sampleProducts;
	private HashSet<Product> products = new HashSet<Product>();

	// Tan(Bisque): #FFE4C4
	// Dark Brown: #362204
	// Money Green: #85bb65

	public HomePagePO() {
		root = new BorderPane();
		Home();
	}

	private void Home() {
		sampleProducts = new Button[SAMPLEPRODUCTSIZE];
		scroll = new ScrollPane();
		subscript = new Label();
		subscript.setText("© 2019-2019, LetsGetThisBread.com, Inc. or its affiliates");
		subscript.setStyle("-fx-text-fill: bisque");

		scroll.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scroll.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scroll.setStyle("-fx-background-color: transparent");

		VBox center = new VBox();
		center.setPadding(new Insets(20));
		center.setStyle("-fx-background-color: bisque");
		center.setOnScroll(new EventHandler<ScrollEvent>() {
			@Override
			public void handle(ScrollEvent event) {
				double deltaY = event.getDeltaY() * SCROLLSPEED; // *6 to make the scrolling a bit faster
				double width = scroll.getContent().getBoundsInLocal().getWidth();
				double vvalue = scroll.getVvalue();
				scroll.setVvalue(vvalue + -deltaY / width); // deltaY/width to make the scrolling equally fast
															// regardless of the actual width of the component
			}
		});

		HBox bottom = new HBox();
		bottom.setAlignment(Pos.BOTTOM_CENTER);
		bottom.setSpacing(20);
		bottom.setPadding(new Insets(20));
		bottom.setStyle("-fx-background-color: #362204");

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

		HBox[] hboxes = new HBox[(sampleProducts.length % PRODUCTNUMBER != 0)
				? sampleProducts.length / PRODUCTNUMBER + 1
				: sampleProducts.length / PRODUCTNUMBER];

		for (int i = 0; i < hboxes.length; i++) {
			hboxes[i] = new HBox();
			hboxes[i].setAlignment(Pos.CENTER_LEFT);
			hboxes[i].setSpacing(20);
			hboxes[i].setPadding(new Insets(20));
			hboxes[i].setStyle("-fx-background-color: bisque");
			center.getChildren().add(hboxes[i]);
		}

		for (int i = 0; i < sampleProducts.length; i++) {
			sampleProducts[i] = new Button();
			hboxes[i / PRODUCTNUMBER].getChildren().add(sampleProducts[i]);
			
			while(products.size()<SAMPLEPRODUCTSIZE) {
				ArrayList<Product> randomDep = deps.get((int)(Math.random()*deps.size())).getProducts(); //These cause problems with images displaying for some reason???
				products.add(randomDep.get((int)(Math.random()*randomDep.size())));
			}
			
			sampleProducts[i].setGraphic(((Product)products.toArray()[i]).getRoot());
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

		root.setTop(new DepartmentBar().getRoot());
		root.setCenter(scroll);
		root.setBottom(bottom);
		root.setLeft(left);
		root.setRight(right);

		bottom.getChildren().add(subscript);
		scroll.setContent(center);
	}

	public Pane getRoot() {
		return root;
	}
}