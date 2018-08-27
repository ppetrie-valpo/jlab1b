package me.ppetrie.jlab1b;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiCalc extends Application implements EventHandler<ActionEvent> {
	
	private Label x;
	private TextField xfield;
	private Label y;
	private TextField yfield;
	private Label rslt;
	private Button computeButton;

	@Override
	public void start(Stage stage) {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10d);
		grid.setVgap(10d);
		grid.setPadding(new Insets(15, 15, 15, 15));
		
		x = new Label("x:");
		
		xfield = new TextField("");
		xfield.setPrefWidth(5d);
		
		y = new Label("y:");
		
		yfield = new TextField("");
		yfield.setPrefWidth(5d);
		
		rslt = new Label("x * y = ");
		
		computeButton = new Button("Compute");
		computeButton.setOnAction(this);
		
		grid.add(x, 0, 0, 5, 5);
		grid.add(xfield, 5, 0, 15, 5);
		grid.add(y, 0, 5, 5, 5);
		grid.add(yfield, 5, 5, 15, 5);
		grid.add(rslt, 0, 10, 20, 5);
		grid.add(computeButton, 0, 15, 20, 5);
		
		stage.setScene(new Scene(grid, 250, 250));
		stage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			rslt.setText("x * y = " + (Integer.valueOf(xfield.getText()) * Integer.valueOf(yfield.getText())));
		} catch(NumberFormatException nfe) {
			rslt.setText("x * y = 0");
		}
	}

}
