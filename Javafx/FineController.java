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
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class FineController implements Initializable{
	
	
	@FXML
	public Label username;
	@FXML
	private Button homeButton;
	private Button resButton;
	private Button loanButton;
	private Button fineButton;
	private Button accButton;
	@FXML
    private static final String IDLE_BUTTON_STYLE = "-fx-background-color: transparent;";
	@FXML
    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, -fx-body-color;";

	
	
	public void setName(String name) {
		username.setText(name);
	}
	

	@FXML
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
	public void handleSignOut(ActionEvent event) throws IOException{
	
		Platform.exit();
		System.exit(0);
		
		/*Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage)root.getScene().getWindow();
		window.setScene(scene);
		window.show();*/
	}
	


	@Override
	public void initialize(URL url, ResourceBundle resources) {
		 
		System.out.println("Working...");
		
	   // homeButton.setOnMouseEntered(e -> homeButton.setStyle(HOVERED_BUTTON_STYLE));
	   // homeButton.setOnMouseExited(e -> homeButton.setStyle(IDLE_BUTTON_STYLE));
	     
	   
	 //   resButton.setOnMouseEntered(e -> resButton.setStyle(HOVERED_BUTTON_STYLE));
	  //  resButton.setOnMouseExited(e -> resButton.setStyle(IDLE_BUTTON_STYLE));
	     
	  /*   loanButton.setStyle(IDLE_BUTTON_STYLE);
	     loanButton.setOnMouseEntered(e -> loanButton.setStyle(HOVERED_BUTTON_STYLE));
	     loanButton.setOnMouseExited(e -> loanButton.setStyle(IDLE_BUTTON_STYLE));
	     
	     fineButton.setStyle(IDLE_BUTTON_STYLE);
	     fineButton.setOnMouseEntered(e -> fineButton.setStyle(HOVERED_BUTTON_STYLE));
	     fineButton.setOnMouseExited(e -> fineButton.setStyle(IDLE_BUTTON_STYLE));
	     
	     accButton.setStyle(IDLE_BUTTON_STYLE);
	     accButton.setOnMouseEntered(e -> accButton.setStyle(HOVERED_BUTTON_STYLE));
	     accButton.setOnMouseExited(e -> accButton.setStyle(IDLE_BUTTON_STYLE));*/
	     

	}
}
