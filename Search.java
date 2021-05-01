
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;

public class Search extends Application {
	public static List<String> resourceList = new ArrayList<String>();
	ObservableList<String> entries = FXCollections.observableArrayList();
	public String chosenResource = null;
	ListView<String> list = new ListView<String>();
	public static void main(String[] args) {
		launch(args);
	}

	public void handleSearchByKey(String oldVal, String newVal) {
		// If the number of characters in the text box is less than last time
		// it must be because the user pressed delete
		if (oldVal != null && (newVal.length() != oldVal.length())) {
			// Restore the lists original set of entries
			// and start from the beginning
			list.setItems(entries);
		}

		// Break out all of the parts of the search text
		// by splitting on white space
		String[] parts = newVal.toUpperCase().split(" ");

		// Filter out the entries that don't contain the entered text
		ObservableList<String> subentries = FXCollections.observableArrayList();

		for (Object entry : list.getItems()) {
			boolean match = true;
			String entryText = (String) entry;
			for (String part : parts) {
				// The entry needs to contain all portions of the
				// search string *but* in any order
				if (!entryText.toUpperCase().contains(part)) {
					match = false;
					break;
				}
			}

			if (match) {
				subentries.add(entryText);
			}
		}
		list.setItems(subentries);
		//return (String) list.getItems;
	}

	@Override
	public void start(Stage primaryStage) {
		final ComboBox typeComboBox = new ComboBox();
        typeComboBox.getItems().addAll(
            "DVD",
            "Laptop",
            "Book",
            "All resources"
        );
        typeComboBox.setValue("All resources");
		primaryStage.setTitle("TAWE Search");
		Button btn = new Button();
		btn.setText("Choose resource");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println(list.getSelectionModel().getSelectedItem());
				System.exit(0);

			}
		});

		TextField txt1 = new TextField();
		txt1.setPromptText("Search");
		txt1.textProperty().addListener(new ChangeListener() {
			public void changed(ObservableValue observable, Object oldVal, Object newVal) {
				if((String)typeComboBox.getValue() != "All resources")
				handleSearchByKey((String)typeComboBox.getValue() +" " +  (String) oldVal, (String)typeComboBox.getValue() +" "+ (String) newVal);
				else handleSearchByKey((String) oldVal, (String) newVal);
			}
		});
		typeComboBox.setOnAction((Event ev) -> {
        	if((String)typeComboBox.getValue() != "All resources") {
        	handleSearchByKey((String)typeComboBox.getValue() + txt1.getText(), (String)typeComboBox.getValue() + " " + txt1.getText());
        	}
        	else {
        		handleSearchByKey("", " ");
        	}
		});
		// Set up the ListView
		list.setMaxHeight(180);
		// Populate the list's entries
		readFile("in.txt");
		list.setItems(entries);
		VBox root = new VBox();
		root.setPadding(new Insets(10, 10, 10, 10));
		root.setSpacing(2);
		root.getChildren().addAll(txt1, typeComboBox, list, btn);
		primaryStage.setScene(new Scene(root, 500, 250));
		primaryStage.show();
	}

	public void readFile(String filename) {
		File inputFile = new File(filename);
		Scanner in = null;
		try {
			in = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open " + filename);
			System.exit(0);
		}
		while (in.hasNextLine()) {
			String curLine = in.nextLine();
			entries.add(curLine);
		}
	}
}
