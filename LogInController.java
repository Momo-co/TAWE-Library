
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

/**
 * Log In class checks username to see if it is valid and moves to 
 * either user or librarian side of the GUI depending on the username.
 * @author Kevin Pan 969449
 * @version 1.0
 *
 */
public class LogInController implements Initializable {

	@FXML
	private Button button;
	@FXML
	private Label label;
	@FXML
	private TextField text;

	@FXML
	/**
	 * Switches scene to either user homepage or librarian homepage depending on the username.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleLogIn(ActionEvent event) throws IOException {
		Boolean login = Library.login(text.getText().trim());
		
		if (login == true) {
			Controller loggedIn = Library.getCurrentLogin();

			// How to decide which interface they should get!
			if (loggedIn.getClass().getName().equalsIgnoreCase("Librarian")) {
				String name = loggedIn.getUsername();
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("LibrarianHome.fxml"));
				Parent root = loader.load();
				Scene scene = new Scene(root);
				LibHomeController display = loader.getController();
				display.setName(name);

				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();

			} else if (loggedIn.getClass().getName().equalsIgnoreCase("User")) {
				String name = loggedIn.getUsername();
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
		} else {
			// couldn't log in
			text.setText("");
			
			// fire "unable to login" alert
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Login failed");
			alert.setHeaderText(null);
			alert.setContentText("Unable to login, please try again.");
			alert.showAndWait();
		}

	}

	@FXML
	/**
	 * Exits the program.
	 * @param event The event is when the button is clicked.
	 * @throws IOException Exception to combat failed or interrupted inputs.
	 */
	public void handleQuit(ActionEvent event) throws IOException {
		System.exit(0);
	}

	@Override
	/**
	 * Method that is immediately run when the scene is loaded.
	 * @param url  The location used to resolve relative paths for the root object or null if the location is unknown.
	 * @param resources The resources used to localise the root object or null if the root object is not localised.
	 */
	public void initialize(URL url, ResourceBundle resources) {
		System.out.println("Working...");
		Library.forceOut();
	}
}
