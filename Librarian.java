/**
 * @author Dale Butt, 957450
 *
 * This file is the subclass of Controller and contains all
 * Librarian information, it gives administrative access to 
 * the Tawe-Library for all these types of users.
 * 
 */

public class Librarian extends Controller {
	
	// what happens if we hit max value? (need to change int to long or something bigger/better)
	private static int uniqueStaffID = 1000; // used to generate a staffNumber (4 numbers)
	String employmentStart;// = new Date();
	int staffNumber;
	
	// Constructor to create a brand new librarian
	public Librarian(String userID, String forename, String surname, String phone, String tele, String location, String imageURL, String employmentDate) {
		super(userID, forename, surname, phone, tele, location, imageURL);
		employmentStart = employmentDate;
		staffNumber = ++uniqueStaffID;
	}
	
	// Constructor to create a librarian with known information (preloads)
	public Librarian(int staffID, String userID, String forename, String surname, String phone, String tele, String location, String imageURL, String employmentDate) {
		super(userID, forename, surname, phone, tele, location, imageURL);
		employmentStart = employmentDate;
		staffNumber = staffID;
	}

	/**
	 * @return the employmentStart
	 */
	public String getEmploymentStart() {
		return employmentStart;
	}

	/**
	 * @return the staffNumber
	 */
	public int getStaffNumber() {
		return staffNumber;
	}

	/**
	 * @return A string of personal information
	 */
	@Override
	public String translateToText() {
		return "Librarian, " + this.getUsername() + ", " + this.getFirstName() + ", "+ this.getLastName() +
				", " + this.getPhoneNumber() + ", " + this.getTelephone() + ", " + this.getAddress() + 
				", " + this.getProfilePicture().getPictureURL() + ", " + this.getEmploymentStart();
	}	
}
