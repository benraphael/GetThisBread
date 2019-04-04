
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Checkout extends MainRunner {

	private BorderPane root;
	private Label name, address, subscript;
	private Button order;
	private Button cancel;
	private RadioButton one, two, three;
	private TextField imputName, imputAddress;

	public Checkout() {
		
		subscript = new Label();
		subscript.setText("© 2019-2019, LetsGetThisBread.com, Inc. or its affiliates");
		subscript.setStyle("-fx-text-fill: bisque");
		
		HBox bottom = new HBox();
		bottom.setAlignment(Pos.BOTTOM_CENTER);
		bottom.setSpacing(20);
		bottom.setPadding(new Insets(20));
		bottom.setStyle("-fx-background-color: #362204");
		bottom.getChildren().add(subscript);
		
		VBox center = new VBox();
		center.setPadding(new Insets(20));
		center.setStyle("-fx-background-color: bisque");
		
		root = new BorderPane();

		name = new Label("Name");
		address = new Label("Adress");

		imputName = new TextField();
		imputName.setPrefWidth(500);

		imputAddress = new TextField();
		imputAddress.setPrefWidth(500);

		order = new Button();
		order.setText("ORDER");
		order.setOnAction(event -> buttonClick(event));

		cancel = new Button();
		cancel.setText("CANCEL");
		cancel.setOnAction(event -> buttonClick(event));

		HBox one = new HBox();
		one.setAlignment(Pos.CENTER);
		one.setSpacing(20);
		one.setPadding(new Insets(20));
		
		HBox two = new HBox();
		two.setAlignment(Pos.CENTER);
		two.setSpacing(20);		
		two.setPadding(new Insets(20));
		
		one.getChildren().addAll(name, imputName);
		two.getChildren().addAll(address, imputAddress);
		center.getChildren().addAll(one, two);

		root.setTop(new DepartmentBar().getRoot());
		root.setBottom(bottom);
		root.setCenter(center);
	}

	private void buttonClick(ActionEvent event) {
		System.out.println(((Button) event.getSource()).getText());
	}

	public Pane getRoot() {
		return root;
	}

}