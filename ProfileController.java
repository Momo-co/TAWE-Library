import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

/**
 * This class handles events when certain parts of the scene is interacted.
 * Output data of the user and allows them to change and save their own data. 
 * 
 * @author Kevin Pan 969449
 * @author
 * @version 1
 */

public class ProfileController implements Initializable{
	
	@FXML
	private Label username;
	@FXML
	private Label uname;
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField mobNum;
	@FXML
	private TextField telNum;
	@FXML
	private TextField address;
	@FXML
	private Label employDate;
	@FXML
	private Label staffNum;
	@FXML
	private ImageView profilePic;
	
	private User accountHolder = (User) Library.getCurrentLogin(); // saves referencing all the time	
	
	/**
	 * Method to display username at the bottom of the scene.
	 * @param name The username from previous scenes.
	 */
	public void setName(String name) {
		username.setText(name);
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
	 * Switches scenes to the issue desk scene when the "Issue Desk" Button is clicked 
	 * and outputs the username in the next scene.
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
	 * Switches scene to the borrowed items scene  when the "Borrowed Items" Button is clicked 
	 * and outputs the username in the next scene.
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
	 * Pops up a new window for the picture of the resource to be picked.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleChangePicture(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ChangePicture.fxml"));
		Parent root = (Parent)loader.load();
		Stage window = new Stage();
		window.setTitle("Profile Picture");
		window.setScene(new Scene(root));
		window.show();
	}
	
	@FXML
	/**
	 * Reads and saves text inputs to update the user.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleSave(ActionEvent event) throws IOException{		
		if (!firstName.getText().equalsIgnoreCase(accountHolder.getFirstName())) {
			accountHolder.setFirstName(firstName.getText());
		}
		
		if (!lastName.getText().equalsIgnoreCase(accountHolder.getLastName())) {
			accountHolder.setLastName(lastName.getText());
		}
		
		if (!mobNum.getText().equalsIgnoreCase(accountHolder.getPhoneNumber())) {
			accountHolder.setPhoneNumber(mobNum.getText());
		}
		
		if (!telNum.getText().equalsIgnoreCase(accountHolder.getTelephone())) {
			accountHolder.setTelephone(telNum.getText());
		}
		
		if (!address.getText().equalsIgnoreCase(accountHolder.getAddress())) {
			accountHolder.setAddress(address.getText());
		}
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Success");
		alert.setHeaderText(null);
		alert.setContentText("Update user information.");
		alert.showAndWait();
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
	 * Method that is immediately run when the scene is loaded and outputs data of the user.
	 * @param url  The location used to resolve relative paths for the root object or null if the location is unknown.
	 * @param resources The resources used to localise the root object or null if the root object is not localised.
	 */
	public void initialize(URL url, ResourceBundle resources) {
		System.out.println("Working...");
		
		uname.setText(accountHolder.getUsername());
		firstName.setText(accountHolder.getFirstName());
		lastName.setText(accountHolder.getLastName());
		mobNum.setText(accountHolder.getPhoneNumber());
		telNum.setText(accountHolder.getTelephone());
		address.setText(accountHolder.getAddress());
		profilePic.setImage(new Image(accountHolder.getProfilePicture().getPictureURL()));
	}
}
