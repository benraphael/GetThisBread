import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class cartPane {
	private BorderPane root;
	private HBox top,center ,bottom;
	private Label cart;
	
	//implement scroll bar, arrays
	public cartPane() {
		System.out.println("nig");
		root = new BorderPane();
		root.setPrefSize(700, 600);
		run();
	}
	private void run() {
		System.out.println("nig");
		Image image1 = new Image("/store/BetterAttemptAtLogo.png");
		ImageView imgView = new ImageView(image1);
		
		top = new HBox();
		top.setStyle("-fx-background-color: Bisque");
		top.setAlignment(Pos.CENTER);
//		imgView.setFitHeight(200);
//		imgView.setFitWidth(170);
		top.getChildren().addAll(imgView);
		
		
		root.setTop(top);
		root.setCenter(center);
		root.setBottom(bottom);
		
		
//		top.setPadding();
//		top.setSpacing();
		
	}
	
	public Pane getRoot() {
		// TODO Auto-generated method stub
		return root;
	}

}

