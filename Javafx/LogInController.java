
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class LogInController implements Initializable{
	
	//LogIn Screen
	public Button button;
	public Label label;
	public TextField text;
	
	
	@FXML
	public void handleLogIn(ActionEvent event) throws IOException{
		
			if(text.getLength() > 0) {
				
				if(text.getText().equals("Lib"))
				{
					String name = text.getText();
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
				else
				{
					String name = text.getText();
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
			}
			
	}
	
	@FXML
	public void handleQuit(ActionEvent event) throws IOException{
			System.exit(0);
	}

	
	@Override
	public void initialize(URL url, ResourceBundle resources) {
		System.out.println("Working...");
	}
}
