import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
/**
 * This class handles events when certain parts of the scene is interacted
 *  and allows the user to search in a list for their resource to request it.
 * @author Kevin Pan 969449
 * @author 
 * @version 1
 */
public class RequestItemsController implements Initializable{
	
	@FXML
	private ObservableList<String> resourceTypeList = FXCollections.observableArrayList("All","Book","DVD","Laptop");
	@FXML
	private ObservableList<String>	entries = FXCollections.observableArrayList();	
	@FXML
	private ChoiceBox resType = new ChoiceBox();
	@FXML
	private Button button;
	@FXML
	private Label username;
	@FXML
	private ListView<String> listOfItems = new ListView<String>();
	
	private String selected = null;
	@FXML
	private TextField textInput;
	
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
	 * sends item request to librarian that user wants to borrow an item
	 *  and a pop up message appears to confirm process.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleRequestButton(ActionEvent event) throws IOException{
		for (Resource item : Library.resourceList) {
			if (item.toString().equalsIgnoreCase(selected)) {
				System.out.println(item.getClass());
				// go through the copy list and find the next available, if no available, requesttoreserve
				
				//try {
				if (item.getClass().toString().contains("Book")) {
					Book bookItem = (Book) item;
					
					if (Library.createNewRequest("Book", bookItem, accountHolder)) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Success");
						alert.setHeaderText(null);
						alert.setContentText("You have successfully requested to borrow: " + bookItem.getTitle());
						alert.showAndWait();							
						return;
					}
			
				} else if (item.getClass().toString().contains("DVD")) {
					DVD dvdItem = (DVD) item;
					
					if (Library.createNewRequest("DVD", dvdItem, accountHolder)) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Success");
						alert.setHeaderText(null);
						alert.setContentText("You have successfully requested to borrow: " + dvdItem.getTitle());
						alert.showAndWait();							
						return;
					}
					
				} else if (item.getClass().toString().contains("Laptop")) {
					Laptop laptopItem = (Laptop) item;
					
					if (Library.createNewRequest("Laptop", laptopItem, accountHolder)) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Success");
						alert.setHeaderText(null);
						alert.setContentText("You have successfully requested to borrow: " + laptopItem.getTitle());
						alert.showAndWait();							
						return;
					}
				}
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
		selected = listOfItems.getSelectionModel().getSelectedItem();
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
	
	/**
	 * The list view changes depending on what is typed in the text field.
	 * @param oldVal text in text field before changes.
	 * @param newVal text in text field after changes.
	 */
	public void handleSearchByKey(String oldVal, String newVal) {
		// If the number of characters in the text box is less than last time
		// it must be because the user pressed delete
		if (oldVal != null && (newVal.length() != oldVal.length())) {
			// Restore the lists original set of entries
			// and start from the beginning
			listOfItems.setItems(entries);
		}

		// Break out all of the parts of the search text
		// by splitting on white space
		String[] parts = newVal.toUpperCase().split(" ");

		// Filter out the entries that don't contain the entered text
		ObservableList<String> subentries = FXCollections.observableArrayList();

		for (Object entry : listOfItems.getItems()) {
			boolean match = true;
			String entryText = (String) entry;
			for (String part : parts) {
				// The entry needs to contain all portions of the
				// search string but in any order
				if (!(entryText).toUpperCase().contains(part)) {
					match = false;
					break;
				}
			}

			if (match) {
				subentries.add(entryText);
			}
		}
		listOfItems.setItems(subentries);
		//return (String) list.getItems;
	}

	@Override
	/**
	 * Method that is immediately run when the scene is loaded, outputs the list of resources
	 * and makes the list view change in real time as the text field is typed
	 * @param url  The location used to resolve relative paths for the root object or null if the location is unknown.
	 * @param resources The resources used to localise the root object or null if the root object is not localised.
	 */
	public void initialize(URL url, ResourceBundle resources) {
		 
		System.out.println("Working...");
		if(Library.resourceList.size() == 0) {
			Library.preloadResources();
			}
			
		System.out.println("Working...");
		resType.setValue("All");
		resType.setItems(resourceTypeList);
		System.out.println(Library.resourceList.size());
		/* loop to load resources into the observableList by one */
		for (int i = 0; i < Library.resourceList.size(); i++) {
			entries.add(Library.resourceList.get(i).toString());
		}
		listOfItems.setItems(entries);
		listOfItems.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		/* Listener of changes by user in textbox */
		textInput.textProperty().addListener(new ChangeListener() {
			/* sends values to the handleSearchByKey method to change the existing observable list */
			public void changed(ObservableValue observable, Object oldVal, Object newVal) {
				if ((String) resType.getValue() != "All")
					handleSearchByKey((String) resType.getValue() + " " + (String) oldVal, /* applies filter AND textbox values if it is not "All" */
							(String) resType.getValue() + " " + (String) newVal);
				else
					handleSearchByKey((String) oldVal, (String) newVal); /* if there is no filter chosen, then just send values from the textbox */
			}
		});
		/* if filter values have changed do eventHandler */
		resType.setOnAction((Event ev) -> {
			if ((String) resType.getValue() != "All") {
				handleSearchByKey((String) resType.getValue() + textInput.getText(), 
						(String) resType.getValue() + " " + textInput.getText()); /* applies filter AND textbox values if it is not "All" */
			} else {
				handleSearchByKey("", " "); /* if filter value is "All" show full list of values */
			}
		});
			
		}
	

}
