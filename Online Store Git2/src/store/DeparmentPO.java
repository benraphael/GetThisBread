

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class DeparmentPO {

	BorderPane root;
	VBox Top, center;
	Label department;
	HBox name, change;
	ScrollPane scroll;
	
	private static final int SAMPLEPRODUCTSIZE = 60;
	private static final int PRODUCTNUMBER = 6;
	private static final int BUTTONSIZE = 230;
	private Button[] sampleProducts;

	public DeparmentPO() {
		root = new BorderPane();
		startUp();
	}

	public void startUp() {
		scroll = new ScrollPane();
		scroll.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scroll.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		
		sampleProducts = new Button[SAMPLEPRODUCTSIZE];

		department = new Label();
		department.setText("DEPARTMENT");
		department.setStyle("-fx-font: 12 sansserif;");

		change = new HBox();
		change.setStyle("-fx-background-color: BLUE;");
		change.setAlignment(Pos.CENTER);
		change.setPrefSize(1600, 80);

		name = new HBox();
		name.setStyle("-fx-background-color: GREEN;");
		name.setAlignment(Pos.CENTER);
		name.setPrefSize(1600, 20);
		name.getChildren().addAll(department);
		
		center = new VBox();
		center.setStyle("-fx-background-color: BISQUE;");
		center.setAlignment(Pos.CENTER);
		center.setSpacing(50);
		center.setOnScroll(new EventHandler<ScrollEvent>() {
	        @Override
	        public void handle(ScrollEvent event) {
	            double deltaY = event.getDeltaY()*2; // *6 to make the scrolling a bit faster
	            double width = scroll.getContent().getBoundsInLocal().getWidth();
	            double vvalue = scroll.getVvalue();
	            scroll.setVvalue(vvalue + -deltaY/width); // deltaY/width to make the scrolling equally fast regardless of the actual width of the component
	        }
	    });

		Top = new VBox();
		Top.getChildren().addAll(change, name);
		Top.setPrefSize(1600, 100);
		
		HBox[] hboxes = new HBox[(sampleProducts.length % PRODUCTNUMBER != 0)
		         				? sampleProducts.length / PRODUCTNUMBER + 1
		         				: sampleProducts.length / PRODUCTNUMBER];
		
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
			sampleProducts[i].setText("" + i);
			hboxes[i/PRODUCTNUMBER].getChildren().add(sampleProducts[i]);
		}

		for (Button button : sampleProducts) {
			button.setPrefSize(BUTTONSIZE, BUTTONSIZE);
			button.setStyle("-fx-background-color: white;");
			button.setOnMouseEntered(e -> {
				button.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;");
				DepartmentTest.clickCursor();
			});
			button.setOnMouseExited(e -> {
				button.setStyle("-fx-background-color: white;");
				DepartmentTest.defaultCursor();
			});
			button.setOnMousePressed(e -> button.setStyle("-fx-background-color: #f2f2f2;-fx-border-color: #85bb65;"));
			button.setOnMouseReleased(e -> button.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;"));
		}

		scroll.setContent(center);
		root.setTop(Top);
		root.setCenter(scroll);
	}

	public Pane getRoot() {
		return root;
	}
}
