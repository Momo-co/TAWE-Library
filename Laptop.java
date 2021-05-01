import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
public class Laptop extends Resource {
	/**
	 * The attributes/variables/fields of a laptop which is inherited from resource
	 */
	public static int uniqueCopyID = 0;
	public List<Copy> copies = new ArrayList<Copy>();
	
	protected String resourceID; 
    protected String title;
    protected int year;
    protected Image image;
    
    /**
	 * The attributes/variables/fields of a laptop
	 */
    private String manufacturer;
    private String model;
    private String os;
    
    /**
     * Constructor of a Laptop
     * @param resourceID		resourceID of a laptop
     * @param title				title of a laptop
     * @param year				year of a laptop
     * @param image				image of a laptop
     * @param manufacturer		manufacturer of a laptop
     * @param model				model of a laptop
     * @param os				operating system of a laptop
     */
    public Laptop(int resourceID, int numberOfCopies, String title, int year, String image, String manufacturer, String model, String os) {
    	super(resourceID, numberOfCopies, title, year, image);
		super.setResourceID(resourceID);
		super.setNumCopies(numberOfCopies);
    	super.setTitle(title);
    	super.setYear(year);
    	super.setImage(image);
    	setManufacturer(manufacturer);
    	setModel(model);
    	setOS(os);
    }
    
    /**
     * Getting the manufacturer of a laptop 
     * @return manufacturer			the manufacturer of a laptop 
     */
    public String getManufacturer() {
    	return manufacturer;
    }
    
    /**
     * Getting the model of a laptop
     * @return model				the model of a laptop
     */
    public String getModel() {
    	return model;
    }
    
    /**
     * Getting the operating system of a laptop
     * @return os					the operating system of a laptop
     */
    public String getOS() {
    	return os;
    }
    
    /**
     * Setting the manufacturer of a laptop
     * @param manufacturer			the manufacturer of a laptop
     */
    public void setManufacturer(String manufacturer) {
    	this.manufacturer = manufacturer;
    }
    
    /**
     * Setting the model of a laptop
     * @param model					the model of a laptop
     */
    public void setModel(String model) {
    	this.model = model;
    }
    
    /**
     * Setting the operating system of a laptop
     * @param os					the operating system of a laptop
     */
    public void setOS(String os) {
    	this.os = os;
    }
    
 // we override because it passes this object, rather than going through a mess
    // of finding what object this is
    @Override
    public Laptop getObject() {
    	return this;
    }
    
    @Override
    public String translateToText() {
		return "Laptop, " + this.getNumCopies() + ", " + this.getResourceID() + ", " +
		this.getTitle() + ", " +this.getYear() + ", " + this.getImage() + ", " + 
		this.getManufacturer() + ", " + this.getModel() + ", " + this.getOS();
    }
}