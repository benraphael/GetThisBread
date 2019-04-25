

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

public class DepartmentPO extends MainRunner{

	BorderPane root;
	VBox Top, center, right, left;
	Label departmentName;
	HBox name;
	ScrollPane scroll;
	
	private Department department;
	private static int SAMPLEPRODUCTSIZE;
	private static final int PRODUCTNUMBER = 6;
	private static final int BUTTONSIZE = 220;
	private Button[] sampleProducts;

	public DepartmentPO(Department dep) {
		department = dep;
		SAMPLEPRODUCTSIZE = department.getProducts().size();
		root = new BorderPane();
		startUp();
	}

	public void startUp() {
		scroll = new ScrollPane();
		scroll.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
		scroll.setStyle("-fx-background-color: transparent");
		
		sampleProducts = new Button[SAMPLEPRODUCTSIZE];

		departmentName = new Label();
		departmentName.setText("- " + department.getName() + " -");
		departmentName.setStyle("-fx-text-fill: #362204");

		name = new HBox();
		name.setStyle("-fx-background-color: #85bb65;");
		name.setAlignment(Pos.CENTER);
		name.setPrefSize(1600, 20);
		name.getChildren().addAll(departmentName);
		
		center = new VBox();
		center.setStyle("-fx-background-color: BISQUE;");
		center.setAlignment(Pos.CENTER);
		center.setPadding(new Insets(20));
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
		Top.getChildren().addAll(new DepartmentBar().getRoot(), name);
		//Top.setPrefSize(1600, 100);
		
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
		
		HBox bottom = new HBox();
		bottom.setAlignment(Pos.BOTTOM_CENTER);
		bottom.setSpacing(20);
		bottom.setPadding(new Insets(20));
		bottom.setStyle("-fx-background-color: #362204");
		
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
			hboxes[i/PRODUCTNUMBER].getChildren().add(sampleProducts[i]);
			
			sampleProducts[i].setGraphic(department.getProducts().get(i).getRoot());
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
		
		root.setRight(right);
		root.setLeft(left);
		root.setTop(new DepartmentBar().getRoot());
		root.setTop(Top);
		root.setCenter(scroll);
		scroll.setContent(center);
		root.setBottom(bottom);
	}

	public Pane getRoot() {
		return root;
	}
}
