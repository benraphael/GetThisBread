import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CartName extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		
		cartPane organizer = new cartPane();

		Scene scene = new Scene(organizer.getRoot());
		stage.setTitle("https://LetsGetThisBread.com/Cart");
		stage.setMaximized(true);
		stage.setScene(scene);
		stage.show();

	}
}
