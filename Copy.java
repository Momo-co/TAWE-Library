import java.util.List;
import java.util.ArrayList;

/*
 * TO DO: implement history list (borrow & returns)
 */

/**
 * @author Suman Gurung
 * @author Dale Butt
 * This class represent a copy of a particular resource (DVD, Book, Laptop)
 * 
 */
public class Copy {
	/**
	 * The attributes/variables/fields of a copy of resource
	 */
	private int copyID;
	private Book book;
	private DVD dvd;
	private Laptop laptop;	
	private String loanDuration;
	private String dueDate;
	private boolean available; // if is being loaned then this will be false (fitering)
	private List<User> history = new ArrayList<User>();
	
	/**
	 * Constructor of copy of a book
	 * @param book			detail of a book
	 * @param loanDuration	the duration that the copy of the book is loaned for
	 */
	public Copy(Book book, String loanDuration) {
		setBook(book);
		setCopyID();
		setLoanDuration(loanDuration);
		setAvailable(true);
	}
	
	/**
	 * Constructor of copy of a DVD
	 * @param dvd			detail of a DVD
	 * @param loanDuration	the duration that the copy of the DVD is loaned for
	 */
	public Copy(DVD dvd, String loanDuration) {
		setDVD(dvd);
		setCopyID();
		setLoanDuration(loanDuration);
		setAvailable(true);
	}
	
	/**
	 * Constructor of copy of a laptop
	 * @param laptop		detail of a laptop
	 * @param loanDuration	the duration that the copy of the laptop is loaned for
	 */
	public Copy(Laptop laptop, String loanDuration) {
		setLaptop(laptop);
		setCopyID();
		setLoanDuration(loanDuration);
		setAvailable(true);
	}
	
	/**
	 * Getting the duration that the copy of the resource is loaned for
	 * @return loanDuration
	 */
	public String getLoanDuration() {
		return loanDuration;
	}
	
	/**
	 * Getting the date on which the copy of the resource needs to be returned to library
	 * @return dueDate
	 */
	public String getDueDate() {
		return dueDate;
	}
	
	/**
	 * Getting the copyID of a particular copy of a resource
	 * @return copyID
	 */
	public int getCopyID() {
		return copyID;
	}
	
	/**
	 * Getting the detail of a book
	 * @return book
	 */
	public Book getBook() {
		return book;
	}
	
	/**
	 * Getting the detail of a DVD
	 * @return dvd
	 */
	public DVD getDVD() {
		return dvd;
	}
	
	/**
	 * Getting the detail of a laptop
	 * @return laptop
	 */
	public Laptop getLaptop() {
		return laptop;
	}
	
	/**
	 * Setting the duration that the copy of the resource is loaned for
	 * @param loanDuration
	 */
	public void setLoanDuration(String loanDuration) {
		this.loanDuration = loanDuration;
	}
	
	/**
	 * Setting the date on which the copy of the resource needs to be returned to library
	 * @param dueDate
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	/**
	 * Setting the copyID of a particular copy of a resource
	 * @param copyID
	 */
	public void setCopyID() {
		if (this.book != null) {
			this.copyID = ++this.book.uniqueCopyID;
			
		} else if (this.dvd != null) {
			this.copyID = ++this.dvd.uniqueCopyID;
			
		} else if (this.laptop != null) {
			this.copyID = ++this.laptop.uniqueCopyID;
		}
	}
	
	/**
	 * Setting the detail of a book
	 * @param book
	 */
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	/**
	 * Setting the detail of a dvd
	 * @param dvd
	 */
	public void setDVD(DVD dvd) {
		this.dvd = dvd;
	}
	
	/**
	 * Setting the detail of a laptop
	 * @param laptop
	 */
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	/**
	 * @return the available
	 */
	public boolean getAvailable() {
		return this.available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean newValue) {
		this.available = newValue;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */	
}
