

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Editor  extends Application{
	
	static Stage main;
	static Scene editor; //main scene for the editor
	static Scene addProd, subProd, addDept, subDept; //scene for adding/removing departments/products
	BorderPane root;
	static Button save, exit;
	static Button addPro, subPro, addDep, subDep;
	static Button addNewP, addNewD, subNewD, subNewP;
	static JSONObject edits; // = new JSONObject(new File("storeJSON")); //Original JSON
	static JSONArray deps;
	static TextField addName, addCost, addDes, addImg;
	static TextField addNDep;
	static ToggleGroup operator;
	static ArrayList<String> remDep; 
	static ArrayList<Product> remPros;
	
	public static void main(String[] args) {launch(args);}
	
	private void createEditor() {
		//Bottom of editor, save and exit buttons
		HBox bottom = new HBox();
		bottom.setAlignment(Pos.CENTER);
		bottom.setSpacing(10);
		save = new Button("Save"); //save button
		exit = new Button("Exit"); //exit button
		bottom.getChildren().addAll(save, exit);
		
		//middle of editor, add and remove products
		HBox center = new HBox();
		center.setAlignment(Pos.CENTER);
		center.setSpacing(10);
		Label product = new Label("Products");
		addPro = new Button("+"); //button 4 adding products
		subPro = new Button("-"); //button 4 removing products
		center.getChildren().addAll(product, addPro, subPro);
		
		//top of editor, add and remove departments
		HBox top = new HBox();
		top.setAlignment(Pos.CENTER);
		top.setSpacing(10);
		Label department = new Label("Departments");
		addDep = new Button("+"); // button 4 adding departments
		subDep = new Button("-"); // button 4 removing departments
		top.getChildren().addAll(department, addDep, subDep);
		
		root.setTop(top);
		root.setCenter(center);
		root.setBottom(bottom);
		
		//Commands for buttons
		save.setOnAction(event -> buttonPressed(event)); //Rewrites the old JSON File w/ the new stuff
		exit.setOnAction(event -> buttonPressed(event)); //exits the editor
		addPro.setOnAction(event -> buttonPressed(event)); //Adds products, must choose a department first
		subPro.setOnAction(event -> buttonPressed(event)); //Removes products, must select a department and what product to remove from said department
		addDep.setOnAction(event -> buttonPressed(event)); //Adds departments
		subDep.setOnAction(event -> buttonPressed(event)); //Removes departments, along w/ the products
	}
	
	private static void buttonPressed(ActionEvent event) {
		if(event.getSource()==save) { //save
			//Add code later when JSON file is finished, adding the changes to the JSONObject edits
		}
		if(event.getSource()==exit) { //exit
			Platform.exit();
		}
		if(event.getSource()==addPro) {
			main.setScene(addProd);
		}
		if(event.getSource()==subPro && !(deps.length()==0)) {
			main.setScene(subProd);
		}
		if(event.getSource()==addDep) {
			main.setScene(addDept);
		}
		if(event.getSource()==subDep && !(deps.length()==0)) {
			main.setScene(subDept);
		}
	}
	
	private void addPros() {  //Creates a scene for adding products
		VBox newPro = new VBox();
		newPro.setAlignment(Pos.CENTER);
		newPro.setSpacing(10);
		
		//Department selection
		HBox depList = new HBox();
		depList.setAlignment(Pos.CENTER);
		operator = new ToggleGroup();
		for(int i=0; i<deps.length(); i++) {
			RadioButton button;
			try {
				button = new RadioButton(deps.getJSONObject(i).getString("name"));
				button.setToggleGroup(operator);
				if(i==0) button.setSelected(true);
				depList.getChildren().add(button);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Product name
		HBox proName = new HBox();
		proName.setAlignment(Pos.CENTER);
		proName.setSpacing(5);
		Label name = new Label("Name: ");
		addName = new TextField("");
		proName.getChildren().addAll(name, addName);
		
		//Product Cost
		HBox proCost = new HBox();
		proCost.setAlignment(Pos.CENTER);
		proCost.setSpacing(5);
		Label cost = new Label("Cost: ");
		addCost = new TextField("");
		proCost.getChildren().addAll(cost, addCost);
		
		//Product Description
		HBox proDes = new HBox();
		proDes.setAlignment(Pos.CENTER);
		proDes.setSpacing(5);
		Label des1 = new Label("Description: ");
		addDes = new TextField("");
		proDes.getChildren().addAll(des1, addDes);
		
		//Image URL
		HBox proImg = new HBox();
		proImg.setAlignment(Pos.CENTER);
		proImg.setSpacing(5);
		Label img = new Label("Image URL: ");
		addImg = new TextField("");
		proImg.getChildren().addAll(img, addImg);
		
		//This button adds to the JSON when pressed
		addNewP = new Button("Add");
		
		newPro.getChildren().addAll(depList, proName, proCost, proDes, proImg, addNewP);
		addProd = new Scene(newPro);
		
		addNewP.setOnAction(event -> addPros2());
		
	}
	
	/**
	 * 
	 */
	private static void addPros2() {
		String added = "{"; //String that will be added to JSON
		added += "\"name\":\""+addName.getText()+"\",";
		added += "\"cost\":\""+addCost.getText()+"\",";
		added += "\"description\":\""+addDes.getText()+"\",";
		added += "\"imageURL\":\""+addImg.getText()+"\"},";
		RadioButton button2 = (RadioButton) operator.getSelectedToggle();
		//System.out.println(button.getText()); //test
		String old = edits.toString();
		String newStuff = old.substring(0, old.indexOf(button2.getText())+button2.getText().length()+14);
		String oldStuff = old.substring(old.indexOf(button2.getText())+button2.getText().length()+14);
		old = newStuff+added+oldStuff;
		//System.out.println(newStuff);
		//System.out.println(old); //test
		try {
			edits = new JSONObject(old);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			deps = edits.getJSONArray("departments");
			
		} catch (JSONException e) {
			System.out.println("E");
			e.printStackTrace();
		}
		subPros();
		addName.setText("");
		addCost.setText("");
		addDes.setText("");
		addImg.setText("");
		main.setScene(editor);
		//System.out.println(edits); //test
	}
	
	private static void subPros() {
		remPros = new ArrayList<Product>();
		VBox idk = new VBox(0);
		idk.setAlignment(Pos.CENTER);
		idk.setSpacing(10);
		Label select = new Label("Select products from a departments to remove: ");
		HBox depList = new HBox();
		depList.setAlignment(Pos.CENTER);
		depList.setSpacing(10);
		for(int i=0; i<deps.length(); i++) {
			Label button;
			try {
				VBox vbox = new VBox();
				vbox.setAlignment(Pos.CENTER);
				vbox.setSpacing(5);
				button = new Label(deps.getJSONObject(i).getString("name"));
				vbox.getChildren().add(button);
				for(int j=0; j<deps.getJSONObject(i).getJSONArray("products").length(); j++) {
					int k = i;
					int x = j;
					CheckBox button2 = new CheckBox(deps.getJSONObject(i).getJSONArray("products").getJSONObject(j).getString("name"));
					vbox.getChildren().add(button2);
					button2.setOnAction(event -> subPros2(event, k, x));
				}
				depList.getChildren().add(vbox);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		subNewP = new Button("Remove");
		
		idk.getChildren().addAll(select,depList, subNewP);
		subProd = new Scene(idk);
		
		subNewP.setOnAction(event -> subPros2(event, 0, 0));
	}
	
	private static void subPros2(ActionEvent event, int i, int j) {
		if(event.getSource() == subNewP) {
			String old="";
			for(int k=0; k<remPros.size(); k++) { //Work on remove string
				String removed = "{";
				removed += "\"cost\":\""+remPros.get(k).getCost()+"\",";
				removed += "\"imageURL\":\""+remPros.get(k).getImageURL()+"\",";
				removed += "\"name\":\""+remPros.get(k).getTitle()+"\",";
				removed += "\"description\":\""+remPros.get(k).getDescription()+"\"},";
				System.out.println(removed);
				if(k==0) old = edits.toString();
				System.out.println(old);
				String newStuff = old.substring(0, old.indexOf(removed));
				System.out.println(newStuff);
				String stuff = old.substring(old.indexOf(removed)+removed.length());
				System.out.println(stuff);
				try {
					if(!stuff.contains("},") && edits.getJSONArray("departments").getJSONObject(i).getJSONArray("products").length()==0) {
						newStuff = old.substring(0, old.indexOf(removed)-1);
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(newStuff);
				String oldStuff; 
				if(stuff.contains("},")) oldStuff = stuff.substring(stuff.indexOf("},")+"23".length());
				else  oldStuff = stuff.substring(stuff.indexOf("}")+"1".length());
				System.out.println(oldStuff);
				old = newStuff+oldStuff;
				System.out.println(old); //test
			}
		}
		else {
			CheckBox rem = (CheckBox)event.getSource();
			if(!remPros.contains(rem.getText()))
				try {
					remPros.add(
							new Product(deps.getJSONObject(i).getJSONArray("products").getJSONObject(j).getString("imageURL"),
									deps.getJSONObject(i).getJSONArray("products").getJSONObject(j).getString("name"),
									deps.getJSONObject(i).getJSONArray("products").getJSONObject(j).getDouble("cost"),
									deps.getJSONObject(i).getJSONArray("products").getJSONObject(j).getString("description")));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	private void addDeps() {
		//Adding departments
		VBox newDep = new VBox();
		newDep.setAlignment(Pos.CENTER);
		newDep.setSpacing(10);
		
		Label dept = new Label("Department Name: ");
		addNDep = new TextField();
		addNewD = new Button("Add");
		newDep.getChildren().addAll(dept, addNDep, addNewD);
		addDept = new Scene(newDep);
	
		addNewD.setOnAction(event -> addDeps2());
	}
	
	private void addDeps2() {
		String added = "{\"name\":\""+addNDep.getText()+"\",\"products\":[]},";
		String old = edits.toString();
		String newStuff = old.substring(0, old.indexOf("[")+1);
		String oldStuff = old.substring(old.indexOf("[")+1);
		old = newStuff+added+oldStuff;
		//System.out.println(old); //test
		try {
			edits = new JSONObject(old);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			deps = edits.getJSONArray("departments");
			
		} catch (JSONException e) {
			System.out.println("E");
			e.printStackTrace();
		}
		addPros();
		subPros();
		subDeps();
		addNDep.setText("");
		main.setScene(editor); 
	}
	
	private void subDeps() {
		remDep = new ArrayList<String>();
		VBox idk = new VBox(0);
		idk.setAlignment(Pos.CENTER);
		idk.setSpacing(5);
		
		Label select = new Label("Select departments to remove: ");
		HBox depList = new HBox();
		depList.setAlignment(Pos.CENTER);
		for(int i=0; i<deps.length(); i++) {
			CheckBox button;
			try {
				button = new CheckBox(deps.getJSONObject(i).getString("name"));
				depList.getChildren().add(button);
				button.setOnAction(event -> subDeps2(event));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		subNewD = new Button("Remove");
		
		idk.getChildren().addAll(select,depList, subNewD);
		subDept = new Scene(idk);
		
		subNewD.setOnAction(event -> subDeps2(event));
	}
	
	private void subDeps2(ActionEvent event) {
		
		if(event.getSource()==subNewD) {
			String old="";
			for(int i=0; i<remDep.size(); i++) { 
				//System.out.println(remDep);
				String removed = "{\"name\":\""+remDep.get(i)+"\",";
				//System.out.println(removed);
				if(i==0) old = edits.toString();
				String newStuff = old.substring(0, old.indexOf(removed));
				//System.out.println(newStuff);
				String stuff = old.substring(old.indexOf(removed)+removed.length());
				//System.out.println(stuff);
				try {
					if(!stuff.contains("]},") && edits.getJSONArray("departments").length()==0) newStuff = old.substring(0, old.indexOf(removed)-1);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println(newStuff);
				String oldStuff; 
				if(stuff.contains("]},")) oldStuff = stuff.substring(stuff.indexOf("]},")+"123".length());
				else  oldStuff = stuff.substring(stuff.indexOf("]}")+"12".length());
				//System.out.println(oldStuff);
				old = newStuff+oldStuff;
				//System.out.println(old); //test
			}
			try {
				edits = new JSONObject(old);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				deps = edits.getJSONArray("departments");
				
			} catch (JSONException e) {
				System.out.println("E");
				e.printStackTrace();
			}
			addPros();
			subPros();
			subDeps();
			main.setScene(editor); 
			main.setScene(editor);
		}
		else {
			CheckBox rem = (CheckBox)event.getSource();
			if(!remDep.contains(rem.getText())) remDep.add(rem.getText());
		}
		
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		root = new BorderPane();
		String jsonIn = "";
		Scanner scan = new Scanner(new File("storeJSON")); //Change string to whatever you are you using as the JSON
		while(scan.hasNextLine()) {
			jsonIn+=scan.nextLine();
		}
		scan.close();
		edits = new JSONObject(jsonIn);
		try {
			deps = edits.getJSONArray("departments");
			
		} catch (JSONException e) {
			System.out.println("E");
			e.printStackTrace();
		}
		//System.out.println(edits); //Test
		createEditor(); //Creates all the buttons and such w/in the editor
		addPros(); //Creates a scene for adding products
		subPros(); //Creates a scene for removing products
		addDeps(); //Creates a scene for adding departments
		subDeps();  //Creates a scene for removing departments
		main = stage;
		editor = new Scene(root);
		main.setScene(editor);
		main.show();
	}
}
