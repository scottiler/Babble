package edu.westga.cs.babble.controllers;

import edu.westga.cs.babble.model.EmptyTileBagException;
import edu.westga.cs.babble.model.PlayedWord;
import edu.westga.cs.babble.model.Tile;
import edu.westga.cs.babble.model.TileBag;
import edu.westga.cs.babble.model.TileNotInGroupException;
import edu.westga.cs.babble.model.TileRack;
import edu.westga.cs.babble.model.TileRackFullException;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import javafx.util.converter.NumberStringConverter;

/**
 * Controller for BabbleGui
 * 
 * @author Perry Iler
 * @version Aug 20, 2019
 */
public class BabbleController implements Initializable {
	private TileBag bag;
	private TileRack rack;
	private PlayedWord wordRack;
	private WordDictionary dictionary;
	private final TotalScore totalScore = new TotalScore();
	private int tileScore;

	@FXML public ListView<Tile> tiles;
	@FXML public ListView<Tile> myWord;
	@FXML public Button reset;
	@FXML public Button playword;
	@FXML public TextField score;
	@FXML public TextField tilesSize;
	@FXML public TextField myWordSize;
	
	/**
	 * Method that is called upon starting the application to shorten
	 * the intialize method
	 */
	public void init() {
		this.tiles.setItems(this.rack.tiles());
		this.myWord.setItems(this.wordRack.tiles());
		this.score.setEditable(false);
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
	
	/**
	 * Allows the player to select a tile from Tiles and
	 * move it to My Word
	 * 
	 * @throws TileRackFullException TileRack can not be full
	 * @throws TileNotInGroupException Rack has to contain the tile
	 */
	public void selectTileFromTiles() throws TileRackFullException, TileNotInGroupException {
		Tile selectedTile = this.tiles.getSelectionModel().getSelectedItem();
		this.wordRack.append(selectedTile);
		this.rack.remove(selectedTile);
	}
	
	/**
	 * Allows the player to select a tile from My Word and
	 * move it to Tiles
	 * 
	 * @throws TileNotInGroupException WordRack has to contain the tile
	 */
	public void selectTileFromWordRack() throws TileNotInGroupException {
		if (!this.wordRack.tiles().isEmpty()) {
			Tile selectedTile = this.myWord.getSelectionModel().getSelectedItem();
			this.rack.append(selectedTile);
			this.wordRack.remove(selectedTile);
		}
	}
	
	/**
	 * Submits Tiles in the wordRack for scoring
	 */
	public void playWord() {
		String word = this.wordRack.getHand();
		
		if (this.dictionary.isValidWord(word)) {
			this.tileScore += this.wordRack.getScore();
			
			this.totalScore.setScoreTotal(tileScore);
			this.wordRack.clear();
			this.placeTiles();
		} else {
			Alert notWord = new Alert(AlertType.INFORMATION);
			notWord.setTitle("Word Not Found");
			notWord.setContentText("Not a valid word, Reset and try again");
			notWord.show(); 
      } 
	}
	
	/**
	 * Moves all tiles from wordRack back to Rack
	 */
	public void reset() {
		for (Tile tile : this.wordRack.tiles()) {
			this.rack.append(tile);
		}
		this.wordRack.clear();
	}

	/**
	 * Draws and places needed tiles in the Rack
	 */
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
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.rack = new TileRack();
		this.wordRack = new PlayedWord();
		this.bag = new TileBag();
		this.dictionary = new WordDictionary();
		this.score.textProperty().bindBidirectional(this.totalScore.scoreTotalProperty(), new NumberStringConverter());
		this.init();
	}

}
