package edu.westga.cs.babble.controllers;

import edu.westga.cs.babble.model.EmptyTileBagException;
import edu.westga.cs.babble.model.Tile;
import edu.westga.cs.babble.model.TileBag;
import edu.westga.cs.babble.model.TileGroup;
import edu.westga.cs.babble.model.TileRack;
import edu.westga.cs.babble.model.TileRackFullException;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class BabbleController implements Initializable {
	private TileBag bag;
	private Tile tile;
	private TileRack rack;
	@FXML 
	public ListView tiles;
	public Button test;

	@FXML public TextField text;
	
	public void setText() throws TileRackFullException, EmptyTileBagException {
		//this.text.setText("it worked");
		System.out.println(this.bag.getBagSize());
		this.rack.append(this.bag.drawTile());
		System.out.println(this.rack.getNumberOfTilesNeeded());
		/*for (int i = 0; i < 98; i++) {
			System.out.println(this.bag.getCharAtIndex(i));
		}*/
		
		this.test.setText("worked");
	}

	public void placeTiles() throws TileRackFullException, EmptyTileBagException {
		for (int count = 0; count <= this.rack.getNumberOfTilesNeeded(); count++) {
			this.rack.append(this.bag.drawTile());
		}
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.test = new Button();
		this.text = new TextField();
		this.text.setText("text");
		this.rack = new TileRack();
		this.bag = new TileBag();
		this.tiles = new ListView(this.rack.tiles());
	}

}
