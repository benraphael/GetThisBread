
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HomePage extends Application {
	
	public static HomePagePO organizer = new HomePagePO();
	public static Scene scene = new Scene(organizer.getRoot(), 1600, 800);

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {
		stage.setTitle("https://LetsGetThisBread.com");
		//HomePagePO organizer = new HomePagePO();
		//Scene scene = new Scene(organizer.getRoot(), 1600, 800);
		stage.setMaximized(true);
		stage.setScene(scene);
		stage.show();
		
		
		
//		Stage stage2 = new Stage();
//		Pane pane = new Pane();
//		Scene scene2 = new Scene(pane,400,400);
//		stage2.initModality(Modality.APPLICATION_MODAL);
//		stage2.setScene(scene2);
//		stage2.showAndWait();
	}
	
	public static void defaultCursor() {
		 scene.setCursor(Cursor.DEFAULT);
		
	}
	public static void clickCursor() {
		 scene.setCursor(Cursor.HAND);
		
	}
	
}
