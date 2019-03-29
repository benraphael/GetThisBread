
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Checkout{   

		Label lbl, lbl2;
		private Button order;
		private Button cancel; 
		private RadioButton one, two, three;
		private TextField imput1 , imput2;
             
   public Checkout() {
	   
	   lbl = new Label();
	   lbl.setText("Name");
	   lbl2 = new Label();
	   lbl2.setText("Address");
	   
	   imput1 = new TextField();
	   imput1.setPrefWidth(10000);
	   
	   imput2 = new TextField();
	   imput2.setPrefWidth(10000);
	   
	   order = new Button ();
		order.setText("ORDER");
		order.setOnAction(event -> buttonClick(event));
		
		cancel = new Button ();
		cancel.setText("CANCEL");
		cancel.setOnAction(event -> buttonClick(event));
	   
	   VBox pane = new VBox();
	   HBox one = new HBox();
	   HBox two = new HBox();
	   	pane.getChildren().addAll(one, two);
		one.getChildren().addAll(lbl , imput1);
		two.getChildren().addAll(lbl2 , imput2);
	   
	   
   }
   
   
   
   private void buttonClick(ActionEvent event) {
	   if(event.getSource()==order) {
			
		}
   }
   
} 