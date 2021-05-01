/**
 * @author Dale Butt, 957450
 *
 * This file is 
 * 
 */


public class LoanRequest {
	
	public Resource resourceToRequest;
	public User borrower;
	public String requestStamp;
	
	public LoanRequest(Resource requestedObject, User person){
		setResource(requestedObject);
		setBorrower(borrower);
		// generate stamp
	}
	
	public void setResource(Resource requestedResource){
		this.resourceToRequest = requestedResource;
	}
	
	public void setBorrower(User borrower){
		this.borrower = borrower;
	}
	
	public void generateStamp(String uniqueID){ //might remove stamp if it doesn't get used!
		this.requestStamp = uniqueID;
	}
}