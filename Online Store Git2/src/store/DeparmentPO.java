import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class DeparmentPO {

	BorderPane root;
	VBox top, center;
	Label department;
	HBox name, change;
	Button boxes;
	
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
		
		boxes = new Button();
		
		center = new VBox();
		center.setStyle("-fx-background-color: RED;");
		center.setAlignment(Pos.CENTER);
		center.setSpacing(5);
		
		root.setTop(top);
		
	}
	
	public Pane getRoot() {
		return root;
	}
	
}
