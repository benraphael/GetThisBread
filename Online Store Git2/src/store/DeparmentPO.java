import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class DeparmentPO {

	BorderPane root;
	VBox top, center;
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
		
		top = new VBox();
		top.getChildren().addAll(change, name);
		top.setPrefSize(1600, 100);
		
		centerMain = new GridPane();
		centerMain.setAlignment(Pos.CENTER);

		
		for(int i = 0;i<10;i++) {
			for(int g = 0;g<10;g++) {
				Button button = new Button();
				button.setPrefSize(20, 20);
				centerMain.setRowIndex(button, i);
				centerMain.setColumnIndex(button, g);
				centerMain.getChildren().addAll(button);
			}
		}
		
		center = new VBox();
		center.setStyle("-fx-background-color: BISQUE;");
		center.setAlignment(Pos.CENTER);
		center.setSpacing(5);
		center.getChildren().addAll(centerMain);
		
		root.setTop(top);
		root.setCenter(center);
		
	}
	
	public Pane getRoot() {
		return root;
	}
	
}
