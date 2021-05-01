
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
/**
 * This class handles events when certain parts of the scene is interacted.
 * Outputs a list of items and can be navigated through using the search bar and choice box.
 * @author Kevin Pan 969449
 * @author
 * @version 1
 */
public class LibResourceSearchController implements Initializable{
	@FXML
	private ObservableList<String> resourceTypeList = FXCollections.observableArrayList("All","Book","DVD","Laptop");
	@FXML
	private ObservableList<String>	entries = FXCollections.observableArrayList();	
	@FXML
	private ChoiceBox resType = new ChoiceBox();
	@FXML
	private Label username;
	@FXML
	private ListView<String> listOfItems = new ListView<String>();
	@FXML
	private static String selected = null;
	@FXML
	private TextField textInput;
	
	/**
	 * Method to display username at the bottom of the scene.
	 * @param name The username from previous scenes.
	 */
	public void setName(String name) {
		username.setText(name);
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
	 * Switches scene to a particular resource scene that is chosen by the librarian.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleRecType(ActionEvent event) throws IOException {
		
		if(selected.substring(0,1).equals("B")){
			String name = username.getText();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("LibBook.fxml"));
			Parent root = loader.load();
	
			Scene scene = new Scene(root);
			LibBookController display = loader.getController();
			display.setName(name);
			display.setSelected(selected);
			
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
			
		} else if (selected.substring(0,1).equals("D")){
			String name = username.getText();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("LibDVD.fxml"));
			Parent root = loader.load();
	
			Scene scene = new Scene(root);
			LibDVDController display = loader.getController();
			display.setName(name);
			display.setSelected(selected);
			
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
			
		} else if (selected.substring(0,1).equals("L")) {
			String name = username.getText();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("LibLaptop.fxml"));
			Parent root = loader.load();
	
			Scene scene = new Scene(root);
			LibLaptopController display = loader.getController();
			display.setName(name);
			display.setSelected(selected);
			
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		}
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
		CreateResourceController display = loader.getController();
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
	 * Selects a certain resource from the list.
	 * @param event The event is when the list item is clicked on
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void listButtonPushed(MouseEvent event) throws IOException{
		
		selected = listOfItems.getSelectionModel().getSelectedItem();
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
	}
	
	@Override
	/**
	 * Method that is immediately run when the scene is loaded, outputs the list of resources
	 * and makes the list view change in real time as the text field is typed or choice box is selected.
	 * @param url  The location used to resolve relative paths for the root object or null if the location is unknown.
	 * @param resources The resources used to localise the root object or null if the root object is not localised.
	 */
	public void initialize(URL url, ResourceBundle resources) {
		if (Library.resourceList.size() == 0) {
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
