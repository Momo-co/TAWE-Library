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
import javafx.stage.Stage;
import javafx.fxml.Initializable;
/**
 * This class handles events when certain parts of the scene is interacted and outputs image data.
 * @author Kevin Pan 969449
 * @version 1
 */
public class ChangeResourcePicController implements Initializable{
	
	

	@FXML
	ObservableList<String> pictures = FXCollections.observableArrayList("Picture 1","Picture 2","Picture 3");
	@FXML
	private String selected;
	@FXML
	private Button save;
	@FXML
	private ChoiceBox<String> pic;
	@FXML
	private Label username;
	@FXML
	private ImageView picture;
	@FXML
	private Image image;
	
	@FXML
	/**
	 * Displays different images depending on which choice is selected.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handlePicturePushed(ActionEvent event) throws IOException{
		
		selected = pic.getSelectionModel().getSelectedItem();
		if(selected == "Picture 1") {
			image = new Image("cd-dvd.jpg");
			picture.setImage(image);
		}
		else if (selected == "Picture 2") {
			image = new Image("laptop.jpg");
			picture.setImage(image);
		}
		else if (selected == "Picture 3") {
			image = new Image("book.png");
			picture.setImage(image);
		}
	}
	
	
	@FXML
	/**
	 * Saves the selected picture and closes the window.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleSave(ActionEvent event){
		
		
		Stage stage = (Stage) save.getScene().getWindow();
	    stage.close();
	}


	@Override
	/**
	 * Saves the selected avatar and closes the window.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void initialize(URL url, ResourceBundle resources) {
		System.out.println("Working...");
		pic.setValue("Picture 1");
		pic.setItems(pictures);

	}
}

