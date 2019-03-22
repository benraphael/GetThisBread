


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONMethods {
	
	static ArrayList<Department> deps = new ArrayList<Department>();
	static JSONObject mainObject;
	
	private void loadDepartments() {
		try {
			Scanner scan = new Scanner(new File("JSONTest"));
			String jsonIn = "";
			while (scan.hasNextLine()) {
				jsonIn += scan.nextLine();
			}
			scan.close();
			
			mainObject = new JSONObject(jsonIn);
			JSONArray departments = mainObject.getJSONArray("departments");
			
			for (int i=0;i<departments.length();i++) {
				Department dep = new Department(departments.getJSONObject(i).getString("name"));
				ArrayList<Product> depProd = new ArrayList<Product>();
				JSONArray products  = departments.getJSONObject(i).getJSONArray("products");
				for (int j=0;j<products.length();j++) {
					String name = products.getJSONObject(j).getString("name");
					Double cost = products.getJSONObject(j).getDouble("cost");
					String desc = products.getJSONObject(j).getString("description");
					String url = products.getJSONObject(j).getString("imageURL");
					Product tempProd = new Product(url, name, cost, desc);
					depProd.add(tempProd);
				}
				dep.setProducts(depProd);
				deps.add(dep);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	private void addProduct() {
		Scanner scan = new Scanner(System.in);
		boolean input = false;
		while (!input) {
			try {
				System.out.println("Type in the name of the product");
				String name = scan.nextLine();
				System.out.println("Type in the cost of the product");
				Double cost = scan.nextDouble();
				scan.nextLine();
				System.out.println("Type in the description of the product");
				String desc = scan.nextLine();
				System.out.println("Type in the image URL of the product");
				String url = scan.nextLine();
				scan.close();
				input = true;
				
				Product prod = new Product(url, name, cost, desc);

				//dep.getProducts().add(prod);
				JSONObject obj = new JSONObject();
				obj.put("name", name);
				obj.put("cost", cost);
				obj.put("description", desc);
				obj.put("imageURL", url);

				JSONArray departments = mainObject.getJSONArray("departments");

				for (int i = 0; i < departments.length(); i++) {
					/*if (departments.getJSONObject(i).get("name").equals(dep.getName())) {
						JSONArray products = departments.getJSONObject(i).getJSONArray("products");
						products.put(obj);
					}*/
				}
				
				BufferedWriter bw = new BufferedWriter(new FileWriter("JSONTest"));
				bw.write(mainObject.toString());
				bw.close();				
			} catch (InputMismatchException e) {
				System.out.println("Wrong input type for cost");
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
