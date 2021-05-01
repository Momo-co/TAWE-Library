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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
/**
 * This class handles events when certain parts of the scene is interacted and outputs image data for user to pick.
 * @author Kevin Pan 969449
 * @version 1
 */ 
public class ChangePictureController implements Initializable {

	ObservableList<String> pictures = FXCollections.observableArrayList("Picture 1", "Picture 2", "Picture 3", "Picture 4", "Picture 5", "Picture 6");
	public String selected;
	
	@FXML
	private Button save;
	@FXML
	private Button drawPicture;
	@FXML
	private ChoiceBox<String> pic;
	@FXML
	private Label username;
	@FXML
	private ImageView picture;
	@FXML
	private Image image;
	@FXML
	private String imageURL;

	@FXML
	/**
	 * Displays different images depending on which choice is selected.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handlePicturePushed(ActionEvent event) throws IOException {
		selected = pic.getSelectionModel().getSelectedItem();
		if (selected == "Picture 1") {
			imageURL = "templates/TAWE-Lib User.png";
			image = new Image(imageURL);
			picture.setImage(image);
			
		} else if (selected == "Picture 2") {
			imageURL = "templates/TAWE-Lib Triangle.png";
			image = new Image(imageURL);
			picture.setImage(image);
			
		} else if (selected == "Picture 3") {
			imageURL = "templates/TAWE-Lib Star.png";
			image = new Image(imageURL);
			picture.setImage(image);
			
		} else if (selected == "Picture 4") {
			imageURL = "templates/TAWE-Lib Lines.png";
			image = new Image(imageURL);
			picture.setImage(image);
			
		} else if (selected == "Picture 5") {
			imageURL = "templates/TAWE-Lib Hex.png";
			image = new Image(imageURL);
			picture.setImage(image);
			
		} else if (selected == "Picture 6") {
			imageURL = "templates/TAWE-Lib Circle.png";
			image = new Image(imageURL);
			picture.setImage(image);
		}
	}
	
	@FXML
	/**
	 * Switches to the drawing scene.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleDrawPicture(ActionEvent event) throws IOException {
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		Drawing newTemplate = new Drawing();
		newTemplate.start(window);
	}

	@FXML
	/**
	 * Saves the selected avatar and closes the window.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleSave(ActionEvent event) {
		Controller currentLogin = Library.getCurrentLogin();
		System.out.println("yee: " + imageURL);
		currentLogin.setPicture(imageURL);

		Stage stage = (Stage) save.getScene().getWindow();
		stage.close();
	}

	@Override
	/**
	 * Method that is immediately run when the scene is loaded to output the inital picture.
	 * @param url  The location used to resolve relative paths for the root object or null if the location is unknown.
	 * @param resources The resources used to localise the root object or null if the root object is not localised.
	 */
	public void initialize(URL url, ResourceBundle resources) {
		System.out.println("Working...");
		
		pic.setValue("Picture 1");
		imageURL = "templates/TAWE-Lib User.png";
		
		pic.setItems(pictures);
	}
}
