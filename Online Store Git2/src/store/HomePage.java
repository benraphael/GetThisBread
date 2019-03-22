



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomePage extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) throws Exception {
		stage.setTitle("https://LetsGetThisBread.com");
		HomePagePO organizer = new HomePagePO();
		Scene scene = new Scene(organizer.getRoot(), 1600, 800);
		stage.setMaximized(true);
		stage.setScene(scene);
		stage.show();
	}

}
