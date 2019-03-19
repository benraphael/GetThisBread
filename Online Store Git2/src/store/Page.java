
public abstract class Page {
	
	private String type;
	
	public Page (String type) {
		this.type = type;
		displayOrganizer();
	}
	
	public abstract void displayOrganizer();
}
