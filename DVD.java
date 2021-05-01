import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

public class DVD extends Resource {
	/**
	 * The attributes/variables/fields of a DVD which is inherited from resource
	 */
	public static int uniqueCopyID = 0;
	public List<Copy> copies = new ArrayList<Copy>();
	
	protected int resourceID; 
    protected String title;
    protected int year;
    protected Image image;
    //protected boolean checkCopies;
    //protected int numOfCopies;
    
    /**
     * The attributes/variables/fields of a DVD 
     */
    private String director;
    private int runTime;
    private String subtitles;
    private String language;
    
    /**
     * Constructor of a DVD
     * @param resourceID	   resourceID of a DVD	
     * @param title			   title of a DVD
     * @param year			   year of a DVD
     * @param image			   thumbnail image of a DVD
     * @param director		   director of a DVD
     * @param runTime		   run time of a DVD
     * @param genre			   genre of a DVD
     * @param isbn			   isbn of a DVD
     * @param language         language of a DVD
     */
    public DVD(int resourceID, int numberOfCopies, String title, int year, String image, String director, int runTime, String language, String subtitles) {
    	super(resourceID, numberOfCopies, title, year, image);
    	super.setResourceID(resourceID);
    	super.setNumCopies(numberOfCopies);
    	super.setTitle(title);
    	super.setYear(year);
    	super.setImage(image);
    	setDirector(director);
    	setRunTime(runTime);
    	setSubtitles(subtitles);
    	setLanguage(language);
    }
    
    /**
     * Getting the director of a DVD
     * @return director      the director of a DVD
     */
    public String getDirector() {
    	return director;
    }
    
    /**
     * Getting the run time of a DVD
     * @return runTime      the run time of a DVD
     */
    public int getRunTime() {
    	return runTime;
    }

    /**
     * Getting the ISBN of a DVD
     * @return isbn           the ISBN of a DVD
     */
    public String getSubtitles() {
    	return subtitles;
    }
    
    /**
     * Getting the language of a DVD
     * @return language         the language of a DVD
     */
    public String getLanguage() {
    	return language;
    }
    
    /**
     * Setting the director of a DVD
     * @param director        the director of a DVD
     */
    public void setDirector(String director) {
    	this.director = director;
    }
    
    /**
     * Setting the run time of a DVD
     * @param runTime        the run time of a DVD
     */
    public void setRunTime(int runTime) {
    	this.runTime = runTime;
    }
    
    /**
     * Setting the subtitles of a DVD
     * @param isbn        the subtitles of a DVD
     */
    public void setSubtitles(String isbn) {
    	this.subtitles = isbn;
    }
    
    /**
     * Setting the language of a DVD
     * @param language   the language of a DVD
     */
    public void setLanguage(String language) {
    	this.language = language;
    }
    
    // we override because it passes this object, rather than going through a mess
    // of finding what object this is
    @Override
    public DVD getObject() {
    	return this;
    }
    
    @Override
    public String translateToText() {
		return "DVD, " + this.getNumCopies() + ", " + this.getResourceID() + ", " + this.getTitle() + ", " +
		this.getYear() + ", " + this.getImage() + ", " + this.getDirector() + ", " + this.getRunTime() + ", " +
		this.getLanguage() + ", " + this.getSubtitles();
    }
}
