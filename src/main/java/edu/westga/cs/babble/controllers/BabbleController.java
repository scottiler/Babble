package edu.westga.cs.babble.controllers;

import edu.westga.cs.babble.model.EmptyTileBagException;
import edu.westga.cs.babble.model.Tile;
import edu.westga.cs.babble.model.TileBag;
import edu.westga.cs.babble.model.TileGroup;
import edu.westga.cs.babble.model.TileNotInGroupException;
import edu.westga.cs.babble.model.TileRack;
import edu.westga.cs.babble.model.TileRackFullException;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

public class BabbleController implements Initializable {
	private TileBag bag;
	private TileRack rack;
	private TileRack wordRack;
	private WordDictionary dictionary;
	private final TotalScore totalScore = new TotalScore();

	@FXML public ListView<Tile> tiles;
	@FXML public ListView<Tile> myWord;
	@FXML public Button reset;
	@FXML public Button playword;
	@FXML public TextField score;
	@FXML public TextField tilesSize;
	@FXML public TextField myWordSize;
	
	@FXML
	public Button test;
	@FXML 
	public TextField text;
	
	
	public void init() {
		this.tiles.setItems(this.rack.tiles());
		this.myWord.setItems(this.wordRack.tiles());
		this.tiles.setCellFactory(new Callback<ListView<Tile>, ListCell<Tile>>() {
			@Override
            public ListCell<Tile> call(ListView<Tile> list) {
                return new LetterCell();
            }
		});
		
		this.myWord.setCellFactory(new Callback<ListView<Tile>, ListCell<Tile>>() {
			@Override
            public ListCell<Tile> call(ListView<Tile> list) {
                return new LetterCell();
            }
		});
		this.placeTiles();
	}
	
	public void selectTileFromTiles() throws TileRackFullException, EmptyTileBagException, TileNotInGroupException {
		Tile selectedTile = this.tiles.getSelectionModel().getSelectedItem();
		this.wordRack.append(selectedTile);
		this.rack.remove(selectedTile);
		this.tilesSize.setText(String.valueOf(this.rack.tiles().size()));
		this.myWordSize.setText(String.valueOf(this.wordRack.tiles().size()));
	}
	
	public void selectTileFromWordRack() throws TileNotInGroupException {
		Tile selectedTile = this.myWord.getSelectionModel().getSelectedItem();
		this.rack.append(selectedTile);
		this.wordRack.remove(selectedTile);
		this.tilesSize.setText(String.valueOf(this.rack.tiles().size()));
		this.myWordSize.setText(String.valueOf(this.wordRack.tiles().size()));
	}
	
	public void playWord() throws TileNotInGroupException {
		String word = this.wordRack.getHand();
		int tileScore = 0;
		if (this.dictionary.isValidWord(word)) {
			for (Tile tile : this.wordRack.tiles()) {
				tileScore += tile.getPointValue();
			}
			this.totalScore.setScoreTotal(tileScore);
			this.score.setText(String.valueOf(tileScore));
			this.wordRack.tiles().clear();
			this.placeTiles();
		} else {
			Alert notWord = new Alert(AlertType.INFORMATION);
			notWord.setContentText("Not a valid word, Reset and try again"); 
			notWord.show(); 
      } 
  
		this.text.setText(word);
	}
	
	public void reset() {
		for (Tile tile : this.wordRack.tiles()) {
			this.rack.append(tile);
		}
		this.wordRack.tiles().clear();
	}

	public void placeTiles() {
		int tilesNeeded = this.rack.getNumberOfTilesNeeded();
		for (int count = 0; count < tilesNeeded; count++) {
			try {
				this.rack.append(this.bag.drawTile());
			} catch (TileRackFullException e) {
				e.printStackTrace();
			} catch (EmptyTileBagException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < this.rack.tiles().size(); i++) {
			System.out.print(this.rack.tiles().get(i).getLetter() + " ");
		}
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.rack = new TileRack();
		this.wordRack = new TileRack();
		this.bag = new TileBag();
		this.dictionary = new WordDictionary();
		this.totalScore.scoreTotalProperty().asString().bindBidirectional(this.score.textProperty());
		this.init();
	}

}
