/**
 * @author Rhys Jacka, 955475
 * @author Dale Butt, 957450
 *
 * This class is used as a pop up window to enable
 * the user to draw their own image. It also sets 
 * their current avatar as the new drawing.
 *
 */

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.imageio.ImageIO;

public class Drawing extends Application {
	Scanner in = new Scanner(System.in);

	// The dimensions of the window
	private final int WINDOW_WIDTH = 800;
	private final int WINDOW_HEIGHT = 525;

	// The dimensions of the canvas
	private final int CANVAS_WIDTH = 695;
	private final int CANVAS_HEIGHT = 525;

	// The dimensions of the tool buttons
	private final int TOOL_BUTTON = 90;

	// private int drawSize = in.nextInt();
	private int drawSize;

	// The canvas in the GUI
	private Canvas canvas;
	
	private Stage drawing;

	// private static final Window primaryStage = null;
	/**
	 * This is the stage.
	 * 
	 * @param Stage primaryStage
	 */
	public void start(Stage primaryStage) {

		// Build the GUI
		Pane root = buildGUI();

		// Create a scene from the GUI
		Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

		// Display the scene on the stage
		primaryStage.setTitle("Drawing");
		primaryStage.setScene(scene);
		primaryStage.show();
		drawing = primaryStage;
	}

