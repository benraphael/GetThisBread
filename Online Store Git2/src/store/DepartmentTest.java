import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DepartmentTest extends Application{
	
	public DeparmentPO depart = new DeparmentPO();
	public static Scene scene = new Scene(depart.getRoot(), 1600, 800);

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage dep) throws Exception {
		dep.setTitle("https://LetsGetThisBread.com/Department");
		dep.setMaximized(true);;
		dep.setScene(scene);
		dep.show();
		
		
		
	}
	
	public static void defaultCursor() {
		 scene.setCursor(Cursor.DEFAULT);
		
	}
	public static void clickCursor() {
		 scene.setCursor(Cursor.HAND);
		
	}

}
