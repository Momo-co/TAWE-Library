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
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
/**
 * This class handles events when certain parts of the scene is interacted.
 * Outputs data on the book and allows the librarian to edit data of the book.
 * @author Kevin Pan 969449
 * @author
 * @version 1
 */
public class LibBookController implements Initializable{
		
	@FXML
	private Label username;
	@FXML
	private Label resID;
	@FXML
	private Label title;
	@FXML
	private TextField year;
	@FXML
	private TextField author;
	@FXML
	private TextField genre;
	@FXML
	private TextField publisher;
	@FXML
	private TextField language;
	@FXML
	private TextField isbn;
	@FXML
	private Label copies;
	@FXML
	public Image image;
	@FXML
	public ObservableList<Copy> copyList = FXCollections.observableArrayList();
	@FXML
	public TableView<Copy> tableView;
	@FXML
	public TableColumn<String,String> copyID;
	@FXML
	public TableColumn<String,Boolean> available;
	
	/**
	 * Method to display username at the bottom of the scene.
	 * @param name The username from previous scenes.
	 */
	public void setName(String name) {
		username.setText(name);
	}
	
	/**
	 * Fills the table view with the list of copies of the resource.
	 * @param listReference The list of copies of resource.
	 * @param observeReference The list of items that are shown on the table view.
	 */
	public void fillList(List<Copy> listReference, ObservableList<Copy> observeReference) {
		for (Copy item : listReference) {
			observeReference.add(item);
		}
	}
	
	/**
	 * Outputs the data of the resource to the scene.
	 * @param selectedBook The selected book.
	 */
	public void setSelected(String selectedBook) {
		for (Resource object : Library.resourceList) {
			if (selectedBook.contains(object.getTitle())) {
				if (object.getClass().toString().contains("Book")) {
					Book objectBook = (Book) object;
				
					resID.setText(Integer.toString(objectBook.getResourceID()));
					title.setText(objectBook.getTitle());
					year.setText(Integer.toString(objectBook.getYear()));
					author.setText(objectBook.getAuthor());
					genre.setText(objectBook.getGenre());
					publisher.setText(objectBook.getPublisher());
					language.setText(objectBook.getLanguage());
					isbn.setText(objectBook.getIsbn());
					copies.setText(Integer.toString(objectBook.copies.size()));
					
					copyID.setCellValueFactory(new PropertyValueFactory<>("copyID"));
					available.setCellValueFactory(new PropertyValueFactory<>("available"));
					fillList(objectBook.copies, copyList);
					tableView.setItems(copyList);					
				}
			}
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
	 * and outputs the username in the next scene.
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
	 * Reads and saves text inputs to update the book. 
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleSave(ActionEvent event) throws IOException{
		for (Resource object : Library.resourceList) {
			if (object.getClass().toString().contains("Book")) {
				Book objectBook = (Book) object;
				if (objectBook.getTitle().equalsIgnoreCase(title.getText())) {
					
					System.out.println(objectBook.translateToText());
					if (!year.getText().equalsIgnoreCase(Integer.toString(objectBook.getYear()))) {
						objectBook.setYear(Integer.parseInt(year.getText()));
					}
					
					if (!author.getText().equalsIgnoreCase(objectBook.getAuthor())) {
						objectBook.setAuthor(author.getText());
					}
					
					if (!genre.getText().equalsIgnoreCase(objectBook.getGenre())) {
						objectBook.setGenre(genre.getText());
					}
					
					if (!publisher.getText().equalsIgnoreCase(objectBook.getPublisher())) {
						objectBook.setPublisher(publisher.getText());
					}
					
					if (!language.getText().equalsIgnoreCase(objectBook.getLanguage())) {
						objectBook.setLanguage(language.getText());
					}
					
					if (!isbn.getText().equalsIgnoreCase(objectBook.getIsbn())) {
						objectBook.setIsbn(isbn.getText());
					}	
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Success");
					alert.setHeaderText(null);
					alert.setContentText("You have succesfully updated: " + objectBook.getTitle());
					alert.showAndWait();
				}
			}
		}
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
	 * Switches scene to the create resource scene when the "Create Resource" button is clicked
	 *  and outputs the username in the next scene.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleCreateResource(ActionEvent event) throws IOException {
		
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("CreateResource.fxml"));
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
	 * Method that is immediately run when the scene is loaded.
	 * @param url  The location used to resolve relative paths for the root object or null if the location is unknown.
	 * @param resources The resources used to localise the root object or null if the root object is not localised.
	 */
	public void initialize(URL url, ResourceBundle resources) {
		System.out.println("Working...");
	     
	}
}
