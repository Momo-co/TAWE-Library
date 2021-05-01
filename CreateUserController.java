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
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
/**
 * This class handles events when certain parts of the scene is interacted
 *  and primarily accepts inputs from the librarian to create a new user/librarian.
 * @author Kevin Pan 969449
 * @author 
 * @version 1
 */
public class CreateUserController implements Initializable{

	
	@FXML
	private Label username;
	@FXML
	private TextField uname;
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
	private ImageView image;
	@FXML
	ObservableList<String> userTypeList = FXCollections.observableArrayList("User", "Librarian");
	@FXML
	private ChoiceBox<String> userType;
    
	private String selected;
	
	/**
	 * Method to display username at the bottom of the scene.
	 * @param name The username from previous scenes.
	 */
	public void setName(String name) {
		username.setText(name);
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
	 * Reads and saves text inputs to create a new user/librarian. 
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleSave(ActionEvent event) throws IOException{
		if(userType.getSelectionModel().getSelectedItem() == "User"){
			Library.createNewUser(//username, firstname, lastname, phone, telephone, address, pictureURL)
				uname.getText(),
				firstName.getText(),
				lastName.getText(),
				mobNum.getText(),
				telNum.getText(),
				address.getText(),
				"templates/TAWE-Lib User.png"
			);
			
		}
		else if (userType.getSelectionModel().getSelectedItem() == "Librarian"){
			Library.createNewLibrarian(
				uname.getText(),
				firstName.getText(),
				lastName.getText(),
				mobNum.getText(),
				telNum.getText(),
				address.getText(),
				"templates/TAWE-Lib Hex.png",
				Library.getCurrentDate().toString() // change this to proper date
			);
			
		}
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Success");
		alert.setHeaderText(null);
		alert.setContentText("New account has been created");
		alert.showAndWait();
		System.out.println(Library.userList);
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
	 * Switches scenes to the librarian issue desk scene when the "Issue Desk" Button is clicked 
	 * and outputs the username in the next scene.
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
	 * Method that is immediately run when the scene is loaded and initialises the choice box.
	 * @param url  The location used to resolve relative paths for the root object or null if the location is unknown.
	 * @param resources The resources used to localise the root object or null if the root object is not localised.
	 */
	public void initialize(URL url, ResourceBundle resources) {
		System.out.println("Working...");
		userType.setValue("User");
		userType.setItems(userTypeList);
	}
}
