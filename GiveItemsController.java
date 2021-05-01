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
 *  and outputs a list view of copies.
 * @author Kevin Pan 969449
 * @author 
 * @version 1
 */
public class GiveItemsController implements Initializable{
		
	@FXML
	ObservableList<String> userCopies = FXCollections.observableArrayList();	
	@FXML
	private Label username;
	@FXML
	private ListView<String> listOfUsers;
	private String selected;
	
	/**
	 * Method to display username at the bottom of the scene.
	 * @param name The username from previous scenes.
	 */
	public void setName(String name) {
		username.setText(name);
	}
	/**
	 * Fills the list view with the list of copies.
	 * @param listReference The items in the user's reserved list.
	 * @param observeReference The list of items that are shown on the list view.
	 */
	public void fillLists(List<Copy> listReference, List<User> listPointer, ObservableList<String> observeReference) {
		for (Copy item : listReference) {
			if (item.getBook() != null) {
				observeReference.add(listPointer.get(listReference.indexOf(item)).getUsername() + ": " + item.getBook().getTitle());

			} else if (item.getDVD() != null) {
				observeReference.add(listPointer.get(listReference.indexOf(item)).getUsername() + ": " + item.getDVD().getTitle());

			} else if (item.getLaptop() != null) {
				observeReference.add(listPointer.get(listReference.indexOf(item)).getUsername() + ": " + item.getLaptop().getTitle());
			}
		}
	}
	
	@FXML
	/**
	 * Selects a certain copy from the list.
	 * @param event The event is when the list item is clicked on
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void listButtonPushed(MouseEvent event) throws IOException{
		selected = listOfUsers.getSelectionModel().getSelectedItem();
	}
	
	@FXML
	/**
	 * Item is given to the user and a pop up message appears to confirm process.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleCollects(ActionEvent event) throws IOException{
		if (selected == null) {
			return;
		}
		
		User borrower = null;
		Copy requestedCopy = null;
		
		for (Controller account : Library.userList) {
			if (account.getUsername().equalsIgnoreCase((String) selected.subSequence(0, selected.indexOf(":")))) {
				if ((User) account != null) {
					borrower = (User) account;
				}
			}
		}
		
		for (Copy item : Library.collectCopies) {
			if (item.getBook() != null) {
				if (item.getBook().getTitle().trim().equalsIgnoreCase(selected.substring(selected.indexOf(":") + 1).trim())) {
					requestedCopy = item;
				}
		
			} else if (item.getDVD() != null) {				
				if (item.getDVD().getTitle().trim().equalsIgnoreCase(selected.substring(selected.indexOf(":") + 1).trim())) {
					requestedCopy = item;
				}
			
			} else if (item.getLaptop() != null) {				
				if (item.getLaptop().getTitle().trim().equalsIgnoreCase(selected.substring(selected.indexOf(":") + 1).trim())) {
					requestedCopy = item;
				}
			}
		}
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Are you sure?");
		alert.setHeaderText(null);
		alert.setContentText("Would you like to accept this colection?");
		alert.showAndWait();
		if (alert.getResult().getText().equalsIgnoreCase("Ok")) {
			Library.approveUserCollects(requestedCopy, borrower);
		}
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
		loader.setLocation(getClass().getResource("LibResourceSearch.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		LibResourceSearchController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	@FXML
	/**
	 * Switches scene to the librarian profile scene when the "Profile" Button is clicked
	 *  and outputs the username in the next scene.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleAccount(ActionEvent event) throws IOException {
		
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("LibProfile.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		LibProfileController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	@FXML
	/**
	 * Switches scenes to the create account scene when the "Create Account" button is clicked 
	 * and outputs the username in the next scene.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleCreateAccount(ActionEvent event) throws IOException {
		
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("CreateUser.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		CreateUserController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	@FXML
	/**
	 * Switches scenes to the manage user scene when the "Manage Users" Button is clicked 
	 * and outputs the username in the next scene.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleManageUser(ActionEvent event) throws IOException {
		
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("LibUserSearch.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		LibUserSearchController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	@FXML
	/**
	 * Switches scene to the librarian homepage scene when the "Home" button is clicked
	 *  and outputs the username in the next scene.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleHome(ActionEvent event) throws IOException {
		
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("LibrarianHome.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		LibHomeController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	@FXML
	/**
	 * Switches scene to the Item History scene when the "Check Item History" Button is clicked
	 *  and outputs the username in the next scene.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleItemHistory(ActionEvent event) throws IOException {
		
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("CheckItemHistory.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		CheckItemHistoryController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	@FXML
	/**
	 * Switches scenes to the librarian issue desk scene when the "Issue Desk" Button is clicked
	 *  and outputs the username in the next scene.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleIssueDesk(ActionEvent event) throws IOException {
		
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("LibIssueDesk.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		LibIssueDeskController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	@FXML
	/**
	 * Switches scenes to the create resource scene when the "Create Resource" button is clicked 
	 * and outputs the username in the next scene.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleCreateResource(ActionEvent event) throws IOException {
		
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("CreateResource.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		CreateResourceController display = loader.getController();
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
	 * Method that is immediately run when the scene is loaded and outputs the list view of items.
	 * @param url  The location used to resolve relative paths for the root object or null if the location is unknown.
	 * @param resources The resources used to localise the root object or null if the root object is not localised.
	 */
	public void initialize(URL url, ResourceBundle resources) {
		System.out.println("Working...");
		fillLists(Library.collectCopies, Library.collectItems, userCopies);
		
		listOfUsers.setItems(userCopies);
		listOfUsers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
}
