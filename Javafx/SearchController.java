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
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class SearchController implements Initializable{
	ObservableList<String> resourceTypeList = FXCollections.observableArrayList("All","Books","DVDs","Laptops");
	ObservableList<String>	list = FXCollections.observableArrayList("Book","DVD","Laptop");	
    public ChoiceBox<String> resType;
	public Button button;
	public Label username;
	public ListView<String> listOfItems;
	public String selected;
	public TextField textInput;
	
	public void setName(String name) {
		username.setText(name);
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
	public void handleRecType(ActionEvent event) throws IOException {
		
		if(selected == "Book"){
			String name = username.getText();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("Book.fxml"));
			Parent root = loader.load();
	
			Scene scene = new Scene(root);
			BookController display = loader.getController();
			display.setName(name);
			
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		}
		else if (selected == "DVD"){
			String name = username.getText();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("DVD.fxml"));
			Parent root = loader.load();
	
			Scene scene = new Scene(root);
			DVDController display = loader.getController();
			display.setName(name);
			
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		}
		else if (selected == "Laptop")
		{
			String name = username.getText();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("Laptop.fxml"));
			Parent root = loader.load();
	
			Scene scene = new Scene(root);
			LaptopController display = loader.getController();
			display.setName(name);
			
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		}
	}
	
	public void listButtonPushed(MouseEvent event) throws IOException{
		
		selected = listOfItems.getSelectionModel().getSelectedItem();
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
		resType.setValue("All");
		resType.setItems(resourceTypeList);
		listOfItems.setItems(list);
		listOfItems.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		
	}
}
