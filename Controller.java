/**
 * @author Dale Butt, 957450
 *
 * This file is the root of all users, the subclasses are User and Librarian.
 * Stores all shared variables and methods.
 *
 */

public class Controller {

	private String username; // unique key
	private String firstName;
	private String lastName;

	private String phoneNumber;
	private String telephone;
	private String address;
	private ProfilePicture profilePicture; // change int to imageId

	public Controller(String user, String forename, String surname, String phone, String tele, String location, String imageURL) {
		username = user;
		firstName = forename;
		lastName = surname;
		phoneNumber = phone;
		telephone = tele;
		address = location;
		profilePicture = new ProfilePicture(imageURL);
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}



	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}



	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}



	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}



	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}



	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}



	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}



	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}



	/**
	 * @return the profilePicture
	 */
	public ProfilePicture getProfilePicture() {
		return profilePicture;
	}

	/**
	 * @param the profilePicture
	 */
	public void setPicture(String string) {
		profilePicture.setPictureURL(string);
	}

	public String translateToText() {
		return "";
	}
}
