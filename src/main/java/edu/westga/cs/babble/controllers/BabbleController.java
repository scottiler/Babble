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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

public class BabbleController implements Initializable {
	private TileBag bag;
	private Tile tile;
	private TileRack rack;

	@FXML 
	public ListView<Tile> tiles;
	@FXML
	public ListView myWord;
	@FXML
	public Button test;

	@FXML public TextField text;
	
	public void init() throws TileRackFullException, EmptyTileBagException {
		this.tiles.setItems(this.rack.tiles());
		this.tiles.setCellFactory(new Callback<ListView<Tile>, ListCell<Tile>>() {
			@Override
            public ListCell<Tile> call(ListView<Tile> list) {
                return new LetterCell();
            }
		});
		this.placeTiles();
	}
	
	public void setText() throws TileRackFullException, EmptyTileBagException {
		
	}

	public void placeTiles() throws TileRackFullException, EmptyTileBagException {
		int tilesNeeded = this.rack.getNumberOfTilesNeeded();
		for (int count = 0; count < tilesNeeded; count++) {
			this.rack.append(this.bag.drawTile());
		}
		for (int i = 0; i < this.rack.tiles().size(); i++) {
			System.out.print(this.rack.tiles().get(i).getLetter() + " ");
		}
		this.text.setText("it worked");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.rack = new TileRack();
		this.bag = new TileBag();
		try {
			this.init();
		} catch (TileRackFullException e) {
			e.printStackTrace();
		} catch (EmptyTileBagException e) {
			e.printStackTrace();
		}
	}

}
