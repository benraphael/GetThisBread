
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class cartPane {
	private BorderPane root;
	private HBox top, bottom;
	private VBox product, quantity, price;
	//implement scroll bar, arrays
	public cartPane() {
		root = new BorderPane();
		root.setPrefSize(700, 600);
		run();
	}
	private void run() {
		top = new HBox();
		top.setStyle("-fx-background-color: Green");
	}
	
	public Pane getRoot() {
		// TODO Auto-generated method stub
		return root;
	}

}