	// launches the application
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Create the GUI.
	 * 
	 * @return The panel that contains the created GUI.
	 */
	private Pane buildGUI() {
		// Create top-level panel that will hold all GUI
		BorderPane root = new BorderPane();

		// Create canvas
		canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
		root.setCenter(canvas);
		GraphicsContext gc;
		gc = canvas.getGraphicsContext2D();
		gc.setLineWidth(1);

		// Create a siderbar with padding and spacing
		VBox toolBar = new VBox(20);
		toolBar.setSpacing(10);
		toolBar.setPadding(new Insets(10));
		toolBar.setStyle("-fx-background-color: #999;");
		// #87CEFA - Blue
		toolBar.setPrefWidth(105);
		root.setLeft(toolBar);

		// Set Colours
		Label Colour = new Label("Colour: ");
		ColorPicker cpLine = new ColorPicker(Color.BLACK);
		Label fillColour = new Label("Fill Colour: ");
		ColorPicker cpFill = new ColorPicker(Color.TRANSPARENT);

		// Create tool content
		ToggleButton drawbtn = new ToggleButton("Draw");
		ToggleButton rubberbtn = new ToggleButton("Rubber");
		ToggleButton linebtn = new ToggleButton("Line");
		ToggleButton rectbtn = new ToggleButton("Rectange");
		ToggleButton circlebtn = new ToggleButton("Circle");

		// Create dropbox
		Label lineSize = new Label("Line Size: ");
		ChoiceBox<Integer> dropBox = new ChoiceBox<>();
		dropBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		dropBox.setValue(1);
		dropBox.setOnAction(e -> getChoice(dropBox));

		Button save = new Button("Save");
		// save.setStyle("-fx-background-color: #87CEFA;");

		// Allow the buttons to grow in width to fill the panel space
		Label drawingTools = new Label("Tools: ");
		drawbtn.setMaxWidth(TOOL_BUTTON);
		rubberbtn.setMaxWidth(TOOL_BUTTON);
		linebtn.setMaxWidth(TOOL_BUTTON);
		rectbtn.setMaxWidth(TOOL_BUTTON);
		circlebtn.setMaxWidth(TOOL_BUTTON);
		dropBox.setMaxWidth(TOOL_BUTTON);
		save.setMaxWidth(TOOL_BUTTON);

		Line line = new Line();
		Rectangle rect = new Rectangle();
		Circle circ = new Circle();

		// Content of toolbar
		toolBar.getChildren().addAll(Colour, cpLine, fillColour, cpFill, lineSize, dropBox, drawingTools, drawbtn,
				rubberbtn, linebtn, rectbtn, circlebtn, save);

		// Create button behaviour
		canvas.setOnMouseDragged(e -> {
			if (drawbtn.isSelected()) {
				gc.lineTo(e.getX(), e.getY());
				gc.stroke();
				gc.setLineWidth(drawSize); // Enables line to change size
			}
			if (rubberbtn.isSelected()) {
				gc.clearRect(e.getX() - drawSize / 2, e.getY() - drawSize / 2, drawSize, drawSize);
			}
		});

		// Start behaviour on mouse press
		canvas.setOnMousePressed(e -> {

			if (drawbtn.isSelected()) {
				gc.setStroke(cpLine.getValue());
				gc.beginPath();
				gc.lineTo(e.getX(), e.getY());
				// If rubber is pressed erase the stroke an follow the mouse
			}
			if (linebtn.isSelected()) {
				gc.setStroke(cpLine.getValue());
				gc.setLineWidth(drawSize);
				// Starts the line at point X and ends at point Y
				line.setStartX(e.getX());
				line.setStartY(e.getY());
			}
			if (rectbtn.isSelected()) {
				gc.setStroke(cpLine.getValue());
				gc.setFill(cpFill.getValue());
				gc.setLineWidth(drawSize);
				// Starts the rectangle at point X and ends at point Y
				rect.setX(e.getX());
				rect.setY(e.getY());
			}
			if (circlebtn.isSelected()) {
				/**
				 * rectbtn.setSelected(false); linebtn.setSelected(false);
				 * rubberbtn.setSelected(false); drawbtn.setSelected(false);
				 */
				gc.setStroke(cpLine.getValue());
				gc.setFill(cpFill.getValue());
				gc.setLineWidth(drawSize);
				// Starts the circle at point X and ends at point Y
				circ.setCenterX(e.getX());
				circ.setCenterY(e.getY());
			}
		});

		// Stop behaviour on mouse release
		canvas.setOnMouseReleased(e -> {
			if (drawbtn.isSelected()) {
				gc.lineTo(e.getX(), e.getY());
				gc.stroke();
				gc.closePath();
			}
			if (rubberbtn.isSelected()) {
				double lineWidth = gc.getLineWidth();
				gc.clearRect(e.getX() - lineWidth / 2, e.getY() - lineWidth / 2, lineWidth, lineWidth);
			}
			if (linebtn.isSelected()) {
				line.setEndX(e.getX());
				line.setEndY(e.getY());
				gc.strokeLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
			}
			if (rectbtn.isSelected()) {
				rect.setWidth(Math.abs((e.getX() - rect.getX())));
				rect.setHeight(Math.abs((e.getY() - rect.getY())));
				// rect.setX((rect.getX() > e.getX()) ? e.getX(): rect.getX());
				if (rect.getX() > e.getX()) {
					rect.setX(e.getX());
				}
				// rect.setY((rect.getY() > e.getY()) ? e.getY(): rect.getY());
				if (rect.getY() > e.getY()) {
					rect.setY(e.getY());
				}
				gc.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
				gc.strokeRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
			}
			if (circlebtn.isSelected()) {
				circ.setRadius((Math.abs(e.getX() - circ.getCenterX()) + Math.abs(e.getY() - circ.getCenterY())) / 2);

				if (circ.getCenterX() > e.getX()) {
					circ.setCenterX(e.getX());
				}
				if (circ.getCenterY() > e.getY()) {
					circ.setCenterY(e.getY());
				}

				gc.fillOval(circ.getCenterX(), circ.getCenterY(), circ.getRadius(), circ.getRadius());
				gc.strokeOval(circ.getCenterX(), circ.getCenterY(), circ.getRadius(), circ.getRadius());
			}
			// Save
			Controller currentLogin = Library.getCurrentLogin();

			save.setOnAction((t) -> {
				File pictureFile = new File("./" + currentLogin.getUsername() + "Picture.png");
				Boolean success;
				try {
					WritableImage writableImage = new WritableImage(695, 525);
					canvas.snapshot(null, writableImage);
					RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
					ImageIO.write(renderedImage, "png", pictureFile);
					success = true;
				} catch (IOException ex) {
					success = false;
					System.out.println("Error!");
				}

				// set user's profile picture URL to the one we generated
				if (success) {
					currentLogin.setPicture(currentLogin.getUsername() + "Picture.png");
				}
				drawing.close();

			});

		});

		return root;
	}

	/**
	 * Returns the dropbox value.
	 * 
	 * @param The panel that contains the created GUI.
	 */
	private void getChoice(ChoiceBox<Integer> dropBox) {
		drawSize = dropBox.getValue();
	}
}