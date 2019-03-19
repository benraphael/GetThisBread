
public class Shirt extends Product{
	
	private String [] sizes, colors;

	public Shirt (String title, String[] sizes, String[] colors, Double cost, String desc) {
		super("goo.gl/Kj7nXY",title, cost, desc);
		this.sizes = sizes;
		this.colors = colors;
	}

	public String[] getSizes() {
		return sizes;
	}

	public void setSizes(String[] sizes) {
		this.sizes = sizes;
	}

	public String[] getColors() {
		return colors;
	}

	public void setColors(String[] colors) {
		this.colors = colors;
	}
	
}
