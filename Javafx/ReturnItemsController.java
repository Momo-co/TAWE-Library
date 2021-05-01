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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class ReturnItemsController implements Initializable{
	
	@FXML
	public String selected;
	public ListView<String> list;
	ObservableList<String> items = FXCollections.observableArrayList("Book","Laptop");
	public Label username;
	
	
	public void setName(String name) {
		username.setText(name);
	}
	@FXML
	public void listButtonPushed(MouseEvent event) throws IOException{
		
		selected = list.getSelectionModel().getSelectedItem();
	}
	
	@FXML
	public void handleReturns(ActionEvent event) throws IOException{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Success");
		alert.setHeaderText(null);
		alert.setContentText("Items Deposited");
		alert.showAndWait();
	}
	
	@FXML
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
	public void handleSignOut(ActionEvent event) throws IOException{
	
/*		Platform.exit();
		System.exit(0);
*/		
		Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	


	@Override
	public void initialize(URL url, ResourceBundle resources) {
		 
		System.out.println("Working...");
		list.setItems(items);
		list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	     

	}
}
