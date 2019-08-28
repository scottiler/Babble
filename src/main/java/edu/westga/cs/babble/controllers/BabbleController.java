package edu.westga.cs.babble.controllers;

import edu.westga.cs.babble.model.Tile;
import edu.westga.cs.babble.model.TileBag;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class BabbleController implements Initializable {
	private TileBag bag;
	@FXML private ListView tiles;
	@FXML private Button test;
	@FXML private TextField text;
	
	public void setText() {
		this.text.setText("it worked");
	}
	
	public void initTiles() {
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.tiles = new ListView<Tile>();
		this.test = new Button();
		this.text = new TextField();
		
	}

}
