import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
/**
 * This class handles events when certain parts of the scene is interacted
 *  and displays the user dashboard.
 * @author Kevin Pan 969449
 * @author 
 * @version 1
 */
public class HomePageController implements Initializable{

	@FXML
	private ListView<String> listOfBorrowed;
	@FXML
	private ListView<String> listOfRequested;
	@FXML
	private ListView<String> listOfReserved;
	@FXML
	private ListView<String> listOfTransactions;
	@FXML
	private ObservableList<String> borrowed = FXCollections.observableArrayList();
	@FXML
	private ObservableList<String> requested = FXCollections.observableArrayList();
	@FXML
	private ObservableList<String> reserved = FXCollections.observableArrayList();
	@FXML
	private ObservableList<String> transactions = FXCollections.observableArrayList();
	
	private User accountHolder = (User) Library.getCurrentLogin(); // saves referencing all the time
	
	private double userBalance = accountHolder.getBalance();
	private String stringBal = "�" + Double.toString(userBalance);
	
	@FXML
	private Label username;
	@FXML
	private Label balance;
	

	/**
	 * Method to display username at the bottom of the scene.
	 * @param name The username from previous scenes.
	 */
	public void setName(String name) {
		username.setText(name);
	}
	
	/**
	 * Fills the list views with the list of their equivalent items.
	 * @param listReference The list of items from user.
	 * @param observeReference The list of items that are shown on the list view.
	 */
	public void fillLists(List<Copy> listReference, ObservableList<String> observeReference) {
		for (Copy item : listReference) {
			if (item.getBook() != null) {
				observeReference.add(item.getBook().getTitle());
				System.out.println("book");
				
			} else if (item.getDVD() != null) {
				observeReference.add(item.getDVD().getTitle());
				System.out.println("dvd");
				
			} else if (item.getLaptop() != null) {
				observeReference.add(item.getLaptop().getTitle());
				System.out.println("laptop");
			}
		}
	}
	
	/**
	 * Fills the table view with data about item transactions.
	 * @param listReference The list of items that have been borrowed/returned.
	 * @param observeReference The list of items that are shown on the table view.
	 */
	public void listTransaction(List<String> listReference, ObservableList<String> observeReference) {
		for (String transaction : listReference) {
			observeReference.add(transaction);
		}
	}
	

	@FXML
	/**
	 * Switches scene to the Search Resource scene when the "Resource" Button is clicked
	 * and outputs the username in the next scene.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleResource(ActionEvent event) throws IOException {
	
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Searching.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		SearchController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	@FXML
	/**
	 * Switches scene to the Profile scene when the "Profile" Button is clicked
	 *  and outputs the username in the next scene.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleAccount(ActionEvent event) throws IOException {
		
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Profile.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		ProfileController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	@FXML
	/**
	 * Switches scene to the add funds scene when "Add Funds" button is pushed 
	 * and outputs the username in the next scene.
	 * @param event The event is when the button is pushed.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleAddFunds(ActionEvent event) throws IOException {
		
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("AddFunds.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		AddFundsController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	@FXML
	/**
	 * Switches scene to the borrowed items scene  when the "Borrowed Items" Button is clicked
	 *  and outputs the username in the next scene.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleLoans(ActionEvent event) throws IOException {
		
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Loans.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		LoanController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	@FXML
	/**
	 * Switches scenes to the issue desk scene when the "Issue Desk" Button is clicked
	 *  and outputs the username in the next scene.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleIssueDesk(ActionEvent event) throws IOException {
		
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("IssueDesk.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		IssueDeskController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	@FXML
	/**
	 * Switches scenes to the sign out scene when the "Sign Out" Button is clicked
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleSignOut(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
		Library.logOut();
	}
	


	@Override
	/**
	 * Method that is immediately run when the scene is loaded to output the list views and table view.
	 * @param url  The location used to resolve relative paths for the root object or null if the location is unknown.
	 * @param resources The resources used to localise the root object or null if the root object is not localised.
	 */
	public void initialize(URL url, ResourceBundle resources) {
		System.out.println("Working...");		
		fillLists(accountHolder.getBorrowedItems(), borrowed);
		fillLists(accountHolder.getRequestedItems(), requested);
		fillLists(accountHolder.getReservedItems(), reserved);
		listTransaction(accountHolder.getTransactionalHistory(), transactions);
		
		listOfBorrowed.setItems(borrowed);
		listOfRequested.setItems(requested);
		listOfReserved.setItems(reserved);
		listOfTransactions.setItems(transactions);
		balance.setText(stringBal);
		
	}
}
