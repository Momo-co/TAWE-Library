import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;

public class Book extends Resource {
	/**
	 * The attributes/variables/fields of a book which is inherited from resource
	 */
	public static int uniqueCopyID = 0;
	public List<Copy> copies = new ArrayList<Copy>();
	
	protected String resourceID; 
    protected String title;
    protected int year;
    protected Image image;
    
	/**
	 * the attributes of a book
	 */
	private String author;
	private String publisher;
	private String genre;
	private String language;
	private String isbn;
	
	/**
	 * Constructor of a book
	 * @param resourceID		resourceID of a book
	 * @param title				title of a book
	 * @param year				year of a book
	 * @param image				image of a book
	 * @param author			author of a book
	 * @param publisher			publisher of a book
	 * @param genre				genre of a book
	 * @param language			language of a book
	 */
	public Book (int resourceID, int numberOfCopies, String title, int year, String image, String author, String publisher, String genre, String language, String isbn) {
		super(resourceID, numberOfCopies, title, year, image);
		super.setResourceID(resourceID);
		super.setNumCopies(numberOfCopies);
    	super.setTitle(title);
    	super.setYear(year);
    	super.setImage(image);
    	setAuthor(author);
    	setPublisher(publisher);
    	setGenre(genre);
    	setLanguage(language);
    	setIsbn(isbn);
	}
	
	/**
	 * Getting the author of a book
	 * @return			the author of a book
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * Getting the publisher of a book
	 * @return			the publisher of a book
	 */
	public String getPublisher() {
		return publisher;
	}
	
	/**
	 * Getting the genre of a book
	 * @return			the genre of a book
	 */
	public String getGenre() {
		return genre;
	}
	
	/**
	 * Getting the language of a book
	 * @return			the language of a book
	 */
	public String getLanguage() {
		return language;
	}
	
	/**
	 * Setting the author of a book
	 * @param author		the author of a book
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * Setting the publisher of a book
	 * @param publisher		the publisher of a book
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	/**
	 * Setting the genre of a book
	 * @param genre			the genre of a book
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	/**
	 * Setting the language of a book
	 * @param language		the language of a book
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	// we override because it passes this object, rather than going through a mess
    // of finding what object this is
    @Override
    public Book getObject() {
    	return this;
    }
    
    @Override
    public String translateToText() {
		return "Book, " + this.getNumCopies() + ", " + this.getResourceID() + ", " +
		this.getTitle() + ", " + this.getYear() + ", " + this.getImage() + ", " +
		this.getAuthor() + ", " + this.getPublisher() + ", " + this.getGenre() + ", " +
		this.getLanguage() + ", " + this.getIsbn();
    }
}