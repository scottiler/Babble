package edu.westga.cs.babble.controllers;

import edu.westga.cs.babble.model.Tile;
import javafx.scene.control.ListCell;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LetterCell extends ListCell<Tile> {
	@Override
	public void updateItem(Tile item, boolean empty) {
		super.updateItem(item, empty);
		if (item != null) {
            setText(String.valueOf(item.getLetter()));
            setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
            setAccessibleText(String.valueOf(item.getLetter()));
        } else {
        	setText("");
        }
	}

}
