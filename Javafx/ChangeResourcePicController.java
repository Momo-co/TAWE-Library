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

public class ChangeResourcePicController implements Initializable{
	
	

	ObservableList<String> pictures = FXCollections.observableArrayList("Picture 1","Picture 2","Picture 3");
	public String selected;
	@FXML
	public Button save;
	public ChoiceBox<String> pic;
	@FXML
	public Label username;
	@FXML
	public ImageView picture;
	public Image image;
	
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
	
	public void handleDrawPicture(ActionEvent event) throws IOException{
		
		/*Parent root = FXMLLoader.load(getClass().getResource("Draw.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
*/
	}
	public void handleSave(ActionEvent event){
		
		
		Stage stage = (Stage) save.getScene().getWindow();
	    stage.close();
	}


	@Override
	public void initialize(URL url, ResourceBundle resources) {
		System.out.println("Working...");
		pic.setValue("Picture 1");
		pic.setItems(pictures);

	}
}

