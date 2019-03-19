
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ProductPageOrganizer {
	private BorderPane root;

	public ProductPageOrganizer() {
		root = new BorderPane();
		run();
	}
	
	public void run() {
		HBox main = new HBox();
		main.setAlignment(Pos.TOP_CENTER);
		main.setStyle("-fx-background-color: PINK;");
		main.setSpacing(20);
		main.setPadding(new Insets(20));
		
		HBox suggest = new HBox();
		suggest.setAlignment(Pos.BOTTOM_CENTER);
		suggest.setPrefSize(600, 200);
		suggest.setStyle("-fx-background-color: ALICEBLUE;");

		VBox info = new VBox();
		info.setAlignment(Pos.CENTER_RIGHT);
		info.setPrefSize(300, 400);
		info.setStyle("-fx-background-color: AQUA;");
		
		VBox picture = new VBox();
		picture.setAlignment(Pos.CENTER_LEFT);
		picture.setPrefSize(300, 400);
		picture.setStyle("-fx-background-color: BLACK;");
		
		VBox navBar = new VBox();
		navBar.setAlignment(Pos.TOP_CENTER);
		navBar.setPrefSize(600, 75);
		navBar.setStyle("-fx-background-color: GREY;");
		
		
		main.getChildren().addAll(info, picture);
		
		root.setCenter(main);
		root.setBottom(suggest);
		root.setTop(navBar);
	}
	
	public Pane getRoot() {
		return root;
	}

}
