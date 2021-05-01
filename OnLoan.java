/**
 * @author Dale Butt, 957450
 *
 * This file is 
 * 
 */
 
import java.time.LocalDate;
import java.util.Date;

 // This represents a resource currently onloan (probaby in a list of currently loaned books?)

public class OnLoan {
	private User borrower;
	private Copy resourceCopy;
	private Librarian staffIssuer;
	private LocalDate startDate;
	private LocalDate dueDate;
	private Librarian reciever;
	private Boolean finePaid;
	
	public OnLoan(User borrower, Copy resourceCopy, Librarian staffIssuer, LocalDate startDate){
		setBorrower(borrower);
		setResourceCopy(resourceCopy);
		setStaffIssuer(staffIssuer);
		setStartDate(startDate);
	}
	
	/**
	 * @return the borrower
	 */
	public User getBorrower() {
		return borrower;
	}

	/**
	 * @param borrower the borrower to set
	 */
	public void setBorrower(User borrower) {
		this.borrower = borrower;
	}

	/**
	 * @return the resourceCopy
	 */
	public Copy getResourceCopy() {
		return resourceCopy;
	}

	/**
	 * @param resourceCopy the resourceCopy to set
	 */
	public void setResourceCopy(Copy resourceCopy) {
		this.resourceCopy = resourceCopy;
	}

	/**
	 * @return the staffIssuer
	 */
	public Librarian getStaffIssuer() {
		return staffIssuer;
	}

	/**
	 * @param staffIssuer the staffIssuer to set
	 */
	public void setStaffIssuer(Librarian staffIssuer) {
		this.staffIssuer = staffIssuer;
	}

	/**
	 * @return the startDate
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate2 the startDate to set
	 */
	public void setStartDate(LocalDate date) {
		this.startDate = date;
	}

	/**
	 * @return the dueDate
	 */
	public LocalDate getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(LocalDate date) {
		this.dueDate = date;
	}
	
	// OTHERS
	public void calculateFine(){
		
	}
	
	public void setFinePaid(Boolean newValue){
		this.finePaid = newValue;
	}
	
	public void setReciever(Librarian staffMember){
		this.reciever = staffMember;
	}
}