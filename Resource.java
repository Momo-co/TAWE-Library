import java.util.LinkedList;
import java.util.Queue;
import javafx.scene.image.Image;

public class Resource {
	/**
	 * the attributes/variables/fields of a resource
	 */
	 
	private static int uniqueResourceID = 0; 
	private int resourceID; 
	
	public Queue<User> requestQueue = new LinkedList<User>();
	
    private String title;
    private int year;
    private String imageURL;
    protected int numOfCopies;
    
    /**
     * Constructor of a resource
     * @param resourceID      resourceID of a resource
     * @param title           title of a resource
     * @param year			  year of a resource
     * @param image		      thumbnail image of a resource
     */
    public Resource(int resourceID, int numberOfCopies, String title, int year, String image) {
        setResourceID(resourceID);
        setTitle(title);
        setYear(year);
        setImage(image);
    }
    
    /**
     * Getting the resource ID of a resource
     * @return resourceID			the resource ID of a resource
     */
    public int getResourceID() {
        return resourceID;
    }
    
    /**
     * Getting the title of a resource
     * @return title			the title of a resource
     */
    public String getTitle() {
    	return title;
    }
    
    /**
     * Getting the year of a resource
     * @return year				the year of a resource
     */
    public int getYear() {
    	return year;
    }
    
    /**
     * Getting the thumbnail image of a resource
     * @return image			the thumbnail image of a resource
     */
    public String getImage() {
    	return imageURL;
    }
    
    /**
     * 
     * @return checkCopies
     * public boolean getAnyCopies() {
    	return checkCopies;
    }
     */
    
    
    /**
     * Getting the number of copies of a resource
     * @return numOfCopies
     * public int getNumOfCopies() {
    	return numOfCopies;
    }
     */
    
    
    /**
     * Setting the resource ID of a resource
     * @param resourceID			the resource ID of a resource
     */
    public void setResourceID(int specificID) {
    	if (specificID > 0) {
    		this.resourceID = specificID;
    		uniqueResourceID = specificID;
    	} else {
    		this.resourceID = ++uniqueResourceID;
    	}
    }
    
    /**
     * Setting the title of a resource
     * @param resource				the title of a resource
     */
    public void setTitle(String title) {
    	this.title = title;
    }
    
    /**
     * Setting the year of a resource
     * @param year				the year of a resource
     */
    public void setYear(int year) {
    	this.year = year;
    }
    
    /**
     * Setting the thumbnail image of a resource
     * @param image				the thumbnail image of a resource
     */
    public void setImage(String image) {
    	this.imageURL = image;
    }
    
    public Object getObject() {
		return null;
    }  
    
    public void setNumCopies(int numberOfCopies) {
		this.numOfCopies = numberOfCopies;
	}
    
    protected int getNumCopies() {
		// TODO Auto-generated method stub
		return this.numOfCopies;
	}
    
    @Override
    public String toString() {
		String result = "";
		result += getClass().toString().substring(6) + ", " + getTitle() + ", "; 
		
		if (getClass().toString().substring(6,7).equals("D")) {
			DVD thisRes = (DVD)this;
			result += thisRes.getDirector() + ", " + thisRes.getYear();
			
		} else if (getClass().toString().substring(6,7).equals("B")) {
			Book thisRes = (Book)this;
			result += thisRes.getAuthor() + ", " + thisRes.getGenre() + ", " + thisRes.getYear();
			
		} else if (getClass().toString().substring(6,7).equals("L")) {
			Laptop thisRes = (Laptop)this;
			result += thisRes.getManufacturer() + ", " + thisRes.getYear();
		}
		return result;
	}

	public String translateToText() {
		return null;
	}

	
}