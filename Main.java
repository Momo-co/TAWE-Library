
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// create the library
		new Library("TAWE-Library");
		
		// open the interface to use application
		Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
		Scene scene = new Scene(root);

		primaryStage.setTitle("Welcome to Tawe-Lib");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
