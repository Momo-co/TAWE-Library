/**
 * 
 * @author Rhys Jacka, 955475
 * @author Dale Butt, 957450
 *
 * This class represents a Fine. 
 *
 */

import java.time.LocalDate;

public class Fine {
	private String itemName = "";
	private double fineAmount;
	public int daysOverDue;
	private double fineRemainder = 0.0;
	
	public Fine(OnLoan contract) {
		if (contract.getResourceCopy().getBook() != null) {
			this.itemName = contract.getResourceCopy().getBook().getTitle();
			
		} else if (contract.getResourceCopy().getDVD() != null) {
			this.itemName = contract.getResourceCopy().getDVD().getTitle();
			
		} else if (contract.getResourceCopy().getLaptop() != null) {
			this.itemName = contract.getResourceCopy().getLaptop().getTitle();
		}
		
		this.calculateDaysOver(contract.getStartDate(), contract.getStartDate());
		this.calculateTotalFine(contract.getResourceCopy());
	}
	
	public double getFinePrice() {
		return fineAmount;
	}

	public void calculateTotalFine(Copy borrowedCopy){
		double totalCost = 0.0;
		
		// if it a book or dvd, fine them 2 pound per day(max of 25 pound)
		if (borrowedCopy.getBook() != null || borrowedCopy.getDVD() != null) {
			double lateCost;
			
			if (this.daysOverDue > 10) {
				lateCost = 100.00;
			} else {
				lateCost = 2.00 * this.daysOverDue;
			}
			totalCost = totalCost + lateCost;
			
		// if it a laptop, fine them 10 pound per day(max of 100 pound)
		} else if(borrowedCopy.getLaptop() != null) {
			double lateCost;
			
			if (this.daysOverDue > 10) {
				lateCost = 100.00;
			} else {
				lateCost = 10.00 * this.daysOverDue;
			}
			totalCost = totalCost + lateCost;
		}
		this.fineAmount = totalCost;
		this.fineRemainder = this.fineAmount;
	}
	
	/**
	 * Calculates how many days over due
	 * @param daysOverDue - how many days a resource is overdue
	 * @return daysOverDue
	 */
	public int calculateDaysOver(LocalDate currentDate, LocalDate dueDate){	
		System.out.println(dueDate + " : " + currentDate);
		
		if (currentDate.getMonth() == dueDate.getMonth()) {
			this.daysOverDue = dueDate.compareTo(currentDate);
			
		} else if (dueDate.compareTo(currentDate) == 1) {
			this.daysOverDue = 28;
		}		
		return daysOverDue;
	}
}