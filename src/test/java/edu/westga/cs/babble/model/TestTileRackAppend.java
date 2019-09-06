package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTileRackAppend {

	@Test
	void shouldNotAppendToFullRack() throws TileRackFullException, EmptyTileBagException {
		TileBag bag = new TileBag();
		TileRack rack = new TileRack();
		for (int index = 0; index < TileRack.MAX_SIZE; index++) {
			rack.append(bag.drawTile());
		}
		assertThrows(TileRackFullException.class, () -> {
			rack.append(bag.drawTile());
		    });
	}
	
	
	

}
