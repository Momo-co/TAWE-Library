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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
/**
 * This class handles events when certain parts of the scene is interacted
 *  and outputs list of their borrowed items for the user to return.
 * @author Kevin Pan 969449
 * @author 
 * @version 1
 */
public class ReturnItemsController implements Initializable{
	
	@FXML
	private String selected;
	@FXML
	private ListView<String> list;
	@FXML
	private ObservableList<String> items = FXCollections.observableArrayList();
	@FXML
	private Label username;
	
	private User accountHolder = (User) Library.getCurrentLogin(); // saves referencing all the time	
	
	/**
	 * Method to display username at the bottom of the scene.
	 * @param name The username from previous scenes.
	 */
	public void setName(String name) {
		username.setText(name);
	}
	
	/**
	 * Fills the list view with the user's borrowed items.
	 * @param listReference The items in the user's request list.
	 * @param observeReference The list of items that are shown on the list view.
	 */
	public void fillLists(List<Copy> listReference, ObservableList<String> observeReference) {
		for (Copy item : listReference) {
			if (item.getBook() != null) {
				observeReference.add(item.getBook().getTitle());

			} else if (item.getDVD() != null) {
				observeReference.add(item.getDVD().getTitle());

			} else if (item.getLaptop() != null) {
				observeReference.add(item.getLaptop().getTitle());
			}
		}
	}
	@FXML
	/**
	 * Selects a certain item from the list.
	 * @param event The event is when the list item is clicked on
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void listButtonPushed(MouseEvent event) throws IOException{
		selected = list.getSelectionModel().getSelectedItem();
	}
	
	@FXML
	/**
	 * sends return request to librarian for the selected items
	 *  and a pop up message appears to confirm process.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleReturns(ActionEvent event) throws IOException {
		// find borrowed copy & send for approval
		Copy userReturnCopy = null;

		for (Copy borrowedCopy : accountHolder.getBorrowedItems()) {
			if (borrowedCopy.getBook() != null) {
				Book borrowedBook = (Book) borrowedCopy.getBook();

				if (borrowedBook.getTitle().equalsIgnoreCase(selected)) {
					userReturnCopy = borrowedCopy;
				}

			} else if (borrowedCopy.getDVD() != null) {
				DVD borrowedDVD = (DVD) borrowedCopy.getDVD();

				if (borrowedDVD.getTitle().equalsIgnoreCase(selected)) {
					userReturnCopy = borrowedCopy;
				}

			} else if (borrowedCopy.getLaptop() != null) {
				Laptop borrowedLaptop = (Laptop) borrowedCopy.getLaptop();

				if (borrowedLaptop.getTitle().equalsIgnoreCase(selected)) {
					userReturnCopy = borrowedCopy;
				}
			}
		}

		if (userReturnCopy != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Are you sure?");
			alert.setHeaderText(null);
			alert.setContentText("Would you like to deposit this copy now?");
			alert.showAndWait();
			if (alert.getResult().getText().equalsIgnoreCase("Ok")) {
				Library.userReturningCopy(accountHolder, userReturnCopy);
			}
		}
	}
	
	@FXML
	/**
	 * Switches scene to the homepage scene when the "Home" button is clicked
	 *  and outputs the username in the next scene.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleHome(ActionEvent event) throws IOException {
	
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Homepage.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		HomePageController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	@FXML
	/**
	 * Switches scene to the Search Resource scene when the "Resource" Button is clicked
	 *  and outputs the username in the next scene.
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
	}
	


	@Override
	/**
	 * Method that is immediately run when the scene is loaded to output borrowed items in a list.
	 * @param url  The location used to resolve relative paths for the root object or null if the location is unknown.
	 * @param resources The resources used to localise the root object or null if the root object is not localised.
	 */
	public void initialize(URL url, ResourceBundle resources) {
		System.out.println("Working...");
		
		fillLists(accountHolder.getBorrowedItems(), items);
		
		list.setItems(items);
		list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
}
