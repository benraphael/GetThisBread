import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DepartmentTest extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage dep) throws Exception {
		dep.setTitle("https://LetsGetThisBread.com/Department");
		DeparmentPO depart = new DeparmentPO();
		Scene scene = new Scene(depart.getRoot(), 1600, 800);
		dep.setMaximized(true);;
		dep.setScene(scene);
		dep.show();
	}

}
