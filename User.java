/**
 * @author Dale Butt, 957450
 *
 * This file is the subclass of Controller and contains all
 * User information, it allows them to use the Tawe-Library
 * to borrow resources and pay fines.
 * 
 */


import java.util.ArrayList;
import java.util.List;

public class User extends Controller {
	
	double currentBalance;
	List<String> searchHistory = new ArrayList<String>(); // String Searches (max of 5)
	List<Copy> borrowedItems = new ArrayList<Copy>(); // currently borrowed items
	List<Copy> requestedItems = new ArrayList<Copy>(); // A list of items that the user has requested, but are not currently available
	List<Copy> reservedItems = new ArrayList<Copy>(); // A list of items that they previously requested that are now available to pick up. They have been reserved for this user
	List<Fine> currentFines = new ArrayList<Fine>(); // a list of fines a user needs to pay
	List<String> transactionalHistory = new ArrayList<String>(); // a list of strings about transactions
	
	
	public User(String userID, String forename, String surname, String phone, String tele, String location, String image) {
		super(userID, forename, surname, phone, tele, location, image);
	}

	/**
	 * @return the currentBalance
	 */
	public double getBalance() {
		return currentBalance;
	}

	/**
	 * @param currentBalance the currentBalance to set
	 */
	public void setBalance(float currentBalance) {
		this.currentBalance = currentBalance;
	}

	/**
	 * @return the searchHistory
	 */
	public List<String> getSearchHistory() {
		return searchHistory;
	}

	/**
	 * @param searchHistory the searchHistory to set
	 */
	public void addSearchHistory(String history) {
		if (searchHistory.size() == 5) {
			searchHistory.remove(0);
		}
		searchHistory.add(history);
	}

	/**
	 * @return the borrowedItems
	 */
	public List<Copy> getBorrowedItems() {
		return borrowedItems;
	}

	/**
	 * @param borrowedItems the borrowedItems to add
	 */
	public void addBorrowedItems(Copy borrowedItem) {
		this.borrowedItems.add(borrowedItem);
	}
	
	/**
	 * @param borrowedItems the borrowedItems to remove
	 */
	public void removeBorrowedItems(Copy borrowedItem) {
		this.borrowedItems.remove(borrowedItem);
	}

	/**
	 * @return the requestedItems
	 */
	public List<Copy> getRequestedItems() {
		return requestedItems;
	}

	/**
	 * @param requestedItems the requestedItems to add
	 */
	public void addRequestedItems(Copy requestedItem) {
		this.requestedItems.add(requestedItem);
	}
	
	/**
	 * @param requestedItems the requestedItems to remove
	 */
	public void removeRequestedItems(Copy requestedItems) {
		this.requestedItems.remove(requestedItems);
	}

	/**
	 * @return the reservedItems
	 */
	public List<Copy> getReservedItems() {
		return reservedItems;
	}

	/**
	 * @param reservedItems the reservedItems to add
	 */
	public void addReservedItems(Copy reserveItem) {
		System.out.println("Addreserve:" + reserveItem);
		this.reservedItems.add(reserveItem);
	}
	
	/**
	 * @param reservedItems the reservedItems to remove
	 */
	public void removeReservedItems(Copy reservedItem) {
		this.reservedItems.remove(reservedItem);
	}

	/**
	 * @return the transactionalHistory
	 */
	public List<String> getTransactionalHistory() {
		return transactionalHistory;
	}

	/**
	 * @param transactionalHistory the transactionalHistory to set
	 */
	public void addTransactionToHistory(List<String> transactionalHistory) {
		this.transactionalHistory = transactionalHistory;
	}

	/**
	 * @return the currentFines
	 */
	public List<Fine> getCurrentFines() {
		return currentFines;
	}

	/**
	 * @param the newFine
	 */
	public void addFine(Fine newFine) {
		currentFines.add(newFine);
	}

	/**
	 * @param currentFines the currentFines to set
	 */
	public void removeFine(Fine fineRef) {
		currentFines.remove(fineRef);
	}
	
	public void addFunds(double funds) {
		// TODO Auto-generated method stub
		this.currentBalance = this.currentBalance + funds;
	}
	
	@Override
	public String translateToText() {
		return "User, " + this.getUsername().trim() + ", " + this.getFirstName().trim() + ", "+ this.getLastName().trim() +
				", " + this.getPhoneNumber().trim() + ", " + this.getTelephone().trim() + ", " + this.getAddress().trim() + 
				", " + this.getProfilePicture().getPictureURL().trim() + ", money:" + this.getBalance() + 
				", searchHistory:" + this.getSearchHistory().toString();
	}

		
}
