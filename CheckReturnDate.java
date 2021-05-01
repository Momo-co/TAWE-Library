/**
 * @author Dale Butt, 957450
 *
 * This file is to Check a return date of a resource
 *
 */


import java.util.Date;

public class CheckReturnDate{
	
	/*
	 * 
	 * checkRequest
	 * calculateDueDate
	 * getDate
	 * getCopyID
	 * getLoanDuration
	 * copyAssign
	 * renewDueDate
	 */
	
	private int copyID;
	private Date dueDate;// = new Date();
	private Date returnedDate;
	private Date todayDate;
	
	public CheckReturnDate(int uniqueID, Date dueDate){
		setDueDate(dueDate);
		setCopyID(uniqueID);
	}
	
	public Boolean checkRequest(int copyID){ // No use of this at the moment
		if (todayDate == returnedDate){
			return true;
		}
		return false;
	}
	
	public void calculateDueDate(Date currentDay){ // No use of this at the moment
		// what are we even calculating??
	}
	
	/**
	 * @return the copyID
	 */
	public int getCopyID() {
		return copyID;
	}

	/**
	 * @param copyID the copyID to set
	 */
	private void setCopyID(int copyID) {
		this.copyID = copyID;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	private void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the returnedDate
	 */
	public Date getReturnedDate() {
		return returnedDate;
	}

	/**
	 * @param returnedDate the returnedDate to set
	 */
	private void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}
}
