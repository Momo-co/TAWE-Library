/**
 * @author Dale Butt
 *
 * This file is the Library and the hub of all objects
 * and all things related, etc, etc
 * 
 */
 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
 
public class Library {
	private String libraryName; // A simple name of the Library (header text)
	private static List<String> logins = new ArrayList<String>(); // this contains all the usernames
	private static Controller currentLogin;
	
	// Lists of Assets (users/librarians and resources)
	public static List<Controller> userList = new ArrayList<Controller>(); //User[] userList; A list of users (instances)
	public static List<Resource> resourceList = new ArrayList<Resource>();//Resource[] resourceList; //A list of resources (instances)
	public static List<Copy> copiesList = new ArrayList<Copy>();	
	public static List<OnLoan> loans = new ArrayList<OnLoan>(); //A list of currently loaned books
	
	public Library(String name){
		this.libraryName = name;
		Library.preloadAccounts();
		Library.preloadResources();
		
		try {
			Library.preloadExecutions();
		} catch (IOException e) {
			// do nothing otherwise?
		}
	}
	
	private static String convertDateToString(LocalDate dateToConvert) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "";
		
	}
	
	private static Controller getUserBasedOnName(String username) {
		for (Controller account : userList) {
			if (account.getUsername().equalsIgnoreCase(username)) {
				return account;
			}
		}
		return null;
	}
	
	public static Boolean createAccounts(Scanner in) {
		Scanner openFile = in;

		while (openFile.hasNextLine()) {
			String curLine = openFile.nextLine();
			Scanner line = new Scanner(curLine).useDelimiter(",");
			
			String accountType = line.next(); // type of account, User or Librarian
			
			if (accountType.equalsIgnoreCase("user")) {
				User newAccount = new User (
					line.next().trim(), // username
					line.next().trim(), // first name
					line.next().trim(), // last name
					line.next().trim(), // phone number
					line.next().trim(), // telephone number
					line.next() + "," + line.next() + "," + line.next() + "," + line.next(), // address
					line.next().trim()
				); 
				
				// User, johndoe, john, doe, 07123456789, 01656 123456, 123 John Street, Bridgend, Wales, CF33 SA1, 0, 
				// money:1.50, searchHistory:[], borrowHistory:[], transactionalHistory:[]
				
				// extension txt files to be added
				while (line.hasNext()){
					String next = line.next().trim();
					System.out.println(next.trim());
					
					if (next.contains("money")){
						float newBalance = Float.parseFloat(next.substring(6));
						newAccount.setBalance(newBalance);
						System.out.println(newBalance);
						
					} else if (next.contains("searchHistory")){
						String searchHistory = next.substring(15, next.length() - 1);
						System.out.println(searchHistory);
						
					} else if (next.contains("borrowHistory")){
						String borrowHistory = next.substring(15, next.length() - 1);
						System.out.println(borrowHistory);
						
					} else if (next.contains("transactionalHistory")){
						String transactionaHistory = next.substring(22, next.length() - 1);
						System.out.println(transactionaHistory);
					}
				}
				Library.logins.add(newAccount.getUsername().trim());
				Library.userList.add(newAccount);
			
			} else if (accountType.equalsIgnoreCase("librarian")) {
				Librarian newAccount = new Librarian(
					line.next().trim(), // username
					line.next().trim(), // first name
					line.next().trim(), // last name
					line.next().trim(), // phone number
					line.next().trim(), // telephone number
					line.next().trim() + ", " + line.next().trim() + ", " + line.next().trim() + ", " + line.next().trim(), // address
					line.next().trim(),  // picture
					line.next().trim()
				);
					
				// create optional fields
				Library.logins.add(newAccount.getUsername().trim());
				Library.userList.add(newAccount);
			}
			line.close();
		}
		openFile.close();
		return true;
	}
	
	public static Boolean createResources(Scanner in) {
		Scanner openFile = in;

		while (openFile.hasNextLine()) {
			String curLine = openFile.nextLine();
			Scanner line = new Scanner(curLine).useDelimiter(",");
			
			String resourceType = line.next();
			int numberOfCopies = Integer.parseInt(line.next().trim());
			
			if (resourceType.equalsIgnoreCase("book")) {
				Book newBook = new Book(
					Integer.parseInt(line.next().trim()), // resouceID
					numberOfCopies,
					line.next().trim(), // name of book
					Integer.parseInt(line.next().trim()), // year
					line.next().trim(), // image
					line.next().trim(), // author
					line.next().trim(), // publisher
					line.next().trim(), // genre
					line.next().trim(), // language
					line.next().trim() // isbn
				);
				Library.resourceList.add(newBook);
				
				// lets create some copies
				for (int i = 0; i < numberOfCopies; i++) {
		        	Copy newCopy = new Copy(newBook, "1 Week");
		        	Library.copiesList.add(newCopy);
		        	newBook.copies.add(newCopy);
		        }
			
			} else if (resourceType.equalsIgnoreCase("dvd")) {
				DVD newDVD = new DVD(
					Integer.parseInt(line.next().trim()), // resouceID
					numberOfCopies,
					line.next().trim(), // name of book
					Integer.parseInt(line.next().trim()), // year
					line.next().trim(), // image
					line.next().trim(), // director
					Integer.parseInt(line.next().trim()), // runTime
					line.next().trim(), // language
					line.next().trim() // subtitles
				);
				Library.resourceList.add(newDVD);
				
				// lets create some copies
				for (int i = 0; i < numberOfCopies; i++) {
		        	Copy newCopy = new Copy(newDVD, "1 Week");
		        	Library.copiesList.add(newCopy);
		        	newDVD.copies.add(newCopy);
		        }
			
			} else if (resourceType.equalsIgnoreCase("laptop")) {
				Laptop newLaptop = new Laptop(
					Integer.parseInt(line.next().trim()), // resouceID
					numberOfCopies,
					line.next().trim(), // name of laptop
					Integer.parseInt(line.next().trim()), // year
					line.next().trim(), // image
					line.next().trim(), // manufacturer
					line.next().trim(), // model
					line.next().trim() // OS
				); 
				Library.resourceList.add(newLaptop);
				
				// lets create some copies
				for (int i = 0; i < numberOfCopies; i++) {
		        	Copy newCopy = new Copy(newLaptop, "1 Week");
		        	Library.copiesList.add(newCopy);
		        	newLaptop.copies.add(newCopy);
		        }
			}
			line.close();
		}
		openFile.close();
		return true;
	}
	
	public static User createNewUser(String username, String firstname, String lastname, String phone, String telephone, String address, String pictureURL){
		User brandNewUser = new User(username, firstname, lastname, phone, telephone, address, pictureURL);
		Library.logins.add(brandNewUser.getUsername().trim());
		Library.userList.add(brandNewUser);	
		
		try {
			Library.saveLocalData();
		} catch (IOException e) {
		}
		return brandNewUser;
	}
	
	public static Librarian createNewLibrarian(String username, String firstname, String lastname, String phone, String telephone, String address, String pictureURL, String startDate){
		Librarian brandNewUser = new Librarian(username, firstname, lastname, phone, telephone, address, pictureURL, startDate);
		Library.logins.add(brandNewUser.getUsername().trim());
		Library.userList.add(brandNewUser);	
		try {
			Library.saveLocalData();
		} catch (IOException e) {
		}
		return brandNewUser;
	}
	
	public static Resource createNewResource(String resourceType, String[] attributes){
		if (resourceType.equalsIgnoreCase("book") && attributes.length == 10) {
			Book newBook = new Book(
				Integer.parseInt(attributes[0].trim()), // resouceID
				Integer.parseInt(attributes[1]),
				attributes[2].trim(), // name of book
				Integer.parseInt(attributes[3]), // year
				attributes[4].trim(), // image
				attributes[5].trim(), // author
				attributes[6].trim(), // publisher
				attributes[7].trim(), // genre
				attributes[8].trim(), // language
				attributes[9].trim() // isbn
			); 				
			resourceList.add(newBook);
			
			// lets create some copies
			for (int i = 0; i < Integer.parseInt(attributes[1]); i++) {
	        	Copy newCopy = new Copy(newBook, "1 Week");
	        	Library.copiesList.add(newCopy);
	        	newBook.copies.add(newCopy);
	        }
			return newBook;
		
		} else if (resourceType.equalsIgnoreCase("dvd") && attributes.length == 9) {
			DVD newDVD = new DVD(
				Integer.parseInt(attributes[0].trim()), // resouceID
				Integer.parseInt(attributes[1]),
				attributes[2].trim(), // name of book
				Integer.parseInt(attributes[3].trim()), // year
				attributes[4].trim(), // image
				attributes[5].trim(), // director
				Integer.parseInt(attributes[6].trim()), // runTime
				attributes[7].trim(), // language
				attributes[8].trim() // subtitles					
			);
			resourceList.add(newDVD);
			// lets create some copies
			for (int i = 0; i < Integer.parseInt(attributes[1]); i++) {
	        	Copy newCopy = new Copy(newDVD, "1 Week");
	        	Library.copiesList.add(newCopy);
	        	newDVD.copies.add(newCopy);
	        }
			
			return newDVD;
		
		} else if (resourceType.equalsIgnoreCase("laptop") && attributes.length == 8) {
			Laptop newLaptop = new Laptop(
				Integer.parseInt(attributes[0].trim()), // resouceID
				Integer.parseInt(attributes[1]), // copies
				attributes[2].trim(), // name of book
				Integer.parseInt(attributes[3].trim()), // year
				attributes[4].trim(), // image
				attributes[5].trim(), // manufacturer
				attributes[6].trim(), // model
				attributes[7].trim()); // OS
			resourceList.add(newLaptop);
			// lets create some copies
			for (int i = 0; i < Integer.parseInt(attributes[1]); i++) {
	        	Copy newCopy = new Copy(newLaptop, "1 Week");
	        	Library.copiesList.add(newCopy);
	        	newLaptop.copies.add(newCopy);
	        }
			return newLaptop;
		}
		try {
			Library.saveLocalData();
		} catch (IOException e) {
		}
		return null;
	}
	
	public static Resource editResource(Resource currentResource, String attributeToChange, String newValue){
		// to do at a later date when we know what they are able to edit
		try {
			Library.saveLocalData();
		} catch (IOException e) {
		}
		return null;
	}
	
	// LOANING SECTION
	// User: // Request > Collect > Return > Pay Fine (if needed)
	// Librarian: // Approve Request > Approve Collection > Approve Returns > Accept Fines?
	
	public static List<User> requestItems = new ArrayList<User>(); // librarian must approve of these requests
	public static List<Copy> requestCopies = new ArrayList<Copy>();
	
	public static List<User> collectItems = new ArrayList<User>(); // approve collections
	public static List<Copy> collectCopies = new ArrayList<Copy>(); 
	
	public static List<User> returningItems = new ArrayList<User>(); // approve returns
	public static List<Copy> returningCopies = new ArrayList<Copy>();
	
	// this takes the request button
	public static Boolean createNewRequest(String type, Resource selectedResource, User borrower) {
		if (type.equalsIgnoreCase("book")) {
			Book selectedBook = (Book) selectedResource;
			
			// if there is an available copy then send to userRequesting that specific copy
			for (Copy currentCopy : selectedBook.copies) {
				if (currentCopy.getAvailable() == true) {
					Library.userRequestCopy(currentCopy, borrower);
					return true;
				}
			}
			
			// if we make it this far, there are no copies available right now
			selectedBook.requestQueue.add(borrower);
			Library.pushLoans(type, selectedResource, borrower);
			
		} else if (type.equalsIgnoreCase("dvd")) {
			DVD selectedDVD = (DVD) selectedResource;
			
			// if there is an available copy then send to userRequesting that specific copy
			for (Copy currentCopy : selectedDVD.copies) {
				if (currentCopy.getAvailable() == true) {
					Library.userRequestCopy(currentCopy, borrower);
					return true;
				}
			}
			
			// if we make it this far, there are no copies available right now
			selectedDVD.requestQueue.add(borrower);
			Library.pushLoans(type, selectedResource, borrower);
			
		} else if (type.equalsIgnoreCase("laptop")) {
			Laptop selectedLaptop = (Laptop) selectedResource;
			
			// if there is an available copy then send to userRequesting that specific copy
			for (Copy currentCopy : selectedLaptop.copies) {
				if (currentCopy.getAvailable() == true) {
					Library.userRequestCopy(currentCopy, borrower);
					return true;
				}
			}
			
			// if we make it this far, there are no copies available right now
			selectedLaptop.requestQueue.add(borrower);
			Library.pushLoans(type, selectedResource, borrower);
		}
		try {
			Library.saveLocalData();
		} catch (IOException e) {
		}
		return false;
	}
	
	public static void pushLoans(String type, Resource selectedResource, User borrower) {
		if (type.equalsIgnoreCase("book")) {
			Book selectedBook = (Book) selectedResource;
			
			
			// if there is an available copy then send to userRequesting that specific copy
			for (OnLoan loanContract : Library.loans) {
				for (Copy currentCopy : selectedBook.copies) {
					if (loanContract.getResourceCopy().equals(currentCopy)) {
						loanContract.setDueDate(Library.getCurrentDate());
					}
				}
			}			
		} else if (type.equalsIgnoreCase("dvd")) {
			DVD selectedDVD = (DVD) selectedResource;
			
			
			// if there is an available copy then send to userRequesting that specific copy
			for (OnLoan loanContract : Library.loans) {
				for (Copy currentCopy : selectedDVD.copies) {
					if (loanContract.getResourceCopy().equals(currentCopy)) {
						loanContract.setDueDate(Library.getCurrentDate());
					}
				}
			}			
		} else if (type.equalsIgnoreCase("laptop")) {
			Laptop selectedLaptop = (Laptop) selectedResource;
			
			
			// if there is an available copy then send to userRequesting that specific copy
			for (OnLoan loanContract : Library.loans) {
				for (Copy currentCopy : selectedLaptop.copies) {
					if (loanContract.getResourceCopy().equals(currentCopy)) {
						loanContract.setDueDate(Library.getCurrentDate());
					}
				}
			}			
		}
		
		try {
			Library.saveLocalData();
		} catch (IOException e) {
		}
	}
	
	// A user searches for a resource and requests it and it searches through all copies
	// until either the first copy which is available or the very first copy of it (if not available)
	// this method is 100% fool proof, IT has to be available,otherwise we don't call it
	public static void userRequestCopy(Copy requestedItem, User borrower){
		borrower.addRequestedItems(requestedItem);
		requestItems.add(borrower); //-> User.getReservedItems (check against that list)
		requestCopies.add(requestItems.indexOf(borrower), requestedItem);
		try {
			Library.saveLocalData();
		} catch (IOException e) {
		}
	}
	
	// A Librarian has approved a request & made the available copy reserved for this user
	// if the copy is still unavailable, they must wait for the current borrower to return it
	public static void reserveCopy(Copy availableCopy, User borrower) {
		// once the copy is available, immediately reserve it for the user
		
		// remove from requested
		requestItems.remove(borrower);
		requestCopies.remove(availableCopy);
		borrower.removeRequestedItems(availableCopy);
		
		// add to reserve
		borrower.addReservedItems(availableCopy);
		
		// update library to remove from access because its reserved
		availableCopy.setAvailable(false);
				
		try {
			Library.saveLocalData();
		} catch (IOException e) {
		}
	}
	
	// A user has requested to collect the copy but the Librarian must approve of it first
	public static void userCollecting(Copy requestedItem, User borrower) {
		// add collection request to list & let librarian approve
		collectItems.add(borrower);
		collectCopies.add(collectItems.indexOf(borrower), requestedItem);
		
		try {
			Library.saveLocalData();
		} catch (IOException e) {
		}
	}
	
	// A librarian approve the collection of the copy & is giving it to the user
	public static void approveUserCollects(Copy requestedItem, User borrower) {
		// this happens AFTER a librarian lets them borrow it & they collect it
		collectItems.remove(borrower);
		collectCopies.remove(requestedItem);
		
		// create loan class & store
		OnLoan newLoan = new OnLoan(borrower, requestedItem, null, Library.getCurrentDate());
		Library.loans.add(newLoan);
		
		// update user's inventory
		borrower.addBorrowedItems(requestedItem);
		borrower.removeReservedItems(requestedItem);
		
		// update library to remove from access
		requestedItem.setAvailable(false);
		
		try {
			Library.saveLocalData();
		} catch (IOException e) {
		}
	}
	
	public static void userReturningCopy(User borrower, Copy returningItem) {
		// a user has clicked return on a book
		System.out.println(Library.collectCopies);
		returningItems.add(borrower); //-> User.getReservedItems (check against that list)
		returningCopies.add(returningItems.indexOf(borrower), returningItem);
		
		try {
			Library.saveLocalData();
		} catch (IOException e) {
		}
	}
	
	// if copy is currently requested (via Object Queue) set next as reserved
	public static void approveReturnCopy(User borrower, Copy returningItem) {
		// a librarian confirms return & gives user the fine
		returningItems.remove(borrower);
		returningCopies.remove(returningItem);
		returningItem.setAvailable(true);
		
		OnLoan selectedLoan = null;
		for (OnLoan eachLoan : Library.loans){
			if (eachLoan.getResourceCopy().equals(returningItem) && eachLoan.getBorrower().equals(borrower)) {
				// it is this loan copy
				selectedLoan = eachLoan;
			}
		};
		
		// set duedate if we don't got one
		if (selectedLoan.getDueDate() == null) {
			selectedLoan.setDueDate(Library.getCurrentDate());
		}
		
		// lets handle next-in-line
		if (returningItem.getBook() != null) {
			Book thisBook = returningItem.getBook();
			if (thisBook.requestQueue.peek() != null) {
				// this book is now reserved for the next user
				for (Copy currentCopy : thisBook.copies) {
					if (currentCopy.getAvailable() == true) {
						Library.userRequestCopy(currentCopy, borrower);
						thisBook.requestQueue.poll();
					}
				}
			}
			
		} else if (returningItem.getDVD() != null) {
			DVD thisDVD = returningItem.getDVD();
			if (thisDVD.requestQueue.peek() != null) {
				// this book is now reserved for the next user
				for (Copy currentCopy : thisDVD.copies) {
					if (currentCopy.getAvailable() == false) {
						Library.userRequestCopy(currentCopy, borrower);
						thisDVD.requestQueue.poll();
					}
				}
			}
			
		} else if (returningItem.getLaptop() != null) {
			Laptop thisLaptop = returningItem.getLaptop();
			if (thisLaptop.requestQueue.peek() != null) {
				// this book is now reserved for the next user
				for (Copy currentCopy : thisLaptop.copies) {
					if (currentCopy.getAvailable() == false) {
						Library.userRequestCopy(currentCopy, borrower);
						thisLaptop.requestQueue.poll();
					}
				}
			}
		}
		
		// update user-side
		borrower.removeBorrowedItems(returningItem);
		
		//update server
		Library.loans.remove(selectedLoan);
		
		// if overdue, create new Fine
		borrower.addFine(new Fine(selectedLoan));
		
		try {
			Library.saveLocalData();
		} catch (IOException e) {
		}
	}
	
	public static void fineUser(Fine fineRef) {
		// a user accepts fine and pays for it
		
		
		try {
			Library.saveLocalData();
		} catch (IOException e) {
		}
	}
	
	// compiles the list of users into readable text
	public static void compileAccounts() throws IOException {
		// empty file first
		String masterString = "";
		String spacer = System.getProperty("line.separator");
		
		for (Controller person : Library.userList) {
			masterString = masterString + person.translateToText() + spacer;
		}
		Datastore.setAsync("dataSet/accounts.txt", masterString);
	}
	
	// compiles the list of users into readable text
		public static void compileResources() throws IOException {
			// empty file first
			String masterString = "";
			String spacer = System.getProperty("line.separator");
			
			for (Resource object : Library.resourceList) {
				masterString = masterString + object.translateToText() + spacer;
			}
			Datastore.setAsync("dataSet/resources.txt", masterString);
		}
	
	// compiling local data
	// this saves the data to the file
	public static void compileExecutions() throws IOException {		
		// empty file first
		String masterString = "";
		String spacer = System.getProperty("line.separator");
		
		// All requested Items by the user ( gives option to librarians to approve)
		for (User person : Library.requestItems) {
			String resourceTitle = "";	
			String resourceType = "";
			Copy currentCopy = Library.requestCopies.get(Library.requestItems.indexOf(person));
			
			if (currentCopy.getBook() != null) {
				resourceTitle = currentCopy.getBook().getTitle();
				resourceType = "Book";
				
			} else if (currentCopy.getDVD() != null) {
				resourceTitle = currentCopy.getDVD().getTitle();
				resourceType = "DVD";
				
			} else if (currentCopy.getLaptop() != null) {
				resourceTitle = currentCopy.getLaptop().getTitle();
				resourceType = "Laptop";
			}
			
			String compileText = "RequestedByUser, " + resourceType + ", " + resourceTitle + ", " + currentCopy.getCopyID() + ", " + person.getUsername();
			masterString = masterString +  compileText + spacer;
		}
		
		// This compiles all reserved copies so that they are able to be loaded again ( gives options to users to request to collect)
		for (Controller person : Library.userList) {
			if (person.getClass().toString().contains("User")) {
				User account = (User) person;
				
				for (Copy currentCopy : account.getReservedItems()) {
					
					String resourceTitle = "";	
					String resourceType = "";
					
					if (currentCopy.getBook() != null) {
						resourceTitle = currentCopy.getBook().getTitle();
						resourceType = "Book";
						
					} else if (currentCopy.getDVD() != null) {
						resourceTitle = currentCopy.getDVD().getTitle();
						resourceType = "DVD";
						
					} else if (currentCopy.getLaptop() != null) {
						resourceTitle = currentCopy.getLaptop().getTitle();
						resourceType = "Laptop";
					}
					
					String compileText = "Reserved, " + resourceType + ", " + resourceTitle + ", " + currentCopy.getCopyID() + ", " + person.getUsername();
					masterString = masterString +  compileText + spacer;
				}
			}
		}
		
		// this gives librarians option to approve collections
		for (User person : Library.collectItems) {
			String resourceTitle = "";	
			String resourceType = "";
			Copy currentCopy = Library.collectCopies.get(Library.collectItems.indexOf(person));
			
			if (currentCopy.getBook() != null) {
				resourceTitle = currentCopy.getBook().getTitle();
				resourceType = "Book";
					
			} else if (currentCopy.getDVD() != null) {
				resourceTitle = currentCopy.getDVD().getTitle();
				resourceType = "DVD";
				
			} else if (currentCopy.getLaptop() != null) {
				resourceTitle = currentCopy.getLaptop().getTitle();
				resourceType = "Laptop";
			}
			
			String compileText = "ApproveCollect, " + resourceType + ", " + resourceTitle + ", " + currentCopy.getCopyID() + ", " + person.getUsername();
			masterString = masterString +  compileText + spacer;
		}
		
		for (OnLoan loanRef : Library.loans) {
			String resourceTitle = "";	
			String resourceType = "";
			Copy currentCopy = loanRef.getResourceCopy();
			User person = loanRef.getBorrower();
			int dayOfMonth = loanRef.getStartDate().getDayOfMonth();
			int month = loanRef.getStartDate().getMonthValue();
			int year = loanRef.getStartDate().getYear();
			
			if (currentCopy.getBook() != null) {
				resourceTitle = currentCopy.getBook().getTitle();
				resourceType = "Book";
				
			} else if (currentCopy.getDVD() != null) {
				resourceTitle = currentCopy.getDVD().getTitle();
				resourceType = "DVD";
				
			} else if (currentCopy.getLaptop() != null) {
				resourceTitle = currentCopy.getLaptop().getTitle();
				resourceType = "Laptop";
			}
			
			String compileText = "Loan, " + resourceType + ", " + resourceTitle + ", " + currentCopy.getCopyID() + ", " + person.getUsername() + ", " + dayOfMonth + ", " + month + ", " + year;
			masterString = masterString +  compileText + spacer;
		}
		
		for (User person : Library.returningItems) {
			String resourceTitle = "";
			String resourceType = "";
			Copy currentCopy = Library.returningCopies.get(Library.returningItems.indexOf(person));
			
			if (currentCopy.getBook() != null) {
				resourceTitle = currentCopy.getBook().getTitle();
				resourceType = "Book";
				
			} else if (currentCopy.getDVD() != null) {
				resourceTitle = currentCopy.getDVD().getTitle();
				resourceType = "DVD";
				
			} else if (currentCopy.getLaptop() != null) {
				resourceTitle = currentCopy.getLaptop().getTitle();
				resourceType = "Laptop";
			}
			
			String compileText = "Return, " + resourceType + ", " + resourceTitle + ", " + currentCopy.getCopyID() + ", " + person.getUsername();
			masterString = masterString +  compileText + spacer;
		}
		
		Datastore.setAsync("dataSet/execute.txt", masterString);
	}
	
	// LOGIN & PRELOAD (introductions)
	
	public static Boolean login(String textField){
		if (Library.logins.contains(textField)){
			for (Controller eachAccount : Library.userList) {
				if (eachAccount.getUsername().trim().equalsIgnoreCase(textField.trim())) {
					Library.currentLogin = Library.userList.get(Library.userList.indexOf(eachAccount));
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}
	
	public static void logOut() throws IOException {
		Library.currentLogin = null;
		Library.compileAccounts();
		Library.compileExecutions();
		Library.compileResources();
	}
	
	public static void forceOut() {
		Library.currentLogin = null;
	}
	
	public static void saveLocalData() throws IOException {
		Library.compileAccounts();
		Library.compileExecutions();
		Library.compileResources();
	}
	
	public static Controller getCurrentLogin() {
		return Library.currentLogin;
	}
	
	public static LocalDate getCurrentDate() {
		return LocalDate.now();
	}
	
	// Preload all accounts in the txt file
	public static void preloadAccounts(){
		String accountsFileLocation = "dataSet/accounts.txt";
		
		Scanner in = new Scanner(accountsFileLocation);

		// Handle the exception just in case the file doesn't exist
		try {
			in = new Scanner(new File(accountsFileLocation));

		} catch (FileNotFoundException e) {
			System.out.println("Cannot open: " + accountsFileLocation);
			System.exit(0);
		}
		
		Library.createAccounts(in);
		System.out.println(Library.userList); // remove this
	}
	
	// Preload all resources in the file
	public static void preloadResources(){
		String resourcesFileLocation = "dataSet/Resources.txt";
		
		Scanner in = new Scanner(resourcesFileLocation);

		// Handle the exception just in case the file doesn't exist
		try {
			in = new Scanner(new File(resourcesFileLocation));

		} catch (FileNotFoundException e) {
			System.out.println("Cannot open: " + resourcesFileLocation);
			System.exit(0);
		}
	
		Library.createResources(in);
		System.out.println(Library.resourceList); //remove this
		System.out.println(Library.copiesList); //remove this
	}
	
	// to be called on startup with preload
	public static void preloadExecutions() throws IOException {
		Scanner fileText = new Scanner(Datastore.getAsync("dataSet/Execute.txt"));
		
		// Action, ResourceType, Title, CopyNumber, Username,
		// Request, Book, Harry Potter and the Deathly Hallows - Part 2, 4, johndoe

		while (fileText.hasNextLine()) {
			String currentLine = fileText.nextLine();
			Scanner line = new Scanner(currentLine).useDelimiter(",");
			
			String action = line.next();
			
			if (action.equalsIgnoreCase("requestedbyuser")) {				
				String type = line.next().trim();
				String title = line.next().trim();
				int copyNumber = Integer.parseInt(line.next().trim());
				String username = line.next().trim();
				
				// begin decoding
				User selectedUser = (User) Library.getUserBasedOnName(username);
				
				if (type.equalsIgnoreCase("book")) {
					Copy selectedCopy = null;
					
					for (Copy thisCopy : Library.copiesList) {
					    if (thisCopy.getCopyID() == copyNumber && thisCopy.getBook() != null) {
					    	if (thisCopy.getBook().getTitle().trim().equalsIgnoreCase(title.trim())) {
					    		selectedCopy = thisCopy;
					    	}
					    }
					}

					Library.requestItems.add(selectedUser);
					Library.requestCopies.add(Library.requestItems.indexOf(selectedUser), selectedCopy);
					
				} else if (type.equalsIgnoreCase("dvd")) {
					Copy selectedCopy = null;
					
					for (Copy thisCopy : Library.copiesList) {
					    if (thisCopy.getCopyID() == copyNumber && thisCopy.getDVD() != null) {
					    	if (thisCopy.getDVD().getTitle().trim().equalsIgnoreCase(title.trim())) {
					    		selectedCopy = thisCopy;
					    	}
					    }
					}
					
					Library.requestItems.add(selectedUser);
					Library.requestCopies.add(Library.requestItems.indexOf(selectedUser), selectedCopy);
				
				} else if (type.equalsIgnoreCase("laptop")) {
					Copy selectedCopy = null;
					
					for (Copy thisCopy : Library.copiesList) {
					    if (thisCopy.getCopyID() == copyNumber && thisCopy.getLaptop() != null) {
					    	if (thisCopy.getLaptop().getTitle().trim().equalsIgnoreCase(title.trim())) {
					    		selectedCopy = thisCopy;
					    	}
					    }
					}
					
					Library.requestItems.add(selectedUser);
					Library.requestCopies.add(Library.requestItems.indexOf(selectedUser), selectedCopy);
				}
				
			} else if (action.equalsIgnoreCase("reserved")) {
				String type = line.next().trim();
				String title = line.next().trim();
				int copyNumber = Integer.parseInt(line.next().trim());
				String username = line.next().trim();
				
				// begin decoding
				User selectedUser = (User) Library.getUserBasedOnName(username);
				
				if (type.equalsIgnoreCase("book")) {
					Copy selectedCopy = null;
					
					for (Copy thisCopy : Library.copiesList) {
					    if (thisCopy.getCopyID() == copyNumber && thisCopy.getBook() != null) {
					    	if (thisCopy.getBook().getTitle().trim().equalsIgnoreCase(title.trim())) {
					    		selectedCopy = thisCopy;
					    	}
					    }
					}

					selectedUser.addReservedItems(selectedCopy);
					selectedCopy.setAvailable(false);
					
				} else if (type.equalsIgnoreCase("dvd")) {
					Copy selectedCopy = null;
					
					for (Copy thisCopy : Library.copiesList) {
					    if (thisCopy.getCopyID() == copyNumber && thisCopy.getDVD() != null) {
					    	if (thisCopy.getDVD().getTitle().trim().equalsIgnoreCase(title.trim())) {
					    		selectedCopy = thisCopy;
					    	}
					    }
					}
					
					selectedUser.addReservedItems(selectedCopy);
					selectedCopy.setAvailable(false);
				
				} else if (type.equalsIgnoreCase("laptop")) {
					Copy selectedCopy = null;
					
					for (Copy thisCopy : Library.copiesList) {
					    if (thisCopy.getCopyID() == copyNumber && thisCopy.getLaptop() != null) {
					    	if (thisCopy.getLaptop().getTitle().trim().equalsIgnoreCase(title.trim())) {
					    		selectedCopy = thisCopy;
					    	}
					    }
					}
					
					selectedUser.addReservedItems(selectedCopy);
					selectedCopy.setAvailable(false);
				}
				
				
			} else if (action.equalsIgnoreCase("approvecollect")) {
			
				String type = line.next().trim();
				String title = line.next().trim();
				int copyNumber = Integer.parseInt(line.next().trim());
				String username = line.next().trim();
				
				// begin decoding
				User selectedUser = (User) Library.getUserBasedOnName(username);
				
				if (type.equalsIgnoreCase("book")) {
					Copy selectedCopy = null;
					
					for (Copy thisCopy : Library.copiesList) {
					    if (thisCopy.getCopyID() == copyNumber && thisCopy.getBook() != null) {
					    	if (thisCopy.getBook().getTitle().trim().equalsIgnoreCase(title.trim())) {
					    		selectedCopy = thisCopy;
					    	}
					    }
					}

					Library.collectItems.add(selectedUser);
					Library.collectCopies.add(Library.collectItems.indexOf(selectedUser), selectedCopy);
					
				} else if (type.equalsIgnoreCase("dvd")) {
					Copy selectedCopy = null;
					
					for (Copy thisCopy : Library.copiesList) {
					    if (thisCopy.getCopyID() == copyNumber && thisCopy.getDVD() != null) {
					    	if (thisCopy.getDVD().getTitle().trim().equalsIgnoreCase(title.trim())) {
					    		selectedCopy = thisCopy;
					    	}
					    }
					}
					
					Library.collectItems.add(selectedUser);
					Library.collectCopies.add(Library.collectItems.indexOf(selectedUser), selectedCopy);
					
				} else if (type.equalsIgnoreCase("laptop")) {
					Copy selectedCopy = null;
					
					for (Copy thisCopy : Library.copiesList) {
					    if (thisCopy.getCopyID() == copyNumber && thisCopy.getLaptop() != null) {
					    	if (thisCopy.getLaptop().getTitle().trim().equalsIgnoreCase(title.trim())) {
					    		selectedCopy = thisCopy;
					    	}
					    }
					}
					
					Library.collectItems.add(selectedUser);
					Library.collectCopies.add(Library.collectItems.indexOf(selectedUser), selectedCopy);
				}
			} else if (action.equalsIgnoreCase("loan")) {
				String type = line.next().trim();
				String title = line.next().trim();
				int copyNumber = Integer.parseInt(line.next().trim());
				String username = line.next().trim();
				int dayOfMonth = Integer.parseInt(line.next().trim());
				int month = Integer.parseInt(line.next().trim());
				int year = Integer.parseInt(line.next().trim());
				
				// begin decoding
				User selectedUser = (User) Library.getUserBasedOnName(username);
				
				if (type.equalsIgnoreCase("book")) {
					Copy selectedCopy = null;
					
					for (Copy thisCopy : Library.copiesList) {
					    if (thisCopy.getCopyID() == copyNumber && thisCopy.getBook() != null) {
					    	if (thisCopy.getBook().getTitle().trim().equalsIgnoreCase(title.trim())) {
					    		selectedCopy = thisCopy;
					    	}
					    }
					}
					
					// create loan class & store
					OnLoan newLoan = new OnLoan(selectedUser, selectedCopy, null, LocalDate.of(year, month, dayOfMonth));
					Library.loans.add(newLoan);
					selectedCopy.setAvailable(false);
					selectedUser.addBorrowedItems(selectedCopy);
					

				} else if (type.equalsIgnoreCase("dvd")) {
					Copy selectedCopy = null;
					
					for (Copy thisCopy : Library.copiesList) {
					    if (thisCopy.getCopyID() == copyNumber && thisCopy.getDVD() != null) {
					    	if (thisCopy.getDVD().getTitle().trim().equalsIgnoreCase(title.trim())) {
					    		selectedCopy = thisCopy;
					    	}
					    }
					}
					
					// create loan class & store
					OnLoan newLoan = new OnLoan(selectedUser, selectedCopy, null, LocalDate.of(year, month, dayOfMonth));
					Library.loans.add(newLoan);
					selectedCopy.setAvailable(false);
					selectedUser.addBorrowedItems(selectedCopy);
					
				} else if (type.equalsIgnoreCase("laptop")) {
					Copy selectedCopy = null;
					
					for (Copy thisCopy : Library.copiesList) {
					    if (thisCopy.getCopyID() == copyNumber && thisCopy.getLaptop() != null) {
					    	if (thisCopy.getLaptop().getTitle().trim().equalsIgnoreCase(title.trim())) {
					    		selectedCopy = thisCopy;
					    	}
					    }
					}
					
					// create loan class & store
					OnLoan newLoan = new OnLoan(selectedUser, selectedCopy, null, LocalDate.of(year, month, dayOfMonth));
					Library.loans.add(newLoan);
					selectedCopy.setAvailable(false);
					selectedUser.addBorrowedItems(selectedCopy);
				}
				
			} else if (action.equalsIgnoreCase("return")) {
				String type = line.next().trim();
				String title = line.next().trim();
				int copyNumber = Integer.parseInt(line.next().trim());
				String username = line.next().trim();
				
				// begin decoding
				User selectedUser = (User) Library.getUserBasedOnName(username);
				
				if (type.equalsIgnoreCase("book")) {
					Copy selectedCopy = null;
					
					for (Copy thisCopy : Library.copiesList) {
					    if (thisCopy.getCopyID() == copyNumber && thisCopy.getBook() != null) {
					    	if (thisCopy.getBook().getTitle().trim().equalsIgnoreCase(title.trim())) {
					    		selectedCopy = thisCopy;
					    	}
					    }
					}

					Library.returningItems.add(selectedUser);
					Library.returningCopies.add(Library.returningItems.indexOf(selectedUser), selectedCopy);
					
				} else if (type.equalsIgnoreCase("dvd")) {
					Copy selectedCopy = null;
					
					for (Copy thisCopy : Library.copiesList) {
					    if (thisCopy.getCopyID() == copyNumber && thisCopy.getDVD() != null) {
					    	if (thisCopy.getDVD().getTitle().trim().equalsIgnoreCase(title.trim())) {
					    		selectedCopy = thisCopy;
					    	}
					    }
					}
					
					Library.returningItems.add(selectedUser);
					Library.returningCopies.add(Library.returningItems.indexOf(selectedUser), selectedCopy);
					
				} else if (type.equalsIgnoreCase("laptop")) {
					Copy selectedCopy = null;
					
					for (Copy thisCopy : Library.copiesList) {
					    if (thisCopy.getCopyID() == copyNumber && thisCopy.getLaptop() != null) {
					    	if (thisCopy.getLaptop().getTitle().trim().equalsIgnoreCase(title.trim())) {
					    		selectedCopy = thisCopy;
					    	}
					    }
					}
					
					Library.returningItems.add(selectedUser);
					Library.returningCopies.add(Library.returningItems.indexOf(selectedUser), selectedCopy);
				}
			}
			line.close();
		}
		fileText.close();
	}
}