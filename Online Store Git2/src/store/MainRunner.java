import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainRunner extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("https://LetsGetThisBread.com");
		HomePagePO organizer = new HomePagePO();
		Scene scene = new Scene(organizer.getRoot(), 1600, 800);
		stage.setMaximized(true);
		stage.setScene(scene);
		stage.show();
	}

}
