package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTileRackGetNumberOfTilesNeeded {
	public TileRack rack = new TileRack();
	private TileBag bag = new TileBag();
	
	@Test
	void emptyTileRackShouldNeedMaxSizeNumberOfTiles() {
		assertEquals(7, this.rack.getNumberOfTilesNeeded());
	}
	
	@Test
	void tileRackWithOneTileShouldNeedMaxSizeMinusOneTiles() throws TileRackFullException, EmptyTileBagException {
		for (int index = 0; index < TileRack.MAX_SIZE - 1; index++) {
			rack.append(this.bag.drawTile());
		}
		assertEquals(1, this.rack.getNumberOfTilesNeeded());
	}
	
	@Test
	void tileRackWithSeveralTilesShouldNeedSomeTiles() throws TileRackFullException, EmptyTileBagException {
		for (int index = 0; index < TileRack.MAX_SIZE - 3; index++) {
			rack.append(this.bag.drawTile());
		}
		assertEquals(3, this.rack.getNumberOfTilesNeeded());
	}
	
	@Test
	void fullRackNeedsZeroTiles() throws TileRackFullException, EmptyTileBagException {
		for (int index = 0; index < TileRack.MAX_SIZE; index++) {
			rack.append(this.bag.drawTile());
		}
		assertEquals(0, this.rack.getNumberOfTilesNeeded());
	}

}
