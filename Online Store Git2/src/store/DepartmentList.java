
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListView;

public class DepartmentList {

	private ListView<String> list;

	/**
	 * The ListView used for the department lists. Each department will be added
	 * here after they are made. In each department scene class, this should be
	 * added using the code:
	 * 
	 * @category borderPaneName.setLeft(new DepartmentList().getRoot());
	 */
	public DepartmentList() {
		list = new ListView<String>();
		list.getItems().addAll("Pokemon", "Anime", "Video Games", "Jam", "Shirts"); //TODO Update with actual departments
		list.setPrefWidth(200);
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				//TODO change to where the changeDepartment method is.
				//StartUp.changeDepartment(newValue);
				// list.getFocusModel().focus(list.getSelectionModel().getSelectedIndex());
			}
		});
	}

	public ListView<String> getRoot() {
		return list;
	}

}
