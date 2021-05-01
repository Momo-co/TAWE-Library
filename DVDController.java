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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
/**
 * This class handles events when certain parts of the scene is interacted
 * and outputs data of the dvd.
 * @author Kevin Pan 969449
 * @author
 * @version 1
 */
public class DVDController implements Initializable {

	@FXML
	private Label username;
	@FXML
	private Label title;
	@FXML
	private Label year;
	@FXML
	private Label runtime;
	@FXML
	private Label director;
	@FXML
	private Label language;
	@FXML
	private Label subtitles;
	@FXML
	private Label copies;
	@FXML
	private Image image;
	@FXML
	public TableView<Copy> tableView;
	@FXML
	public TableColumn copyID;
	@FXML
	public TableColumn available;
	@FXML
	private ObservableList<Copy> data = FXCollections.observableArrayList();
	
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

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	@FXML
	/**
	 * Switches scene to the Profile scene when the "Profile" Button is clicked 
	 * and outputs the username in the next scene.
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

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	@FXML
	/**
	 * Switches scenes to the sign out scene when the "Sign Out" Button is clicked 
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleSignOut(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	@Override
	/**
	 * Method that is immediately run when the scene is loaded to output data about the dvd and its copies.
	 * @param url  The location used to resolve relative paths for the root object or null if the location is unknown.
	 * @param resources The resources used to localise the root object or null if the root object is not localised.
	 */
	public void initialize(URL url, ResourceBundle resources) {
		System.out.println("Working...");
		copyID.setCellValueFactory(new PropertyValueFactory<>("copyID"));
		available.setCellValueFactory(new PropertyValueFactory<>("available"));
		
		
		String tit = SearchController.selected.substring(4);
		String finalTit = tit.substring(0, tit.indexOf(","));
		title.setText(finalTit);
	
		for(Resource object : Library.resourceList) {
			if (object.getTitle().trim().equalsIgnoreCase(finalTit.trim())) {
				DVD someDVD = (DVD) object;
				
				year.setText(Integer.toString(someDVD.getYear()));
				director.setText(someDVD.getDirector());
				runtime.setText(Integer.toString(someDVD.getRunTime()));
				subtitles.setText(someDVD.getSubtitles());
				language.setText(someDVD.getLanguage());
				copies.setText(Integer.toString(someDVD.copies.size()));
				
				for (Copy copyRef : someDVD.copies) {
					data.add(copyRef);
				}
				tableView.setItems(data);
			}
		}
	}
}
