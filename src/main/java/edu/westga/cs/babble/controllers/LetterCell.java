package edu.westga.cs.babble.controllers;
import edu.westga.cs.babble.model.Tile;
import javafx.scene.control.ListCell;

public class LetterCell extends ListCell<Tile>{
	@Override
	public void updateItem(Tile item, boolean empty) {
		super.updateItem(item, empty);
		if (item != null) {
            setText(String.valueOf(item.getLetter()));
        }
	}

}
