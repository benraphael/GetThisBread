import java.awt.Component;
import java.awt.ScrollPane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class DeparmentPO {

	BorderPane root;
	VBox Top, center;
	GridPane centerMain;
	Label department;
	HBox name, change;

	public DeparmentPO() {
		root = new BorderPane();
		startUp();
	}

	public void startUp() {

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

		Top = new VBox();
		Top.getChildren().addAll(change, name);
		Top.setPrefSize(1600, 100);

		centerMain = new GridPane();
		centerMain.setAlignment(Pos.CENTER);
		centerMain.setHgap(5);
		centerMain.setVgap(100);
		centerMain.setPadding(new Insets(10, 10, 10, 10));

		for (int i = 0; i < 2; i++) {
			for (int g = 0; g < 5; g++) {
				Button button = new Button();
				button.setPrefSize(200, 200);
				button.setStyle("-fx-background-color: white;" + "-fx-border-color: #85bb65;");
				button.setOnMousePressed(e -> button.setStyle("-fx-background-color: #f2f2f2;-fx-border-color: #85bb65;"));
				button.setOnMouseReleased(e -> button.setStyle("-fx-background-color: white;-fx-border-color: #85bb65;"));
				centerMain.setRowIndex(button, i);
				centerMain.setColumnIndex(button, g);
				centerMain.getChildren().addAll(button);
			}
		}

		center = new VBox();
		center.setStyle("-fx-background-color: BISQUE;");
		center.setAlignment(Pos.CENTER);
		center.setSpacing(50);
		center.getChildren().addAll(centerMain);

		root.setTop(Top);
		root.setCenter(center);
		
		

	}
	
	

	public Pane getRoot() {
		return root;
	}

}
