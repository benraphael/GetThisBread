/**
 * @author Ethan Jones
 * @date Mar 15, 2019
 * @file Page.java
 * @timestamp 10:16:27 AM
 */
public abstract class Page {
	
	private String type;
	
	public Page (String type) {
		this.type = type;
		displayOrganizer();
	}
	
	public abstract void displayOrganizer();
}
